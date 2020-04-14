/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.Logradouro;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class AddressViewHelper implements IViewHelper {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableAddress address = new TableAddress();
        switch(request.getParameter("rca").charAt(1)){
            case 'U':
                address.setId(Integer.parseInt(request.getParameter("addressId")));                
                // Atulaização (update) além do ID precisa dos dados abaixo (não incluir break):
            case 'C': // Se a rota for para criar (create) endereço (Address): 
                address.setLogradouro(new Logradouro(Integer.parseInt(request.getParameter("postcode"))));
                address.setHouseNumbering(request.getParameter("houseNumbering"));
                address.setComplements(request.getParameter("complements"));                
                address.setCustomer(new TableCustomer(Integer.parseInt(request.getParameter("customerId")))); // obrigatório para update e create 
            break;
            case 'D': // Excluir (DELETE)
            case 'I': // FindById(READ)
                address.setId(Integer.parseInt(request.getParameter("addressId")));
                break;
            default:
                address.setId(1);
        }        
        return address;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {       
        
        List<TableAddress> address = (List<TableAddress>)(List<?>) resultado.getEntidades();
        switch(request.getParameter("rca").charAt(3)){            
            case 'L': // // Se a rota for para mortar um alista (list.jsp)
                request.setAttribute("addressList", address);
                break;                
            case 'U': // Retorna um endereço para atualização (update)
            case 'E': // Retorna um endereço para confircar exlcusão (DELETE)
            case 'D': // Se a rota for para mostrar detalhe (detail.jsp)
                request.setAttribute("address", address.get(0));
                break;
            default:
        }
        
    }
}
