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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "table_option")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOption.findAll", query = "SELECT t FROM TableOption t"),
    @NamedQuery(name = "TableOption.findByOptionId", query = "SELECT t FROM TableOption t WHERE t.optionId = :optionId"),
    @NamedQuery(name = "TableOption.findByType", query = "SELECT t FROM TableOption t WHERE t.type = :type"),
    @NamedQuery(name = "TableOption.findBySortOrder", query = "SELECT t FROM TableOption t WHERE t.sortOrder = :sortOrder")})
public class TableOption extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "option_id")
    private Integer optionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;

    public TableOption() {
    }

    public TableOption(Integer optionId) {
        this.optionId = optionId;
    }

    public TableOption(Integer optionId, String name, String type, int sortOrder) {
        this.optionId = optionId;
        this.name = name;
        this.type = type;
        this.sortOrder = sortOrder;
    }

    @Override
    public Integer getId() {
        return optionId;
    }

    @Override
    public void setId(Integer optionId) {
        this.optionId = optionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }   
    

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionId != null ? optionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOption)) {
            return false;
        }
        TableOption other = (TableOption) object;
        if ((this.optionId == null && other.optionId != null) || (this.optionId != null && !this.optionId.equals(other.optionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOption[ optionId=" + optionId + " ]";
    }
    
}
