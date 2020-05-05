/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.command.IComando;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByIdCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByNameCommand;
import br.com.fatecmogidascruzes.controle.web.vh.EntityFactory;
import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.impl.TableOrderProduct;
import br.com.fatecmogidascruzes.domain.impl.TableOrder;
import br.com.fatecmogidascruzes.domain.impl.TableProduct;
import br.com.fatecmogidascruzes.domain.impl.TableReturn;
import br.com.fatecmogidascruzes.domain.impl.TableReturnAction;
import br.com.fatecmogidascruzes.domain.impl.TableReturnReason;
import br.com.fatecmogidascruzes.domain.impl.TableReturnStatus;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josias Wattrelos
 */
public class ReturnViewHelper extends EntityFactory {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        TableReturn tableReturn = new TableReturn();
        
        switch(request.getParameter("rsa").charAt(2)){
            case 'i': // Se a rota for para buscar tableReturn por ID
                tableReturn.setId(Integer.parseInt(request.getParameter("id")));
            break;
            case 'c': // Se a rota for para buscar tableReturn por ID
                // Isso garante que somente o usuário logado pode ter acesso e tão somente aos próprios dados.
                TableCustomer customer = new TableCustomer();                       
                customer.setUsername((String)sessao.getAttribute("user"));
                IComando findOneByName = new FindOneByNameCommand(); 
                Resultado resultado = findOneByName.execute(customer);        
                customer = (TableCustomer) resultado.getEntidades().get(0); 
                // -- End session user ---------------------                                
                tableReturn.setCustomer(customer);
                tableReturn.setFullname(customer.getFullName());
                tableReturn.setEmail(customer.getEmail());
                tableReturn.setTelephone(customer.getTelephone());
                
                tableReturn.setOrder(new TableOrder(Integer.parseInt(request.getParameter("order-id"))));
                
                IComando findOneById = new FindOneByIdCommand();
                TableOrderProduct orderProduct = new TableOrderProduct(Integer.parseInt(request.getParameter("product-id")));
                resultado = findOneById.execute(orderProduct);
                orderProduct = (TableOrderProduct)resultado.getEntidades().get(0);
                tableReturn.setProduct(new TableProduct(orderProduct.getProductId()));
                tableReturn.setProductName(orderProduct.getName());
                tableReturn.setModel(orderProduct.getModel());
                tableReturn.setQuantity(Integer.parseInt(request.getParameter("quantity")));
                tableReturn.setReturnReason(new TableReturnReason(Integer.parseInt(request.getParameter("return-reason"))));
                tableReturn.setReturnStatus(new TableReturnStatus(1));
                tableReturn.setReturnAction(new TableReturnAction(14));
                
                if(request.getParameter("opened").equals('1')){
                    tableReturn.setOpened(true);
                }else{
                    tableReturn.setOpened(false);
                }
                // TableOrderProduct orderProduct = new TableOrderProduct();
            break;
            default:
                tableReturn.setId(1);
        }
        return tableReturn;        
    }

}
