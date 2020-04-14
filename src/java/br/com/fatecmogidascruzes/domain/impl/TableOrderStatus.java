/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_order_status")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrderStatus.findAll", query = "SELECT t FROM TableOrderStatus t"),
    @NamedQuery(name = "TableOrderStatus.findById", query = "SELECT t FROM TableOrderStatus t WHERE t.orderStatusId = :id"),
    @NamedQuery(name = "TableOrderStatus.findByName", query = "SELECT t FROM TableOrderStatus t WHERE t.name = :name")})
public class TableOrderStatus extends EntidadeDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_status_id")
    private Integer orderStatusId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    
    // Collection --------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "orderStatus")
    private List<TableOrder> orderList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.REFRESH, mappedBy = "orderStatus")
    private List<TableOrderHistory> orderHistoryList;
    
    // Constructors ------------------------------------------------------------------------------------------------------------------
    public TableOrderStatus() {
    }

    public TableOrderStatus(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    public TableOrderStatus(Integer orderStatusId, String name) {
        this.orderStatusId = orderStatusId;
        this.name = name;
    }

    @Override
    public Integer getId() {
        return orderStatusId;
    }

    @Override
    public void setId(Integer orderStatusId) {
        this.orderStatusId = orderStatusId;
    }
    
    public List<TableOrder> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<TableOrder> tableOrderList) {
        this.orderList = tableOrderList;
    }

    @XmlTransient
    public List<TableOrderHistory> getOrderHistoryList() {
        return orderHistoryList;
    }

    public void setOrderHistoryList(List<TableOrderHistory> tableOrderHistoryList) {
        this.orderHistoryList = tableOrderHistoryList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderStatusId != null ? orderStatusId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrderStatus)) {
            return false;
        }
        TableOrderStatus other = (TableOrderStatus) object;
        if ((this.orderStatusId == null && other.orderStatusId != null) || (this.orderStatusId != null && !this.orderStatusId.equals(other.orderStatusId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOrderStatus[ orderStatusId=" + orderStatusId + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
