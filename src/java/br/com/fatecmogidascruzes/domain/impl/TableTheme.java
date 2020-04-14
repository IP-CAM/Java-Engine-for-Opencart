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
import javax.persistence.Lob;
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
@Table(name = "table_theme")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableTheme.findAll", query = "SELECT t FROM TableTheme t"),
    @NamedQuery(name = "TableTheme.findById", query = "SELECT t FROM TableTheme t WHERE t.themeId = :id"),
    @NamedQuery(name = "TableTheme.findByStoreId", query = "SELECT t FROM TableTheme t WHERE t.storeId = :storeId"),
    @NamedQuery(name = "TableTheme.findByTheme", query = "SELECT t FROM TableTheme t WHERE t.theme = :theme"),
    @NamedQuery(name = "TableTheme.findByRoute", query = "SELECT t FROM TableTheme t WHERE t.route = :route"),
    @NamedQuery(name = "TableTheme.findByDateAdded", query = "SELECT t FROM TableTheme t WHERE t.dateAdded = :dateAdded")})
public class TableTheme extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "theme_id")
    private Integer themeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "store_id")
    private int storeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "theme")
    private String theme;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "route")
    private String route;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    public TableTheme() {
    }

    public TableTheme(Integer themeId) {
        this.themeId = themeId;
    }

    public TableTheme(Integer themeId, int storeId, String theme, String route, String code, Date dateAdded) {
        this.themeId = themeId;
        this.storeId = storeId;
        this.theme = theme;
        this.route = route;
        this.code = code;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return themeId;
    }

    @Override
    public void setId(Integer themeId) {
        this.themeId = themeId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (themeId != null ? themeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableTheme)) {
            return false;
        }
        TableTheme other = (TableTheme) object;
        if ((this.themeId == null && other.themeId != null) || (this.themeId != null && !this.themeId.equals(other.themeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableTheme[ themeId=" + themeId + " ]";
    }
    
}
