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
import java.util.Date;
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
@Table(name = "table_currency")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableCurrency.findAll", query = "SELECT t FROM TableCurrency t"),
    @NamedQuery(name = "TableCurrency.findById", query = "SELECT t FROM TableCurrency t WHERE t.currencyId = :id"),
    @NamedQuery(name = "TableCurrency.findByTitle", query = "SELECT t FROM TableCurrency t WHERE t.title = :title"),
    @NamedQuery(name = "TableCurrency.findByCode", query = "SELECT t FROM TableCurrency t WHERE t.code = :code"),
    @NamedQuery(name = "TableCurrency.findBySymbolLeft", query = "SELECT t FROM TableCurrency t WHERE t.symbolLeft = :symbolLeft"),
    @NamedQuery(name = "TableCurrency.findBySymbolRight", query = "SELECT t FROM TableCurrency t WHERE t.symbolRight = :symbolRight"),
    @NamedQuery(name = "TableCurrency.findByDecimalPlace", query = "SELECT t FROM TableCurrency t WHERE t.decimalPlace = :decimalPlace"),
    @NamedQuery(name = "TableCurrency.findByValue", query = "SELECT t FROM TableCurrency t WHERE t.value = :value"),
    @NamedQuery(name = "TableCurrency.findByStatus", query = "SELECT t FROM TableCurrency t WHERE t.status = :status"),
    @NamedQuery(name = "TableCurrency.findByDateModified", query = "SELECT t FROM TableCurrency t WHERE t.dateModified = :dateModified")})
public class TableCurrency extends EntidadeDominio implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "currency_id")
    private Integer currencyId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull()
    @Size(min = 1, max = 3)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "symbol_left")
    private String symbolLeft;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "symbol_right")
    private String symbolRight;
    @Basic(optional = false)
    @NotNull
    @Column(name = "decimal_place")
    private Character decimalPlace;
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private BigDecimal value;    
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_modified")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateModified;
    
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "currencyId")
    private List<TableOrder> tableOrderList;

    public TableCurrency() {
    }

    public TableCurrency(Integer currencyId) {
        this.currencyId = currencyId;
    }

    public TableCurrency(Integer currencyId, String title, String code, String symbolLeft, String symbolRight, Character decimalPlace, BigDecimal value, boolean status, Date dateModified) {
        this.currencyId = currencyId;
        this.title = title;
        this.code = code;
        this.symbolLeft = symbolLeft;
        this.symbolRight = symbolRight;
        this.decimalPlace = decimalPlace;
        this.value = value;
        this.status = status;
        this.dateModified = dateModified;
    }

    @Override
    public Integer getId() {
        return currencyId;
    }

    @Override
    public void setId(Integer currencyId) {
        this.currencyId = currencyId;
    }


    public String getSymbolLeft() {
        return symbolLeft;
    }

    public void setSymbolLeft(String symbolLeft) {
        this.symbolLeft = symbolLeft;
    }

    public String getSymbolRight() {
        return symbolRight;
    }

    public void setSymbolRight(String symbolRight) {
        this.symbolRight = symbolRight;
    }

    public Character getDecimalPlace() {
        return decimalPlace;
    }

    public void setDecimalPlace(Character decimalPlace) {
        this.decimalPlace = decimalPlace;
    }


    public Date getDateModified() {
        return dateModified;
    }

    public void setDateModified(Date dateModified) {
        this.dateModified = dateModified;
    }

    @XmlTransient
    public List<TableOrder> getTableOrderList() {
        return tableOrderList;
    }

    public void setTableOrderList(List<TableOrder> tableOrderList) {
        this.tableOrderList = tableOrderList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (currencyId != null ? currencyId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableCurrency)) {
            return false;
        }
        TableCurrency other = (TableCurrency) object;
        if ((this.currencyId == null && other.currencyId != null) || (this.currencyId != null && !this.currencyId.equals(other.currencyId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableCurrency[ currencyId=" + currencyId + " ]";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }   

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }   
    
}
