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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_api")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableApi.findAll", query = "SELECT t FROM TableApi t"),
    @NamedQuery(name = "TableApi.findByUsername", query = "SELECT t FROM TableApi t WHERE t.username = :username"),
    @NamedQuery(name = "TableApi.findByStatus", query = "SELECT t FROM TableApi t WHERE t.status = :status"),
    @NamedQuery(name = "TableApi.findByDateAdded", query = "SELECT t FROM TableApi t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableApi.findByDateModified", query = "SELECT t FROM TableApi t WHERE t.dateModified = :dateModified")})
public class TableApi extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "api_id")
    private Integer apiId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "username")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "key")
    private String key;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
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
    
    // Collection --------------------------------------------------------------------------------------------------------------------
    
    public TableApi() {
    }

    public TableApi(Integer apiId) {
        this.apiId = apiId;
    }

    public TableApi(Integer apiId, String username, String key, boolean status, Date dateAdded, Date dateModified) {
        this.apiId = apiId;
        this.username = username;
        this.key = key;
        this.status = status;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return apiId;
    }

    @Override
    public void setId(Integer apiId) {
        this.apiId = apiId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        hash += (apiId != null ? apiId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableApi)) {
            return false;
        }
        TableApi other = (TableApi) object;
        if ((this.apiId == null && other.apiId != null) || (this.apiId != null && !this.apiId.equals(other.apiId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableApi[ apiId=" + apiId + " ]";
    }
    
}
