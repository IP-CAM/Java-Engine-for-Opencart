/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.EntityFactory;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.Pagination;
import br.com.fatecmogidascruzes.domain.impl.TableProduct;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josias Wattrelos
 */
public class PaginationViewHelper extends EntityFactory {

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
        String rsa = request.getParameter("rsa");
        if(rsa.charAt(3) == 'v'){
            request.setAttribute("productList", entity); 
            request.setAttribute("itensQuantity", resultado.getItensQuantity());
            request.setAttribute("pageNumber", resultado.getPageNumber());
            request.setAttribute("pageQuantity", resultado.getPageQuantity());
            request.setAttribute("lastPage", resultado.isLastPage());
            request.setAttribute("initialPage", resultado.getInitialPage());
            request.setAttribute("finalPage", resultado.getFinalPage());
            // Obtém o caminho da página a ser encaminhada
            Integer selectpath = 26 * ((int)rsa.charAt(4) - 96) + ((int)rsa.charAt(5) - 96);
            Integer selectPage = (int)rsa.charAt(6) - 96;
            // Encaminha para a página JSP que receberá o conteúdo:       
            try {
                request.getRequestDispatcher(getPath(selectpath).toLowerCase() + getPath(selectPage).toLowerCase()).forward(request, response);
            } catch (IOException ex) {
                Logger.getLogger("Erro " + ex);
            }
        }else{
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            response.setContentType("application/json;charset=UTF-8");
            try {
                response.getWriter().write(objectMapper.writeValueAsString(resultado.getEntidades()));
            } catch (IOException ex) {
                Logger.getLogger(OrderViewHelper.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
