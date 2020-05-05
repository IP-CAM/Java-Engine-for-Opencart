/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.command.IComando;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByNameCommand;
import br.com.fatecmogidascruzes.controle.web.vh.EntityFactory;
import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableCreditCard;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CreditcardViewHelper extends EntityFactory {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        
        HttpSession sessao = request.getSession();
        TableCreditCard creditcard = new TableCreditCard();
        
        switch(request.getParameter("rca").charAt(1)){
            case 'i': // Se a rota for para buscar creditcard por ID
                creditcard.setId(Integer.parseInt(request.getParameter("id")));
            break;
                case 'C': // Se a rota for para buscar creditcard por ID
                TableCustomer customer = new TableCustomer();                       
                customer.setUsername((String)sessao.getAttribute("user"));
                IComando findOneByName = new FindOneByNameCommand(); 
                Resultado resultado = findOneByName.execute(customer);        
                customer = (TableCustomer) resultado.getEntidades().get(0);
                creditcard.setCustomer(customer);
                creditcard.setCardholder_name(request.getParameter("cardholder-name"));
                creditcard.setNumber(Long.parseLong(request.getParameter("number")));
                // Date --------------------------
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    creditcard.setMemberSinceDate(sdf.parse(request.getParameter("member-since")));
                    creditcard.setExpiration_date(sdf.parse(request.getParameter("expiration-date"))); 
                } catch (ParseException ex) {
                    Logger.getLogger(CustomerViewHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
                // Date --------------------------;
                creditcard.setSecurity_code(Integer.parseInt(request.getParameter("security-code")));
            break;
            default:
                creditcard.setId(1);
        }
        return creditcard;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<TableCreditCard> creditcard = (List<TableCreditCard>)(List<?>) resultado.getEntidades();
        request.setAttribute("creditcardList", creditcard);
    }
}
