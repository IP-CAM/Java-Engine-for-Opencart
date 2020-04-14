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
@Table(name = "table_review")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableReview.findAll", query = "SELECT t FROM TableReview t"),
    @NamedQuery(name = "TableReview.findByReviewId", query = "SELECT t FROM TableReview t WHERE t.reviewId = :reviewId"),
    @NamedQuery(name = "TableReview.findByProductId", query = "SELECT t FROM TableReview t WHERE t.productId = :productId"),
    @NamedQuery(name = "TableReview.findByCustomerId", query = "SELECT t FROM TableReview t WHERE t.customerId = :customerId"),
    @NamedQuery(name = "TableReview.findByAuthor", query = "SELECT t FROM TableReview t WHERE t.author = :author"),
    @NamedQuery(name = "TableReview.findByRating", query = "SELECT t FROM TableReview t WHERE t.rating = :rating"),
    @NamedQuery(name = "TableReview.findByStatus", query = "SELECT t FROM TableReview t WHERE t.status = :status"),
    @NamedQuery(name = "TableReview.findByDateAdded", query = "SELECT t FROM TableReview t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableReview.findByDateModified", query = "SELECT t FROM TableReview t WHERE t.dateModified = :dateModified")})
public class TableReview extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "review_id")
    private Integer reviewId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "customer_id")
    private int customerId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "author")
    private String author;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "text")
    private String text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "rating")
    private int rating;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;

    public TableReview() {
    }

    public TableReview(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public TableReview(Integer reviewId, int productId, int customerId, String author, String text, int rating, boolean status, Date dateAdded, Date dateModified) {
        this.reviewId = reviewId;
        this.productId = productId;
        this.customerId = customerId;
        this.author = author;
        this.text = text;
        this.rating = rating;
        this.status = status;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return reviewId;
    }

    @Override
    public void setId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
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

    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableReview)) {
            return false;
        }
        TableReview other = (TableReview) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableReview[ reviewId=" + reviewId + " ]";
    }
    
}
