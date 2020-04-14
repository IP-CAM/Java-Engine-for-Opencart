/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.core.impl.controle.Fachada;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;

/**
 *
 * @author Josias Wattrelos
 */
public class TestAddressFindById_Fachada {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Fachada facade = new Fachada();        
        TableAddress address1 = new TableAddress(27);
        Resultado resultado = facade.findOneById(address1);        
        TableAddress address = (TableAddress) resultado.getEntidades().get(0);
        System.out.println("CEP:" + address.getLogradouro().getPostcode());
        System.out.println("Endereço:" + address.getLogradouro().getTipoLogradouro() + " " + address.getLogradouro().getLogradouro());
        System.out.println("Número:" + address.getHouseNumbering());
        System.out.println("Bairro:" + address.getLogradouro().getBairro().getName());
        System.out.println("Cidade:" + address.getLogradouro().getBairro().getCidade().getName());
        System.out.println("Estado:" + address.getLogradouro().getBairro().getCidade().getEstado().getName());        
    }
}
