package br.com.fatecmogidascruzes.dao.impl;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.dao.AbstractDAO;
import br.com.fatecmogidascruzes.dao.EntityManagerProvider;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.security.service.CredenciaisDTO;
import br.com.fatecmogidascruzes.security.service.JWTUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class  CustomerDAO  extends AbstractDAO {
    
    private BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
    
    public  CustomerDAO() {
        super(new TableCustomer());
    }
    
    @Override
    public EntidadeDominio create(EntidadeDominio entity) {
       
        Session session = EntityManagerProvider.getSession();
        Transaction transaction = session.beginTransaction();
        TableCustomer customer = (TableCustomer)entity;
        customer.setPassword(pe.encode(customer.getPassword())); // Criptografar senha.
        session.save(customer);
        transaction.commit();
        return entity;        
    }
    @Override
    public EntidadeDominio update(EntidadeDominio entity) {    
        
        TableCustomer customer = (TableCustomer)entity;
        customer.setPassword(pe.encode(customer.getPassword())); // Criptografar senha.        
        Session session = EntityManagerProvider.getSession();        
        session.beginTransaction();
        session.saveOrUpdate(customer);
        session.getTransaction().commit();        
        return null;
    }
    
    public TableCustomer findByUserName(String customerName) {
        Session session = EntityManagerProvider.getSession();
        Query query = session.getNamedQuery("TableCustomer.findByUserName");
        query.setParameter("username", customerName);
        TableCustomer customer = (TableCustomer) query.uniqueResult();
        return customer;
    }
    
    public CredenciaisDTO Authentication(CredenciaisDTO creds) {
        Session session = EntityManagerProvider.getSession();         
        Query query = session.getNamedQuery("TableCustomer.findByUserName");
        query.setParameter("username", creds.getUserName());        
        TableCustomer customer = (TableCustomer) query.uniqueResult();
        if(customer != null && customer.getStatus()){ // Somente usuários ativos podem fazer login
            if(pe.matches(creds.getPassword(), customer.getPassword())){
                session.clear();
                Session session2 = EntityManagerProvider.getSession();
                JWTUtil jwtUtil = new JWTUtil();
                customer.setToken(jwtUtil.generateToken(creds.getUserName()));                            
                session2.beginTransaction();
                session2.update(customer);
                session2.getTransaction().commit();
                creds.setToken(customer.getToken());
                creds.setPassword("");
                creds.setExpirationDate(jwtUtil.getExpirationDate(customer.getToken()));
                creds.setAuthorities(customer.getUserGroup().getName());
                return creds;
            }
        }
        return null;
    }
}
