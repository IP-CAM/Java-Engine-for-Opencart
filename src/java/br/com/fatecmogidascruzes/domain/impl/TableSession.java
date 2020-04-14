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
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import org.junit.Ignore;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_session")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableSession.findAll", query = "SELECT t FROM TableSession t"),
    @NamedQuery(name = "TableSession.findBySession", query = "SELECT t FROM TableSession t WHERE t.session = :value"),
    @NamedQuery(name = "TableSession.findByExpire", query = "SELECT t FROM TableSession t WHERE t.expire = :expire")})
public class TableSession  extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "session_id")
    private String session;
    
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "data")
    private String data;
    
    @Basic(optional = false)
    @Column(name = "expire", updatable = true, insertable = true, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    @Temporal(TemporalType.TIMESTAMP)
    private Date expire;    

    public TableSession () {
    }

    public TableSession(String session) {
        this.session = session;
    }

    public TableSession(String session, String data, Date expire) {
        this.session = session;
        this.data = data;
        this.expire = expire;
    }
    
    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Date getExpire() {
        return expire;
    }

    public void setExpire(Date expire) {
        this.expire = expire;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (session != null ? session.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableSession)) {
            return false;
        }
        TableSession other = (TableSession) object;
        if ((this.session == null && other.session != null) || (this.session != null && !this.session.equals(other.session))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableSession[ session=" + session + " ]";
    }   

    @Ignore
    @Override
    public Integer getId() {
        return null;
    }

    @Ignore
    @Override
    public void setId(Integer id) {
        
    }
    
}
