/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.AbstractDAO;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;

/**
 *
 * @author Josias Wattrelos
 */
public class TestAddressFindById {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractDAO addressDAO = new AbstractDAO(new TableAddress());        
        EntidadeDominio entidadeDominio = addressDAO.findOneById(26);        
        TableAddress tableAddress = (TableAddress) entidadeDominio;
        System.out.println("CEP:" + tableAddress.getLogradouro().getPostcode());
        System.out.println("Endereço:" + tableAddress.getLogradouro().getTipoLogradouro() + " " + tableAddress.getLogradouro().getLogradouro());
        System.out.println("Número:" + tableAddress.getHouseNumbering());
        System.out.println("Bairro:" + tableAddress.getLogradouro().getBairro().getName());
        System.out.println("Cidade:" + tableAddress.getLogradouro().getBairro().getCidade().getName());
        System.out.println("Estado:" + tableAddress.getLogradouro().getBairro().getCidade().getEstado().getName());        
    }
}
