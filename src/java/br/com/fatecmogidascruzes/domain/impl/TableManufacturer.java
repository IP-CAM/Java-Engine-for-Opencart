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
@Table(name = "table_manufacturer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableManufacturer.findAll", query = "SELECT t FROM TableManufacturer t"),
    @NamedQuery(name = "TableManufacturer.findByManufacturerId", query = "SELECT t FROM TableManufacturer t WHERE t.manufacturerId = :manufacturerId"),
    @NamedQuery(name = "TableManufacturer.findByName", query = "SELECT t FROM TableManufacturer t WHERE t.name = :name"),
    @NamedQuery(name = "TableManufacturer.findByImage", query = "SELECT t FROM TableManufacturer t WHERE t.image = :image"),
    @NamedQuery(name = "TableManufacturer.findBySortOrder", query = "SELECT t FROM TableManufacturer t WHERE t.sortOrder = :sortOrder")})
public class TableManufacturer extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "manufacturer_id")
    private Integer manufacturerId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
   
    // Collections ---------------------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "manufacturer")
    private List<TableProduct> tableProductList;

    // Constructors --------------------------------------------------------------------------------------------------------------------------------
    public TableManufacturer() {
    }

    public TableManufacturer(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }

    public TableManufacturer(Integer manufacturerId, String name, int sortOrder) {
        this.manufacturerId = manufacturerId;
        this.name = name;
        this.sortOrder = sortOrder;
    }

    @Override
    public Integer getId() {
        return manufacturerId;
    }

    @Override
    public void setId(Integer manufacturerId) {
        this.manufacturerId = manufacturerId;
    }


    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
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
        hash += (manufacturerId != null ? manufacturerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableManufacturer)) {
            return false;
        }
        TableManufacturer other = (TableManufacturer) object;
        if ((this.manufacturerId == null && other.manufacturerId != null) || (this.manufacturerId != null && !this.manufacturerId.equals(other.manufacturerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableManufacturer[ manufacturerId=" + manufacturerId + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }  
    
    
}
