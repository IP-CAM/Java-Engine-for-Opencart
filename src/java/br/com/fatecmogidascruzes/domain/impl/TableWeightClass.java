/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "table_weight_class")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableWeightClass.findAll", query = "SELECT t FROM TableWeightClass t"),
    @NamedQuery(name = "TableWeightClass.findById", query = "SELECT t FROM TableWeightClass t WHERE t.weightClassId = :id"),
    @NamedQuery(name = "TableWeightClass.findByTitle", query = "SELECT t FROM TableWeightClass t WHERE t.title = :title"),
    @NamedQuery(name = "TableWeightClass.findByUnit", query = "SELECT t FROM TableWeightClass t WHERE t.unit = :unit"),
    @NamedQuery(name = "TableWeightClass.findByValue", query = "SELECT t FROM TableWeightClass t WHERE t.value = :value")})
public class TableWeightClass extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "weight_class_id")
    private Integer weightClassId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "title")
    private String title;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "unit")
    private String unit;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private BigDecimal value;  

    // Constructors ---------------------------------------------------------------------------------------------------------------------------------
    public TableWeightClass() {
    }

    public TableWeightClass(Integer weightClassId) {
        this.weightClassId = weightClassId;
    }

    public TableWeightClass(Integer weightClassId, String title, String unit, BigDecimal value) {
        this.weightClassId = weightClassId;
        this.title = title;
        this.unit = unit;
        this.value = value;
    }

    @Override
    public Integer getId() {
        return weightClassId;
    }

    @Override
    public void setId(Integer weightClassId) {
        this.weightClassId = weightClassId;
    }
     
    @Override
    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (weightClassId != null ? weightClassId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableWeightClass)) {
            return false;
        }
        TableWeightClass other = (TableWeightClass) object;
        if ((this.weightClassId == null && other.weightClassId != null) || (this.weightClassId != null && !this.weightClassId.equals(other.weightClassId))) {
            return false;
        }
        return true;
    }   
}
