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
import javax.persistence.Lob;
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
@Table(name = "table_customer_group")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomerGroup.findAll", query = "SELECT t FROM TableCustomerGroup t"),
    @NamedQuery(name = "TableCustomerGroup.findByCustomerGroupId", query = "SELECT t FROM TableCustomerGroup t WHERE t.customerGroupId = :customerGroupId"),
    @NamedQuery(name = "TableCustomerGroup.findByName", query = "SELECT t FROM TableCustomerGroup t WHERE t.name = :name"),
    @NamedQuery(name = "TableCustomerGroup.findByApproval", query = "SELECT t FROM TableCustomerGroup t WHERE t.approval = :approval"),
    @NamedQuery(name = "TableCustomerGroup.findBySortOrder", query = "SELECT t FROM TableCustomerGroup t WHERE t.sortOrder = :sortOrder")})
public class TableCustomerGroup extends EntidadeDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_group_id")
    private Integer customerGroupId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "approval")
    private int approval;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerGroup")
    private List<TableCustomer> tableCustomerList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerGroup")
    private List<TableOrder> tableOrderList;

    // Constructors -------------------------------------------------------------------------------------------------------------------------
    public TableCustomerGroup() {
    }

    public TableCustomerGroup(Integer customerGroupId) {
        this.customerGroupId = customerGroupId;
    }

    public TableCustomerGroup(Integer customerGroupId, String name, String description, int approval, int sortOrder) {
        this.customerGroupId = customerGroupId;
        this.name = name;
        this.description = description;
        this.approval = approval;
        this.sortOrder = sortOrder;
    }

    public Integer getId() {
        return customerGroupId;
    }

    public void setId(Integer customerGroupId) {
        this.customerGroupId = customerGroupId;
    }


    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @XmlTransient
    public List<TableCustomer> getTableCustomerList() {
        return tableCustomerList;
    }

    public void setTableCustomerList(List<TableCustomer> tableCustomerList) {
        this.tableCustomerList = tableCustomerList;
    }

    @XmlTransient
    public List<TableOrder> getTableOrderList() {
        return tableOrderList;
    }

    public void setTableOrderList(List<TableOrder> tableOrderList) {
        this.tableOrderList = tableOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerGroupId != null ? customerGroupId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomerGroup)) {
            return false;
        }
        TableCustomerGroup other = (TableCustomerGroup) object;
        if ((this.customerGroupId == null && other.customerGroupId != null) || (this.customerGroupId != null && !this.customerGroupId.equals(other.customerGroupId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCustomerGroup[ customerGroupId=" + customerGroupId + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getApproval() {
        return approval;
    }

    public void setApproval(int approval) {
        this.approval = approval;
    }   
    
}
