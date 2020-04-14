/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "table_product_option_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableProductOptionValue.findAll", query = "SELECT t FROM TableProductOptionValue t"),
    @NamedQuery(name = "TableProductOptionValue.findByProductOptionValueId", query = "SELECT t FROM TableProductOptionValue t WHERE t.productOptionValueId = :productOptionValueId"),
    @NamedQuery(name = "TableProductOptionValue.findByProductOptionId", query = "SELECT t FROM TableProductOptionValue t WHERE t.productOptionId = :productOptionId"),
    @NamedQuery(name = "TableProductOptionValue.findByProductId", query = "SELECT t FROM TableProductOptionValue t WHERE t.productId = :productId"),
    @NamedQuery(name = "TableProductOptionValue.findByOptionId", query = "SELECT t FROM TableProductOptionValue t WHERE t.optionId = :optionId"),
    @NamedQuery(name = "TableProductOptionValue.findByOptionValueId", query = "SELECT t FROM TableProductOptionValue t WHERE t.optionValueId = :optionValueId"),
    @NamedQuery(name = "TableProductOptionValue.findByQuantity", query = "SELECT t FROM TableProductOptionValue t WHERE t.quantity = :quantity"),
    @NamedQuery(name = "TableProductOptionValue.findBySubtract", query = "SELECT t FROM TableProductOptionValue t WHERE t.subtract = :subtract"),
    @NamedQuery(name = "TableProductOptionValue.findByPrice", query = "SELECT t FROM TableProductOptionValue t WHERE t.price = :price"),
    @NamedQuery(name = "TableProductOptionValue.findByPricePrefix", query = "SELECT t FROM TableProductOptionValue t WHERE t.pricePrefix = :pricePrefix"),
    @NamedQuery(name = "TableProductOptionValue.findByPoints", query = "SELECT t FROM TableProductOptionValue t WHERE t.points = :points"),
    @NamedQuery(name = "TableProductOptionValue.findByPointsPrefix", query = "SELECT t FROM TableProductOptionValue t WHERE t.pointsPrefix = :pointsPrefix"),
    @NamedQuery(name = "TableProductOptionValue.findByWeight", query = "SELECT t FROM TableProductOptionValue t WHERE t.weight = :weight"),
    @NamedQuery(name = "TableProductOptionValue.findByWeightPrefix", query = "SELECT t FROM TableProductOptionValue t WHERE t.weightPrefix = :weightPrefix")})
public class TableProductOptionValue extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_option_value_id")
    private Integer productOptionValueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_option_id")
    private int productOptionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "option_id")
    private int optionId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "option_value_id")
    private int optionValueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "subtract")
    private boolean subtract;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "price_prefix")
    private String pricePrefix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "points")
    private int points;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "points_prefix")
    private String pointsPrefix;
    @Basic(optional = false)
    @NotNull
    @Column(name = "weight")
    private BigDecimal weight;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1)
    @Column(name = "weight_prefix")
    private String weightPrefix;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productOptionValue")
    private List<TableOrderOption> tableOrderOptionList;

    public TableProductOptionValue() {
    }

    public TableProductOptionValue(Integer productOptionValueId) {
        this.productOptionValueId = productOptionValueId;
    }

    public TableProductOptionValue(Integer productOptionValueId, int productOptionId, int productId, int optionId, int optionValueId, int quantity, boolean subtract, BigDecimal price, String pricePrefix, int points, String pointsPrefix, BigDecimal weight, String weightPrefix) {
        this.productOptionValueId = productOptionValueId;
        this.productOptionId = productOptionId;
        this.productId = productId;
        this.optionId = optionId;
        this.optionValueId = optionValueId;
        this.quantity = quantity;
        this.subtract = subtract;
        this.price = price;
        this.pricePrefix = pricePrefix;
        this.points = points;
        this.pointsPrefix = pointsPrefix;
        this.weight = weight;
        this.weightPrefix = weightPrefix;
    }

    @Override
    public Integer getId() {
        return productOptionValueId;
    }

    @Override
    public void setId(Integer productOptionValueId) {
        this.productOptionValueId = productOptionValueId;
    }

    public int getProductOptionId() {
        return productOptionId;
    }

    public void setProductOptionId(int productOptionId) {
        this.productOptionId = productOptionId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public int getOptionValueId() {
        return optionValueId;
    }

    public void setOptionValueId(int optionValueId) {
        this.optionValueId = optionValueId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean getSubtract() {
        return subtract;
    }

    public void setSubtract(boolean subtract) {
        this.subtract = subtract;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getPricePrefix() {
        return pricePrefix;
    }

    public void setPricePrefix(String pricePrefix) {
        this.pricePrefix = pricePrefix;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getPointsPrefix() {
        return pointsPrefix;
    }

    public void setPointsPrefix(String pointsPrefix) {
        this.pointsPrefix = pointsPrefix;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public String getWeightPrefix() {
        return weightPrefix;
    }

    public void setWeightPrefix(String weightPrefix) {
        this.weightPrefix = weightPrefix;
    }

    @XmlTransient
    public List<TableOrderOption> getTableOrderOptionList() {
        return tableOrderOptionList;
    }

    public void setTableOrderOptionList(List<TableOrderOption> tableOrderOptionList) {
        this.tableOrderOptionList = tableOrderOptionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productOptionValueId != null ? productOptionValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableProductOptionValue)) {
            return false;
        }
        TableProductOptionValue other = (TableProductOptionValue) object;
        if ((this.productOptionValueId == null && other.productOptionValueId != null) || (this.productOptionValueId != null && !this.productOptionValueId.equals(other.productOptionValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableProductOptionValue[ productOptionValueId=" + productOptionValueId + " ]";
    }
    
}
