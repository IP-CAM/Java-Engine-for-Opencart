/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.Pagination;
import br.com.fatecmogidascruzes.domain.impl.TableProduct;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josias Wattrelos
 */
public class PaginationViewHelper implements IViewHelper {

    Pagination pagination = new Pagination();
    @Override
    public IEntidade getEntidade(HttpServletRequest request) { 
        
        HttpSession sessao = request.getSession();
        Pagination pagination  = (Pagination)sessao.getAttribute("pagination");        
        if(null == pagination) {            
            pagination = new Pagination();
        }
        
        TableProduct entity = new TableProduct(); //request.getParameter("entity");
        pagination.setEntity(entity);
        if(request.getParameter("findBy") != null){        
            pagination.setFindBy(request.getParameter("findBy"));
        }
        if(request.getParameter("searchValue") != null){
            pagination.setSearchValue(request.getParameter("searchValue"));
        }
        if(request.getParameter("page") != null){
            pagination.setPage(Integer.parseInt(request.getParameter("page")));
        }
        if(request.getParameter("linesPerPage") != null){
            pagination.setLinesPerPage(Integer.parseInt(request.getParameter("linesPerPage")));
        }
        if(request.getParameter("orderBy") != null || request.getParameter("orderBy") != ""){
            pagination.setOrderBy(request.getParameter("orderBy"));
        }
        if(request.getParameter("direction") != null || request.getParameter("direction") != ""){
            pagination.setOrderBy(request.getParameter("direction"));
        }        
        sessao.setAttribute("pagination",pagination);
        return pagination;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<TableProduct> entity = (List<TableProduct>)(List<?>) resultado.getEntidades();
        request.setAttribute("productList", entity); 
        request.setAttribute("itensQuantity", resultado.getItensQuantity());
        request.setAttribute("pageNumber", resultado.getPageNumber());
        request.setAttribute("pageQuantity", resultado.getPageQuantity());
        request.setAttribute("lastPage", resultado.isLastPage());
        request.setAttribute("initialPage", resultado.getInitialPage());
        request.setAttribute("finalPage", resultado.getFinalPage());
    }
}
