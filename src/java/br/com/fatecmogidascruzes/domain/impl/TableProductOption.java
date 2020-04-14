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
import javax.persistence.Lob;
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
@Table(name = "table_product_option")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableProductOption.findAll", query = "SELECT t FROM TableProductOption t"),
    @NamedQuery(name = "TableProductOption.findByProductOptionId", query = "SELECT t FROM TableProductOption t WHERE t.productOptionId = :productOptionId"),
    @NamedQuery(name = "TableProductOption.findByProductId", query = "SELECT t FROM TableProductOption t WHERE t.productId = :productId"),
    @NamedQuery(name = "TableProductOption.findByOptionId", query = "SELECT t FROM TableProductOption t WHERE t.optionId = :optionId"),
    @NamedQuery(name = "TableProductOption.findByRequired", query = "SELECT t FROM TableProductOption t WHERE t.required = :required")})
public class TableProductOption extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "product_option_id")
    private Integer productOptionId;
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
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "value")
    private String value;
    @Basic(optional = false)
    @NotNull
    @Column(name = "required")
    private boolean required;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productOption")
    private List<TableOrderOption> tableOrderOptionList;

    public TableProductOption() {
    }

    public TableProductOption(Integer productOptionId) {
        this.productOptionId = productOptionId;
    }

    public TableProductOption(Integer productOptionId, int productId, int optionId, String value, boolean required) {
        this.productOptionId = productOptionId;
        this.productId = productId;
        this.optionId = optionId;
        this.value = value;
        this.required = required;
    }

    @Override
    public Integer getId() {
        return productOptionId;
    }

    @Override
    public void setId(Integer productOptionId) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean getRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
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
        hash += (productOptionId != null ? productOptionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableProductOption)) {
            return false;
        }
        TableProductOption other = (TableProductOption) object;
        if ((this.productOptionId == null && other.productOptionId != null) || (this.productOptionId != null && !this.productOptionId.equals(other.productOptionId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableProductOption[ productOptionId=" + productOptionId + " ]";
    }
    
}
