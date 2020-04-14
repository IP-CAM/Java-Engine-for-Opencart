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
import javax.persistence.CascadeType;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_cart")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCart.findAll", query = "SELECT t FROM TableCart t"),
    @NamedQuery(name = "TableCart.findById", query = "SELECT t FROM TableCart t WHERE t.cartId = :id"),    
    @NamedQuery(name = "TableCart.findBySession", query = "SELECT t FROM TableCart t JOIN t.session s where s.session = :value"),
    @NamedQuery(name = "TableCart.findByQuantity", query = "SELECT t FROM TableCart t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TableCart.findByDateAdded", query = "SELECT t FROM TableCart t WHERE t.dateAdded = :dateAdded")})
public class TableCart extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cart_id")
    private Integer cartId;    
    
    @Lob
    @Column(name = "option")
    private String option;
    
    @Basic(optional = false)
    @Column(name = "quantity")
    private int quantity;    
    
    @Basic(optional = false)
    @Column(name = "date_added", updatable = false, insertable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    
    // Collection --------------------------------------------------------------------------------------------------------------------
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "api_id", referencedColumnName = "api_id")    
    private TableApi api;
    
    @JsonIgnore
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")    
    private TableCustomer customer;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private TableProduct product;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "recurring_id", referencedColumnName = "recurring_id")
    private TableRecurring recurring;
    
    @ManyToOne(cascade = CascadeType.REFRESH)
    @JoinColumn(name = "session_id", referencedColumnName = "session_id")
    private TableSession session;

    public TableCart() {
    }

    public TableCart(Integer cartId) {
        this.cartId = cartId;
    }

    public TableCart(Integer cartId, String option, int quantity, Date dateAdded) {
        this.cartId = cartId;
        this.option = option;
        this.quantity = quantity;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return cartId;
    }

    @Override
    public void setId(Integer cartId) {
        this.cartId = cartId;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public TableApi getApiId() {
        return api;
    }

    public void setApiId(TableApi apiId) {
        this.api = apiId;
    }

    public TableCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TableCustomer customerId) {
        this.customer = customerId;
    }

    public TableProduct getProduct() {
        return product;
    }

    public void setProduct(TableProduct productId) {
        this.product = productId;
    }

    public TableRecurring getRecurringId() {
        return recurring;
    }

    public void setRecurring(TableRecurring recurringId) {
        this.recurring = recurringId;
    }

    public TableSession getSession() {
        return session;
    }

    public void setSession(TableSession sessionId) {
        this.session = sessionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartId != null ? cartId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCart)) {
            return false;
        }
        TableCart other = (TableCart) object;
        if ((this.cartId == null && other.cartId != null) || (this.cartId != null && !this.cartId.equals(other.cartId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCart[ cartId=" + cartId + " ]";
    }
    
}
