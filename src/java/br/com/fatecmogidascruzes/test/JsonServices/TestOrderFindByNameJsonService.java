/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test.JsonServices;

import br.com.fatecmogidascruzes.controle.web.command.IComando;
import br.com.fatecmogidascruzes.controle.web.command.impl.CreateCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.DeleteCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindAllCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindByColumn;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindByPageCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByIdCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByNameCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.UpdateCommand;
import br.com.fatecmogidascruzes.controle.web.json.IJsonService;
import br.com.fatecmogidascruzes.controle.web.json.impl.CartJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.CustomerJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.LogradouroJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.OrderJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.ProductJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.UserJson;
import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableCart;
import br.com.fatecmogidascruzes.domain.impl.TableOrder;
import br.com.fatecmogidascruzes.security.service.JWTUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Josias Wattrelos
 */
public class TestOrderFindByNameJsonService {
    
    public static void main(String[] args) throws JsonProcessingException {
        

        TableOrder order = new TableOrder();
        order.setName("Vitoria");        
        IComando command = new FindOneByNameCommand(); 
        Resultado resultado = command.execute(order);        
        List<TableOrder> orderList = (List<TableOrder>) (List<?>) resultado.getEntidades();
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
        String jsonString = mapper.writeValueAsString(orderList);
        System.out.println(jsonString);
    }
    
}
