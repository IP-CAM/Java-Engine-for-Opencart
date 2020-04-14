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
@Table(name = "table_translation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableTranslation.findAll", query = "SELECT t FROM TableTranslation t"),
    @NamedQuery(name = "TableTranslation.findByTranslationId", query = "SELECT t FROM TableTranslation t WHERE t.translationId = :translationId"),
    @NamedQuery(name = "TableTranslation.findByStoreId", query = "SELECT t FROM TableTranslation t WHERE t.storeId = :storeId"),
    @NamedQuery(name = "TableTranslation.findByLanguageId", query = "SELECT t FROM TableTranslation t WHERE t.languageId = :languageId"),
    @NamedQuery(name = "TableTranslation.findByRoute", query = "SELECT t FROM TableTranslation t WHERE t.route = :route"),
    @NamedQuery(name = "TableTranslation.findByKey", query = "SELECT t FROM TableTranslation t WHERE t.key = :key"),
    @NamedQuery(name = "TableTranslation.findByDateAdded", query = "SELECT t FROM TableTranslation t WHERE t.dateAdded = :dateAdded")})
public class TableTranslation extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "translation_id")
    private Integer translationId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "store_id")
    private int storeId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "language_id")
    private int languageId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "route")
    private String route;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
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
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    public TableTranslation() {
    }

    public TableTranslation(Integer translationId) {
        this.translationId = translationId;
    }

    public TableTranslation(Integer translationId, int storeId, int languageId, String route, String key, String value, Date dateAdded) {
        this.translationId = translationId;
        this.storeId = storeId;
        this.languageId = languageId;
        this.route = route;
        this.key = key;
        this.value = value;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return translationId;
    }

    @Override
    public void setId(Integer translationId) {
        this.translationId = translationId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
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

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (translationId != null ? translationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableTranslation)) {
            return false;
        }
        TableTranslation other = (TableTranslation) object;
        if ((this.translationId == null && other.translationId != null) || (this.translationId != null && !this.translationId.equals(other.translationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableTranslation[ translationId=" + translationId + " ]";
    }
    
}
