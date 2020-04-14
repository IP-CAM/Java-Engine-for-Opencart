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
@Table(name = "table_modification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableModification.findAll", query = "SELECT t FROM TableModification t"),
    @NamedQuery(name = "TableModification.findByModificationId", query = "SELECT t FROM TableModification t WHERE t.modificationId = :modificationId"),
    @NamedQuery(name = "TableModification.findByExtensionInstallId", query = "SELECT t FROM TableModification t WHERE t.extensionInstallId = :extensionInstallId"),
    @NamedQuery(name = "TableModification.findByName", query = "SELECT t FROM TableModification t WHERE t.name = :name"),
    @NamedQuery(name = "TableModification.findByCode", query = "SELECT t FROM TableModification t WHERE t.code = :code"),
    @NamedQuery(name = "TableModification.findByAuthor", query = "SELECT t FROM TableModification t WHERE t.author = :author"),
    @NamedQuery(name = "TableModification.findByVersion", query = "SELECT t FROM TableModification t WHERE t.version = :version"),
    @NamedQuery(name = "TableModification.findByLink", query = "SELECT t FROM TableModification t WHERE t.link = :link"),
    @NamedQuery(name = "TableModification.findByStatus", query = "SELECT t FROM TableModification t WHERE t.status = :status"),
    @NamedQuery(name = "TableModification.findByDateAdded", query = "SELECT t FROM TableModification t WHERE t.dateAdded = :dateAdded")})
public class TableModification extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "modification_id")
    private Integer modificationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "extension_install_id")
    private int extensionInstallId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "version")
    private String version;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "xml")
    private String xml;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    public TableModification() {
    }

    public TableModification(Integer modificationId) {
        this.modificationId = modificationId;
    }

    public TableModification(Integer modificationId, int extensionInstallId, String name, String code, String author, String version, String link, String xml, boolean status, Date dateAdded) {
        this.modificationId = modificationId;
        this.extensionInstallId = extensionInstallId;
        this.name = name;
        this.code = code;
        this.author = author;
        this.version = version;
        this.link = link;
        this.xml = xml;
        this.status = status;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return modificationId;
    }

    @Override
    public void setId(Integer modificationId) {
        this.modificationId = modificationId;
    }

    public int getExtensionInstallId() {
        return extensionInstallId;
    }

    public void setExtensionInstallId(int extensionInstallId) {
        this.extensionInstallId = extensionInstallId;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
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
        hash += (modificationId != null ? modificationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableModification)) {
            return false;
        }
        TableModification other = (TableModification) object;
        if ((this.modificationId == null && other.modificationId != null) || (this.modificationId != null && !this.modificationId.equals(other.modificationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableModification[ modificationId=" + modificationId + " ]";
    }
    
}
