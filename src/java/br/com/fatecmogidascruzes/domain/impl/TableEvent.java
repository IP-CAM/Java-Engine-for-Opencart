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
import javax.persistence.Lob;
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
@Table(name = "table_event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableEvent.findAll", query = "SELECT t FROM TableEvent t"),
    @NamedQuery(name = "TableEvent.findByEventId", query = "SELECT t FROM TableEvent t WHERE t.eventId = :eventId"),
    @NamedQuery(name = "TableEvent.findByCode", query = "SELECT t FROM TableEvent t WHERE t.code = :code"),
    @NamedQuery(name = "TableEvent.findByStatus", query = "SELECT t FROM TableEvent t WHERE t.status = :status"),
    @NamedQuery(name = "TableEvent.findBySortOrder", query = "SELECT t FROM TableEvent t WHERE t.sortOrder = :sortOrder")})
public class TableEvent extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "event_id")
    private Integer eventId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 64)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "trigger")
    private String trigger;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "action")
    private String action;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private boolean status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sort_order")
    private int sortOrder;

    public TableEvent() {
    }

    public TableEvent(Integer eventId) {
        this.eventId = eventId;
    }

    public TableEvent(Integer eventId, String code, String trigger, String action, boolean status, int sortOrder) {
        this.eventId = eventId;
        this.code = code;
        this.trigger = trigger;
        this.action = action;
        this.status = status;
        this.sortOrder = sortOrder;
    }

    @Override
    public Integer getId() {
        return eventId;
    }

    @Override
    public void setId(Integer eventId) {
        this.eventId = eventId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eventId != null ? eventId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableEvent)) {
            return false;
        }
        TableEvent other = (TableEvent) object;
        if ((this.eventId == null && other.eventId != null) || (this.eventId != null && !this.eventId.equals(other.eventId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableEvent[ eventId=" + eventId + " ]";
    }
    
}
