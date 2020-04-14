/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerGroup;
import br.com.fatecmogidascruzes.domain.impl.TableUserGroup;
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
public class CustomerViewHelper implements IViewHelper {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableCustomer customer = new TableCustomer();
        switch(request.getParameter("rca").charAt(1)){
            case 'C': // Se a rota for para criar (create) cliente (Customer):
                // customerList.setId(Integer.parseInt(request.getParameter("id")));
                customer.setUserGroup(new TableUserGroup(4)); // Todo cliente é usuário do tipo "Customer".
                // customerList.setStore(null);
                customer.setFullName(request.getParameter("fullname"));
                customer.setEmail(request.getParameter("email"));
                customer.setTelephone(request.getParameter("telephone"));
                customer.setCpf(Long.parseLong(request.getParameter("taxid")));
                // Data de nascimento:
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date dateOfBirthday = null;
                try {
                    dateOfBirthday = sdf.parse(request.getParameter("birthday"));                    
                    //if(true) throw new UnsupportedOperationException("CustomerViewHelper  birthday=" + dataNascimento);
                } catch (ParseException ex) {
                    Logger.getLogger(CustomerViewHelper.class.getName()).log(Level.SEVERE, null, ex);
                }
                customer.setDateOfBirth(dateOfBirthday); // Obter a data atual;);
                customer.setSexo(request.getParameter("gender").charAt(0));
                // Credenciais
                customer.setUsername(request.getParameter("username"));
                customer.setPassword(request.getParameter("password"));
                customer.setConfirmPassword(request.getParameter("confirmpassword"));
                customer.setIp(request.getRemoteAddr());
                
                customer.setCustomerGroup(new TableCustomerGroup(1)); // Tipo de cliente.                
                customer.setStatus(true);
                customer.setSafe(true);
                customer.setToken("0"); // Adicionar com BCrypt
                customer.setCode("0");
                customer.setSalt("0");
                customer.setDateAdded(null); // A data de criação será automaticamente criada pelo banco de dados.
                if(request.getParameter("newsletter") == "1")
                    customer.setNewsletter(true);
                else
                    customer.setNewsletter(false);
                break;
            case 'I': // Se a rota for para criar (create) cliente (Customer):                
                customer.setId(Integer.parseInt(request.getParameter("id")));
                break;
            case 'n': // Se a rota for para criar (create) cliente (Customer):
                HttpSession sessao = request.getSession();                
                String user = (String)sessao.getAttribute("user");
                customer.setUsername(user);
                break;
            default:
                customer.setId(1);
        }
        
        return customer;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
       
        List<TableCustomer> customerList = (List<TableCustomer>)(List<?>) resultado.getEntidades();      
        request.setAttribute("customer", customerList.get(0));
        switch(request.getParameter("rca").charAt(2)){
            case 'a': // Se a rota for para mortar um alista (list.jsp)
                request.setAttribute("addressList", customerList.get(0).getAddressList());
                request.setAttribute("customerUserName", customerList.get(0).getUsername());
                request.setAttribute("customerId", customerList.get(0).getId());
                break;
            case 'O': // Se a rota for para mostrar detalhe (detail.jsp)
                if(request.getParameter("rca").charAt(3) == 'C'){
                    request.setAttribute("customer", customerList.get(0));
                }else{                    
                    request.setAttribute("orderList", customerList.get(0).getOrderList());
                }
                break;
            default:        
                switch(request.getParameter("rca").charAt(3)){
                    case 'L': // Se a rota for para mortar um alista (list.jsp)
                        request.setAttribute("customerList", customerList);
                        break;
                    case 'D': // Se a rota for para mostrar detalhe (detail.jsp)
                        request.setAttribute("customer", customerList.get(0));
                        break;
                    default:
                        request.setAttribute("customerList", customerList);
                }
        }
    }
}
