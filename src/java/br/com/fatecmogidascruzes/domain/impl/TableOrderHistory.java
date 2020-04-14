/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
@Table(name = "table_order_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrderHistory.findAll", query = "SELECT t FROM TableOrderHistory t"),
    @NamedQuery(name = "TableOrderHistory.findById", query = "SELECT t FROM TableOrderHistory t WHERE t.orderHistoryId = :id"),
    @NamedQuery(name = "TableOrderHistory.findByNotify", query = "SELECT t FROM TableOrderHistory t WHERE t.notify = :notify"),
    @NamedQuery(name = "TableOrderHistory.findByDateAdded", query = "SELECT t FROM TableOrderHistory t WHERE t.dateAdded = :dateAdded")})
public class TableOrderHistory extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_history_id")
    private Integer orderHistoryId;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "notify")
    private boolean notify;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comment")
    private String comment;
    
    @Basic(optional = false)
    @Column(name = "date_added", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    
    // Collections ------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private TableOrder order;
    
    @JoinColumn(name = "order_status_id", referencedColumnName = "order_status_id")
    @ManyToOne(optional = false)
    private TableOrderStatus orderStatus;

    // Constructors ------------------------------------------------------------------------------------------------------------------
    public TableOrderHistory() {
    }

    public TableOrderHistory(Integer orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
    }

    public TableOrderHistory(Integer orderHistoryId, boolean notify, String comment, Date dateAdded) {
        this.orderHistoryId = orderHistoryId;
        this.notify = notify;
        this.comment = comment;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return orderHistoryId;
    }

    @Override
    public void setId(Integer orderHistoryId) {
        this.orderHistoryId = orderHistoryId;
    }
    
    @Override
    public String getName() {
        return comment;
    }
    
    public void setName(String comment) {
        this.comment = comment;
    }
    

    public boolean getNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }
    
    public TableOrder getOrder() {
        return order;
    }

    public void setOrder(TableOrder orderId) {
        this.order = orderId;
    }
    
    public TableOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(TableOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderHistoryId != null ? orderHistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrderHistory)) {
            return false;
        }
        TableOrderHistory other = (TableOrderHistory) object;
        if ((this.orderHistoryId == null && other.orderHistoryId != null) || (this.orderHistoryId != null && !this.orderHistoryId.equals(other.orderHistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOrderHistory[ orderHistoryId=" + orderHistoryId + " ]";
    }
    
}
