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
import javax.persistence.Lob;
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
@Table(name = "table_module")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableModule.findAll", query = "SELECT t FROM TableModule t"),
    @NamedQuery(name = "TableModule.findByModuleId", query = "SELECT t FROM TableModule t WHERE t.moduleId = :moduleId"),
    @NamedQuery(name = "TableModule.findByName", query = "SELECT t FROM TableModule t WHERE t.name = :name"),
    @NamedQuery(name = "TableModule.findByCode", query = "SELECT t FROM TableModule t WHERE t.code = :code")})
public class TableModule extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "module_id")
    private Integer moduleId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "setting")
    private String setting;

    public TableModule() {
    }

    public TableModule(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public TableModule(Integer moduleId, String name, String code, String setting) {
        this.moduleId = moduleId;
        this.name = name;
        this.code = code;
        this.setting = setting;
    }

    @Override
    public Integer getId() {
        return moduleId;
    }

    @Override
    public void setId(Integer moduleId) {
        this.moduleId = moduleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSetting() {
        return setting;
    }

    public void setSetting(String setting) {
        this.setting = setting;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moduleId != null ? moduleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableModule)) {
            return false;
        }
        TableModule other = (TableModule) object;
        if ((this.moduleId == null && other.moduleId != null) || (this.moduleId != null && !this.moduleId.equals(other.moduleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableModule[ moduleId=" + moduleId + " ]";
    }
    
}
