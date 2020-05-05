/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.EntityFactory;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.Logradouro;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Josias Wattrelos
 */
public class AddressViewHelper extends EntityFactory {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableAddress address = new TableAddress();
        switch(request.getParameter("rsa").charAt(2)){
            case 'U':
                address.setId(Integer.parseInt(request.getParameter("addressId")));                
                // Atulaização (update) além do ID precisa dos dados abaixo (não incluir break):
            case 'C': // Se a rota for para criar (create) endereço (Address): 
                address.setLogradouro(new Logradouro(Integer.parseInt(request.getParameter("postcode"))));
                address.setHouseNumbering(request.getParameter("houseNumbering"));
                address.setComplements(request.getParameter("complements"));                
                address.setCustomer(new TableCustomer(Integer.parseInt(request.getParameter("customerId")))); // obrigatório para update e create 
            break;
            case 'd': // Excluir (DELETE)
            case 'i': // FindById(READ)
                address.setId(Integer.parseInt(request.getParameter("addressId")));
                break;
            default:
                address.setId(1);
        }        
        return address;        
    }
}
