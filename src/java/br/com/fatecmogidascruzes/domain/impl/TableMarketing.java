/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import java.util.Date;
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
@Table(name = "table_marketing")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableMarketing.findAll", query = "SELECT t FROM TableMarketing t"),
    @NamedQuery(name = "TableMarketing.findByMarketingId", query = "SELECT t FROM TableMarketing t WHERE t.marketingId = :marketingId"),
    @NamedQuery(name = "TableMarketing.findByName", query = "SELECT t FROM TableMarketing t WHERE t.name = :name"),
    @NamedQuery(name = "TableMarketing.findByCode", query = "SELECT t FROM TableMarketing t WHERE t.code = :code"),
    @NamedQuery(name = "TableMarketing.findByClicks", query = "SELECT t FROM TableMarketing t WHERE t.clicks = :clicks"),
    @NamedQuery(name = "TableMarketing.findByDateAdded", query = "SELECT t FROM TableMarketing t WHERE t.dateAdded = :dateAdded")})
public class TableMarketing extends EntidadeDominio implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "clicks")
    private int clicks;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "marketing_id")
    private Integer marketingId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marketing")
    private List<TableOrder> tableOrderList;

    public TableMarketing() {
    }

    public TableMarketing(Integer marketingId) {
        this.marketingId = marketingId;
    }

    public TableMarketing(Integer marketingId, String name, String description, String code, int clicks, Date dateAdded) {
        this.marketingId = marketingId;
        this.name = name;
        this.description = description;
        this.code = code;
        this.clicks = clicks;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return marketingId;
    }

    @Override
    public void setId(Integer marketingId) {
        this.marketingId = marketingId;
    }


    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
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
        hash += (marketingId != null ? marketingId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableMarketing)) {
            return false;
        }
        TableMarketing other = (TableMarketing) object;
        if ((this.marketingId == null && other.marketingId != null) || (this.marketingId != null && !this.marketingId.equals(other.marketingId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableMarketing[ marketingId=" + marketingId + " ]";
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getClicks() {
        return clicks;
    }

    public void setClicks(int clicks) {
        this.clicks = clicks;
    }
    
}
