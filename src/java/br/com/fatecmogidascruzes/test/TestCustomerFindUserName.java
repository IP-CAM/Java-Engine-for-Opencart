/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.EntityManagerProvider;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.impl.TableUser;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Josias Wattrelos
 */
public class TestCustomerFindUserName {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* CustomerDAO customerDAO = new CustomerDAO();        
        EntidadeDominio entidadeDominio = customerDAO.findOneById(2);        
        TableUser customer = (TableUser) entidadeDominio;
        */
        /*
        Session session = EntityManagerProvider.getSession();
        Query query = session.getNamedQuery("TableUser.findByUserName");
        query.setParameter("customerName", 2);
        TableUser customer = (TableUser) query.uniqueResult();
        */
        Session session = EntityManagerProvider.getSession();
        Query query = session.getNamedQuery("TableCustomer.findByUserName");
        query.setParameter("username", "JosiasWattrelos");
        TableCustomer customer = (TableCustomer) query.uniqueResult();        
        
        System.out.println("Id:" + customer.getId());
        System.out.println("Nome completo:" + customer.getFullName());
        System.out.println("Apelido:" + customer.getUsername());
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
