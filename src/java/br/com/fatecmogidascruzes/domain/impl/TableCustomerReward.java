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
@Table(name = "table_customer_reward")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomerReward.findAll", query = "SELECT t FROM TableCustomerReward t"),
    @NamedQuery(name = "TableCustomerReward.findByCustomerRewardId", query = "SELECT t FROM TableCustomerReward t WHERE t.customerRewardId = :customerRewardId"),
    @NamedQuery(name = "TableCustomerReward.findByPoints", query = "SELECT t FROM TableCustomerReward t WHERE t.points = :points"),
    @NamedQuery(name = "TableCustomerReward.findByDateAdded", query = "SELECT t FROM TableCustomerReward t WHERE t.dateAdded = :dateAdded")})
public class TableCustomerReward extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_reward_id")
    private Integer customerRewardId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private int points;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    
    // Collection --------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;
    
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private TableOrder order;
    
    // Constructors ------------------------------------------------------------------------------------------------------------------
    public TableCustomerReward() {
    }

    public TableCustomerReward(Integer customerRewardId) {
        this.customerRewardId = customerRewardId;
    }

    public TableCustomerReward(Integer customerRewardId, String description, int points, Date dateAdded) {
        this.customerRewardId = customerRewardId;
        this.description = description;
        this.points = points;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return customerRewardId;
    }

    @Override
    public void setId(Integer customerRewardId) {
        this.customerRewardId = customerRewardId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
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
        hash += (customerRewardId != null ? customerRewardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomerReward)) {
            return false;
        }
        TableCustomerReward other = (TableCustomerReward) object;
        if ((this.customerRewardId == null && other.customerRewardId != null) || (this.customerRewardId != null && !this.customerRewardId.equals(other.customerRewardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCustomerReward[ customerRewardId=" + customerRewardId + " ]";
    }
    
}
