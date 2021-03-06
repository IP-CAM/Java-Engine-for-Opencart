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
import javax.persistence.Table;

/**
 *
 * @author Josias Wattrelos
 */
@Entity
@Table(name = "bairro")
public class Bairro extends EntidadeDominio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_bairro")
    private Integer idBairro;

    @Column(name = "bairro", length = 80)
    private String bairro;

    @ManyToOne
    @JoinColumn(name = "id_cidade")
    private Cidade cidade;

    // Constructors ------------------------------------------------------------------------------------------------------------------
    public Bairro() {
    }

    public Bairro(Integer idBairro) {
        this.idBairro = idBairro;
    }

    // Setters and Getters -----------------------------------------------------------------------------------------------------------
    @Override
    public Integer getId() {
        return idBairro;
    }

    @Override
    public void setId(Integer idBairro) {
        this.idBairro = idBairro;
    }

    public String getName() {
        return bairro;
    }

    public void setName(String bairro) {
        this.bairro = bairro;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBairro != null ? idBairro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bairro)) {
            return false;
        }
        Bairro other = (Bairro) object;
        if ((this.idBairro == null && other.idBairro != null) || (this.idBairro != null && !this.idBairro.equals(other.idBairro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Bairro{" + "idBairro=" + idBairro + ", bairro=" + bairro + ", cidade=" + cidade + '}';
    }

    public String toJson() {
        return "{\"idBairro\":\"" + idBairro
                + "\",\"bairro\":\"" + bairro
                + "\",\"cidade\":" + cidade.toJson() + "}";
    }

}
