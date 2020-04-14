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
@Table(name = "table_order_recurring_transaction")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrderRecurringTransaction.findAll", query = "SELECT t FROM TableOrderRecurringTransaction t"),
    @NamedQuery(name = "TableOrderRecurringTransaction.findByOrderRecurringTransactionId", query = "SELECT t FROM TableOrderRecurringTransaction t WHERE t.orderRecurringTransactionId = :orderRecurringTransactionId"),
    @NamedQuery(name = "TableOrderRecurringTransaction.findByOrderRecurringId", query = "SELECT t FROM TableOrderRecurringTransaction t WHERE t.orderRecurringId = :orderRecurringId"),
    @NamedQuery(name = "TableOrderRecurringTransaction.findByReference", query = "SELECT t FROM TableOrderRecurringTransaction t WHERE t.reference = :reference"),
    @NamedQuery(name = "TableOrderRecurringTransaction.findByType", query = "SELECT t FROM TableOrderRecurringTransaction t WHERE t.type = :type"),
    @NamedQuery(name = "TableOrderRecurringTransaction.findByAmount", query = "SELECT t FROM TableOrderRecurringTransaction t WHERE t.amount = :amount"),
    @NamedQuery(name = "TableOrderRecurringTransaction.findByDateAdded", query = "SELECT t FROM TableOrderRecurringTransaction t WHERE t.dateAdded = :dateAdded")})
public class TableOrderRecurringTransaction extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_recurring_transaction_id")
    private Integer orderRecurringTransactionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_recurring_id")
    private int orderRecurringId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "type")
    private String type;
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

    public TableOrderRecurringTransaction() {
    }

    public TableOrderRecurringTransaction(Integer orderRecurringTransactionId) {
        this.orderRecurringTransactionId = orderRecurringTransactionId;
    }

    public TableOrderRecurringTransaction(Integer orderRecurringTransactionId, int orderRecurringId, String reference, String type, BigDecimal amount, Date dateAdded) {
        this.orderRecurringTransactionId = orderRecurringTransactionId;
        this.orderRecurringId = orderRecurringId;
        this.reference = reference;
        this.type = type;
        this.amount = amount;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return orderRecurringTransactionId;
    }

    @Override
    public void setId(Integer orderRecurringTransactionId) {
        this.orderRecurringTransactionId = orderRecurringTransactionId;
    }

    public int getOrderRecurringId() {
        return orderRecurringId;
    }

    public void setOrderRecurringId(int orderRecurringId) {
        this.orderRecurringId = orderRecurringId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderRecurringTransactionId != null ? orderRecurringTransactionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrderRecurringTransaction)) {
            return false;
        }
        TableOrderRecurringTransaction other = (TableOrderRecurringTransaction) object;
        if ((this.orderRecurringTransactionId == null && other.orderRecurringTransactionId != null) || (this.orderRecurringTransactionId != null && !this.orderRecurringTransactionId.equals(other.orderRecurringTransactionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOrderRecurringTransaction[ orderRecurringTransactionId=" + orderRecurringTransactionId + " ]";
    }
    
}
