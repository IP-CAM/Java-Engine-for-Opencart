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
@Table(name = "table_customer_login")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCustomerLogin.findAll", query = "SELECT t FROM TableCustomerLogin t"),
    @NamedQuery(name = "TableCustomerLogin.findByCustomerLoginId", query = "SELECT t FROM TableCustomerLogin t WHERE t.customerLoginId = :customerLoginId"),
    @NamedQuery(name = "TableCustomerLogin.findByEmail", query = "SELECT t FROM TableCustomerLogin t WHERE t.email = :email"),
    @NamedQuery(name = "TableCustomerLogin.findByIp", query = "SELECT t FROM TableCustomerLogin t WHERE t.ip = :ip"),
    @NamedQuery(name = "TableCustomerLogin.findByTotal", query = "SELECT t FROM TableCustomerLogin t WHERE t.total = :total"),
    @NamedQuery(name = "TableCustomerLogin.findByDateAdded", query = "SELECT t FROM TableCustomerLogin t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableCustomerLogin.findByDateModified", query = "SELECT t FROM TableCustomerLogin t WHERE t.dateModified = :dateModified")})
public class TableCustomerLogin extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "customer_login_id")
    private Integer customerLoginId;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="E-mail inválido")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 96)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "ip")
    private String ip;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private int total;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    public TableCustomerLogin() {
    }

    public TableCustomerLogin(Integer customerLoginId) {
        this.customerLoginId = customerLoginId;
    }

    public TableCustomerLogin(Integer customerLoginId, String email, String ip, int total, Date dateAdded, Date dateModified) {
        this.customerLoginId = customerLoginId;
        this.email = email;
        this.ip = ip;
        this.total = total;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return customerLoginId;
    }

    @Override
    public void setId(Integer customerLoginId) {
        this.customerLoginId = customerLoginId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerLoginId != null ? customerLoginId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCustomerLogin)) {
            return false;
        }
        TableCustomerLogin other = (TableCustomerLogin) object;
        if ((this.customerLoginId == null && other.customerLoginId != null) || (this.customerLoginId != null && !this.customerLoginId.equals(other.customerLoginId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCustomerLogin[ customerLoginId=" + customerLoginId + " ]";
    }
    
}
