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
@Table(name = "table_tax_rule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableTaxRule.findAll", query = "SELECT t FROM TableTaxRule t"),
    @NamedQuery(name = "TableTaxRule.findByTaxRuleId", query = "SELECT t FROM TableTaxRule t WHERE t.taxRuleId = :taxRuleId"),
    @NamedQuery(name = "TableTaxRule.findByTaxClassId", query = "SELECT t FROM TableTaxRule t WHERE t.taxClassId = :taxClassId"),
    @NamedQuery(name = "TableTaxRule.findByTaxRateId", query = "SELECT t FROM TableTaxRule t WHERE t.taxRateId = :taxRateId"),
    @NamedQuery(name = "TableTaxRule.findByBased", query = "SELECT t FROM TableTaxRule t WHERE t.based = :based"),
    @NamedQuery(name = "TableTaxRule.findByPriority", query = "SELECT t FROM TableTaxRule t WHERE t.priority = :priority")})
public class TableTaxRule extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tax_rule_id")
    private Integer taxRuleId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax_class_id")
    private int taxClassId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tax_rate_id")
    private int taxRateId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "based")
    private String based;
    @Basic(optional = false)
    @NotNull
    @Column(name = "priority")
    private int priority;

    public TableTaxRule() {
    }

    public TableTaxRule(Integer taxRuleId) {
        this.taxRuleId = taxRuleId;
    }

    public TableTaxRule(Integer taxRuleId, int taxClassId, int taxRateId, String based, int priority) {
        this.taxRuleId = taxRuleId;
        this.taxClassId = taxClassId;
        this.taxRateId = taxRateId;
        this.based = based;
        this.priority = priority;
    }

    @Override
    public Integer getId() {
        return taxRuleId;
    }

    @Override
    public void setId(Integer taxRuleId) {
        this.taxRuleId = taxRuleId;
    }

    public int getTaxClassId() {
        return taxClassId;
    }

    public void setTaxClassId(int taxClassId) {
        this.taxClassId = taxClassId;
    }

    public int getTaxRateId() {
        return taxRateId;
    }

    public void setTaxRateId(int taxRateId) {
        this.taxRateId = taxRateId;
    }

    public String getBased() {
        return based;
    }

    public void setBased(String based) {
        this.based = based;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxRuleId != null ? taxRuleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableTaxRule)) {
            return false;
        }
        TableTaxRule other = (TableTaxRule) object;
        if ((this.taxRuleId == null && other.taxRuleId != null) || (this.taxRuleId != null && !this.taxRuleId.equals(other.taxRuleId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableTaxRule[ taxRuleId=" + taxRuleId + " ]";
    }
    
}
