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
@Table(name = "table_order_shipment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrderShipment.findAll", query = "SELECT t FROM TableOrderShipment t"),
    @NamedQuery(name = "TableOrderShipment.findByOrderShipmentId", query = "SELECT t FROM TableOrderShipment t WHERE t.orderShipmentId = :orderShipmentId"),
    @NamedQuery(name = "TableOrderShipment.findByOrderId", query = "SELECT t FROM TableOrderShipment t WHERE t.orderId = :orderId"),
    @NamedQuery(name = "TableOrderShipment.findByDateAdded", query = "SELECT t FROM TableOrderShipment t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableOrderShipment.findByShippingCourierId", query = "SELECT t FROM TableOrderShipment t WHERE t.shippingCourierId = :shippingCourierId"),
    @NamedQuery(name = "TableOrderShipment.findByTrackingNumber", query = "SELECT t FROM TableOrderShipment t WHERE t.trackingNumber = :trackingNumber")})
public class TableOrderShipment extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_shipment_id")
    private Integer orderShipmentId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "shipping_courier_id")
    private String shippingCourierId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "tracking_number")
    private String trackingNumber;

    public TableOrderShipment() {
    }

    public TableOrderShipment(Integer orderShipmentId) {
        this.orderShipmentId = orderShipmentId;
    }

    public TableOrderShipment(Integer orderShipmentId, int orderId, Date dateAdded, String shippingCourierId, String trackingNumber) {
        this.orderShipmentId = orderShipmentId;
        this.orderId = orderId;
        this.dateAdded = dateAdded;
        this.shippingCourierId = shippingCourierId;
        this.trackingNumber = trackingNumber;
    }

    @Override
    public Integer getId() {
        return orderShipmentId;
    }

    @Override
    public void setId(Integer orderShipmentId) {
        this.orderShipmentId = orderShipmentId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public String getShippingCourierId() {
        return shippingCourierId;
    }

    public void setShippingCourierId(String shippingCourierId) {
        this.shippingCourierId = shippingCourierId;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderShipmentId != null ? orderShipmentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrderShipment)) {
            return false;
        }
        TableOrderShipment other = (TableOrderShipment) object;
        if ((this.orderShipmentId == null && other.orderShipmentId != null) || (this.orderShipmentId != null && !this.orderShipmentId.equals(other.orderShipmentId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOrderShipment[ orderShipmentId=" + orderShipmentId + " ]";
    }
    
}
