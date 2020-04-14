/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.impl.CustomerDAO;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;
import br.com.fatecmogidascruzes.domain.impl.TableCategory;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josias Wattrelos
 */
public class TestCustomerFindAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomerDAO locationDAO = new CustomerDAO();        
        List<EntidadeDominio> entidadeDominio = locationDAO.findAll();
        List<TableCustomer> customerList = (List<TableCustomer>)(List<?>) entidadeDominio;  
        for(TableCustomer customer : customerList){
            System.out.println("\033[47mId: " + customer.getId()); 
            System.out.println("\033[47mNome completo: " + customer.getFullName()); 
            System.out.println("\033[47mApelido: " + customer.getUsername()); 
            for(TableAddress address : customer.getAddressList()){
                System.out.println("Endereço: " + address.getLogradouro().getTipoLogradouro() + " " + address.getLogradouro().getLogradouro()); 

            }           
        }
    }    
}
