/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.AbstractDAO;
import br.com.fatecmogidascruzes.dao.impl.SessionDAO;
import br.com.fatecmogidascruzes.domain.impl.TableApi;
import br.com.fatecmogidascruzes.domain.impl.TableCart;
import br.com.fatecmogidascruzes.domain.impl.TableProduct;
import br.com.fatecmogidascruzes.domain.impl.TableSession;
import java.util.List;

/**
 *
 * @author Josias Wattrelos
 */
public class TestAddCart {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
                TableSession mySession = new TableSession();
                SessionDAO sessionDao = new SessionDAO();
                List<TableSession> sessionList = sessionDao.findOneByName("C6E629A9C9FE520DAB7B1AE93E9D9138");               
                
                mySession.setSession(sessionList.get(0).getSession());
                System.out.println("Session value=" + mySession.getSession());
                
                TableCart cart = new TableCart();
                cart.setSession(mySession);
                cart.setApiId(new TableApi(1));
                cart.setProduct(new TableProduct(110008));
                cart.setQuantity(1);
                System.out.println("Cart Session=" + cart.getSession() +
                        "\nCart ApiId=" + cart.getApiId().getId() +
                        "\nCart Quantity=" + cart.getQuantity() +
                        "\nCart Product descrition=" + cart.getProduct().getId()
                );
                 
                AbstractDAO cartDao = new AbstractDAO(cart);
                cartDao.create(cart);                
            }
}
