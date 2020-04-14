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
@Table(name = "table_length_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableLengthClass.findAll", query = "SELECT t FROM TableLengthClass t"),
    @NamedQuery(name = "TableLengthClass.findByLengthClassId", query = "SELECT t FROM TableLengthClass t WHERE t.lengthClassId = :lengthClassId"),
    @NamedQuery(name = "TableLengthClass.findByValue", query = "SELECT t FROM TableLengthClass t WHERE t.value = :value"),
    @NamedQuery(name = "TableLengthClass.findByTitle", query = "SELECT t FROM TableLengthClass t WHERE t.title = :title"),
    @NamedQuery(name = "TableLengthClass.findByUnit", query = "SELECT t FROM TableLengthClass t WHERE t.unit = :unit")})
public class TableLengthClass extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "length_class_id")
    private Integer lengthClassId;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private BigDecimal value;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "title")
    private String title;
    
    @Size(max = 4)
    @Column(name = "unit")
    private String unit;
    
    // Collections ---------------------------------------------------------------------------------------------------------------------------------
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "lengthClass")
    private List<TableProduct> tableProductList;

    // Constructors --------------------------------------------------------------------------------------------------------------------------------
    public TableLengthClass() {
    }

    public TableLengthClass(Integer lengthClassId) {
        this.lengthClassId = lengthClassId;
    }

    public TableLengthClass(Integer lengthClassId, BigDecimal value, String title) {
        this.lengthClassId = lengthClassId;
        this.value = value;
        this.title = title;
    }

    @Override
    public Integer getId() {
        return lengthClassId;
    }

    @Override
    public void setId(Integer lengthClassId) {
        this.lengthClassId = lengthClassId;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (lengthClassId != null ? lengthClassId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableLengthClass)) {
            return false;
        }
        TableLengthClass other = (TableLengthClass) object;
        if ((this.lengthClassId == null && other.lengthClassId != null) || (this.lengthClassId != null && !this.lengthClassId.equals(other.lengthClassId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableLengthClass[ lengthClassId=" + lengthClassId + " ]";
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @XmlTransient
    public List<TableProduct> getTableProductList() {
        return tableProductList;
    }

    public void setTableProductList(List<TableProduct> tableProductList) {
        this.tableProductList = tableProductList;
    }
    
}
