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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_layout_route")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableLayoutRoute.findAll", query = "SELECT t FROM TableLayoutRoute t"),
    @NamedQuery(name = "TableLayoutRoute.findByLayoutRouteId", query = "SELECT t FROM TableLayoutRoute t WHERE t.layoutRouteId = :layoutRouteId"),
    @NamedQuery(name = "TableLayoutRoute.findByLayoutId", query = "SELECT t FROM TableLayoutRoute t WHERE t.layoutId = :layoutId"),
    @NamedQuery(name = "TableLayoutRoute.findByStoreId", query = "SELECT t FROM TableLayoutRoute t WHERE t.storeId = :storeId"),
    @NamedQuery(name = "TableLayoutRoute.findByRoute", query = "SELECT t FROM TableLayoutRoute t WHERE t.route = :route")})
public class TableLayoutRoute extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "layout_route_id")
    private Integer layoutRouteId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "layout_id")
    private int layoutId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "store_id")
    private int storeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "route")
    private String route;

    public TableLayoutRoute() {
    }

    public TableLayoutRoute(Integer layoutRouteId) {
        this.layoutRouteId = layoutRouteId;
    }

    public TableLayoutRoute(Integer layoutRouteId, int layoutId, int storeId, String route) {
        this.layoutRouteId = layoutRouteId;
        this.layoutId = layoutId;
        this.storeId = storeId;
        this.route = route;
    }

    @Override
    public Integer getId() {
        return layoutRouteId;
    }

    @Override
    public void setId(Integer layoutRouteId) {
        this.layoutRouteId = layoutRouteId;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (layoutRouteId != null ? layoutRouteId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableLayoutRoute)) {
            return false;
        }
        TableLayoutRoute other = (TableLayoutRoute) object;
        if ((this.layoutRouteId == null && other.layoutRouteId != null) || (this.layoutRouteId != null && !this.layoutRouteId.equals(other.layoutRouteId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableLayoutRoute[ layoutRouteId=" + layoutRouteId + " ]";
    }
    
}
