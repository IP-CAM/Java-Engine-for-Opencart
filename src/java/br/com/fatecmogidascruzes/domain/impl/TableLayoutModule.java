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
@Table(name = "table_layout_module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableLayoutModule.findAll", query = "SELECT t FROM TableLayoutModule t"),
    @NamedQuery(name = "TableLayoutModule.findByLayoutModuleId", query = "SELECT t FROM TableLayoutModule t WHERE t.layoutModuleId = :layoutModuleId"),
    @NamedQuery(name = "TableLayoutModule.findByLayoutId", query = "SELECT t FROM TableLayoutModule t WHERE t.layoutId = :layoutId"),
    @NamedQuery(name = "TableLayoutModule.findByCode", query = "SELECT t FROM TableLayoutModule t WHERE t.code = :code"),
    @NamedQuery(name = "TableLayoutModule.findByPosition", query = "SELECT t FROM TableLayoutModule t WHERE t.position = :position"),
    @NamedQuery(name = "TableLayoutModule.findBySortOrder", query = "SELECT t FROM TableLayoutModule t WHERE t.sortOrder = :sortOrder")})
public class TableLayoutModule extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "layout_module_id")
    private Integer layoutModuleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "layout_id")
    private int layoutId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "position")
    private String position;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;

    public TableLayoutModule() {
    }

    public TableLayoutModule(Integer layoutModuleId) {
        this.layoutModuleId = layoutModuleId;
    }

    public TableLayoutModule(Integer layoutModuleId, int layoutId, String code, String position, int sortOrder) {
        this.layoutModuleId = layoutModuleId;
        this.layoutId = layoutId;
        this.code = code;
        this.position = position;
        this.sortOrder = sortOrder;
    }

    @Override
    public Integer getId() {
        return layoutModuleId;
    }

    @Override
    public void setId(Integer layoutModuleId) {
        this.layoutModuleId = layoutModuleId;
    }

    public int getLayoutId() {
        return layoutId;
    }

    public void setLayoutId(int layoutId) {
        this.layoutId = layoutId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (layoutModuleId != null ? layoutModuleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableLayoutModule)) {
            return false;
        }
        TableLayoutModule other = (TableLayoutModule) object;
        if ((this.layoutModuleId == null && other.layoutModuleId != null) || (this.layoutModuleId != null && !this.layoutModuleId.equals(other.layoutModuleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableLayoutModule[ layoutModuleId=" + layoutModuleId + " ]";
    }
    
}
