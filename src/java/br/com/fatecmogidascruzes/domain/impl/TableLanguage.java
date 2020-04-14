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
@Table(name = "table_language")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableLanguage.findAll", query = "SELECT t FROM TableLanguage t"),
    @NamedQuery(name = "TableLanguage.findByLanguageId", query = "SELECT t FROM TableLanguage t WHERE t.languageId = :languageId"),
    @NamedQuery(name = "TableLanguage.findByName", query = "SELECT t FROM TableLanguage t WHERE t.name = :name"),
    @NamedQuery(name = "TableLanguage.findByCode", query = "SELECT t FROM TableLanguage t WHERE t.code = :code"),
    @NamedQuery(name = "TableLanguage.findByLocale", query = "SELECT t FROM TableLanguage t WHERE t.locale = :locale"),
    @NamedQuery(name = "TableLanguage.findByImage", query = "SELECT t FROM TableLanguage t WHERE t.image = :image"),
    @NamedQuery(name = "TableLanguage.findByDirectory", query = "SELECT t FROM TableLanguage t WHERE t.directory = :directory"),
    @NamedQuery(name = "TableLanguage.findBySortOrder", query = "SELECT t FROM TableLanguage t WHERE t.sortOrder = :sortOrder"),
    @NamedQuery(name = "TableLanguage.findByStatus", query = "SELECT t FROM TableLanguage t WHERE t.status = :status")})
public class TableLanguage extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "language_id")
    private Integer languageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "locale")
    private String locale;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "directory")
    private String directory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;

    public TableLanguage() {
    }

    public TableLanguage(Integer languageId) {
        this.languageId = languageId;
    }

    public TableLanguage(Integer languageId, String name, String code, String locale, String image, String directory, int sortOrder, boolean status) {
        this.languageId = languageId;
        this.name = name;
        this.code = code;
        this.locale = locale;
        this.image = image;
        this.directory = directory;
        this.sortOrder = sortOrder;
        this.status = status;
    }

    public Integer getId() {
        return languageId;
    }

    public void setId(Integer languageId) {
        this.languageId = languageId;
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

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (languageId != null ? languageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableLanguage)) {
            return false;
        }
        TableLanguage other = (TableLanguage) object;
        if ((this.languageId == null && other.languageId != null) || (this.languageId != null && !this.languageId.equals(other.languageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableLanguage[ languageId=" + languageId + " ]";
    }
    
}
