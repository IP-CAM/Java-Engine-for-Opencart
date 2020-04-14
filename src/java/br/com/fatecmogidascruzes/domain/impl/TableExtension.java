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
@Table(name = "table_extension")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableExtension.findAll", query = "SELECT t FROM TableExtension t"),
    @NamedQuery(name = "TableExtension.findByExtensionId", query = "SELECT t FROM TableExtension t WHERE t.extensionId = :extensionId"),
    @NamedQuery(name = "TableExtension.findByType", query = "SELECT t FROM TableExtension t WHERE t.type = :type"),
    @NamedQuery(name = "TableExtension.findByCode", query = "SELECT t FROM TableExtension t WHERE t.code = :code")})
public class TableExtension extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "extension_id")
    private Integer extensionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "code")
    private String code;

    public TableExtension() {
    }

    public TableExtension(Integer extensionId) {
        this.extensionId = extensionId;
    }

    public TableExtension(Integer extensionId, String type, String code) {
        this.extensionId = extensionId;
        this.type = type;
        this.code = code;
    }

    @Override
    public Integer getId() {
        return extensionId;
    }

    @Override
    public void setId(Integer extensionId) {
        this.extensionId = extensionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (extensionId != null ? extensionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableExtension)) {
            return false;
        }
        TableExtension other = (TableExtension) object;
        if ((this.extensionId == null && other.extensionId != null) || (this.extensionId != null && !this.extensionId.equals(other.extensionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableExtension[ extensionId=" + extensionId + " ]";
    }
    
}
