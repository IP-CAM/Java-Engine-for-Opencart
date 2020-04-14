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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
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
@Table(name = "table_customer_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomerTransaction.findAll", query = "SELECT t FROM TableCustomerTransaction t"),
    @NamedQuery(name = "TableCustomerTransaction.findByCustomerTransactionId", query = "SELECT t FROM TableCustomerTransaction t WHERE t.customerTransactionId = :customerTransactionId"),
    @NamedQuery(name = "TableCustomerTransaction.findByAmount", query = "SELECT t FROM TableCustomerTransaction t WHERE t.amount = :amount"),
    @NamedQuery(name = "TableCustomerTransaction.findByDateAdded", query = "SELECT t FROM TableCustomerTransaction t WHERE t.dateAdded = :dateAdded")})
public class TableCustomerTransaction extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_transaction_id")
    private Integer customerTransactionId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "amount")
    private BigDecimal amount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    
    // Collection --------------------------------------------------------------------------------------------------------------------
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private TableOrder order;

    public TableCustomerTransaction() {
    }

    public TableCustomerTransaction(Integer customerTransactionId) {
        this.customerTransactionId = customerTransactionId;
    }

    public TableCustomerTransaction(Integer customerTransactionId, String description, BigDecimal amount, Date dateAdded) {
        this.customerTransactionId = customerTransactionId;
        this.description = description;
        this.amount = amount;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return customerTransactionId;
    }

    @Override
    public void setId(Integer customerTransactionId) {
        this.customerTransactionId = customerTransactionId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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

    public TableOrder getOrderId() {
        return order;
    }

    public void setOrderId(TableOrder orderId) {
        this.order = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerTransactionId != null ? customerTransactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomerTransaction)) {
            return false;
        }
        TableCustomerTransaction other = (TableCustomerTransaction) object;
        if ((this.customerTransactionId == null && other.customerTransactionId != null) || (this.customerTransactionId != null && !this.customerTransactionId.equals(other.customerTransactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCustomerTransaction[ customerTransactionId=" + customerTransactionId + " ]";
    }
    
}
