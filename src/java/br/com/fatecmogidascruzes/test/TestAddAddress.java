/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.AbstractDAO;
import br.com.fatecmogidascruzes.domain.impl.Logradouro;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Josias Wattrelos
 */
public class TestAddAddress {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) { 
                
        TableCustomer customer = new TableCustomer(1);
        

        Logradouro logradouro = new Logradouro(6412110);
        // Endereço:
        TableAddress address = new TableAddress();
        List<TableAddress> addressList = new ArrayList<>();                
        address.setLogradouro(logradouro);
        address.setHouseNumbering("123");
        address.setComplements("casa 1");                
        address.setCustomer(customer);
        addressList.add(address);

        customer.setAddressList(addressList);
        System.out.println("Customer Name=" + customer.getFullName() +
                "\nCustomer email=" + customer.getEmail() +
                "\nCustomer Phone=" + customer.getTelephone() +
                "\nCustomer username=" + customer.getUsername()
        );

        AbstractDAO addressDAO = new AbstractDAO(address);
        addressDAO.create(address);                
    }
}
