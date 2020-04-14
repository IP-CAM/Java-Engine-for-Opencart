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
@Table(name = "table_extension_install")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableExtensionInstall.findAll", query = "SELECT t FROM TableExtensionInstall t"),
    @NamedQuery(name = "TableExtensionInstall.findByExtensionInstallId", query = "SELECT t FROM TableExtensionInstall t WHERE t.extensionInstallId = :extensionInstallId"),
    @NamedQuery(name = "TableExtensionInstall.findByExtensionDownloadId", query = "SELECT t FROM TableExtensionInstall t WHERE t.extensionDownloadId = :extensionDownloadId"),
    @NamedQuery(name = "TableExtensionInstall.findByFilename", query = "SELECT t FROM TableExtensionInstall t WHERE t.filename = :filename"),
    @NamedQuery(name = "TableExtensionInstall.findByDateAdded", query = "SELECT t FROM TableExtensionInstall t WHERE t.dateAdded = :dateAdded")})
public class TableExtensionInstall extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "extension_install_id")
    private Integer extensionInstallId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extension_download_id")
    private int extensionDownloadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    public TableExtensionInstall() {
    }

    public TableExtensionInstall(Integer extensionInstallId) {
        this.extensionInstallId = extensionInstallId;
    }

    public TableExtensionInstall(Integer extensionInstallId, int extensionDownloadId, String filename, Date dateAdded) {
        this.extensionInstallId = extensionInstallId;
        this.extensionDownloadId = extensionDownloadId;
        this.filename = filename;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return extensionInstallId;
    }

    @Override
    public void setId(Integer extensionInstallId) {
        this.extensionInstallId = extensionInstallId;
    }

    public int getExtensionDownloadId() {
        return extensionDownloadId;
    }

    public void setExtensionDownloadId(int extensionDownloadId) {
        this.extensionDownloadId = extensionDownloadId;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
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
        hash += (extensionInstallId != null ? extensionInstallId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableExtensionInstall)) {
            return false;
        }
        TableExtensionInstall other = (TableExtensionInstall) object;
        if ((this.extensionInstallId == null && other.extensionInstallId != null) || (this.extensionInstallId != null && !this.extensionInstallId.equals(other.extensionInstallId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableExtensionInstall[ extensionInstallId=" + extensionInstallId + " ]";
    }
    
}
