/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.EntityFactory;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableStore;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class StoreViewHelper extends EntityFactory {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableStore store = new TableStore();
        /*
        switch(request.getParameter("rca").charAt(1)){
            case 'i': // Se a rota for para buscar store por ID
                store.setId(Integer.parseInt(request.getParameter("id")));
            break;
            default:
                store.setId(1);
        }*/
        store.setId(1);
        return store;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<TableStore> store = (List<TableStore>)(List<?>) resultado.getEntidades();
        request.setAttribute("store", store.get(0).getName());
        request.setAttribute("featuredProduct", store.get(0).getFeaturedProduct());
        request.setAttribute("categoryList", store.get(0).getCategoryList());
    }
}
