/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_return_action")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableReturnAction.findAll", query = "SELECT t FROM TableReturnAction t"),
    @NamedQuery(name = "TableReturnAction.findByName", query = "SELECT t FROM TableReturnAction t WHERE t.name = :name")})
public class TableReturnAction extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "return_action_id")
    private Integer returnActionId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;

    public TableReturnAction() {
    }    

    @Override
    public Integer getId() {
        return returnActionId;
    }

    @Override
    public void setId(Integer returnActionId) {
        this.returnActionId = returnActionId;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
