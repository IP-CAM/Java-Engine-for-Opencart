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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_order_total")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOrderTotal.findAll", query = "SELECT t FROM TableOrderTotal t"),
    @NamedQuery(name = "TableOrderTotal.findByOrderTotalId", query = "SELECT t FROM TableOrderTotal t WHERE t.orderTotalId = :orderTotalId"),
    @NamedQuery(name = "TableOrderTotal.findByCode", query = "SELECT t FROM TableOrderTotal t WHERE t.code = :code"),
    @NamedQuery(name = "TableOrderTotal.findByTitle", query = "SELECT t FROM TableOrderTotal t WHERE t.title = :title"),
    @NamedQuery(name = "TableOrderTotal.findByValue", query = "SELECT t FROM TableOrderTotal t WHERE t.value = :value"),
    @NamedQuery(name = "TableOrderTotal.findBySortOrder", query = "SELECT t FROM TableOrderTotal t WHERE t.sortOrder = :sortOrder")})
public class TableOrderTotal extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "order_total_id")
    private Integer orderTotalId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private BigDecimal value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    
    @JsonIgnore
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    @ManyToOne(optional = false)
    private TableOrder order;

    public TableOrderTotal() {
    }

    public TableOrderTotal(Integer orderTotalId) {
        this.orderTotalId = orderTotalId;
    }

    public TableOrderTotal(Integer orderTotalId, String code, String title, BigDecimal value, int sortOrder) {
        this.orderTotalId = orderTotalId;
        this.code = code;
        this.title = title;
        this.value = value;
        this.sortOrder = sortOrder;
    }

    @Override
    public Integer getId() {
        return orderTotalId;
    }

    @Override
    public void setId(Integer orderTotalId) {
        this.orderTotalId = orderTotalId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
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
        hash += (orderTotalId != null ? orderTotalId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOrderTotal)) {
            return false;
        }
        TableOrderTotal other = (TableOrderTotal) object;
        if ((this.orderTotalId == null && other.orderTotalId != null) || (this.orderTotalId != null && !this.orderTotalId.equals(other.orderTotalId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOrderTotal[ orderTotalId=" + orderTotalId + " ]";
    }
    
}
