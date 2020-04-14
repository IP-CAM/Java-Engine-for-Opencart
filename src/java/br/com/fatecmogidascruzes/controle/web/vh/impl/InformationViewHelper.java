/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableInformation;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class InformationViewHelper implements IViewHelper{
    
    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        
        TableInformation information = new TableInformation();
        /*
        if(request.getParameter("information") != null){
        
        }
        */
        
        information.setId(Integer.parseInt(request.getParameter("information")));
        
        return information;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<TableInformation> information = (List<TableInformation>)(List<?>) resultado.getEntidades();
        request.setAttribute("information", information.get(0).getDescription().toString());
    }
    
}
