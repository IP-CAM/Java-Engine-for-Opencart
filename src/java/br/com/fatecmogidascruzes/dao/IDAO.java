package br.com.fatecmogidascruzes.dao;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import java.util.List;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.util.Date;

public interface IDAO {
    
    // CREATE ------------------------------------------------
    public EntidadeDominio create(EntidadeDominio entity);
    
    // READ --------------------------------------------------
    public EntidadeDominio findOneById(Integer id);
    public List<EntidadeDominio> findByName(String name); 
    public List<EntidadeDominio> findByColumn(String findBy, String searchValue);
    public Resultado findByPage(String findBy, String searchValue, Integer page, Integer linesPerPage, String orderBy, String direction);
    public Resultado findByDate(EntidadeDominio entidadeDominio);
    public Resultado findAllPage(Integer page, Integer linesPerPage, String orderBy, String direction);
    public List<EntidadeDominio> findAll();
    public List<EntidadeDominio> findRange(int[] range);
    
    // UPDATE ------------------------------------------------
    public EntidadeDominio update(EntidadeDominio entity);
    
    // DELETE ------------------------------------------------
    public void delete(Integer id);

    
	
}
