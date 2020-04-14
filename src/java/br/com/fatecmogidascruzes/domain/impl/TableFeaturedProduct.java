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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "table_featured_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableFeaturedProduct.findAll", query = "SELECT t FROM TableFeaturedProduct t"),
    @NamedQuery(name = "TableFeaturedProduct.findById", query = "SELECT t FROM TableFeaturedProduct t WHERE t.featuredId = :id"),
    @NamedQuery(name = "TableFeaturedProduct.findByName", query = "SELECT t FROM TableFeaturedProduct t WHERE t.name = :name")})
public class TableFeaturedProduct extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "featured_id")
    private Integer featuredId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    
    @JoinTable(name = "table_featured_to_product", joinColumns = {
        @JoinColumn(name = "featured_id", referencedColumnName = "featured_id")}, inverseJoinColumns = {
        @JoinColumn(name = "product_id", referencedColumnName = "product_id")})
    @ManyToMany
    private List<TableProduct> productList;

    public TableFeaturedProduct() {
    }

    public TableFeaturedProduct(Integer featuredId) {
        this.featuredId = featuredId;
    }

    public TableFeaturedProduct(Integer featuredId, String name) {
        this.featuredId = featuredId;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return featuredId;
    }

    @Override
    public void setId(Integer featuredId) {
        this.featuredId = featuredId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlTransient
    public List<TableProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<TableProduct> tableProductList) {
        this.productList = tableProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (featuredId != null ? featuredId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableFeaturedProduct)) {
            return false;
        }
        TableFeaturedProduct other = (TableFeaturedProduct) object;
        if ((this.featuredId == null && other.featuredId != null) || (this.featuredId != null && !this.featuredId.equals(other.featuredId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableFeaturedProduct[ featuredId=" + featuredId + " ]";
    }
    
}
