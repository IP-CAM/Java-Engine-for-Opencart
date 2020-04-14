/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.impl.TableOrderHistory;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableOrderHistory;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class OrderHistoryViewHelper implements IViewHelper {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        return new TableOrderHistory();        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
       
        List<TableOrderHistory> orderHistoryList = (List<TableOrderHistory>)(List<?>) resultado.getEntidades();
        request.setAttribute("orderHistoryList", orderHistoryList);        
    }
}
