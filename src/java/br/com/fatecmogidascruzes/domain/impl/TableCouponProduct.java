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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_coupon_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCouponProduct.findAll", query = "SELECT t FROM TableCouponProduct t"),
    @NamedQuery(name = "TableCouponProduct.findByCouponProductId", query = "SELECT t FROM TableCouponProduct t WHERE t.couponProductId = :couponProductId")})
public class TableCouponProduct extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coupon_product_id")
    private Integer couponProductId;
    @JoinColumn(name = "coupon_id", referencedColumnName = "coupon_id")
    @ManyToOne(optional = false)
    private TableCoupon couponId;
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    @ManyToOne(optional = false)
    private TableProduct productId;

    public TableCouponProduct() {
    }

    public TableCouponProduct(Integer couponProductId) {
        this.couponProductId = couponProductId;
    }

    @Override
    public Integer getId() {
        return couponProductId;
    }

    @Override
    public void setId(Integer couponProductId) {
        this.couponProductId = couponProductId;
    }

    public TableCoupon getCouponId() {
        return couponId;
    }

    public void setCouponId(TableCoupon couponId) {
        this.couponId = couponId;
    }

    public TableProduct getProductId() {
        return productId;
    }

    public void setProductId(TableProduct productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couponProductId != null ? couponProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCouponProduct)) {
            return false;
        }
        TableCouponProduct other = (TableCouponProduct) object;
        if ((this.couponProductId == null && other.couponProductId != null) || (this.couponProductId != null && !this.couponProductId.equals(other.couponProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCouponProduct[ couponProductId=" + couponProductId + " ]";
    }
    
}
