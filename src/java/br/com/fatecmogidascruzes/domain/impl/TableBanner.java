/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_banner")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableBanner.findAll", query = "SELECT t FROM TableBanner t"),
    @NamedQuery(name = "TableBanner.findById", query = "SELECT t FROM TableBanner t WHERE t.bannerId = :id"),
    @NamedQuery(name = "TableBanner.findByName", query = "SELECT t FROM TableBanner t WHERE t.name = :name"),
    @NamedQuery(name = "TableBanner.findByStatus", query = "SELECT t FROM TableBanner t WHERE t.status = :status")})
public class TableBanner extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "banner_id")
    private Integer bannerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bannerId")
    private List<TableBannerImage> bannerImageList;

    public TableBanner() {
    }

    public TableBanner(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public TableBanner(Integer bannerId, String name, boolean status) {
        this.bannerId = bannerId;
        this.name = name;
        this.status = status;
    }

    @Override
    public Integer getId() {
        return bannerId;
    }

    @Override
    public void setId(Integer bannerId) {
        this.bannerId = bannerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @XmlTransient
    public List<TableBannerImage> getBannerImageList() {
        return bannerImageList;
    }

    public void setBannerImageList(List<TableBannerImage> tableBannerImageList) {
        this.bannerImageList = tableBannerImageList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (bannerId != null ? bannerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableBanner)) {
            return false;
        }
        TableBanner other = (TableBanner) object;
        if ((this.bannerId == null && other.bannerId != null) || (this.bannerId != null && !this.bannerId.equals(other.bannerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableBanner[ bannerId=" + bannerId + " ]";
    }
    
}
