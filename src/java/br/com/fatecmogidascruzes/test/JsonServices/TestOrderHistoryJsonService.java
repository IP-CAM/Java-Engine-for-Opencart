/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test.JsonServices;

import br.com.fatecmogidascruzes.controle.web.command.IComando;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindAllCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByIdCommand;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.impl.TableOrderHistory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

/**
 *
 * @author Josias Wattrelos
 */
public class TestOrderHistoryJsonService {
    
    public static void main(String[] args) throws JsonProcessingException {
                
               
        IComando command = new FindAllCommand(); 
        Resultado resultado = command.execute(new TableOrderHistory()); 
        
        List<TableOrderHistory> orderHistoryList = (List<TableOrderHistory>) (List<?>) resultado.getEntidades();
        /*
        System.out.println("CEP:" + cart.getLogradouro().getPostcode());
        System.out.println("Endereço:" + cart.getLogradouro().getTipoLogradouro() + " " + cart.getLogradouro().getLogradouro());
        System.out.println("Número:" + cart.getHouseNumbering());
        System.out.println("Bairro:" + cart.getLogradouro().getBairro().getBairro());
        System.out.println("Cidade:" + cart.getLogradouro().getBairro().getCidade().getCidade());
        System.out.println("Estado:" + cart.getLogradouro().getBairro().getCidade().getEstado().getEstado()); 
        */
        
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(orderHistoryList);
        
        
        System.out.println(jsonString);
    }
    
}
