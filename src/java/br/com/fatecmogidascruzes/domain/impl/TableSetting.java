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
@Table(name = "table_setting")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableSetting.findAll", query = "SELECT t FROM TableSetting t"),
    @NamedQuery(name = "TableSetting.findBySettingId", query = "SELECT t FROM TableSetting t WHERE t.settingId = :settingId"),
    @NamedQuery(name = "TableSetting.findByStoreId", query = "SELECT t FROM TableSetting t WHERE t.storeId = :storeId"),
    @NamedQuery(name = "TableSetting.findByCode", query = "SELECT t FROM TableSetting t WHERE t.code = :code"),
    @NamedQuery(name = "TableSetting.findByKey", query = "SELECT t FROM TableSetting t WHERE t.key = :key"),
    @NamedQuery(name = "TableSetting.findBySerialized", query = "SELECT t FROM TableSetting t WHERE t.serialized = :serialized")})
public class TableSetting extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "setting_id")
    private Integer settingId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "store_id")
    private int storeId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "key")
    private String key;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "serialized")
    private boolean serialized;

    public TableSetting() {
    }

    public TableSetting(Integer settingId) {
        this.settingId = settingId;
    }

    public TableSetting(Integer settingId, int storeId, String code, String key, String value, boolean serialized) {
        this.settingId = settingId;
        this.storeId = storeId;
        this.code = code;
        this.key = key;
        this.value = value;
        this.serialized = serialized;
    }

    @Override
    public Integer getId() {
        return settingId;
    }

    @Override
    public void setId(Integer settingId) {
        this.settingId = settingId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getSerialized() {
        return serialized;
    }

    public void setSerialized(boolean serialized) {
        this.serialized = serialized;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (settingId != null ? settingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableSetting)) {
            return false;
        }
        TableSetting other = (TableSetting) object;
        if ((this.settingId == null && other.settingId != null) || (this.settingId != null && !this.settingId.equals(other.settingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableSetting[ settingId=" + settingId + " ]";
    }
    
}
