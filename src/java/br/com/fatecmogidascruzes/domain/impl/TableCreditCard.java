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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_credit_card")
public class TableCreditCard extends EntidadeDominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "creditcard_id")
    private Integer id;
    
    @Column(name = "network", length = 20)
    private String network;
    
    @Basic(optional = false)
    @Column(name = "cardholder_name", length = 80)
    private String cardholder_name;
    
    @Basic(optional = false)
    @Column(name = "number")
    private long number;
    
    @JsonIgnore
    @Basic(optional = false)
    @Column(name = "security_code")
    private Integer security_code; 
    
    @Basic(optional = false)
    @Column(name = "date_of_account_opening")
    @Temporal(TemporalType.DATE)
    private Date memberSinceDate;
    
    @Basic(optional = false)
    @Column(name = "expiration_date")
    @Temporal(TemporalType.DATE)
    private Date expiration_date;
    
    @Basic(optional = false)
    @Column(name = "date_added", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded; 
    
    @Basic(optional = false)
    @Column(name = "date_modified", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified; 
    
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;

    public TableCreditCard() {
    }

    public TableCreditCard(Integer id) {
        this.id = id;
    }

    public TableCreditCard(Integer id, String network, String cardholder_name, long number, Integer security_code, Date date_of_account_opening, Date expiration_date, TableCustomer customer) {
        this.id = id;
        this.network = network;
        this.cardholder_name = cardholder_name;
        this.number = number;
        this.security_code = security_code;
        this.memberSinceDate = date_of_account_opening;
        this.expiration_date = expiration_date;
        this.customer = customer;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public String getCardholder_name() {
        return cardholder_name;
    }

    public void setCardholder_name(String cardholder_name) {
        this.cardholder_name = cardholder_name;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public Integer getSecurity_code() {
        return security_code;
    }

    public void setSecurity_code(Integer security_code) {
        this.security_code = security_code;
    }

    public Date getMemberSinceDate() {
        return memberSinceDate;
    }

    public void setMemberSinceDate(Date memberSinceDate) {
        this.memberSinceDate = memberSinceDate;
    }

    public Date getExpiration_date() {
        return expiration_date;
    }

    public void setExpiration_date(Date expiration_date) {
        this.expiration_date = expiration_date;
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

    public TableCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TableCustomer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TableCreditCard other = (TableCreditCard) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    

   

    
}
