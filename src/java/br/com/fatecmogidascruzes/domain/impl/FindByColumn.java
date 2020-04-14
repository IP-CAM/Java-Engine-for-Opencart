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

public class FindByColumn extends EntidadeDominio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    private Integer id;
    // Variáveis de conteúdo
    private EntidadeDominio entity;
    private String findBy = "name";
    private String searchValue = "value";     

    // Constructors
    public FindByColumn(String findBy, String searchValue) {
        this.findBy = findBy;
        this.searchValue = searchValue;
    }

    // Getters and Setters:
    @Override
    public Integer getId() {
        return id;
    }
    
    @Override
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
    
    public EntidadeDominio getEntity() {
        return entity;
    }

    public void setEntity(EntidadeDominio entity) {        
        this.entity = entity;
    } 

}
