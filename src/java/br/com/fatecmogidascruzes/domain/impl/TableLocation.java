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
@Table(name = "table_location")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableLocation.findAll", query = "SELECT t FROM TableLocation t"),
    @NamedQuery(name = "TableLocation.findByLocationId", query = "SELECT t FROM TableLocation t WHERE t.locationId = :locationId"),
    @NamedQuery(name = "TableLocation.findByName", query = "SELECT t FROM TableLocation t WHERE t.name = :name"),
    @NamedQuery(name = "TableLocation.findByTelephone", query = "SELECT t FROM TableLocation t WHERE t.telephone = :telephone"),
    @NamedQuery(name = "TableLocation.findByFax", query = "SELECT t FROM TableLocation t WHERE t.fax = :fax"),
    @NamedQuery(name = "TableLocation.findByGeocode", query = "SELECT t FROM TableLocation t WHERE t.geocode = :geocode"),
    @NamedQuery(name = "TableLocation.findByImage", query = "SELECT t FROM TableLocation t WHERE t.image = :image")})
public class TableLocation extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "location_id")
    private Integer locationId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "address")
    private String address;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "telephone")
    private String telephone;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Formato de telefone/fax inválido, deve ser xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "fax")
    private String fax;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 32)
    @Column(name = "geocode")
    private String geocode;
    @Size(max = 255)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "open")
    private String open;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comment")
    private String comment;

    public TableLocation() {
    }

    public TableLocation(Integer locationId) {
        this.locationId = locationId;
    }

    public TableLocation(Integer locationId, String name, String address, String telephone, String fax, String geocode, String open, String comment) {
        this.locationId = locationId;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
        this.fax = fax;
        this.geocode = geocode;
        this.open = open;
        this.comment = comment;
    }

    @Override
    public Integer getId() {
        return locationId;
    }

    @Override
    public void setId(Integer locationId) {
        this.locationId = locationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getGeocode() {
        return geocode;
    }

    public void setGeocode(String geocode) {
        this.geocode = geocode;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (locationId != null ? locationId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableLocation)) {
            return false;
        }
        TableLocation other = (TableLocation) object;
        if ((this.locationId == null && other.locationId != null) || (this.locationId != null && !this.locationId.equals(other.locationId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableLocation[ locationId=" + locationId + " ]";
    }
    
}
