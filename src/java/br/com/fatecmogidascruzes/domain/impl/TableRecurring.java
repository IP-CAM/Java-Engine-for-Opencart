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
@Table(name = "table_recurring")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableRecurring.findAll", query = "SELECT t FROM TableRecurring t"),
    @NamedQuery(name = "TableRecurring.findByRecurringId", query = "SELECT t FROM TableRecurring t WHERE t.recurringId = :recurringId"),
    @NamedQuery(name = "TableRecurring.findByPrice", query = "SELECT t FROM TableRecurring t WHERE t.price = :price"),
    @NamedQuery(name = "TableRecurring.findByFrequency", query = "SELECT t FROM TableRecurring t WHERE t.frequency = :frequency"),
    @NamedQuery(name = "TableRecurring.findByDuration", query = "SELECT t FROM TableRecurring t WHERE t.duration = :duration"),
    @NamedQuery(name = "TableRecurring.findByCycle", query = "SELECT t FROM TableRecurring t WHERE t.cycle = :cycle"),
    @NamedQuery(name = "TableRecurring.findByTrialStatus", query = "SELECT t FROM TableRecurring t WHERE t.trialStatus = :trialStatus"),
    @NamedQuery(name = "TableRecurring.findByTrialPrice", query = "SELECT t FROM TableRecurring t WHERE t.trialPrice = :trialPrice"),
    @NamedQuery(name = "TableRecurring.findByTrialFrequency", query = "SELECT t FROM TableRecurring t WHERE t.trialFrequency = :trialFrequency"),
    @NamedQuery(name = "TableRecurring.findByTrialDuration", query = "SELECT t FROM TableRecurring t WHERE t.trialDuration = :trialDuration"),
    @NamedQuery(name = "TableRecurring.findByTrialCycle", query = "SELECT t FROM TableRecurring t WHERE t.trialCycle = :trialCycle"),
    @NamedQuery(name = "TableRecurring.findByStatus", query = "SELECT t FROM TableRecurring t WHERE t.status = :status"),
    @NamedQuery(name = "TableRecurring.findBySortOrder", query = "SELECT t FROM TableRecurring t WHERE t.sortOrder = :sortOrder")})
public class TableRecurring extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recurring_id")
    private Integer recurringId;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
        
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private BigDecimal price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "frequency")
    private String frequency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "duration")
    private int duration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cycle")
    private int cycle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trial_status")
    private short trialStatus;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trial_price")
    private BigDecimal trialPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "trial_frequency")
    private String trialFrequency;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trial_duration")
    private int trialDuration;
    @Basic(optional = false)
    @NotNull
    @Column(name = "trial_cycle")
    private int trialCycle;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private short status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;
    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recurring")
    private List<TableCart> tableCartList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recurring")
    private List<TableOrderRecurring> tableOrderRecurringList;

    public TableRecurring() {
    }

    public TableRecurring(Integer recurringId) {
        this.recurringId = recurringId;
    }

    public TableRecurring(Integer recurringId, String name, BigDecimal price, String frequency, int duration, int cycle, short trialStatus, BigDecimal trialPrice, String trialFrequency, int trialDuration, int trialCycle, short status, int sortOrder) {
        this.recurringId = recurringId;
        this.name = name;
        this.price = price;
        this.frequency = frequency;
        this.duration = duration;
        this.cycle = cycle;
        this.trialStatus = trialStatus;
        this.trialPrice = trialPrice;
        this.trialFrequency = trialFrequency;
        this.trialDuration = trialDuration;
        this.trialCycle = trialCycle;
        this.status = status;
        this.sortOrder = sortOrder;
    }

    @Override
    public Integer getId() {
        return recurringId;
    }

    @Override
    public void setId(Integer recurringId) {
        this.recurringId = recurringId;
    }

    public Integer getRecurringId() {
        return recurringId;
    }

    public void setRecurringId(Integer recurringId) {
        this.recurringId = recurringId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    public short getTrialStatus() {
        return trialStatus;
    }

    public void setTrialStatus(short trialStatus) {
        this.trialStatus = trialStatus;
    }

    public BigDecimal getTrialPrice() {
        return trialPrice;
    }

    public void setTrialPrice(BigDecimal trialPrice) {
        this.trialPrice = trialPrice;
    }

    public String getTrialFrequency() {
        return trialFrequency;
    }

    public void setTrialFrequency(String trialFrequency) {
        this.trialFrequency = trialFrequency;
    }

    public int getTrialDuration() {
        return trialDuration;
    }

    public void setTrialDuration(int trialDuration) {
        this.trialDuration = trialDuration;
    }

    public int getTrialCycle() {
        return trialCycle;
    }

    public void setTrialCycle(int trialCycle) {
        this.trialCycle = trialCycle;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @XmlTransient
    public List<TableCart> getTableCartList() {
        return tableCartList;
    }

    public void setTableCartList(List<TableCart> tableCartList) {
        this.tableCartList = tableCartList;
    }

    @XmlTransient
    public List<TableOrderRecurring> getTableOrderRecurringList() {
        return tableOrderRecurringList;
    }

    public void setTableOrderRecurringList(List<TableOrderRecurring> tableOrderRecurringList) {
        this.tableOrderRecurringList = tableOrderRecurringList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recurringId != null ? recurringId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableRecurring)) {
            return false;
        }
        TableRecurring other = (TableRecurring) object;
        if ((this.recurringId == null && other.recurringId != null) || (this.recurringId != null && !this.recurringId.equals(other.recurringId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableRecurring[ recurringId=" + recurringId + " ]";
    }
    
}
