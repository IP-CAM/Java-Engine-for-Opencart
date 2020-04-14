/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.domain.impl;

import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "table_upload")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TableUpload.findAll", query = "SELECT t FROM TableUpload t"),
    @NamedQuery(name = "TableUpload.findByUploadId", query = "SELECT t FROM TableUpload t WHERE t.uploadId = :uploadId"),
    @NamedQuery(name = "TableUpload.findByName", query = "SELECT t FROM TableUpload t WHERE t.name = :name"),
    @NamedQuery(name = "TableUpload.findByFilename", query = "SELECT t FROM TableUpload t WHERE t.filename = :filename"),
    @NamedQuery(name = "TableUpload.findByCode", query = "SELECT t FROM TableUpload t WHERE t.code = :code"),
    @NamedQuery(name = "TableUpload.findByDateAdded", query = "SELECT t FROM TableUpload t WHERE t.dateAdded = :dateAdded")})
public class TableUpload extends EntidadeDominio implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "upload_id")
    private Integer uploadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "filename")
    private String filename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_added")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateAdded;

    public TableUpload() {
    }

    public TableUpload(Integer uploadId) {
        this.uploadId = uploadId;
    }

    public TableUpload(Integer uploadId, String name, String filename, String code, Date dateAdded) {
        this.uploadId = uploadId;
        this.name = name;
        this.filename = filename;
        this.code = code;
        this.dateAdded = dateAdded;
    }

    @Override
    public Integer getId() {
        return uploadId;
    }

    @Override
    public void setId(Integer uploadId) {
        this.uploadId = uploadId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uploadId != null ? uploadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TableUpload)) {
            return false;
        }
        TableUpload other = (TableUpload) object;
        if ((this.uploadId == null && other.uploadId != null) || (this.uploadId != null && !this.uploadId.equals(other.uploadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.fatecmogidascruzes.domain.impl.TableUpload[ uploadId=" + uploadId + " ]";
    }
    
}
