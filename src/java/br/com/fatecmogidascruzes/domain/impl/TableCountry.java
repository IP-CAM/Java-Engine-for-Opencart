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
import javax.persistence.Lob;
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
@Table(name = "table_country")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCountry.findAll", query = "SELECT t FROM TableCountry t"),
    @NamedQuery(name = "TableCountry.findByCountryId", query = "SELECT t FROM TableCountry t WHERE t.countryId = :countryId"),
    @NamedQuery(name = "TableCountry.findByName", query = "SELECT t FROM TableCountry t WHERE t.name = :name"),
    @NamedQuery(name = "TableCountry.findByIsoCode2", query = "SELECT t FROM TableCountry t WHERE t.isoCode2 = :isoCode2"),
    @NamedQuery(name = "TableCountry.findByIsoCode3", query = "SELECT t FROM TableCountry t WHERE t.isoCode3 = :isoCode3"),
    @NamedQuery(name = "TableCountry.findByPostcodeRequired", query = "SELECT t FROM TableCountry t WHERE t.postcodeRequired = :postcodeRequired"),
    @NamedQuery(name = "TableCountry.findByStatus", query = "SELECT t FROM TableCountry t WHERE t.status = :status")})
public class TableCountry extends EntidadeDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "country_id")
    private Integer countryId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 2)
    @Column(name = "iso_code_2")
    private String isoCode2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "iso_code_3")
    private String isoCode3;
    @Basic(optional = false)
    @NotNull
    @Lob()
    @Size(min = 1, max = 65535)
    @Column(name = "address_format")
    private String addressFormat;
    @Basic(optional = false)
    @NotNull
    @Column(name = "postcode_required")
    private boolean postcodeRequired;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<TableZoneToGeoZone> tableZoneToGeoZoneList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<TableZone> tableZoneList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "country")
    private List<TableAddress> tableAddressList;

    public TableCountry() {
    }

    public TableCountry(Integer countryId) {
        this.countryId = countryId;
    }

    public TableCountry(Integer countryId, String name, String isoCode2, String isoCode3, String addressFormat, boolean postcodeRequired, boolean status) {
        this.countryId = countryId;
        this.name = name;
        this.isoCode2 = isoCode2;
        this.isoCode3 = isoCode3;
        this.addressFormat = addressFormat;
        this.postcodeRequired = postcodeRequired;
        this.status = status;
    }

    @Override
    public Integer getId() {
        return countryId;
    }

    @Override
    public void setId(Integer countryId) {
        this.countryId = countryId;
    }


    public String getIsoCode2() {
        return isoCode2;
    }

    public void setIsoCode2(String isoCode2) {
        this.isoCode2 = isoCode2;
    }

    public String getIsoCode3() {
        return isoCode3;
    }

    public void setIsoCode3(String isoCode3) {
        this.isoCode3 = isoCode3;
    }

    public String getAddressFormat() {
        return addressFormat;
    }

    public void setAddressFormat(String addressFormat) {
        this.addressFormat = addressFormat;
    }

    public boolean getPostcodeRequired() {
        return postcodeRequired;
    }

    public void setPostcodeRequired(boolean postcodeRequired) {
        this.postcodeRequired = postcodeRequired;
    }

    @XmlTransient
    public List<TableZone> getTableZoneList() {
        return tableZoneList;
    }

    public void setTableZoneList(List<TableZone> tableZoneList) {
        this.tableZoneList = tableZoneList;
    }

    @XmlTransient
    public List<TableAddress> getTableAddressList() {
        return tableAddressList;
    }

    public void setTableAddressList(List<TableAddress> tableAddressList) {
        this.tableAddressList = tableAddressList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (countryId != null ? countryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCountry)) {
            return false;
        }
        TableCountry other = (TableCountry) object;
        if ((this.countryId == null && other.countryId != null) || (this.countryId != null && !this.countryId.equals(other.countryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCountry[ countryId=" + countryId + " ]";
    }


    @XmlTransient
    public List<TableZoneToGeoZone> getTableZoneToGeoZoneList() {
        return tableZoneToGeoZoneList;
    }

    public void setTableZoneToGeoZoneList(List<TableZoneToGeoZone> tableZoneToGeoZoneList) {
        this.tableZoneToGeoZoneList = tableZoneToGeoZoneList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
