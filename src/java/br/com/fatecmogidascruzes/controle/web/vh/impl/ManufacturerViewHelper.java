/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableManufacturer;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class ManufacturerViewHelper implements IViewHelper {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableManufacturer manufacturer = new TableManufacturer();
        
        switch(request.getParameter("rca").charAt(1)){
            case 'I': // Se a rota for para buscar manufacturer por ID
                manufacturer.setId(Integer.parseInt(request.getParameter("id")));
            break;
            default:
                manufacturer.setId(1);
        }
        return manufacturer;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<TableManufacturer> manufacturer = (List<TableManufacturer>)(List<?>) resultado.getEntidades();
        request.setAttribute("manufacturer", manufacturer);
    }
}
