/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "table_stock_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableStockStatus.findAll", query = "SELECT t FROM TableStockStatus t"),
    @NamedQuery(name = "TableStockStatus.findById", query = "SELECT t FROM TableStockStatus t WHERE t.stockStatusId = :id"),
    @NamedQuery(name = "TableStockStatus.findByName", query = "SELECT t FROM TableStockStatus t WHERE t.name = :name")})
public class TableStockStatus extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stock_status_id")
    private Integer stockStatusId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    
    // Collections ---------------------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "stockStatus")
    private List<TableProduct> tableProductList;

    // Constructors --------------------------------------------------------------------------------------------------------------------------------
    public TableStockStatus() {
    }

    public TableStockStatus(Integer stockStatusId) {
        this.stockStatusId = stockStatusId;
    }

    public TableStockStatus(Integer stockStatusId, String name) {
        this.stockStatusId = stockStatusId;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return stockStatusId;
    }

    @Override
    public void setId(Integer stockStatusId) {
        this.stockStatusId = stockStatusId;
    }


    @XmlTransient
    public List<TableProduct> getTableProductList() {
        return tableProductList;
    }

    public void setTableProductList(List<TableProduct> tableProductList) {
        this.tableProductList = tableProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockStatusId != null ? stockStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableStockStatus)) {
            return false;
        }
        TableStockStatus other = (TableStockStatus) object;
        if ((this.stockStatusId == null && other.stockStatusId != null) || (this.stockStatusId != null && !this.stockStatusId.equals(other.stockStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableStockStatus[ stockStatusId=" + stockStatusId + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
