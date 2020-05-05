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
@Table(name = "table_return_reason")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableReturnReason.findAll", query = "SELECT t FROM TableReturnReason t"),
    @NamedQuery(name = "TableReturnReason.findByName", query = "SELECT t FROM TableReturnReason t WHERE t.name = :name")})
public class TableReturnReason extends EntidadeDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "return_reason_id")
    private Integer returnReasonId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "language_id")
    private Integer languageId;

    public TableReturnReason() {
    }
    public TableReturnReason(Integer returnReasonId) {
        this.returnReasonId = returnReasonId;
    }

    public TableReturnReason(Integer returnReasonId, Integer languageId) {
        this.returnReasonId = returnReasonId;
        this.languageId = languageId;
    }

    @Override
    public Integer getId() {
        return returnReasonId;
    }

    @Override
    public void setId(Integer returnReasonId) {
        this.returnReasonId = returnReasonId;
    }
    
    @Override
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    
    
    
}
