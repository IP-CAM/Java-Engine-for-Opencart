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
@Table(name = "table_filter")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableFilter.findAll", query = "SELECT t FROM TableFilter t"),
    @NamedQuery(name = "TableFilter.findById", query = "SELECT t FROM TableFilter t WHERE t.filterId = :id"),
    @NamedQuery(name = "TableFilter.findByFilterGroupId", query = "SELECT t FROM TableFilter t WHERE t.filterGroupId = :filterGroupId"),
    @NamedQuery(name = "TableFilter.findBySortOrder", query = "SELECT t FROM TableFilter t WHERE t.sortOrder = :sortOrder"),
    @NamedQuery(name = "TableFilter.findByName", query = "SELECT t FROM TableFilter t WHERE t.name = :name")})
public class TableFilter extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "filter_id")
    private Integer filterId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "filter_group_id")
    private int filterGroupId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;

    public TableFilter() {
    }

    public TableFilter(Integer filterId) {
        this.filterId = filterId;
    }

    public TableFilter(Integer filterId, int filterGroupId, int sortOrder, String name) {
        this.filterId = filterId;
        this.filterGroupId = filterGroupId;
        this.sortOrder = sortOrder;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return filterId;
    }

    @Override
    public void setId(Integer filterId) {
        this.filterId = filterId;
    }

    public int getFilterGroupId() {
        return filterGroupId;
    }

    public void setFilterGroupId(int filterGroupId) {
        this.filterGroupId = filterGroupId;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (filterId != null ? filterId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableFilter)) {
            return false;
        }
        TableFilter other = (TableFilter) object;
        if ((this.filterId == null && other.filterId != null) || (this.filterId != null && !this.filterId.equals(other.filterId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableFilter[ filterId=" + filterId + " ]";
    }
    
}
