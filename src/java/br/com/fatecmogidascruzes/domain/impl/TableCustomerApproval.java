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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "table_customer_approval")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomerApproval.findAll", query = "SELECT t FROM TableCustomerApproval t"),
    @NamedQuery(name = "TableCustomerApproval.findByCustomerApprovalId", query = "SELECT t FROM TableCustomerApproval t WHERE t.customerApprovalId = :customerApprovalId"),
    @NamedQuery(name = "TableCustomerApproval.findByType", query = "SELECT t FROM TableCustomerApproval t WHERE t.type = :type"),
    @NamedQuery(name = "TableCustomerApproval.findByDateAdded", query = "SELECT t FROM TableCustomerApproval t WHERE t.dateAdded = :dateAdded")})
public class TableCustomerApproval extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_approval_id")
    private Integer customerApprovalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;

    public TableCustomerApproval() {
    }

    public TableCustomerApproval(Integer customerApprovalId) {
        this.customerApprovalId = customerApprovalId;
    }

    public TableCustomerApproval(Integer customerApprovalId, String type, Date dateAdded) {
        this.customerApprovalId = customerApprovalId;
        this.type = type;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return customerApprovalId;
    }

    @Override
    public void setId(Integer customerApprovalId) {
        this.customerApprovalId = customerApprovalId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
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
        hash += (customerApprovalId != null ? customerApprovalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomerApproval)) {
            return false;
        }
        TableCustomerApproval other = (TableCustomerApproval) object;
        if ((this.customerApprovalId == null && other.customerApprovalId != null) || (this.customerApprovalId != null && !this.customerApprovalId.equals(other.customerApprovalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCustomerApproval[ customerApprovalId=" + customerApprovalId + " ]";
    }
    
}
