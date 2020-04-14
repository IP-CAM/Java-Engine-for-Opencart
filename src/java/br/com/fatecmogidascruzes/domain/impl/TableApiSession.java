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
@Table(name = "table_api_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableApiSession.findAll", query = "SELECT t FROM TableApiSession t"),
    @NamedQuery(name = "TableApiSession.findByApiSessionId", query = "SELECT t FROM TableApiSession t WHERE t.apiSessionId = :apiSessionId"),
    @NamedQuery(name = "TableApiSession.findByIp", query = "SELECT t FROM TableApiSession t WHERE t.ip = :ip"),
    @NamedQuery(name = "TableApiSession.findByDateAdded", query = "SELECT t FROM TableApiSession t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableApiSession.findByDateModified", query = "SELECT t FROM TableApiSession t WHERE t.dateModified = :dateModified")})
public class TableApiSession extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "api_session_id")
    private Integer apiSessionId;
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    @JoinColumn(name = "api_id", referencedColumnName = "api_id")
    @ManyToOne(optional = false)
    private TableApi apiId;
    @JoinColumn(name = "session_id", referencedColumnName = "session_id")
    @ManyToOne(optional = false)
    private TableSession sessionId;

    public TableApiSession() {
    }

    public TableApiSession(Integer apiSessionId) {
        this.apiSessionId = apiSessionId;
    }

    public TableApiSession(Integer apiSessionId, String ip, Date dateAdded, Date dateModified) {
        this.apiSessionId = apiSessionId;
        this.ip = ip;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return apiSessionId;
    }

    @Override
    public void setId(Integer apiSessionId) {
        this.apiSessionId = apiSessionId;
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

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    public TableApi getApiId() {
        return apiId;
    }

    public void setApiId(TableApi apiId) {
        this.apiId = apiId;
    }

    public TableSession getSessionId() {
        return sessionId;
    }

    public void setSessionId(TableSession sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (apiSessionId != null ? apiSessionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableApiSession)) {
            return false;
        }
        TableApiSession other = (TableApiSession) object;
        if ((this.apiSessionId == null && other.apiSessionId != null) || (this.apiSessionId != null && !this.apiSessionId.equals(other.apiSessionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableApiSession[ apiSessionId=" + apiSessionId + " ]";
    }
    
}
