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
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "table_order_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrderProduct.findAll", query = "SELECT t FROM TableOrderProduct t"),
    @NamedQuery(name = "TableOrderProduct.findByOrderProductId", query = "SELECT t FROM TableOrderProduct t WHERE t.orderProductId = :orderProductId"),
    @NamedQuery(name = "TableOrderProduct.findByProductId", query = "SELECT t FROM TableOrderProduct t WHERE t.productId = :productId"),
    @NamedQuery(name = "TableOrderProduct.findByName", query = "SELECT t FROM TableOrderProduct t WHERE t.name = :name"),
    @NamedQuery(name = "TableOrderProduct.findByModel", query = "SELECT t FROM TableOrderProduct t WHERE t.model = :model"),
    @NamedQuery(name = "TableOrderProduct.findByQuantity", query = "SELECT t FROM TableOrderProduct t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TableOrderProduct.findByPrice", query = "SELECT t FROM TableOrderProduct t WHERE t.price = :price"),
    @NamedQuery(name = "TableOrderProduct.findByTotal", query = "SELECT t FROM TableOrderProduct t WHERE t.total = :total"),
    @NamedQuery(name = "TableOrderProduct.findByTax", query = "SELECT t FROM TableOrderProduct t WHERE t.tax = :tax"),
    @NamedQuery(name = "TableOrderProduct.findByReward", query = "SELECT t FROM TableOrderProduct t WHERE t.reward = :reward")})
public class TableOrderProduct extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_product_id")
    private Integer orderProductId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private BigDecimal total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax")
    private BigDecimal tax;
    @Basic(optional = false)
    @NotNull
    @Column(name = "reward")
    private int reward;
    
    // Collection --------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderProduct")
    private List<TableOrderOption> tableOrderOptionList;
    
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private TableOrder order;

    public TableOrderProduct() {
    }

    public TableOrderProduct(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public TableOrderProduct(Integer orderProductId, int productId, String name, String model, int quantity, BigDecimal price, BigDecimal total, BigDecimal tax, int reward) {
        this.orderProductId = orderProductId;
        this.productId = productId;
        this.name = name;
        this.model = model;
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.tax = tax;
        this.reward = reward;
    }

    @Override
    public Integer getId() {
        return orderProductId;
    }

    @Override
    public void setId(Integer orderProductId) {
        this.orderProductId = orderProductId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    @XmlTransient
    public List<TableOrderOption> getTableOrderOptionList() {
        return tableOrderOptionList;
    }

    public void setTableOrderOptionList(List<TableOrderOption> tableOrderOptionList) {
        this.tableOrderOptionList = tableOrderOptionList;
    }

    public TableOrder getOrder() {
        return order;
    }

    public void setOrder(TableOrder orderId) {
        this.order = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderProductId != null ? orderProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrderProduct)) {
            return false;
        }
        TableOrderProduct other = (TableOrderProduct) object;
        if ((this.orderProductId == null && other.orderProductId != null) || (this.orderProductId != null && !this.orderProductId.equals(other.orderProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOrderProduct[ orderProductId=" + orderProductId + " ]";
    }

}
