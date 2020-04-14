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
@Table(name = "table_product_image")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableProductImage.findAll", query = "SELECT t FROM TableProductImage t"),
    @NamedQuery(name = "TableProductImage.findByProductImageId", query = "SELECT t FROM TableProductImage t WHERE t.productImageId = :productImageId"),
    @NamedQuery(name = "TableProductImage.findByProductId", query = "SELECT t FROM TableProductImage t WHERE t.productId = :productId"),
    @NamedQuery(name = "TableProductImage.findByImage", query = "SELECT t FROM TableProductImage t WHERE t.image = :image"),
    @NamedQuery(name = "TableProductImage.findBySortOrder", query = "SELECT t FROM TableProductImage t WHERE t.sortOrder = :sortOrder")})
public class TableProductImage extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_image_id")
    private Integer productImageId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;

    public TableProductImage() {
    }

    public TableProductImage(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public TableProductImage(Integer productImageId, int productId, int sortOrder) {
        this.productImageId = productImageId;
        this.productId = productId;
        this.sortOrder = sortOrder;
    }

    @Override
    public Integer getId() {
        return productImageId;
    }

    @Override
    public void setId(Integer productImageId) {
        this.productImageId = productImageId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productImageId != null ? productImageId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableProductImage)) {
            return false;
        }
        TableProductImage other = (TableProductImage) object;
        if ((this.productImageId == null && other.productImageId != null) || (this.productImageId != null && !this.productImageId.equals(other.productImageId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableProductImage[ productImageId=" + productImageId + " ]";
    }
    
}
