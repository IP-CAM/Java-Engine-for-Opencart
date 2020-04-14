/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.impl.CustomerDAO;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
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
public class TestCustomerFindAllJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CustomerDAO locationDAO = new CustomerDAO();        
        List<EntidadeDominio> entidadeDominio = locationDAO.findAll();
        List<TableCustomer> customer = (List<TableCustomer>)(List<?>) entidadeDominio;  
        
        /*
        String arrayToJson = new Gson().toJson(customer);
        System.out.println("location:" + arrayToJson);
                */
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        
        String arrayToJson = "";         
       
        try {
            arrayToJson = objectMapper.writeValueAsString(customer);
            System.out.println("Customer: " + arrayToJson);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(TestCustomerFindAllJson.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
