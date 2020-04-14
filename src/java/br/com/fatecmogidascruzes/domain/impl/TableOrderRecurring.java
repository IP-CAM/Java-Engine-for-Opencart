/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "table_order_recurring")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrderRecurring.findAll", query = "SELECT t FROM TableOrderRecurring t"),
    @NamedQuery(name = "TableOrderRecurring.findByOrderRecurringId", query = "SELECT t FROM TableOrderRecurring t WHERE t.orderRecurringId = :orderRecurringId"),
    @NamedQuery(name = "TableOrderRecurring.findByReference", query = "SELECT t FROM TableOrderRecurring t WHERE t.reference = :reference"),
    @NamedQuery(name = "TableOrderRecurring.findByProductId", query = "SELECT t FROM TableOrderRecurring t WHERE t.productId = :productId"),
    @NamedQuery(name = "TableOrderRecurring.findByProductName", query = "SELECT t FROM TableOrderRecurring t WHERE t.productName = :productName"),
    @NamedQuery(name = "TableOrderRecurring.findByProductQuantity", query = "SELECT t FROM TableOrderRecurring t WHERE t.productQuantity = :productQuantity"),
    @NamedQuery(name = "TableOrderRecurring.findByRecurringName", query = "SELECT t FROM TableOrderRecurring t WHERE t.recurringName = :recurringName"),
    @NamedQuery(name = "TableOrderRecurring.findByRecurringDescription", query = "SELECT t FROM TableOrderRecurring t WHERE t.recurringDescription = :recurringDescription"),
    @NamedQuery(name = "TableOrderRecurring.findByRecurringFrequency", query = "SELECT t FROM TableOrderRecurring t WHERE t.recurringFrequency = :recurringFrequency"),
    @NamedQuery(name = "TableOrderRecurring.findByRecurringCycle", query = "SELECT t FROM TableOrderRecurring t WHERE t.recurringCycle = :recurringCycle"),
    @NamedQuery(name = "TableOrderRecurring.findByRecurringDuration", query = "SELECT t FROM TableOrderRecurring t WHERE t.recurringDuration = :recurringDuration"),
    @NamedQuery(name = "TableOrderRecurring.findByRecurringPrice", query = "SELECT t FROM TableOrderRecurring t WHERE t.recurringPrice = :recurringPrice"),
    @NamedQuery(name = "TableOrderRecurring.findByTrial", query = "SELECT t FROM TableOrderRecurring t WHERE t.trial = :trial"),
    @NamedQuery(name = "TableOrderRecurring.findByTrialFrequency", query = "SELECT t FROM TableOrderRecurring t WHERE t.trialFrequency = :trialFrequency"),
    @NamedQuery(name = "TableOrderRecurring.findByTrialCycle", query = "SELECT t FROM TableOrderRecurring t WHERE t.trialCycle = :trialCycle"),
    @NamedQuery(name = "TableOrderRecurring.findByTrialDuration", query = "SELECT t FROM TableOrderRecurring t WHERE t.trialDuration = :trialDuration"),
    @NamedQuery(name = "TableOrderRecurring.findByTrialPrice", query = "SELECT t FROM TableOrderRecurring t WHERE t.trialPrice = :trialPrice"),
    @NamedQuery(name = "TableOrderRecurring.findByStatus", query = "SELECT t FROM TableOrderRecurring t WHERE t.status = :status"),
    @NamedQuery(name = "TableOrderRecurring.findByDateAdded", query = "SELECT t FROM TableOrderRecurring t WHERE t.dateAdded = :dateAdded")})
