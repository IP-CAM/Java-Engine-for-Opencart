/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.json.impl.CartJson;
import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.dao.impl.SessionDAO;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.FindByColumn;
import br.com.fatecmogidascruzes.domain.impl.TableCart;
import br.com.fatecmogidascruzes.domain.impl.TableSession;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class CartViewHelper implements IViewHelper {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableCart cart = new TableCart();
         // Get session ---------------------------------------------------------------------        
        for (Cookie cookie : request.getCookies()) {
            if (cookie.getName().equals("JSESSIONID")){
                TableSession mySession = new TableSession();
                SessionDAO sessionDao = new SessionDAO();
                List<TableSession> sessionList = sessionDao.findOneByName(cookie.getValue());
                if(sessionList.isEmpty()){ 
                    // TableSession mySession = (TableSession) entidadeDominio.get(0);                
                    mySession.setSession(cookie.getValue());
                    mySession.setData("{\"language\":\"pt-br\",\"currency\":\"BRL\"}");
                    // Gerar data 
                    LocalDateTime now = LocalDateTime.now();                    
                    String dataAtual = String.valueOf(now.getYear() + "-" + now.getMonthValue() + "-" + (now.getDayOfMonth() + 1));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date date2; 
                    try {
                        date2 = sdf.parse(dataAtual); // Obter a data atual;
                        mySession.setExpire(date2);
                    } catch (ParseException ex) {
                        Logger.getLogger(CartJson.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    sessionDao.create(mySession);

                } else{
                    mySession.setSession(sessionList.get(0).getSession());
                }
                cart.setSession(mySession);
            }
        }
       
        FindByColumn findByColumn = new FindByColumn("Session", cart.getSession().getSession());
        findByColumn.setEntity(cart);
        return findByColumn;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
        List<TableCart> carts = (List<TableCart>)(List<?>) resultado.getEntidades();
        Integer totalQuantity = 0;
        BigDecimal subTotal = BigDecimal.ZERO;
        String fragment = new String();
        for(TableCart cart: carts){
            totalQuantity += cart.getQuantity();
            BigDecimal prince = cart.getProduct().getPrice();
            subTotal = subTotal.add(prince);
        }
        request.setAttribute("cart", carts);
        request.setAttribute("quantity", totalQuantity);
        request.setAttribute("subtotal", subTotal);
    }
}
