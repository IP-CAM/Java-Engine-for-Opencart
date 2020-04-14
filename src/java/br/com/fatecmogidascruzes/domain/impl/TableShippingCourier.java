/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_shipping_courier")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableShippingCourier.findAll", query = "SELECT t FROM TableShippingCourier t"),
    @NamedQuery(name = "TableShippingCourier.findByShippingCourierId", query = "SELECT t FROM TableShippingCourier t WHERE t.shippingCourierId = :shippingCourierId"),
    @NamedQuery(name = "TableShippingCourier.findByShippingCourierCode", query = "SELECT t FROM TableShippingCourier t WHERE t.shippingCourierCode = :shippingCourierCode"),
    @NamedQuery(name = "TableShippingCourier.findByShippingCourierName", query = "SELECT t FROM TableShippingCourier t WHERE t.shippingCourierName = :shippingCourierName")})
public class TableShippingCourier extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping_courier_id")
    private Integer shippingCourierId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "shipping_courier_code")
    private String shippingCourierCode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "shipping_courier_name")
    private String shippingCourierName;

    public TableShippingCourier() {
    }

    public TableShippingCourier(Integer shippingCourierId) {
        this.shippingCourierId = shippingCourierId;
    }

    public TableShippingCourier(Integer shippingCourierId, String shippingCourierCode, String shippingCourierName) {
        this.shippingCourierId = shippingCourierId;
        this.shippingCourierCode = shippingCourierCode;
        this.shippingCourierName = shippingCourierName;
    }

    @Override
    public Integer getId() {
        return shippingCourierId;
    }

    @Override
    public void setId(Integer shippingCourierId) {
        this.shippingCourierId = shippingCourierId;
    }

    public String getShippingCourierCode() {
        return shippingCourierCode;
    }

    public void setShippingCourierCode(String shippingCourierCode) {
        this.shippingCourierCode = shippingCourierCode;
    }

    public String getShippingCourierName() {
        return shippingCourierName;
    }

    public void setShippingCourierName(String shippingCourierName) {
        this.shippingCourierName = shippingCourierName;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (shippingCourierId != null ? shippingCourierId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableShippingCourier)) {
            return false;
        }
        TableShippingCourier other = (TableShippingCourier) object;
        if ((this.shippingCourierId == null && other.shippingCourierId != null) || (this.shippingCourierId != null && !this.shippingCourierId.equals(other.shippingCourierId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableShippingCourier[ shippingCourierId=" + shippingCourierId + " ]";
    }
    
}
