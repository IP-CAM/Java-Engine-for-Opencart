/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableProduct;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class ProductViewHelper implements IViewHelper {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableProduct product = new TableProduct();
        
        switch(request.getParameter("rca").charAt(1)){
            case 'I': // Se a rota for para buscar product por ID
            case 'D': // Se a rota for para escluir product por ID
                product.setId(Integer.parseInt(request.getParameter("id")));                     
                break;
            default:
                product.setId(1);
        }
        return product;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<TableProduct> product = (List<TableProduct>)(List<?>) resultado.getEntidades();
        switch(request.getParameter("rca").charAt(3)){
            case 'D': // Se a rota for para buscar product por ID
                request.setAttribute("product", product.get(0));                
                break;
            case 'L': // Se a rota for para buscar product por ID
                request.setAttribute("productList", product);
                break;
            case 'I': // Se a rota for para buscar product por ID
                request.setAttribute("product", product.get(0));
                break;
            default:
                request.setAttribute("productList", product);
        }
    }
}
