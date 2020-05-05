/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.vh.EntityFactory;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerGroup;
import br.com.fatecmogidascruzes.domain.impl.TableUserGroup;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class CustomerViewHelper extends EntityFactory {

    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        TableCustomer customer = new TableCustomer();        
        switch(request.getParameter("rsa").charAt(2)){
            
            case 'c': // Se a rota for para criar (create) cliente (Customer):
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
            case 'i': // Se a rota for para criar (create) cliente (Customer):                
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
        String rsa = request.getParameter("rsa");
        if(rsa.charAt(3) == 'v'){
                String pathUrl = "";
                // Converter o resultado em objetos de páginas HTTP
                // request.setAttribute("title",  resultado.getEntidades().get(0).getClass().getSimpleName().replace("Table", "")); // Remove a palavra Table do nome da classe
                request.setAttribute(resultado.getEntidades().get(0).getClass().getSimpleName().replace("Table", "").toLowerCase() + "List",  resultado.getEntidades());
                                                
                // Obtém o caminho da página a ser encaminhada
                Integer selectpath = 26 * ((int)rsa.charAt(4) - 96) + ((int)rsa.charAt(5) - 96);
                Integer selectPage = (int)rsa.charAt(6) - 96;
                pathUrl = getPath(selectpath).toLowerCase() + getPath(selectPage).toLowerCase();
                
                // Encaminha para a página JSP que receberá o conteúdo:       
                try {
                    request.getRequestDispatcher(pathUrl).forward(request, response);
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
                    Logger.getLogger(resultado.getEntidades().get(0).getClass().getSimpleName()).log(Level.SEVERE, null, ex);
                }
            }
    }
    
}
