/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableProduct.findAll", query = "SELECT t FROM TableProduct t"),
    @NamedQuery(name = "TableProduct.findCount", query = "SELECT count(t) FROM TableProduct t"),
    @NamedQuery(name = "TableProduct.findById", query = "SELECT t FROM TableProduct t WHERE t.productId = :id"),
    @NamedQuery(name = "TableProduct.findByName", query = "SELECT t FROM TableProduct t WHERE t.name = :name"),
    @NamedQuery(name = "TableProduct.findByMetaTitle", query = "SELECT t FROM TableProduct t WHERE t.metaTitle = :metaTitle"),
    @NamedQuery(name = "TableProduct.findByMetaDescription", query = "SELECT t FROM TableProduct t WHERE t.metaDescription = :metaDescription"),
    @NamedQuery(name = "TableProduct.findByMetaKeyword", query = "SELECT t FROM TableProduct t WHERE t.metaKeyword = :metaKeyword"),
    @NamedQuery(name = "TableProduct.findByModel", query = "SELECT t FROM TableProduct t WHERE t.model = :model"),
    @NamedQuery(name = "TableProduct.findBySku", query = "SELECT t FROM TableProduct t WHERE t.sku = :sku"),
    @NamedQuery(name = "TableProduct.findByUpc", query = "SELECT t FROM TableProduct t WHERE t.upc = :upc"),
    @NamedQuery(name = "TableProduct.findByEan", query = "SELECT t FROM TableProduct t WHERE t.ean = :ean"),
    @NamedQuery(name = "TableProduct.findByJan", query = "SELECT t FROM TableProduct t WHERE t.jan = :jan"),
    @NamedQuery(name = "TableProduct.findByIsbn", query = "SELECT t FROM TableProduct t WHERE t.isbn = :isbn"),
    @NamedQuery(name = "TableProduct.findByMpn", query = "SELECT t FROM TableProduct t WHERE t.mpn = :mpn"),
    @NamedQuery(name = "TableProduct.findByLocation", query = "SELECT t FROM TableProduct t WHERE t.location = :location"),
    @NamedQuery(name = "TableProduct.findByQuantity", query = "SELECT t FROM TableProduct t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TableProduct.findByImage", query = "SELECT t FROM TableProduct t WHERE t.image = :image"),
    @NamedQuery(name = "TableProduct.findByShipping", query = "SELECT t FROM TableProduct t WHERE t.shipping = :shipping"),
    @NamedQuery(name = "TableProduct.findByPrice", query = "SELECT t FROM TableProduct t WHERE t.price = :price"),
    @NamedQuery(name = "TableProduct.findByPoints", query = "SELECT t FROM TableProduct t WHERE t.points = :points"),
    @NamedQuery(name = "TableProduct.findByDateAvailable", query = "SELECT t FROM TableProduct t WHERE t.dateAvailable = :dateAvailable"),
    @NamedQuery(name = "TableProduct.findByWeight", query = "SELECT t FROM TableProduct t WHERE t.weight = :weight"),
    @NamedQuery(name = "TableProduct.findByLength", query = "SELECT t FROM TableProduct t WHERE t.length = :length"),
    @NamedQuery(name = "TableProduct.findByWidth", query = "SELECT t FROM TableProduct t WHERE t.width = :width"),
    @NamedQuery(name = "TableProduct.findByHeight", query = "SELECT t FROM TableProduct t WHERE t.height = :height"),
    @NamedQuery(name = "TableProduct.findBySubtract", query = "SELECT t FROM TableProduct t WHERE t.subtract = :subtract"),
    @NamedQuery(name = "TableProduct.findByMinimum", query = "SELECT t FROM TableProduct t WHERE t.minimum = :minimum"),
    @NamedQuery(name = "TableProduct.findBySortOrder", query = "SELECT t FROM TableProduct t WHERE t.sortOrder = :sortOrder"),
    @NamedQuery(name = "TableProduct.findByStatus", query = "SELECT t FROM TableProduct t WHERE t.status = :status"),
    @NamedQuery(name = "TableProduct.findByViewed", query = "SELECT t FROM TableProduct t WHERE t.viewed = :viewed"),
    @NamedQuery(name = "TableProduct.findByDateAdded", query = "SELECT t FROM TableProduct t WHERE t.dateAdded = :dateAdded"),
    @NamedQuery(name = "TableProduct.findByDateModified", query = "SELECT t FROM TableProduct t WHERE t.dateModified = :dateModified"),
    // Collection
    @NamedQuery(name = "TableProduct.findByCategory", query = "SELECT p FROM TableProduct p JOIN p.categoryList c where c.categoryId = :id order by p.name ASC"),
    @NamedQuery(name = "TableProduct.findByManufacturer", query = "SELECT p FROM TableProduct p JOIN p.manufacturer m where m.manufacturerId = :id order by p.name ASC"),        
    // Count
    @NamedQuery(name = "TableProduct.CountByCategory",     query = "SELECT count (p.productId) FROM TableProduct p JOIN p.categoryList c WHERE c.categoryId = :id"),
    @NamedQuery(name = "TableProduct.CountByManufacturer", query = "SELECT count (p.productId) FROM TableProduct p JOIN p.manufacturer m WHERE m.manufacturerId = :id")

})
public class TableProduct extends EntidadeDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private Integer productId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull()
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Lob()
    @Size(min = 1, max = 65535)
    @Column(name = "tag")
    private String tag;
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
    @Size(min = 1, max = 64)
    @Column(name = "model")
    private String model;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "sku")
    private String sku;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "upc")
    private String upc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 14)
    @Column(name = "ean")
    private String ean;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "jan")
    private String jan;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 17)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "mpn")
    private String mpn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "location")
    private String location;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "shipping")
    private boolean shipping;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull()
    @Column(name = "price")
    private BigDecimal price;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private int points;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_available")
    @Temporal(TemporalType.DATE)
    private Date dateAvailable;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private BigDecimal weight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "length")
    private BigDecimal length;
    @Basic(optional = false)
    @NotNull
    @Column(name = "width")
    private BigDecimal width;
    @Basic(optional = false)
    @NotNull
    @Column(name = "height")
    private BigDecimal height;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtract")
    private boolean subtract;
    @Basic(optional = false)
    @NotNull
    @Column(name = "minimum")
    private int minimum;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "viewed")
    private int viewed;
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
    
    // Collections ---------------------------------------------------------------------------------------------------------------------------------
    @JoinColumn(name = "length_class_id", referencedColumnName = "length_class_id")
    @ManyToOne(optional = false)
    private TableLengthClass lengthClass;
    @JoinColumn(name = "manufacturer_id", referencedColumnName = "manufacturer_id")
    @ManyToOne(optional = false)
    private TableManufacturer manufacturer;
    @JoinColumn(name = "stock_status_id", referencedColumnName = "stock_status_id")
    @ManyToOne(optional = false)
    private TableStockStatus stockStatus;
    @JoinColumn(name = "tax_class_id", referencedColumnName = "tax_class_id")
    @ManyToOne(optional = false)
    private TableTaxClass taxClass;
    @JoinColumn(name = "weight_class_id", referencedColumnName = "weight_class_id")
    @ManyToOne(optional = false)
    private TableWeightClass weightClass;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")    
    private List<TableCart> tableCartList;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productId")
    private List<TableCouponProduct> tableCouponProductList;
    
    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "table_product_to_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id")
    )
    private List<TableCategory> categoryList = new ArrayList<>();
    
    // Constructors ---------------------------------------------------------------------------------------------------------------------------------
    public TableProduct() {
    }

    public TableProduct(Integer productId) {
        this.productId = productId;
    }

    public TableProduct(Integer productId, String name, String description, String tag, String metaTitle, String metaDescription, String metaKeyword, String model, String sku, String upc, String ean, String jan, String isbn, String mpn, String location, int quantity, boolean shipping, BigDecimal price, int points, Date dateAvailable, BigDecimal weight, BigDecimal length, BigDecimal width, BigDecimal height, boolean subtract, int minimum, int sortOrder, boolean status, int viewed, Date dateAdded, Date dateModified) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.tag = tag;
        this.metaTitle = metaTitle;
        this.metaDescription = metaDescription;
        this.metaKeyword = metaKeyword;
        this.model = model;
        this.sku = sku;
        this.upc = upc;
        this.ean = ean;
        this.jan = jan;
        this.isbn = isbn;
        this.mpn = mpn;
        this.location = location;
        this.quantity = quantity;
        this.shipping = shipping;
        this.price = price;
        this.points = points;
        this.dateAvailable = dateAvailable;
        this.weight = weight;
        this.length = length;
        this.width = width;
        this.height = height;
        this.subtract = subtract;
        this.minimum = minimum;
        this.sortOrder = sortOrder;
        this.status = status;
        this.viewed = viewed;
        this.dateAdded = dateAdded;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return productId;
    }

    @Override
    public void setId(Integer productId) {
        this.productId = productId;
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


    public Date getDateAvailable() {
        return dateAvailable;
    }

    public void setDateAvailable(Date dateAvailable) {
        this.dateAvailable = dateAvailable;
    }


    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
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


    public TableLengthClass getLengthClass() {
        return lengthClass;
    }

    public void setLengthClass(TableLengthClass lengthClassId) {
        this.lengthClass = lengthClassId;
    }

    public TableManufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(TableManufacturer manufacturerId) {
        this.manufacturer = manufacturerId;
    }

    public TableStockStatus getStockStatus() {
        return stockStatus;
    }

    public void setStockStatus(TableStockStatus stockStatus) {
        this.stockStatus = stockStatus;
    }

    public TableTaxClass getTaxClass() {
        return taxClass;
    }

    public void setTaxClass(TableTaxClass taxClass) {
        this.taxClass = taxClass;
    }

    public TableWeightClass getWeightClass() {
        return weightClass;
    }

    public void setWeightClass(TableWeightClass weightClass) {
        this.weightClass = weightClass;
    }

    @XmlTransient
    public List<TableCart> getTableCartList() {
        return tableCartList;
    }

    public void setTableCartList(List<TableCart> tableCartList) {
        this.tableCartList = tableCartList;
    }

    @XmlTransient
    public List<TableCouponProduct> getTableCouponProductList() {
        return tableCouponProductList;
    }

    public void setTableCouponProductList(List<TableCouponProduct> tableCouponProductList) {
        this.tableCouponProductList = tableCouponProductList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }
  

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getUpc() {
        return upc;
    }

    public void setUpc(String upc) {
        this.upc = upc;
    }

    public String getEan() {
        return ean;
    }

    public void setEan(String ean) {
        this.ean = ean;
    }
    
    public String getJan() {
        return jan;
    }

    public void setJan(String jan) {
        this.jan = jan;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getMpn() {
        return mpn;
    }

    public void setMpn(String mpn) {
        this.mpn = mpn;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean getShipping() {
        return shipping;
    }

    public void setShipping(boolean shipping) {
        this.shipping = shipping;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
   

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public boolean getSubtract() {
        return subtract;
    }

    public void setSubtract(boolean subtract) {
        this.subtract = subtract;
    }

    public int getMinimum() {
        return minimum;
    }

    public void setMinimum(int minimum) {
        this.minimum = minimum;
    }   

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }

    public List<TableCategory> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<TableCategory> categoryList) {
        this.categoryList = categoryList;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableProduct)) {
            return false;
        }
        TableProduct other = (TableProduct) object;
        if ((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableProduct[ product=" + productId + " ]";
    }
    
}
