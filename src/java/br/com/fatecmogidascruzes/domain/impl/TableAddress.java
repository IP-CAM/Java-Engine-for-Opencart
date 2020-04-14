/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableAddress.findAll", query = "SELECT t FROM TableAddress t"),
    @NamedQuery(name = "TableAddress.findById", query = "SELECT t FROM TableAddress t WHERE t.addressId = :id"),
    @NamedQuery(name = "TableAddress.findByComplements", query = "SELECT t FROM TableAddress t WHERE t.complements = :complements")})
public class TableAddress extends EntidadeDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "address_id")
    private Integer addressId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "house_numbering")
    private String houseNumbering;    
    
    @Column(name = "complements")
    private String complements;
    
    // Collections -------------------------------------------------------------------------    
    @JoinColumn(name = "postcode", referencedColumnName = "postcode")
    @ManyToOne(optional = false, cascade = CascadeType.REFRESH)
    private Logradouro logradouro;
    
    @JoinColumn(name = "zone_id", referencedColumnName = "zone_id")
    @ManyToOne(optional = true, cascade = CascadeType.REFRESH)
    private TableZone zoneId;
    
    @JoinColumn(name = "country_id", referencedColumnName = "country_id")
    @ManyToOne(optional = true, cascade = CascadeType.REFRESH)
    private TableCountry country;
      
    @JsonIgnore    
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;

    // Constructors -------------------------------------------------------------------------
    public TableAddress() {
    }

    public TableAddress(Integer addressId) {
        this.addressId = addressId;
    }

    public TableAddress(Integer addressId, String houseNumbering, String complements) {        
        this.houseNumbering = houseNumbering;
        this.complements = complements;
    }

    // Setters and Getters ------------------------------------------------------------------------------------------
    @Override
    public Integer getId() {
        return addressId;
    }

    @Override
    public void setId(Integer addressId) {
        this.addressId = addressId;
    }    

    public String getHouseNumbering() {
        return houseNumbering;
    }

    public void setHouseNumbering(String houseNumbering) {
        this.houseNumbering = houseNumbering;
    }

    public String getComplements() {
        return complements;
    }

    public void setComplements(String complements) {
        this.complements = complements;
    }

    public Logradouro getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(Logradouro logradouro) {
        this.logradouro = logradouro;
    }

    public TableZone getZone() {
        return zoneId;
    }

    public void setZone(TableZone zoneId) {
        this.zoneId = zoneId;
    }

    public TableCountry getCountry() {
        return country;
    }

    public void setCountry(TableCountry countryId) {
        this.country = countryId;
    }

    public TableCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TableCustomer customer) {
        this.customer = customer;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableAddress)) {
            return false;
        }
        TableAddress other = (TableAddress) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TableAddress{" + "addressId=" + addressId + ", houseNumbering=" + houseNumbering + ", complements=" + complements + ", logradouro=" + logradouro + ", zoneId=" + zoneId + ", country=" + country + ", customer=" + customer + '}';
    }

    public String toJson() {
        // return "{" + "\"addressId\":\"" + addressId + "\",\"postcode\":\"" + logradouro.getPostcode() + "\",\"houseNumbering\":\"" + houseNumbering + "\",\"complements\":\"" + complements + "\",\"logradouro\":\"" + logradouro.getTipoLogradouro() + " " + logradouro.getLogradouro() + "\",\"country\":\"" + country + "\",\"customer\":\"" + customer.getFullName() + "\"}";
        return "{" + "\"addressId\":\"" + addressId + "\",\"houseNumbering\":\"" + houseNumbering 
                + "\",\"complements\":\"" + complements
                + "\",\"logradouro\":" + logradouro.toJson() + "}";
    }
    
}
