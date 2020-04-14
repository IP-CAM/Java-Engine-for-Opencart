/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "table_tax_rate")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableTaxRate.findAll", query = "SELECT t FROM TableTaxRate t"),
    @NamedQuery(name = "TableTaxRate.findByTaxRateId", query = "SELECT t FROM TableTaxRate t WHERE t.taxRateId = :taxRateId"),
    @NamedQuery(name = "TableTaxRate.findByGeoZoneId", query = "SELECT t FROM TableTaxRate t WHERE t.geoZoneId = :geoZoneId"),
    @NamedQuery(name = "TableTaxRate.findByName", query = "SELECT t FROM TableTaxRate t WHERE t.name = :name"),
    @NamedQuery(name = "TableTaxRate.findByRate", query = "SELECT t FROM TableTaxRate t WHERE t.rate = :rate"),
    @NamedQuery(name = "TableTaxRate.findByType", query = "SELECT t FROM TableTaxRate t WHERE t.type = :type"),
    @NamedQuery(name = "TableTaxRate.findByDateAdded", query = "SELECT t FROM TableTaxRate t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableTaxRate.findByDateModified", query = "SELECT t FROM TableTaxRate t WHERE t.dateModified = :dateModified")})
public class TableTaxRate extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tax_rate_id")
    private Integer taxRateId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "geo_zone_id")
    private int geoZoneId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "rate")
    private BigDecimal rate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private Character type;
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

    public TableTaxRate() {
    }

    public TableTaxRate(Integer taxRateId) {
        this.taxRateId = taxRateId;
    }

    public TableTaxRate(Integer taxRateId, int geoZoneId, String name, BigDecimal rate, Character type, Date dateAdded, Date dateModified) {
        this.taxRateId = taxRateId;
        this.geoZoneId = geoZoneId;
        this.name = name;
        this.rate = rate;
        this.type = type;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return taxRateId;
    }

    @Override
    public void setId(Integer taxRateId) {
        this.taxRateId = taxRateId;
    }

    public int getGeoZoneId() {
        return geoZoneId;
    }

    public void setGeoZoneId(int geoZoneId) {
        this.geoZoneId = geoZoneId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxRateId != null ? taxRateId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableTaxRate)) {
            return false;
        }
        TableTaxRate other = (TableTaxRate) object;
        if ((this.taxRateId == null && other.taxRateId != null) || (this.taxRateId != null && !this.taxRateId.equals(other.taxRateId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableTaxRate[ taxRateId=" + taxRateId + " ]";
    }
    
}
