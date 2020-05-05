/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.EntityFactory;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableProduct;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Josias Wattrelos
 */
public class ProductViewHelper extends EntityFactory {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableProduct product = new TableProduct();
        
        switch(request.getParameter("rsa").charAt(2)){
            case 'i': // Se a rota for para buscar product por ID
            case 'd': // Se a rota for para escluir product por ID
                product.setId(Integer.parseInt(request.getParameter("id")));                     
                break;
            default:
                product.setId(1);
        }
        return product;        
    }
    
}
