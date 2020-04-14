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
@Table(name = "table_extension_path")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableExtensionPath.findAll", query = "SELECT t FROM TableExtensionPath t"),
    @NamedQuery(name = "TableExtensionPath.findByExtensionPathId", query = "SELECT t FROM TableExtensionPath t WHERE t.extensionPathId = :extensionPathId"),
    @NamedQuery(name = "TableExtensionPath.findByExtensionInstallId", query = "SELECT t FROM TableExtensionPath t WHERE t.extensionInstallId = :extensionInstallId"),
    @NamedQuery(name = "TableExtensionPath.findByPath", query = "SELECT t FROM TableExtensionPath t WHERE t.path = :path"),
    @NamedQuery(name = "TableExtensionPath.findByDateAdded", query = "SELECT t FROM TableExtensionPath t WHERE t.dateAdded = :dateAdded")})
public class TableExtensionPath extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "extension_path_id")
    private Integer extensionPathId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extension_install_id")
    private int extensionInstallId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "path")
    private String path;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    public TableExtensionPath() {
    }

    public TableExtensionPath(Integer extensionPathId) {
        this.extensionPathId = extensionPathId;
    }

    public TableExtensionPath(Integer extensionPathId, int extensionInstallId, String path, Date dateAdded) {
        this.extensionPathId = extensionPathId;
        this.extensionInstallId = extensionInstallId;
        this.path = path;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return extensionPathId;
    }

    @Override
    public void setId(Integer extensionPathId) {
        this.extensionPathId = extensionPathId;
    }

    public int getExtensionInstallId() {
        return extensionInstallId;
    }

    public void setExtensionInstallId(int extensionInstallId) {
        this.extensionInstallId = extensionInstallId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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
        hash += (extensionPathId != null ? extensionPathId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableExtensionPath)) {
            return false;
        }
        TableExtensionPath other = (TableExtensionPath) object;
        if ((this.extensionPathId == null && other.extensionPathId != null) || (this.extensionPathId != null && !this.extensionPathId.equals(other.extensionPathId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableExtensionPath[ extensionPathId=" + extensionPathId + " ]";
    }
    
}
