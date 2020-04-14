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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "logradouro")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Logradouro.findAll", query = "SELECT l FROM Logradouro l"),
    @NamedQuery(name = "Logradouro.findById", query = "SELECT l FROM Logradouro l WHERE l.postcode = :id"),
    @NamedQuery(name = "Logradouro.findByPostCode", query = "SELECT l FROM Logradouro l WHERE l.postcode = :postcode"),
    @NamedQuery(name = "Logradouro.findByLogradouro", query = "SELECT l FROM Logradouro l WHERE l.logradouro = :logradouro"),
    @NamedQuery(name = "Logradouro.findByTipoLogradouro", query = "SELECT l FROM Logradouro l WHERE l.tipoLogradouro = :tipoLogradouro"),
    @NamedQuery(name = "Logradouro.findByComplemento", query = "SELECT l FROM Logradouro l WHERE l.complemento = :complemento"),
    @NamedQuery(name = "Logradouro.findByLocal", query = "SELECT l FROM Logradouro l WHERE l.local = :local")})
public class Logradouro extends EntidadeDominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "postcode")
    private Integer postcode;
    @Column(name = "logradouro", length = 120)
    private String logradouro;
    @Column(name = "tipo_logradouro", length = 80)
    private String tipoLogradouro;
    @Column(name = "complemento", length = 100)
    private String complemento;
    @Column(name = "local", length = 100)
    private String local;
    // Coleções -------------------
    @ManyToOne
    @JoinColumn(name="id_bairro")
    private Bairro bairro;

    public Logradouro() {
    }
    
    public Logradouro(String logradouro) {
    }

    public Logradouro(Integer cep) {
        this.postcode = cep;
    }
    
    public Logradouro(Integer cep, String tipoLogradouro, String logradouro, String complemento, String local, Bairro bairro) {
        this.postcode = cep;
        this.tipoLogradouro = tipoLogradouro;
        this.logradouro = logradouro;
        this.complemento = complemento;
        this.local = local;
        this.bairro = bairro;
    }

    @Override
    public Integer getId() {
        return postcode;
    }
    
    
    @Override
    public void setId(Integer cep) {
        this.postcode = cep;
    }    
    
    @Override
    public String getName() {
        return logradouro;
    }
    
    public void setName(String logradouro) {
        this.logradouro = logradouro;
    }
        
    public Integer getPostcode() {
        return postcode;
    }    

    public void setPostcode(Integer cep) {
        this.postcode = cep;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getTipoLogradouro() {
        return tipoLogradouro;
    }

    public void setTipoLogradouro(String tipoLogradouro) {
        this.tipoLogradouro = tipoLogradouro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Bairro getBairro() {
		return bairro;
	}

	public void setBairro(Bairro bairro) {
		this.bairro = bairro;
	}

	@Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Logradouro)) {
            return false;
        }
        Logradouro other = (Logradouro) object;
        if ((this.postcode == null && other.postcode != null) || (this.postcode != null && !this.postcode.equals(other.postcode))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Logradouro{" + "postcode=" + postcode + ", logradouro=" + logradouro + ", tipoLogradouro=" + tipoLogradouro + ", complemento=" + complemento + ", local=" + local + ", bairro=" + bairro + '}';
    }
    
    
    public String toJson() {
        return "{\"postcode\":\"" + postcode + 
                "\",\"logradouro\":\"" + logradouro + 
                "\",\"tipoLogradouro\":\"" + tipoLogradouro + 
                "\",\"complemento\":\"" + complemento + 
                "\",\"local\":\"" + local + 
                "\",\"bairro\":" + bairro.toJson() + "}";
    }

   
    
}
