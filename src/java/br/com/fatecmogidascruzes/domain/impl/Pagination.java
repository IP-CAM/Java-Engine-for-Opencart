/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Josias Wattrelos
 */
@Entity

public class Pagination extends EntidadeDominio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    // Variáveis de conteúdo
    private EntidadeDominio entity;
    private String findBy = "id";
    private String searchValue = "1";
    // Variáveis de paginação
    private Integer page = 0;
    private Integer linesPerPage = 24;       
    private String orderBy = "name";
    private String direction = "ASC";
    private boolean lastPage = false;
    
    
    
    public void pagination(){
    }    

    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFindBy() {
        return findBy;
    }

    public void setFindBy(String findBy) {
        this.findBy = findBy;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }
    
    public String getNome() {
        throw new UnsupportedOperationException("Not supported by this class"); //To change body of generated methods, choose Tools | Templates.
    }

    public EntidadeDominio getEntity() {
        return entity;
    }

    public void setEntity(EntidadeDominio entity) {        
        this.entity = entity;
    } 
    
    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
    public Integer getLinesPerPage() {        
        return linesPerPage;
    }

    public void setLinesPerPage(Integer linesPerPage) {
        this.linesPerPage = linesPerPage;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
       this.orderBy = orderBy;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    public boolean isLastPage() {
        return lastPage;
    }
    

}
