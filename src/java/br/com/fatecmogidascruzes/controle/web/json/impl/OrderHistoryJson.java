/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.json.impl;

import br.com.fatecmogidascruzes.controle.web.json.IJsonService;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableOrderHistory;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class OrderHistoryJson implements IJsonService{
    
    TableOrderHistory orderHistory = new TableOrderHistory();

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        switch(request.getParameter("rca").charAt(1)){
            case 'C': // Create:
            case 'U': // Update            
            case 'D': // Excluir (DELETE)
            case 'I': // FindById(READ)
                try {
                    orderHistory = new ObjectMapper().readValue(request.getInputStream(), TableOrderHistory.class);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                break;
            default:
        }
        return new TableOrderHistory();
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {

    }
}
