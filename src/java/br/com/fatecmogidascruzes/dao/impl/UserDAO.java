package br.com.fatecmogidascruzes.dao.impl;
import br.com.fatecmogidascruzes.dao.AbstractDAO;
import br.com.fatecmogidascruzes.dao.EntityManagerProvider;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableUser;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class  UserDAO  extends AbstractDAO {
    
    private BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
    
    public  UserDAO() {
        super(new TableUser());
    }
    
    public TableUser findByUserName(String username) {
        
        Session session = EntityManagerProvider.getSession();                
        Query query = session.getNamedQuery("TableUser.findByUserName");
        query.setParameter("username", username);        
        TableUser user = (TableUser) query.uniqueResult();
        return user;
    }
    @Override
    public EntidadeDominio create(EntidadeDominio entity) {
       
        Session session = EntityManagerProvider.getSession();
        Transaction transaction = session.beginTransaction();
        TableUser user = (TableUser)entity;
        user.setPassword(pe.encode(user.getPassword())); // Criptografar senha.
        session.save(user);
        transaction.commit();
        return entity;        
    }
    @Override
    public EntidadeDominio update(EntidadeDominio entity) {    
        
        TableUser user = (TableUser)entity;
        user.setPassword(pe.encode(user.getPassword())); // Criptografar senha.        
        Session session = EntityManagerProvider.getSession();        
        session.beginTransaction();
        session.saveOrUpdate(user);
        session.getTransaction().commit();        
        return null;
    }
   
}
