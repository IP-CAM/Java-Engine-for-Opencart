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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_zone_to_geo_zone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableZoneToGeoZone.findAll", query = "SELECT t FROM TableZoneToGeoZone t"),
    @NamedQuery(name = "TableZoneToGeoZone.findByZoneToGeoZoneId", query = "SELECT t FROM TableZoneToGeoZone t WHERE t.zoneToGeoZoneId = :zoneToGeoZoneId"),
    @NamedQuery(name = "TableZoneToGeoZone.findByDateAdded", query = "SELECT t FROM TableZoneToGeoZone t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableZoneToGeoZone.findByDateModified", query = "SELECT t FROM TableZoneToGeoZone t WHERE t.dateModified = :dateModified")})
public class TableZoneToGeoZone extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zone_to_geo_zone_id")
    private Integer zoneToGeoZoneId;
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
    
    // Collections ---------------------------------------------------------------------------------------------
    @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
    @ManyToOne(optional = false)
    private TableZone zoneId;
    
    @JsonIgnore
    @JoinColumn(name = "geo_zone_id", referencedColumnName = "geo_zone_id")
    @ManyToOne(optional = false)
    private TableGeoZone geoZoneId;
    
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = false)
    private TableCountry country;

    public TableZoneToGeoZone() {
    }

    public TableZoneToGeoZone(Integer zoneToGeoZoneId) {
        this.zoneToGeoZoneId = zoneToGeoZoneId;
    }

    public TableZoneToGeoZone(Integer zoneToGeoZoneId, Date dateAdded, Date dateModified) {
        this.zoneToGeoZoneId = zoneToGeoZoneId;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return zoneToGeoZoneId;
    }

    @Override
    public void setId(Integer zoneToGeoZoneId) {
        this.zoneToGeoZoneId = zoneToGeoZoneId;
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

    public TableZone getZoneId() {
        return zoneId;
    }

    public void setZoneId(TableZone zoneId) {
        this.zoneId = zoneId;
    }

    public TableGeoZone getGeoZoneId() {
        return geoZoneId;
    }

    public void setGeoZoneId(TableGeoZone geoZoneId) {
        this.geoZoneId = geoZoneId;
    }

    public TableCountry getCountryId() {
        return country;
    }

    public void setCountryId(TableCountry countryId) {
        this.country = countryId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (zoneToGeoZoneId != null ? zoneToGeoZoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableZoneToGeoZone)) {
            return false;
        }
        TableZoneToGeoZone other = (TableZoneToGeoZone) object;
        if ((this.zoneToGeoZoneId == null && other.zoneToGeoZoneId != null) || (this.zoneToGeoZoneId != null && !this.zoneToGeoZoneId.equals(other.zoneToGeoZoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableZoneToGeoZone[ zoneToGeoZoneId=" + zoneToGeoZoneId + " ]";
    }
    
}
