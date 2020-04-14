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
@Table(name = "table_coupon_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCouponHistory.findAll", query = "SELECT t FROM TableCouponHistory t"),
    @NamedQuery(name = "TableCouponHistory.findByCouponHistoryId", query = "SELECT t FROM TableCouponHistory t WHERE t.couponHistoryId = :couponHistoryId"),
    @NamedQuery(name = "TableCouponHistory.findByAmount", query = "SELECT t FROM TableCouponHistory t WHERE t.amount = :amount"),
    @NamedQuery(name = "TableCouponHistory.findByDateAdded", query = "SELECT t FROM TableCouponHistory t WHERE t.dateAdded = :dateAdded")})
public class TableCouponHistory extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coupon_history_id")
    private Integer couponHistoryId;
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
    @JoinColumn(name = "coupon_id", referencedColumnName = "coupon_id")
    @ManyToOne(optional = false)
    private TableCoupon coupon;
    
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;
    
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private TableOrder order;

    // Constructors ------------------------------------------------------------------------------------------------------------------
    public TableCouponHistory() {
    }

    public TableCouponHistory(Integer couponHistoryId) {
        this.couponHistoryId = couponHistoryId;
    }

    public TableCouponHistory(Integer couponHistoryId, BigDecimal amount, Date dateAdded) {
        this.couponHistoryId = couponHistoryId;
        this.amount = amount;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return couponHistoryId;
    }

    @Override
    public void setId(Integer couponHistoryId) {
        this.couponHistoryId = couponHistoryId;
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

    public TableCoupon getCouponId() {
        return coupon;
    }

    public void setCouponId(TableCoupon couponId) {
        this.coupon = couponId;
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
        hash += (couponHistoryId != null ? couponHistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCouponHistory)) {
            return false;
        }
        TableCouponHistory other = (TableCouponHistory) object;
        if ((this.couponHistoryId == null && other.couponHistoryId != null) || (this.couponHistoryId != null && !this.couponHistoryId.equals(other.couponHistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCouponHistory[ couponHistoryId=" + couponHistoryId + " ]";
    }
    
}
