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
@Table(name = "table_geo_zone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableGeoZone.findAll", query = "SELECT t FROM TableGeoZone t"),
    @NamedQuery(name = "TableGeoZone.findByGeoZoneId", query = "SELECT t FROM TableGeoZone t WHERE t.geoZoneId = :geoZoneId"),
    @NamedQuery(name = "TableGeoZone.findByName", query = "SELECT t FROM TableGeoZone t WHERE t.name = :name"),
    @NamedQuery(name = "TableGeoZone.findByDescription", query = "SELECT t FROM TableGeoZone t WHERE t.description = :description"),
    @NamedQuery(name = "TableGeoZone.findByDateAdded", query = "SELECT t FROM TableGeoZone t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableGeoZone.findByDateModified", query = "SELECT t FROM TableGeoZone t WHERE t.dateModified = :dateModified")})
public class TableGeoZone extends EntidadeDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "geo_zone_id")    
    private Integer geoZoneId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
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
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "geoZoneId")
    private List<TableZoneToGeoZone> tableZoneToGeoZoneList;

    public TableGeoZone() {
    }

    public TableGeoZone(Integer geoZoneId) {
        this.geoZoneId = geoZoneId;
    }

    public TableGeoZone(Integer geoZoneId, String name, String description, Date dateAdded, Date dateModified) {
        this.geoZoneId = geoZoneId;
        this.name = name;
        this.description = description;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return geoZoneId;
    }

    @Override
    public void setId(Integer geoZoneId) {
        this.geoZoneId = geoZoneId;
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
    public List<TableZoneToGeoZone> getTableZoneToGeoZoneList() {
        return tableZoneToGeoZoneList;
    }

    public void setTableZoneToGeoZoneList(List<TableZoneToGeoZone> tableZoneToGeoZoneList) {
        this.tableZoneToGeoZoneList = tableZoneToGeoZoneList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (geoZoneId != null ? geoZoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableGeoZone)) {
            return false;
        }
        TableGeoZone other = (TableGeoZone) object;
        if ((this.geoZoneId == null && other.geoZoneId != null) || (this.geoZoneId != null && !this.geoZoneId.equals(other.geoZoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableGeoZone[ geoZoneId=" + geoZoneId + " ]";
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
    
    
    
}
