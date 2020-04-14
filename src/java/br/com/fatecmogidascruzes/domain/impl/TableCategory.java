/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_category")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCategory.findAll", query = "SELECT t FROM TableCategory t"),
    @NamedQuery(name = "TableCategory.findById", query = "SELECT t FROM TableCategory t WHERE t.categoryId = :id"),
    @NamedQuery(name = "TableCategory.findByName", query = "SELECT t FROM TableCategory t WHERE t.name = :name"),
    @NamedQuery(name = "TableCategory.findByMetaTitle", query = "SELECT t FROM TableCategory t WHERE t.metaTitle = :metaTitle"),
    @NamedQuery(name = "TableCategory.findByMetaDescription", query = "SELECT t FROM TableCategory t WHERE t.metaDescription = :metaDescription"),
    @NamedQuery(name = "TableCategory.findByMetaKeyword", query = "SELECT t FROM TableCategory t WHERE t.metaKeyword = :metaKeyword"),
    @NamedQuery(name = "TableCategory.findByImage", query = "SELECT t FROM TableCategory t WHERE t.image = :image"),
    @NamedQuery(name = "TableCategory.findByTop", query = "SELECT t FROM TableCategory t WHERE t.top = :top"),
    @NamedQuery(name = "TableCategory.findByColumn", query = "SELECT t FROM TableCategory t WHERE t.column = :column"),
    @NamedQuery(name = "TableCategory.findBySortOrder", query = "SELECT t FROM TableCategory t WHERE t.sortOrder = :sortOrder"),
    @NamedQuery(name = "TableCategory.findByStatus", query = "SELECT t FROM TableCategory t WHERE t.status = :status"),
    @NamedQuery(name = "TableCategory.findByDateAdded", query = "SELECT t FROM TableCategory t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableCategory.findByDateModified", query = "SELECT t FROM TableCategory t WHERE t.dateModified = :dateModified")})
public class TableCategory extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "category_id")
    private Integer categoryId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "meta_title")
    private String metaTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "meta_description")
    private String metaDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "meta_keyword")
    private String metaKeyword;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "top")
    private boolean top;
    @Basic(optional = false)
    @NotNull
    @Column(name = "column")
    private int column;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    
    @Basic(optional = false)
    @Column(name = "date_added", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)    
    private Date dateAdded;
    
    @Column(name = "date_modified", updatable = true, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    
    // Collections --------------------------------------------------------------------------------------------------------------------------
    @OneToMany(mappedBy = "parentId")
    private List<TableCategory> categoryList;
    
    @JsonIgnore
    @JoinColumn(name = "parent_id", referencedColumnName = "category_id")
    @ManyToOne
    private TableCategory parentId;
    
    @JsonIgnore
    @OneToMany(mappedBy = "categoryId")
    private List<TableCustomerSearch> customerSearchList;

    // Constructors
    public TableCategory() {
    }

    public TableCategory(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public TableCategory(Integer categoryId, String name, String description, String metaTitle, String metaDescription, String metaKeyword, boolean top, int column, int sortOrder, boolean status, Date dateAdded, Date dateModified) {
        this.categoryId = categoryId;
        this.name = name;
        this.description = description;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.metaKeyword = metaKeyword;
        this.top = top;
        this.column = column;
        this.sortOrder = sortOrder;
        this.status = status;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    // Setters and Getters
    @Override
    public Integer getId() {
        return categoryId;
    }

    @Override
    public void setId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeyword() {
        return metaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getTop() {
        return top;
    }

    public void setTop(boolean top) {
        this.top = top;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @XmlTransient
    public List<TableCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<TableCategory> tableCategoryList) {
        this.categoryList = tableCategoryList;
    }

    public TableCategory getParentId() {
        return parentId;
    }

    public void setParentId(TableCategory parentId) {
        this.parentId = parentId;
    }

    @XmlTransient
    public List<TableCustomerSearch> getTableCustomerSearchList() {
        return customerSearchList;
    }

    public void setTableCustomerSearchList(List<TableCustomerSearch> tableCustomerSearchList) {
        this.customerSearchList = tableCustomerSearchList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoryId != null ? categoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCategory)) {
            return false;
        }
        TableCategory other = (TableCategory) object;
        if ((this.categoryId == null && other.categoryId != null) || (this.categoryId != null && !this.categoryId.equals(other.categoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCategory[ categoryId=" + categoryId + " ]";
    }
    
}
