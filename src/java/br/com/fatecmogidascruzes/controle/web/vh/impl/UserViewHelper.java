/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.impl.TableUser;
import br.com.fatecmogidascruzes.domain.IEntidade;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class UserViewHelper implements IViewHelper {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableUser user = new TableUser();
        switch(request.getParameter("rca").charAt(1)){
            case 'C': 
            case 'X':
                user.setUsername(request.getParameter("userName"));
                user.setPassword(request.getParameter("password"));
                break;
            case 'I': // Se a rota for para criar (create) cliente (User):                
                user.setId(Integer.parseInt(request.getParameter("id")));
                break;
            default:
                user.setId(1);
        }
        return user;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
       
        List<TableUser> user = (List<TableUser>)(List<?>) resultado.getEntidades();
               
        switch(request.getParameter("rca").charAt(3)){
            case 'L': // Se a rota for para mortar um alista (list.jsp)
                request.setAttribute("userList", user);
                break;
            case 'D': // Se a rota for para mostrar detalhe (detail.jsp)
                request.setAttribute("user", user.get(0));
                break;
                
            case 'X': // Se a rota for para mostrar detalhe (detail.jsp)
                request.setAttribute("user", user.get(0));
                break;
            default:
                request.setAttribute("userList", user.get(0));
        }
    }
}