public class TableOrderRecurring extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_recurring_id")
    private Integer orderRecurringId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "reference")
    private String reference;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "product_name")
    private String productName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_quantity")
    private int productQuantity;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "recurring_name")
    private String recurringName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "recurring_description")
    private String recurringDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "recurring_frequency")
    private String recurringFrequency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recurring_cycle")
    private short recurringCycle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recurring_duration")
    private short recurringDuration;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "recurring_price")
    private BigDecimal recurringPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trial")
    private boolean trial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "trial_frequency")
    private String trialFrequency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trial_cycle")
    private short trialCycle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trial_duration")
    private short trialDuration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trial_price")
    private BigDecimal trialPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private short status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    
    // Collection --------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private TableOrder order;
    
    @JoinColumn(name = "recurring_id", referencedColumnName = "recurring_id")
    @ManyToOne(optional = false)
    private TableRecurring recurring;

    // Constructors ------------------------------------------------------------------------------------------------------------------
    public TableOrderRecurring() {
    }

    public TableOrderRecurring(Integer orderRecurringId) {
        this.orderRecurringId = orderRecurringId;
    }

    public TableOrderRecurring(Integer orderRecurringId, String reference, int productId, String productName, int productQuantity, String recurringName, String recurringDescription, String recurringFrequency, short recurringCycle, short recurringDuration, BigDecimal recurringPrice, boolean trial, String trialFrequency, short trialCycle, short trialDuration, BigDecimal trialPrice, short status, Date dateAdded) {
        this.orderRecurringId = orderRecurringId;
        this.reference = reference;
        this.productId = productId;
        this.productName = productName;
        this.productQuantity = productQuantity;
        this.recurringName = recurringName;
        this.recurringDescription = recurringDescription;
        this.recurringFrequency = recurringFrequency;
        this.recurringCycle = recurringCycle;
        this.recurringDuration = recurringDuration;
        this.recurringPrice = recurringPrice;
        this.trial = trial;
        this.trialFrequency = trialFrequency;
        this.trialCycle = trialCycle;
        this.trialDuration = trialDuration;
        this.trialPrice = trialPrice;
        this.status = status;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return orderRecurringId;
    }

    @Override
    public void setId(Integer orderRecurringId) {
        this.orderRecurringId = orderRecurringId;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getRecurringName() {
        return recurringName;
    }

    public void setRecurringName(String recurringName) {
        this.recurringName = recurringName;
    }

    public String getRecurringDescription() {
        return recurringDescription;
    }

    public void setRecurringDescription(String recurringDescription) {
        this.recurringDescription = recurringDescription;
    }

    public String getRecurringFrequency() {
        return recurringFrequency;
    }

    public void setRecurringFrequency(String recurringFrequency) {
        this.recurringFrequency = recurringFrequency;
    }

    public short getRecurringCycle() {
        return recurringCycle;
    }

    public void setRecurringCycle(short recurringCycle) {
        this.recurringCycle = recurringCycle;
    }

    public short getRecurringDuration() {
        return recurringDuration;
    }

    public void setRecurringDuration(short recurringDuration) {
        this.recurringDuration = recurringDuration;
    }

    public BigDecimal getRecurringPrice() {
        return recurringPrice;
    }

    public void setRecurringPrice(BigDecimal recurringPrice) {
        this.recurringPrice = recurringPrice;
    }

    public boolean getTrial() {
        return trial;
    }

    public void setTrial(boolean trial) {
        this.trial = trial;
    }

    public String getTrialFrequency() {
        return trialFrequency;
    }

    public void setTrialFrequency(String trialFrequency) {
        this.trialFrequency = trialFrequency;
    }

    public short getTrialCycle() {
        return trialCycle;
    }

    public void setTrialCycle(short trialCycle) {
        this.trialCycle = trialCycle;
    }

    public short getTrialDuration() {
        return trialDuration;
    }

    public void setTrialDuration(short trialDuration) {
        this.trialDuration = trialDuration;
    }

    public BigDecimal getTrialPrice() {
        return trialPrice;
    }

    public void setTrialPrice(BigDecimal trialPrice) {
        this.trialPrice = trialPrice;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public TableOrder getOrderId() {
        return order;
    }

    public void setOrderId(TableOrder orderId) {
        this.order = orderId;
    }

    public TableRecurring getRecurringId() {
        return recurring;
    }

    public void setRecurringId(TableRecurring recurringId) {
        this.recurring = recurringId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderRecurringId != null ? orderRecurringId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrderRecurring)) {
            return false;
        }
        TableOrderRecurring other = (TableOrderRecurring) object;
        if ((this.orderRecurringId == null && other.orderRecurringId != null) || (this.orderRecurringId != null && !this.orderRecurringId.equals(other.orderRecurringId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOrderRecurring[ orderRecurringId=" + orderRecurringId + " ]";
    }
    
}
