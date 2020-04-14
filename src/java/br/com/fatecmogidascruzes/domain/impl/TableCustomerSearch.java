/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_customer_search")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomerSearch.findAll", query = "SELECT t FROM TableCustomerSearch t"),
    @NamedQuery(name = "TableCustomerSearch.findByCustomerSearchId", query = "SELECT t FROM TableCustomerSearch t WHERE t.customerSearchId = :customerSearchId"),
    @NamedQuery(name = "TableCustomerSearch.findByStoreId", query = "SELECT t FROM TableCustomerSearch t WHERE t.storeId = :storeId"),
    @NamedQuery(name = "TableCustomerSearch.findByCustomer", query = "SELECT t FROM TableCustomerSearch t WHERE t.customer = :customer"),
    @NamedQuery(name = "TableCustomerSearch.findByKeyword", query = "SELECT t FROM TableCustomerSearch t WHERE t.keyword = :keyword"),
    @NamedQuery(name = "TableCustomerSearch.findBySubCategory", query = "SELECT t FROM TableCustomerSearch t WHERE t.subCategory = :subCategory"),
    @NamedQuery(name = "TableCustomerSearch.findByDescription", query = "SELECT t FROM TableCustomerSearch t WHERE t.description = :description"),
    @NamedQuery(name = "TableCustomerSearch.findByProducts", query = "SELECT t FROM TableCustomerSearch t WHERE t.products = :products"),
    @NamedQuery(name = "TableCustomerSearch.findByIp", query = "SELECT t FROM TableCustomerSearch t WHERE t.ip = :ip"),
    @NamedQuery(name = "TableCustomerSearch.findByDateAdded", query = "SELECT t FROM TableCustomerSearch t WHERE t.dateAdded = :dateAdded")})
public class TableCustomerSearch extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_search_id")
    private Integer customerSearchId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "store_id")
    private int storeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "language_id")
    private int languageId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int customer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "keyword")
    private String keyword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sub_category")
    private boolean subCategory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "description")
    private boolean description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "products")
    private int products;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    // Collections
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    @ManyToOne
    private TableCategory categoryId;

    public TableCustomerSearch() {
    }

    public TableCustomerSearch(Integer customerSearchId) {
        this.customerSearchId = customerSearchId;
    }

    public TableCustomerSearch(Integer customerSearchId, int storeId, int languageId, int customer, String keyword, boolean subCategory, boolean description, int products, String ip, Date dateAdded) {
        this.customerSearchId = customerSearchId;
        this.storeId = storeId;
        this.languageId = languageId;
        this.customer = customer;
        this.keyword = keyword;
        this.subCategory = subCategory;
        this.description = description;
        this.products = products;
        this.ip = ip;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return customerSearchId;
    }

    @Override
    public void setId(Integer customerSearchId) {
        this.customerSearchId = customerSearchId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public int getCustomer() {
        return customer;
    }

    public void setCustomer(int customer) {
        this.customer = customer;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public boolean getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(boolean subCategory) {
        this.subCategory = subCategory;
    }

    public boolean getDescription() {
        return description;
    }

    public void setDescription(boolean description) {
        this.description = description;
    }

    public int getProducts() {
        return products;
    }

    public void setProducts(int products) {
        this.products = products;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public TableCategory getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(TableCategory categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerSearchId != null ? customerSearchId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomerSearch)) {
            return false;
        }
        TableCustomerSearch other = (TableCustomerSearch) object;
        if ((this.customerSearchId == null && other.customerSearchId != null) || (this.customerSearchId != null && !this.customerSearchId.equals(other.customerSearchId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCustomerSearch[ customerSearchId=" + customerSearchId + " ]";
    }
    
}
