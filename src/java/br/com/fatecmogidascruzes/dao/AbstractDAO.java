/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.dao;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.test.TableOrderTemp;
import java.util.List;
import javax.persistence.TemporalType;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Josias Wattrelos
 */
public class AbstractDAO implements IDAO{
    
    private final EntidadeDominio entityClass; 
    
    public AbstractDAO(EntidadeDominio entityClass) {
        
        this.entityClass = entityClass;
         
    }
    
    protected String getColumnName(){
    	return "name"; // Por padrão, retorna o nome da coluna para busca por nome.        
    }
   
    /** CREATE ***************************************************************************************************
     * 
     * @param entity
     * @return 
     */
    @Override
    public EntidadeDominio create(EntidadeDominio entity) {       
               
        Session session = EntityManagerProvider.getSession(); 
        Transaction transaction = session.beginTransaction();
        session.save(entity);
        transaction.commit();
        return entity;        
    }
    
    @Override
    public List<EntidadeDominio> findAll(){
        Session session = EntityManagerProvider.getSession();
        Query query = session.getNamedQuery(entityClass.getClass().getSimpleName() + ".findAll");
        List<EntidadeDominio> entityList = query.list();
        return entityList;

    }
    
    @Override 
    public Resultado findByPage(String findBy, String searchValue, Integer page, Integer linesPerPage, String orderBy, String direction) {
       
        Resultado resultado = new Resultado();
        
        Session session = EntityManagerProvider.getSession();
        
        // Pagination lines counting        
        Query countQuery = session.getNamedQuery(entityClass.getClass().getSimpleName() + ".CountBy" + findBy);
        countQuery.setParameter("id", Integer.parseInt(searchValue));
        Long countResults = (Long) countQuery.uniqueResult();        
        resultado.setPageNumber(page);
        resultado.setItensQuantity(countResults.intValue());
        //Last Page
        int lastPageNumber = (int) ((countResults / linesPerPage) );
        resultado.setPageQuantity(lastPageNumber);
        if(lastPageNumber == page) resultado.setLastPage(true);
        // End pagination 
        Query query = session.getNamedQuery(entityClass.getClass().getSimpleName() + ".findBy" + findBy);        
        query.setParameter("id", Integer.parseInt(searchValue));
        // ------------------------------------------------------------------------------------------------------------------
        
        // ------------------------------------------------------------------------------------------------------------------
        query.setFirstResult(page * linesPerPage);
        query.setMaxResults(linesPerPage);
        // if(true) throw new UnsupportedOperationException("AbstractDAO.findByPage query=" + query);
        resultado.setEntidades(query.list());
        // Calcular botões de navegação por páginas:
        int initialPage = 0;
        if(page > 4){
            initialPage = page - 4;        
        }
        int finalPage = page + 4;
        if(finalPage > lastPageNumber){
            finalPage = lastPageNumber;
        }
        
        resultado.setInitialPage(initialPage);
        resultado.setFinalPage(finalPage);
        
        return resultado;

    }
    
    @Override 
    public Resultado findByDate(EntidadeDominio entidadeDominio) {
        
        TableOrderTemp orderTemp = (TableOrderTemp) entidadeDominio;
        Resultado resultado = new Resultado();
        
        Session session = EntityManagerProvider.getSession();
        
        // Pagination lines counting        
        
        Query query = session.getNamedQuery(entityClass.getClass().getSimpleName() + ".findByDate");
       
        query.setParameter("startDate", orderTemp.getDateAdded(), TemporalType.TIMESTAMP);
        query.setParameter("endDate", orderTemp.getDateModified(), TemporalType.TIMESTAMP);
        
        // if(true) throw new UnsupportedOperationException("Fachada.findByPage query=" + query);
        
        resultado.setEntidades(query.list());
        
        return resultado;

    }
    
    @Override 
    public Resultado findAllPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
        // Test
        /*
        if(true) throw new UnsupportedOperationException("AbstractDAO.findByPage "
                    + "findBy=" + findBy
                    + "\tsearchValue=" + searchValue
                    + "\tpage=" + page
                    + "\tlinesPerPage=" + linesPerPage
                    + "\torderBy=" + orderBy
                    + "\tdirection=" + direction
            );
        */
         //End Test
        Resultado resultado = new Resultado();
        
        Session session = EntityManagerProvider.getSession();
        
        // Pagination lines counting        
        Query countQuery = session.getNamedQuery(entityClass.getClass().getSimpleName() + ".findCount");
        Long countResults = (Long) countQuery.uniqueResult();        
        resultado.setPageNumber(page);
        resultado.setItensQuantity(countResults.intValue());
        //Last Page
        int lastPageNumber = (int) ((countResults / linesPerPage) );
        resultado.setPageQuantity(lastPageNumber);
        if(lastPageNumber == page) resultado.setLastPage(true);
        // End pagination ------------------------------------------------------------------------------------------------------------------
        
        Query query = session.getNamedQuery(entityClass.getClass().getSimpleName() + ".findAll");
        query.setFirstResult(page * linesPerPage);
        query.setMaxResults(linesPerPage);
        // if(true) throw new UnsupportedOperationException("AbstractDAO.findByPage query=" + query);
        resultado.setEntidades(query.list());
        // Calcular botões de navegação por páginas:
        int initialPage = 0;
        if(page > 4){
            initialPage = page - 4;        
        }
        int finalPage = page + 4;
        if(finalPage > lastPageNumber){
            finalPage = lastPageNumber;
        }
        
        resultado.setInitialPage(initialPage);
        resultado.setFinalPage(finalPage);
        
        return resultado;

    }

    
    @Override
    public EntidadeDominio findOneById(Integer id) {        
       
        Session session = EntityManagerProvider.getSession();                
        Query query = session.getNamedQuery(entityClass.getClass().getSimpleName() + ".findById");
        query.setParameter("id", id);        
        EntidadeDominio entity = (EntidadeDominio) query.uniqueResult();        
        return entity;
        
    }

    @Override
    public List<EntidadeDominio> findByName(String name) {

        Session session = EntityManagerProvider.getSession();
        Query query = session.getNamedQuery(entityClass.getClass().getSimpleName() + ".findByName");
        query.setParameter("name", name);
        List<EntidadeDominio> entityList = query.list();
        return entityList;
    }
    
    @Override
    public List<EntidadeDominio> findByColumn(String findBy, String searchValue) {
        
        Session session = EntityManagerProvider.getSession();                
        Query query = session.getNamedQuery(entityClass.getClass().getSimpleName() + ".findBy" + findBy);        
        query.setParameter("value", searchValue);
        List<EntidadeDominio> entityList = query.list();
        
        return entityList;

    }

    /**
     *
     * @param range
     * @return
     */
    @Override
    public List<EntidadeDominio> findRange(int[] range) {
        throw new UnsupportedOperationException("AbstractDAO.findRange Ainda não foi implantado"); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param entity
     * @return
     */
    @Override
    public EntidadeDominio update(EntidadeDominio entity) {
        
        System.out.println("AbstractDAO.update " + entity.getClass().getSimpleName());        
        Session session = EntityManagerProvider.getSession();        
        session.beginTransaction();
        session.saveOrUpdate(entity);
        session.getTransaction().commit();
        return findOneById(entity.getId());
    }

    /**
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        EntidadeDominio entidadeDominio = findOneById(id);        
        Session session = EntityManagerProvider.getSession(); 
        Transaction transaction = session.beginTransaction();
        session.delete(entidadeDominio);
        transaction.commit();
    }

}
