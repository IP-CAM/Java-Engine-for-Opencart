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
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.security.service.JWTUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Josias Wattrelos
 */
public class TestCustomerJsonService {
    
    public static void main(String[] args) throws JsonProcessingException {
                
        IEntidade entidade = new TableCustomer(28);//vh.getEntidade(entityReq);        
        IComando command = new FindOneByIdCommand(); 
        Resultado resultado = command.execute(entidade);        
        TableCustomer customer = (TableCustomer) resultado.getEntidades().get(0);
        
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(customer);
        System.out.println(jsonString);
    }
    
}
