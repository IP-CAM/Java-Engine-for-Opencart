/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "table_store")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableStore.findAll", query = "SELECT t FROM TableStore t"),
    @NamedQuery(name = "TableStore.findById", query = "SELECT t FROM TableStore t WHERE t.storeId = :id"),
    @NamedQuery(name = "TableStore.findByName", query = "SELECT t FROM TableStore t WHERE t.name = :name"),
    @NamedQuery(name = "TableStore.findByUrl", query = "SELECT t FROM TableStore t WHERE t.url = :url"),
    @NamedQuery(name = "TableStore.findBySsl", query = "SELECT t FROM TableStore t WHERE t.ssl = :ssl")})
public class TableStore extends EntidadeDominio implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "url")
    private String url;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "ssl")
    private String ssl;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "store_id")
    private Integer storeId;
    
    // Collections
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private List<TableCustomer> tableCustomerList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "store")
    private List<TableOrder> orderList;
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "table_store_to_featured",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "featured_id")
    )
    private List<TableFeaturedProduct> featuredProduct = new ArrayList<>();
    
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "table_store_to_category",
            joinColumns = @JoinColumn(name = "store_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<TableCategory> categoryList = new ArrayList<>();

    public TableStore() {
    }

    public TableStore(Integer storeId) {
        this.storeId = storeId;
    }

    public TableStore(Integer storeId, String name, String url, String ssl) {
        this.storeId = storeId;
        this.name = name;
        this.url = url;
        this.ssl = ssl;
    }

    @Override
    public Integer getId() {
        return storeId;
    }

    @Override
    public void setId(Integer storeId) {
        this.storeId = storeId;
    }

    @XmlTransient
    public List<TableOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<TableOrder> tableOrderList) {
        this.orderList = tableOrderList;
    }

    public List<TableFeaturedProduct> getFeaturedProduct() {
        return featuredProduct;
    }

    public void setFeaturedProduct(List<TableFeaturedProduct> featuredProduct) {
        this.featuredProduct = featuredProduct;
    }

    public List<TableCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<TableCategory> tableCategory) {
        this.categoryList = tableCategory;
    }   

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (storeId != null ? storeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableStore)) {
            return false;
        }
        TableStore other = (TableStore) object;
        if ((this.storeId == null && other.storeId != null) || (this.storeId != null && !this.storeId.equals(other.storeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableStore[ storeId=" + storeId + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSsl() {
        return ssl;
    }

    public void setSsl(String ssl) {
        this.ssl = ssl;
    }

   
    
}
