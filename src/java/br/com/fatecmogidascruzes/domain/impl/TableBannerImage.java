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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "table_banner_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableBannerImage.findAll", query = "SELECT t FROM TableBannerImage t"),
    @NamedQuery(name = "TableBannerImage.findById", query = "SELECT t FROM TableBannerImage t WHERE t.bannerImageId = :id"),
    @NamedQuery(name = "TableBannerImage.findByTitle", query = "SELECT t FROM TableBannerImage t WHERE t.title = :title"),
    @NamedQuery(name = "TableBannerImage.findByImage", query = "SELECT t FROM TableBannerImage t WHERE t.image = :image"),
    @NamedQuery(name = "TableBannerImage.findBySortOrder", query = "SELECT t FROM TableBannerImage t WHERE t.sortOrder = :sortOrder")})
public class TableBannerImage extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "banner_image_id")
    private Integer bannerImageId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "link")
    private String link;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    @JoinColumn(name = "banner_id", referencedColumnName = "banner_id")
    @ManyToOne(optional = false)
    private TableBanner bannerId;

    public TableBannerImage() {
    }

    public TableBannerImage(Integer bannerImageId) {
        this.bannerImageId = bannerImageId;
    }

    public TableBannerImage(Integer bannerImageId, String title, String link, String image, int sortOrder) {
        this.bannerImageId = bannerImageId;
        this.title = title;
        this.link = link;
        this.image = image;
        this.sortOrder = sortOrder;
    }

    @Override
    public Integer getId() {
        return bannerImageId;
    }

    @Override
    public void setId(Integer bannerImageId) {
        this.bannerImageId = bannerImageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    public TableBanner getBannerId() {
        return bannerId;
    }

    public void setBannerId(TableBanner bannerId) {
        this.bannerId = bannerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bannerImageId != null ? bannerImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableBannerImage)) {
            return false;
        }
        TableBannerImage other = (TableBannerImage) object;
        if ((this.bannerImageId == null && other.bannerImageId != null) || (this.bannerImageId != null && !this.bannerImageId.equals(other.bannerImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableBannerImage[ bannerImageId=" + bannerImageId + " ]";
    }
    
}
