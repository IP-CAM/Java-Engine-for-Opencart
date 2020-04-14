/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.impl.CustomerDAO;
import br.com.fatecmogidascruzes.domain.impl.Logradouro;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerGroup;
import br.com.fatecmogidascruzes.domain.impl.TableUserGroup;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josias Wattrelos
 */
public class TestAddCustomer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
                
                
                TableCustomer customer = new TableCustomer();
                
                customer.setFullName("Nome completo 3");
                customer.setEmail("meuemail@empresa.com.br");
                customer.setTelephone("11 4201 0052");
                customer.setUserGroup(new TableUserGroup(1));
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date1;
                try {
                    date1 = sdf.parse("1989-05-07");
                    customer.setDateOfBirth(date1);
                } catch (ParseException ex) {
                    Logger.getLogger(TestAddCustomer.class.getName()).log(Level.SEVERE, null, ex);
                }
                  
                // Credenciais
                customer.setUsername("username");
                customer.setPassword("password");
                customer.setConfirmPassword("password");
                
                TableCustomerGroup customerGroup = new TableCustomerGroup();
                customerGroup.setId(1); // Não implementado ainda
                customer.setCustomerGroup(customerGroup);
                customer.setStatus(true);
                customer.setSafe(true);
                customer.setIp("::1");
                customer.setToken("0"); // Adicionar com BCrypt
                customer.setCode("0");
                customer.setSalt("0");
                customer.setNewsletter(false);
                customer.setDateAdded(null); // A data de criação será automaticamente criada pelo banco de dados.

                /*
                CustomerDAO customerDao = new CustomerDAO();
                customer = (TableCustomer) customerDao.create(customer);
                
                System.out.println("CustomerId= " + customer.getId());
                */
                
                // Endereço:
                TableAddress address = new TableAddress();
                
                Logradouro logradouro = new Logradouro(6412110);
                address.setLogradouro(logradouro);
                address.setHouseNumbering("54321");
                address.setComplements("casa 2");                
                address.setCustomer(customer);
                
                List<TableAddress> addressList = new ArrayList<>();                
                addressList.add(address);
                /*
                AddressDAO addressDao = new AddressDAO();                
                addressDao.create(address);
                */
                customer.setAddressList(addressList);
                CustomerDAO customerDao = new CustomerDAO();
                customer = (TableCustomer) customerDao.create(customer);
               
                
                // customer.getAddressList().add(address);
                
                // customer.setAddressList(addressList);
         
                                
            }
}
