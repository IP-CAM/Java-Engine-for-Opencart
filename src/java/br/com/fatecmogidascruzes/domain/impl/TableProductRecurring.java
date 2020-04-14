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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */

@Entity
@Table(name = "table_product_recurring")
@XmlRootElement
public class TableProductRecurring extends EntidadeDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private Integer productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "recurring_id")
    private Integer recurringId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_group_id")
    private Integer customerGroupId;

    public TableProductRecurring() {
    }

    public TableProductRecurring(int productId, Integer recurringId, Integer customerGroupId) {
        this.productId = productId;
        this.recurringId = recurringId;
        this.customerGroupId = customerGroupId;
    }

    @Override
    public Integer getId() {
        return productId;
    }

    @Override
    public void setId(Integer productId) {
        this.productId = productId;
    }

    public Integer getRecurringId() {
        return recurringId;
    }

    public void setRecurringId(int recurringId) {
        this.recurringId = recurringId;
    }

    public Integer getCustomerGroupId() {
        return customerGroupId;
    }

    public void setCustomerGroupId(int customerGroupId) {
        this.customerGroupId = customerGroupId;
    }
    
}
