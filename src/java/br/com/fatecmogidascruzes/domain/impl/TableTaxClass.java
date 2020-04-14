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
@Table(name = "table_tax_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableTaxClass.findAll", query = "SELECT t FROM TableTaxClass t"),
    @NamedQuery(name = "TableTaxClass.findByTaxClassId", query = "SELECT t FROM TableTaxClass t WHERE t.taxClassId = :taxClassId"),
    @NamedQuery(name = "TableTaxClass.findByTitle", query = "SELECT t FROM TableTaxClass t WHERE t.title = :title"),
    @NamedQuery(name = "TableTaxClass.findByDescription", query = "SELECT t FROM TableTaxClass t WHERE t.description = :description"),
    @NamedQuery(name = "TableTaxClass.findByDateAdded", query = "SELECT t FROM TableTaxClass t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableTaxClass.findByDateModified", query = "SELECT t FROM TableTaxClass t WHERE t.dateModified = :dateModified")})
public class TableTaxClass extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tax_class_id")    
    private Integer taxClassId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
   
    // Collections ---------------------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "taxClass")
    private List<TableProduct> tableProductList;

    // Constructors ---------------------------------------------------------------------------------------------------------------------------------
    public TableTaxClass() {
    }

    public TableTaxClass(Integer taxClassId) {
        this.taxClassId = taxClassId;
    }

    public TableTaxClass(Integer taxClassId, String title, String description, Date dateAdded, Date dateModified) {
        this.taxClassId = taxClassId;
        this.title = title;
        this.description = description;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return taxClassId;
    }

    @Override
    public void setId(Integer taxClassId) {
        this.taxClassId = taxClassId;
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
    public List<TableProduct> getTableProductList() {
        return tableProductList;
    }

    public void setTableProductList(List<TableProduct> tableProductList) {
        this.tableProductList = tableProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxClassId != null ? taxClassId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableTaxClass)) {
            return false;
        }
        TableTaxClass other = (TableTaxClass) object;
        if ((this.taxClassId == null && other.taxClassId != null) || (this.taxClassId != null && !this.taxClassId.equals(other.taxClassId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableTaxClass[ taxClassId=" + taxClassId + " ]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
