package br.com.fatecmogidascruzes.dao.impl;

import br.com.fatecmogidascruzes.dao.AbstractDAO;
import br.com.fatecmogidascruzes.dao.EntityManagerProvider;
import br.com.fatecmogidascruzes.domain.impl.TableSession;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class  SessionDAO  extends AbstractDAO {

    public SessionDAO() {
        super(new TableSession());
    }
    
    public TableSession create(TableSession entity) {       
        Session session = EntityManagerProvider.getSession(); 
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(entity);
        transaction.commit();
        return entity;        
    }
   
    public List<TableSession> findOneByName(String value) {        
        
        Session session = EntityManagerProvider.getSession();
        Query query = session.getNamedQuery("TableSession.findBySession");
        query.setParameter("value", value);
        List<TableSession> entityList = query.list(); 
        return entityList;
    }
}
