/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_order_option")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrderOption.findAll", query = "SELECT t FROM TableOrderOption t"),
    @NamedQuery(name = "TableOrderOption.findByOrderOptionId", query = "SELECT t FROM TableOrderOption t WHERE t.orderOptionId = :orderOptionId"),
    @NamedQuery(name = "TableOrderOption.findByName", query = "SELECT t FROM TableOrderOption t WHERE t.name = :name"),
    @NamedQuery(name = "TableOrderOption.findByType", query = "SELECT t FROM TableOrderOption t WHERE t.type = :type")})
public class TableOrderOption extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_option_id")
    private Integer orderOptionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "type")
    private String type;
    
    // Collection --------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private TableOrder order;
    
    @JsonIgnore
    @JoinColumn(name = "order_product_id", referencedColumnName = "order_product_id")
    @ManyToOne(optional = false)
    private TableOrderProduct orderProduct;
    
    @JoinColumn(name = "product_option_value_id", referencedColumnName = "product_option_value_id")
    @ManyToOne(optional = false)
    private TableProductOptionValue productOptionValue;
    
    @JoinColumn(name = "product_option_id", referencedColumnName = "product_option_id")
    @ManyToOne(optional = false)
    private TableProductOption productOption;

    public TableOrderOption() {
    }

    public TableOrderOption(Integer orderOptionId) {
        this.orderOptionId = orderOptionId;
    }

    public TableOrderOption(Integer orderOptionId, String name, String value, String type) {
        this.orderOptionId = orderOptionId;
        this.name = name;
        this.value = value;
        this.type = type;
    }

    @Override
    public Integer getId() {
        return orderOptionId;
    }

    @Override
    public void setId(Integer orderOptionId) {
        this.orderOptionId = orderOptionId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TableOrder getOrderId() {
        return order;
    }

    public void setOrderId(TableOrder orderId) {
        this.order = orderId;
    }

    public TableOrderProduct getOrderProductId() {
        return orderProduct;
    }

    public void setOrderProductId(TableOrderProduct orderProductId) {
        this.orderProduct = orderProductId;
    }

    public TableProductOptionValue getProductOptionValueId() {
        return productOptionValue;
    }

    public void setProductOptionValueId(TableProductOptionValue productOptionValueId) {
        this.productOptionValue = productOptionValueId;
    }

    public TableProductOption getProductOptionId() {
        return productOption;
    }

    public void setProductOptionId(TableProductOption productOptionId) {
        this.productOption = productOptionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (orderOptionId != null ? orderOptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrderOption)) {
            return false;
        }
        TableOrderOption other = (TableOrderOption) object;
        if ((this.orderOptionId == null && other.orderOptionId != null) || (this.orderOptionId != null && !this.orderOptionId.equals(other.orderOptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOrderOption[ orderOptionId=" + orderOptionId + " ]";
    }
    
}
