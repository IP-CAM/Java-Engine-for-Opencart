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
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "table_customer_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomerHistory.findAll", query = "SELECT t FROM TableCustomerHistory t"),
    @NamedQuery(name = "TableCustomerHistory.findByCustomerHistoryId", query = "SELECT t FROM TableCustomerHistory t WHERE t.customerHistoryId = :customerHistoryId"),
    @NamedQuery(name = "TableCustomerHistory.findByDateAdded", query = "SELECT t FROM TableCustomerHistory t WHERE t.dateAdded = :dateAdded")})
public class TableCustomerHistory extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_history_id")
    private Integer customerHistoryId;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comment")
    private String comment;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;

    public TableCustomerHistory() {
    }

    public TableCustomerHistory(Integer customerHistoryId) {
        this.customerHistoryId = customerHistoryId;
    }

    public TableCustomerHistory(Integer customerHistoryId, String comment, Date dateAdded) {
        this.customerHistoryId = customerHistoryId;
        this.comment = comment;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return customerHistoryId;
    }
    
    @Override
    public void setId(Integer customerHistoryId) {
        this.customerHistoryId = customerHistoryId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public TableCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(TableCustomer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerHistoryId != null ? customerHistoryId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomerHistory)) {
            return false;
        }
        TableCustomerHistory other = (TableCustomerHistory) object;
        if ((this.customerHistoryId == null && other.customerHistoryId != null) || (this.customerHistoryId != null && !this.customerHistoryId.equals(other.customerHistoryId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCustomerHistory[ customerHistoryId=" + customerHistoryId + " ]";
    }
    
}
