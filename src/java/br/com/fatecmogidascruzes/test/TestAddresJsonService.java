/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.controle.web.command.IComando;
import br.com.fatecmogidascruzes.controle.web.command.impl.CreateCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.DeleteCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindAllCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindByColumn;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindByPageCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByIdCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.UpdateCommand;
import br.com.fatecmogidascruzes.controle.web.json.IJsonService;
import br.com.fatecmogidascruzes.controle.web.json.impl.AddressJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.CartJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.CustomerJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.LogradouroJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.OrderJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.ProductJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.UserJson;
import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;
import br.com.fatecmogidascruzes.security.service.JWTUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Josias Wattrelos
 */
public class TestAddresJsonService {
    
    public static void main(String[] args) throws JsonProcessingException {
        // Constructors ----------------------------------------------------------------------------------------
        Map<String, IJsonService> vhs;
        Map<String, IComando> commands;
        
        IViewHelper vh;
        JWTUtil jwtUtil = new JWTUtil();
        
        /*
         * Utilizando o command para chamar a fachada e indexando cada command pela
         * operação garantimos que esta servelt atenderá qualquer operação
         */
        commands = new HashMap<String, IComando>();

        commands.put("findAll", new FindAllCommand());
        commands.put("findByPage", new FindByPageCommand());        
        commands.put("findByColumn", new FindByColumn());
        commands.put("findOneById", new FindOneByIdCommand());
        commands.put("create", new CreateCommand());
        commands.put("update", new UpdateCommand());
        commands.put("delete", new DeleteCommand());
        
        commands.put("add", new CreateCommand());
        commands.put("list", new FindAllCommand());

        /*
         * Utilizando o ViewHelper para tratar especificações de qualquer tela e
         * indexando cada viewhelper pela url em que esta servlet é chamada no form
         * garantimos que esta servelt atenderá qualquer entidade
         */
        vhs = new HashMap<String, IJsonService>();
    	
        vhs.put("Address", new AddressJson());
        vhs.put("Cart", new CartJson());
        vhs.put("Customer", new CustomerJson()); 
        vhs.put("Logradouro", new LogradouroJson());  
        vhs.put("Order", new OrderJson());
        vhs.put("Product", new ProductJson());
        vhs.put("User", new UserJson());
        //  vhs.put("status", new StatusJson());
        //  vhs.put("usuario", new UsuarioJson());
        //vhs.put("vitrine", new VitrineJson());
        
        // Constructors ----------------------------------------------------------------------------------------
        
        
        String entityReq = "Address";
        String action = "findAll";
                
        IEntidade entidade = new TableAddress();//vh.getEntidade(entityReq);        
        IComando command = commands.get(action); 
        Resultado resultado = command.execute(entidade);        
        TableAddress address = (TableAddress) resultado.getEntidades().get(0);
        /*
        System.out.println("CEP:" + address.getLogradouro().getPostcode());
        System.out.println("Endereço:" + address.getLogradouro().getTipoLogradouro() + " " + address.getLogradouro().getLogradouro());
        System.out.println("Número:" + address.getHouseNumbering());
        System.out.println("Bairro:" + address.getLogradouro().getBairro().getBairro());
        System.out.println("Cidade:" + address.getLogradouro().getBairro().getCidade().getCidade());
        System.out.println("Estado:" + address.getLogradouro().getBairro().getCidade().getEstado().getEstado()); 
        */
        
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(address);
        System.out.println(jsonString);
    }
    
}
