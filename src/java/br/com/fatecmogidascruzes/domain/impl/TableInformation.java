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
@Table(name = "table_information")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableInformation.findAll", query = "SELECT t FROM TableInformation t"),
    @NamedQuery(name = "TableInformation.findById", query = "SELECT t FROM TableInformation t WHERE t.informationId = :id"),
    @NamedQuery(name = "TableInformation.findByTitle", query = "SELECT t FROM TableInformation t WHERE t.title = :title"),
    @NamedQuery(name = "TableInformation.findByMetaTitle", query = "SELECT t FROM TableInformation t WHERE t.metaTitle = :metaTitle"),
    @NamedQuery(name = "TableInformation.findByMetaDescription", query = "SELECT t FROM TableInformation t WHERE t.metaDescription = :metaDescription"),
    @NamedQuery(name = "TableInformation.findByMetaKeyword", query = "SELECT t FROM TableInformation t WHERE t.metaKeyword = :metaKeyword"),
    @NamedQuery(name = "TableInformation.findByBottom", query = "SELECT t FROM TableInformation t WHERE t.bottom = :bottom"),
    @NamedQuery(name = "TableInformation.findBySortOrder", query = "SELECT t FROM TableInformation t WHERE t.sortOrder = :sortOrder"),
    @NamedQuery(name = "TableInformation.findByStatus", query = "SELECT t FROM TableInformation t WHERE t.status = :status")})
public class TableInformation extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "information_id")
    private Integer informationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 16777215)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "meta_title")
    private String metaTitle;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "meta_description")
    private String metaDescription;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "meta_keyword")
    private String metaKeyword;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bottom")
    private int bottom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;

    public TableInformation() {
    }

    public TableInformation(Integer informationId) {
        this.informationId = informationId;
    }

    public TableInformation(Integer informationId, String title, String description, String metaTitle, String metaDescription, String metaKeyword, int bottom, int sortOrder, boolean status) {
        this.informationId = informationId;
        this.title = title;
        this.description = description;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.metaKeyword = metaKeyword;
        this.bottom = bottom;
        this.sortOrder = sortOrder;
        this.status = status;
    }

    @Override
    public Integer getId() {
        return informationId;
    }

    @Override
    public void setId(Integer informationId) {
        this.informationId = informationId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMetaTitle() {
        return metaTitle;
    }

    public void setMetaTitle(String metaTitle) {
        this.metaTitle = metaTitle;
    }

    public String getMetaDescription() {
        return metaDescription;
    }

    public void setMetaDescription(String metaDescription) {
        this.metaDescription = metaDescription;
    }

    public String getMetaKeyword() {
        return metaKeyword;
    }

    public void setMetaKeyword(String metaKeyword) {
        this.metaKeyword = metaKeyword;
    }

    public int getBottom() {
        return bottom;
    }

    public void setBottom(int bottom) {
        this.bottom = bottom;
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
        hash += (informationId != null ? informationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableInformation)) {
            return false;
        }
        TableInformation other = (TableInformation) object;
        if ((this.informationId == null && other.informationId != null) || (this.informationId != null && !this.informationId.equals(other.informationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableInformation[ informationId=" + informationId + " ]";
    }
    
}
