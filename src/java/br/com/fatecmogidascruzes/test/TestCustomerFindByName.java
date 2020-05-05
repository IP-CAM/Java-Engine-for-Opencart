/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.core.impl.controle.Fachada;
import br.com.fatecmogidascruzes.dao.EntityManagerProvider;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.impl.TableUser;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Josias Wattrelos
 */
public class TestCustomerFindByName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*
        Session session = EntityManagerProvider.getSession();
        Query query = session.getNamedQuery("TableCustomer.findByName");
        query.setParameter("name", "ThaisDaufouy");        
        TableCustomer customer = (TableCustomer) query.uniqueResult();        
        */
        
        TableCustomer customer2 = new TableCustomer();
        customer2.setUsername("patriciatavares");
        Fachada fachada = new Fachada();
        Resultado result = fachada.findByName(customer2);
        List<EntidadeDominio> entity = result.getEntidades();
        TableCustomer customer = (TableCustomer)entity.get(0);
        System.out.println("Nome completo:" + customer.getFullName());
        System.out.println("Email:" + customer.getEmail());
        System.out.println("Apelido:" + customer.getUsername());
        System.out.println("Group:" + customer.getUserGroup().getName());
        /*
        TableAddress address = customer.getAddressList().get(0);
                
        System.out.println("CEP:" + address.getLogradouro().getCep());
        System.out.println("Endereço:" + address.getLogradouro().getTipoLogradouro() + " " + address.getLogradouro().getLogradouro());
        System.out.println("Número:" + address.getHouseNumbering());
        System.out.println("Bairro:" + address.getLogradouro().getBairro().getBairro());
        System.out.println("Cidade:" + address.getLogradouro().getBairro().getCidade().getCidade());
        System.out.println("Estado:" + address.getLogradouro().getBairro().getCidade().getEstado().getEstado());   
         */
    }
}
