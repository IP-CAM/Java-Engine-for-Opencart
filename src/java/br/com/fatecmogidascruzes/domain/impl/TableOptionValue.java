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
@Table(name = "table_option_value")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableOptionValue.findAll", query = "SELECT t FROM TableOptionValue t"),
    @NamedQuery(name = "TableOptionValue.findById", query = "SELECT t FROM TableOptionValue t WHERE t.optionValueId = :id"),
    @NamedQuery(name = "TableOptionValue.findByOptionId", query = "SELECT t FROM TableOptionValue t WHERE t.optionId = :optionId"),
    @NamedQuery(name = "TableOptionValue.findByImage", query = "SELECT t FROM TableOptionValue t WHERE t.image = :image"),
    @NamedQuery(name = "TableOptionValue.findBySortOrder", query = "SELECT t FROM TableOptionValue t WHERE t.sortOrder = :sortOrder"),
    @NamedQuery(name = "TableOptionValue.findByName", query = "SELECT t FROM TableOptionValue t WHERE t.name = :name")})
public class TableOptionValue extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "option_value_id")
    private Integer optionValueId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "option_id")
    private int optionId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "name")
    private String name;

    public TableOptionValue() {
    }

    public TableOptionValue(Integer optionValueId) {
        this.optionValueId = optionValueId;
    }

    public TableOptionValue(Integer optionValueId, int optionId, String image, int sortOrder, String name) {
        this.optionValueId = optionValueId;
        this.optionId = optionId;
        this.image = image;
        this.sortOrder = sortOrder;
        this.name = name;
    }

    public Integer getId() {
        return optionValueId;
    }

    public void setId(Integer optionValueId) {
        this.optionValueId = optionValueId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (optionValueId != null ? optionValueId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableOptionValue)) {
            return false;
        }
        TableOptionValue other = (TableOptionValue) object;
        if ((this.optionValueId == null && other.optionValueId != null) || (this.optionValueId != null && !this.optionValueId.equals(other.optionValueId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableOptionValue[ optionValueId=" + optionValueId + " ]";
    }
    
}
