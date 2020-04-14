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
@Table(name = "table_customer_activity")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomerActivity.findAll", query = "SELECT t FROM TableCustomerActivity t"),
    @NamedQuery(name = "TableCustomerActivity.findByCustomerActivityId", query = "SELECT t FROM TableCustomerActivity t WHERE t.customerActivityId = :customerActivityId"),
    @NamedQuery(name = "TableCustomerActivity.findByKey", query = "SELECT t FROM TableCustomerActivity t WHERE t.key = :key"),
    @NamedQuery(name = "TableCustomerActivity.findByIp", query = "SELECT t FROM TableCustomerActivity t WHERE t.ip = :ip"),
    @NamedQuery(name = "TableCustomerActivity.findByDateAdded", query = "SELECT t FROM TableCustomerActivity t WHERE t.dateAdded = :dateAdded")})
public class TableCustomerActivity extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_activity_id")
    private Integer customerActivityId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "key")
    private String key;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "data")
    private String data;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    @ManyToOne(optional = false)
    private TableCustomer customer;

    public TableCustomerActivity() {
    }

    public TableCustomerActivity(Integer customerActivityId) {
        this.customerActivityId = customerActivityId;
    }

    public TableCustomerActivity(Integer customerActivityId, String key, String data, String ip, Date dateAdded) {
        this.customerActivityId = customerActivityId;
        this.key = key;
        this.data = data;
        this.ip = ip;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return customerActivityId;
    }

    @Override
    public void setId(Integer customerActivityId) {
        this.customerActivityId = customerActivityId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
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
        hash += (customerActivityId != null ? customerActivityId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomerActivity)) {
            return false;
        }
        TableCustomerActivity other = (TableCustomerActivity) object;
        if ((this.customerActivityId == null && other.customerActivityId != null) || (this.customerActivityId != null && !this.customerActivityId.equals(other.customerActivityId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCustomerActivity[ customerActivityId=" + customerActivityId + " ]";
    }
    
}
