/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableBanner;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class BannerViewHelper implements IViewHelper {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableBanner banner = new TableBanner();
        /*
        switch(request.getParameter("rca").charAt(1)){
            case 'I': // Se a rota for para buscar banner por ID
                if(request.getParameter("id") == null){
                    banner.setId(8);
                }else{
                    banner.setId(Integer.parseInt(request.getParameter("id")));
                }
            break;
            default:
                banner.setId(8);
        }
                */;
        return banner;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<TableBanner> banner = (List<TableBanner>)(List<?>) resultado.getEntidades();       
                 request.setAttribute("banner", banner);
    }
}
