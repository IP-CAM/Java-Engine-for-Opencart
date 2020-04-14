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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_coupon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCoupon.findAll", query = "SELECT t FROM TableCoupon t"),
    @NamedQuery(name = "TableCoupon.findByCouponId", query = "SELECT t FROM TableCoupon t WHERE t.couponId = :couponId"),
    @NamedQuery(name = "TableCoupon.findByName", query = "SELECT t FROM TableCoupon t WHERE t.name = :name"),
    @NamedQuery(name = "TableCoupon.findByCode", query = "SELECT t FROM TableCoupon t WHERE t.code = :code"),
    @NamedQuery(name = "TableCoupon.findByType", query = "SELECT t FROM TableCoupon t WHERE t.type = :type"),
    @NamedQuery(name = "TableCoupon.findByDiscount", query = "SELECT t FROM TableCoupon t WHERE t.discount = :discount"),
    @NamedQuery(name = "TableCoupon.findByLogged", query = "SELECT t FROM TableCoupon t WHERE t.logged = :logged"),
    @NamedQuery(name = "TableCoupon.findByShipping", query = "SELECT t FROM TableCoupon t WHERE t.shipping = :shipping"),
    @NamedQuery(name = "TableCoupon.findByTotal", query = "SELECT t FROM TableCoupon t WHERE t.total = :total"),
    @NamedQuery(name = "TableCoupon.findByDateStart", query = "SELECT t FROM TableCoupon t WHERE t.dateStart = :dateStart"),
    @NamedQuery(name = "TableCoupon.findByDateEnd", query = "SELECT t FROM TableCoupon t WHERE t.dateEnd = :dateEnd"),
    @NamedQuery(name = "TableCoupon.findByUsesTotal", query = "SELECT t FROM TableCoupon t WHERE t.usesTotal = :usesTotal"),
    @NamedQuery(name = "TableCoupon.findByUsesCustomer", query = "SELECT t FROM TableCoupon t WHERE t.usesCustomer = :usesCustomer"),
    @NamedQuery(name = "TableCoupon.findByStatus", query = "SELECT t FROM TableCoupon t WHERE t.status = :status"),
    @NamedQuery(name = "TableCoupon.findByDateAdded", query = "SELECT t FROM TableCoupon t WHERE t.dateAdded = :dateAdded")})
public class TableCoupon extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "coupon_id")
    private Integer couponId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "type")
    private Character type;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "discount")
    private BigDecimal discount;
    @Basic(optional = false)
    @NotNull
    @Column(name = "logged")
    private boolean logged;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping")
    private boolean shipping;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_start")
    @Temporal(TemporalType.DATE)
    private Date dateStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_end")
    @Temporal(TemporalType.DATE)
    private Date dateEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "uses_total")
    private int usesTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "uses_customer")
    private String usesCustomer;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "coupon")
    private List<TableCouponHistory> tableCouponHistoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "couponId")
    private List<TableCouponProduct> tableCouponProductList;

    public TableCoupon() {
    }

    public TableCoupon(Integer couponId) {
        this.couponId = couponId;
    }

    public TableCoupon(Integer couponId, String name, String code, Character type, BigDecimal discount, boolean logged, boolean shipping, BigDecimal total, Date dateStart, Date dateEnd, int usesTotal, String usesCustomer, boolean status, Date dateAdded) {
        this.couponId = couponId;
        this.name = name;
        this.code = code;
        this.type = type;
        this.discount = discount;
        this.logged = logged;
        this.shipping = shipping;
        this.total = total;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.usesTotal = usesTotal;
        this.usesCustomer = usesCustomer;
        this.status = status;
        this.dateAdded = dateAdded;
    }

    public Integer getId() {
        return couponId;
    }

    public void setId(Integer couponId) {
        this.couponId = couponId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Character getType() {
        return type;
    }

    public void setType(Character type) {
        this.type = type;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public boolean getLogged() {
        return logged;
    }

    public void setLogged(boolean logged) {
        this.logged = logged;
    }

    public boolean getShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public int getUsesTotal() {
        return usesTotal;
    }

    public void setUsesTotal(int usesTotal) {
        this.usesTotal = usesTotal;
    }

    public String getUsesCustomer() {
        return usesCustomer;
    }

    public void setUsesCustomer(String usesCustomer) {
        this.usesCustomer = usesCustomer;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @XmlTransient
    public List<TableCouponHistory> getTableCouponHistoryList() {
        return tableCouponHistoryList;
    }

    public void setTableCouponHistoryList(List<TableCouponHistory> tableCouponHistoryList) {
        this.tableCouponHistoryList = tableCouponHistoryList;
    }

    @XmlTransient
    public List<TableCouponProduct> getTableCouponProductList() {
        return tableCouponProductList;
    }

    public void setTableCouponProductList(List<TableCouponProduct> tableCouponProductList) {
        this.tableCouponProductList = tableCouponProductList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (couponId != null ? couponId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCoupon)) {
            return false;
        }
        TableCoupon other = (TableCoupon) object;
        if ((this.couponId == null && other.couponId != null) || (this.couponId != null && !this.couponId.equals(other.couponId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCoupon[ couponId=" + couponId + " ]";
    }
    
}
