/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_return_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableReturnStatus.findAll", query = "SELECT t FROM TableReturnStatus t"),
    @NamedQuery(name = "TableReturnStatus.findById", query = "SELECT t FROM TableReturnStatus t WHERE t.returnStatusId = :returnStatusId"),
    @NamedQuery(name = "TableReturnStatus.findByName", query = "SELECT t FROM TableReturnStatus t WHERE t.name = :name")})
public class TableReturnStatus extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "return_status_id")
    private Integer returnStatusId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "language_id")
    private Integer languageId;
    public TableReturnStatus() {
    }
    public TableReturnStatus(Integer returnStatusId) {
        this.returnStatusId = returnStatusId;
    }
    public TableReturnStatus(Integer returnStatusId, String name, Integer languageId) {
        this.returnStatusId = returnStatusId;
        this.name = name;
        this.languageId = languageId;
    }

    public Integer getId() {
        return returnStatusId;
    }

    public void setId(Integer returnStatusId) {
        this.returnStatusId = returnStatusId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getLanguageId() {
        return languageId;
    }

    public void setLanguageId(Integer languageId) {
        this.languageId = languageId;
    }
    
    
    

    
}
