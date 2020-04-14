/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableFeaturedProduct;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class FeaturedProductViewHelper implements IViewHelper {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableFeaturedProduct featuredProduct = new TableFeaturedProduct();
        /*
        switch(request.getParameter("rca").charAt(1)){
            case 'I': // Se a rota for para buscar featuredProduct por ID
                featuredProduct.setId(Integer.parseInt(request.getParameter("id")));
            break;
            default:
                featuredProduct.setId(1);
        }*/
        featuredProduct.setId(1);
        return featuredProduct;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<TableFeaturedProduct> featuredProduct = (List<TableFeaturedProduct>)(List<?>) resultado.getEntidades();
        request.setAttribute("featuredProduct", featuredProduct);
    }
}
