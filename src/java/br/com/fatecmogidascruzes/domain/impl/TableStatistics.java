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
@Table(name = "table_statistics")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableStatistics.findAll", query = "SELECT t FROM TableStatistics t"),
    @NamedQuery(name = "TableStatistics.findByStatisticsId", query = "SELECT t FROM TableStatistics t WHERE t.statisticsId = :statisticsId"),
    @NamedQuery(name = "TableStatistics.findByCode", query = "SELECT t FROM TableStatistics t WHERE t.code = :code"),
    @NamedQuery(name = "TableStatistics.findByValue", query = "SELECT t FROM TableStatistics t WHERE t.value = :value")})
public class TableStatistics extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "statistics_id")
    private Integer statisticsId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "code")
    private String code;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "value")
    private BigDecimal value;

    public TableStatistics() {
    }

    public TableStatistics(Integer statisticsId) {
        this.statisticsId = statisticsId;
    }

    public TableStatistics(Integer statisticsId, String code, BigDecimal value) {
        this.statisticsId = statisticsId;
        this.code = code;
        this.value = value;
    }

    @Override
    public Integer getId() {
        return statisticsId;
    }

    @Override
    public void setId(Integer statisticsId) {
        this.statisticsId = statisticsId;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (statisticsId != null ? statisticsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableStatistics)) {
            return false;
        }
        TableStatistics other = (TableStatistics) object;
        if ((this.statisticsId == null && other.statisticsId != null) || (this.statisticsId != null && !this.statisticsId.equals(other.statisticsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableStatistics[ statisticsId=" + statisticsId + " ]";
    }
    
}
