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
@Table(name = "table_customer_ip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomerIp.findAll", query = "SELECT t FROM TableCustomerIp t"),
    @NamedQuery(name = "TableCustomerIp.findByCustomerIpId", query = "SELECT t FROM TableCustomerIp t WHERE t.customerIpId = :customerIpId"),
    @NamedQuery(name = "TableCustomerIp.findByIp", query = "SELECT t FROM TableCustomerIp t WHERE t.ip = :ip"),
    @NamedQuery(name = "TableCustomerIp.findByDateAdded", query = "SELECT t FROM TableCustomerIp t WHERE t.dateAdded = :dateAdded")})
public class TableCustomerIp extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_ip_id")
    private Integer customerIpId;
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

    public TableCustomerIp() {
    }

    public TableCustomerIp(Integer customerIpId) {
        this.customerIpId = customerIpId;
    }

    public TableCustomerIp(Integer customerIpId, String ip, Date dateAdded) {
        this.customerIpId = customerIpId;
        this.ip = ip;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return customerIpId;
    }

    @Override
    public void setId(Integer customerIpId) {
        this.customerIpId = customerIpId;
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
        hash += (customerIpId != null ? customerIpId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomerIp)) {
            return false;
        }
        TableCustomerIp other = (TableCustomerIp) object;
        if ((this.customerIpId == null && other.customerIpId != null) || (this.customerIpId != null && !this.customerIpId.equals(other.customerIpId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCustomerIp[ customerIpId=" + customerIpId + " ]";
    }
    
}
