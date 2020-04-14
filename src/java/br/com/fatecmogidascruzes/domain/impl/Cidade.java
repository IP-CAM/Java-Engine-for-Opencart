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
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "cidade")
public class Cidade extends EntidadeDominio implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @Column(name = "id_cidade")
    private Integer idCidade;
    
    @Column(name = "cidade", length = 100)
    private String cidade;
    
    @Column(name = "uf", length = 2)
    private String uf;
    
    @Basic(optional = false)
    @Column(name = "cod_ibge", length = 10)
    private String codIbge;
    
    @Basic(optional = false)
    @Column(name = "area")
    private float area;
    
    @Column(name = "id_municipio_subordinado")
    private Integer idMunicipioSubordinado;
    // Coleções ---------------------------------------------------------
    @JoinColumns({
        @JoinColumn(name = "uf", referencedColumnName = "uf", insertable=false, updatable=false)})
    @ManyToOne(optional = false)
    private Estado estado;

    public Cidade() {
    	
    }

    public Cidade(Integer idCidade) {
        this.idCidade = idCidade;
    }

    public Cidade(Integer idCidade, String codIbge, float area) {
        this.idCidade = idCidade;
        this.codIbge = codIbge;
        this.area = area;
    }
    
    @Override
      public Integer getId() {
        return idCidade;
    }
      
    @Override
    public void setId(Integer id) {
        this.idCidade = id;
    }

    @Override
    public String getName() {
        return cidade;
    }

    public void setName(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCodIbge() {
        return codIbge;
    }

    public void setCodIbge(String codIbge) {
        this.codIbge = codIbge;
    }

    public float getArea() {
        return area;
    }

    public void setArea(float area) {
        this.area = area;
    }

    public Integer getIdMunicipioSubordinado() {
        return idMunicipioSubordinado;
    }

    public void setIdMunicipioSubordinado(Integer idMunicipioSubordinado) {
        this.idMunicipioSubordinado = idMunicipioSubordinado;
    }

    public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
    public int hashCode() {
        int hash = 0;
        hash += (idCidade != null ? idCidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cidade)) {
            return false;
        }
        Cidade other = (Cidade) object;
        if ((this.idCidade == null && other.idCidade != null) || (this.idCidade != null && !this.idCidade.equals(other.idCidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cidade{" + "idCidade=" + idCidade + ", cidade=" + cidade + ", uf=" + uf +
                ", codIbge=" + codIbge +
                ", area=" + area +
                ", idMunicipioSubordinado=" + idMunicipioSubordinado +
                ", estado=" + estado + '}';
    }
    
     public String toJson() {
        return "{\"idCidade\":\"" + idCidade +
                "\",\"cidade\":\"" + cidade +
                "\",\"uf\":\"" + uf +
                "\",\"codIbge\":\"" + codIbge +
                "\",\"area\":\"" + area +
                "\",\"idMunicipioSubordinado\":\"" + idMunicipioSubordinado +
                "\",\"estado\":" + estado.toJson() + "}";
    }

  
    
}
