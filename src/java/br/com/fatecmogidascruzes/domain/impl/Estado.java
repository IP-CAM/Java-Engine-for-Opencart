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
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "estado")
public class Estado extends EntidadeDominio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "cod_ibge")
    private int codIbge;    
    
    @Basic(optional = false)
    @Column(name = "uf", length = 2)
    private String uf;
    
    @Basic(optional = false)
    @Column(name = "estado", length = 70)
    private String estado;

    public Estado() {
    }

    public Estado(String uf) {
        this.uf = uf;
    }

    public Estado(String uf, String estado, int codIbge) {
        this.uf = uf;
        this.estado = estado;
        this.codIbge = codIbge;
    }

    @Override
    public Integer getId() {
        return codIbge;
    }

    @Override
    public void setId(Integer codIbge) {
        this.codIbge = codIbge;
    }
            
    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    @Override
    public String getName() {
        return estado;
    }

    public void setName(String estado) {
        this.estado = estado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (uf != null ? uf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estado)) {
            return false;
        }
        Estado other = (Estado) object;
        if ((this.uf == null && other.uf != null) || (this.uf != null && !this.uf.equals(other.uf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Estado{" + "codIbge=" + codIbge + ", uf=" + uf + ", estado=" + estado + '}';
    }
    
    public String toJson() {
        return "{\"codIbge=\":\"" + codIbge +
               "\",\"uf=\":\"" + uf +
               "\",\"estado=\":\"" + estado + "\"}";
    }

  
    
}
