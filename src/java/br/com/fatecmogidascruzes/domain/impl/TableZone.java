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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "table_zone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableZone.findAll", query = "SELECT t FROM TableZone t"),
    @NamedQuery(name = "TableZone.findByZoneId", query = "SELECT t FROM TableZone t WHERE t.zoneId = :zoneId"),
    @NamedQuery(name = "TableZone.findByName", query = "SELECT t FROM TableZone t WHERE t.name = :name"),
    @NamedQuery(name = "TableZone.findByCode", query = "SELECT t FROM TableZone t WHERE t.code = :code"),
    @NamedQuery(name = "TableZone.findByStatus", query = "SELECT t FROM TableZone t WHERE t.status = :status")})
public class TableZone extends EntidadeDominio implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "zone_id")
    private Integer zoneId;
    // Collections ------------------------------------------------------------------------------------------------
    @JsonIgnore
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = false)
    private TableCountry country;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zoneId")
    private List<TableAddress> tableAddressList;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "zoneId")
    private List<TableZoneToGeoZone> tableZoneToGeoZoneList;

    public TableZone() {
    }

    public TableZone(Integer zoneId) {
        this.zoneId = zoneId;
    }

    public TableZone(Integer zoneId, String name, String code, boolean status) {
        this.zoneId = zoneId;
        this.name = name;
        this.code = code;
        this.status = status;
    }

    @Override
    public Integer getId() {
        return zoneId;
    }

    @Override
    public void setId(Integer zoneId) {
        this.zoneId = zoneId;
    }


    public TableCountry getCountryId() {
        return country;
    }

    public void setCountryId(TableCountry countryId) {
        this.country = countryId;
    }

    @XmlTransient
    public List<TableAddress> getTableAddressList() {
        return tableAddressList;
    }

    public void setTableAddressList(List<TableAddress> tableAddressList) {
        this.tableAddressList = tableAddressList;
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
        hash += (zoneId != null ? zoneId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableZone)) {
            return false;
        }
        TableZone other = (TableZone) object;
        if ((this.zoneId == null && other.zoneId != null) || (this.zoneId != null && !this.zoneId.equals(other.zoneId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableZone[ zoneId=" + zoneId + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
