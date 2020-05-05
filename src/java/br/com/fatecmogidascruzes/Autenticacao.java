/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes;

import br.com.fatecmogidascruzes.dao.impl.CustomerDAO;
import br.com.fatecmogidascruzes.dao.impl.SessionDAO;
import br.com.fatecmogidascruzes.domain.impl.TableSession;
import br.com.fatecmogidascruzes.security.service.CredenciaisDTO;
// import br.com.fatecmogidascruzes.security.CredenciaisDTO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Josias Wattrelos
 */

public class Autenticacao extends HttpServlet{    
    
    private BCryptPasswordEncoder pe;
    public Autenticacao(){
        pe = new BCryptPasswordEncoder();
    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
        
       
    }

   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         // Comando para finalizar sessão:
        HttpSession sessao = request.getSession();
        sessao.setMaxInactiveInterval(1); 
        request.getRequestDispatcher("/ag?rsa=baavafh").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        
        HttpSession sessao = request.getSession();        
        // Autenticar:
        CredenciaisDTO creds = new CredenciaisDTO();
        creds.setUserName(request.getParameter("username"));
        creds.setPassword(request.getParameter("password"));
        
        
        CustomerDAO customerDao = new CustomerDAO();  // Preparar para a busca no banco de dados        
        creds = customerDao.Authentication(creds); // Buscar usuário pelo apelido        
        if(creds == null){ // Usuário inativo (status false) ou apelido incorreto ou senha incorreta.
            request.setAttribute("mensagemErro", "Credenciais incorretas!!! ");
            request.getRequestDispatcher("/view/error/error.jsp").forward(request, response);
        }else{                               
            // Adiciona, ao cabeçalho da requisição, o token de autorização 
            response.setContentType("text/html;charset=UTF-8");
            response.addHeader("Authorization", "Bearer " + creds.getToken()); // Assinar o cabeçalho das páginas com token de autorização.
            response.addHeader("access-control-expose-headers", "Authorization");
            response.addHeader("Authorities", creds.getAuthorities());  //Adiciona tipo de usuário.            
            
            // Sessão ---------------------------------------
            sessao.setAttribute("user", creds.getUserName());
            sessao.setAttribute("token", "Bearer " + creds.getToken());
            sessao.setMaxInactiveInterval(86400000);
            TableSession mySession = new TableSession();
            
            SessionDAO sessionDao = new SessionDAO();
            mySession.setSession(sessao.getId());
            mySession.setData("{\"language\":\"pt-br\",\"currency\":\"BRL\"}");
            mySession.setExpire(creds.getExpirationDate());                        
            sessionDao.create(mySession);

            // Ir para a página inicial. Opcionalmente, pode-se escolher retornar para a página de origem.
            request.getRequestDispatcher("/view/cart/detail.jsp").forward(request, response);
            // request.getRequestDispatcher("/view/error/teste.jsp").forward(request, response); //Apenas testes
        } 
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
