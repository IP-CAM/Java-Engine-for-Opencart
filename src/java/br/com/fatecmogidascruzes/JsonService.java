/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes;

import br.com.fatecmogidascruzes.controle.web.command.IComando;
import br.com.fatecmogidascruzes.controle.web.command.impl.CreateCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.DeleteCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindAllCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindAllPageCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindByPageCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByIdCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindByColumn;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindByDateCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByNameCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.UpdateCommand;
import br.com.fatecmogidascruzes.controle.web.json.IJsonService;
import br.com.fatecmogidascruzes.controle.web.json.impl.AddressJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.CartJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.CategoryJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.CustomerJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.LogradouroJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.ManufacturerJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.OrderHistoryJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.OrderJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.ProductJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.SessionJson;
import br.com.fatecmogidascruzes.controle.web.json.impl.UserJson;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.security.service.JWTUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josias Wattrelos
 */
public class JsonService extends HttpServlet {
    private static Map<Integer, IJsonService> vhs;
    private static Map<Integer, IComando> commands;
    private static IJsonService vh;
    private static JWTUtil jwtUtil;
    
    
    public JsonService(){
        jwtUtil = new JWTUtil();
        
        /*
         * Utilizando o command para chamar a fachada e indexando cada command pela
         * operação garantimos que esta servelt atenderá qualquer operação
         */
        commands = new HashMap<>();        
        commands.put(67,new CreateCommand());		// 'C' create 
        commands.put(65, new FindAllCommand());		// 'A' findAll 
        commands.put(80, new FindByPageCommand());      // 'P' findByPage (Pagination)
        commands.put(100,new FindByDateCommand());      // 'd' findByDate (Pagination)
        commands.put(97, new FindAllPageCommand());     // 'a' findAllPage (Pagination)
        commands.put(78, new FindByColumn());           // 'N' findOneByColumn
        commands.put(73, new FindOneByIdCommand());	// 'I' findOneById
        commands.put(110,new FindOneByNameCommand());	// 'n' findOneByName 
        commands.put(85, new UpdateCommand());		// 'U' update 
        commands.put(68, new DeleteCommand());		// 'D' delete 

        /*
         * Utilizando o ViewHelper para tratar especificações de qualquer tela e
         * indexando cada viewhelper pela url em que esta servlet é chamada no form
         * garantimos que esta servelt atenderá qualquer entidade
         */
        vhs = new HashMap<>();
        
        vhs.put(97,new AddressJson()); // a
        //vhs.put(98,new BannerJson()); // b
        vhs.put(67,new CartJson()); // C
        vhs.put(99,new CategoryJson()); // c
       // vhs.put(113,new CreditcardJson()); // q
        vhs.put(117,new CustomerJson()); // u
        //vhs.put(102,new FeaturedProductJson()); // f
        //vhs.put(105,new InformationJson()); // i
        vhs.put(108,new LogradouroJson()); // l
        vhs.put(109,new ManufacturerJson());  // 'm'
        vhs.put(79,new OrderJson()); // O
        vhs.put(104,new OrderHistoryJson()); // h
        //vhs.put(100,new OrderTempJson()); // d
        vhs.put(112,new ProductJson()); // p
        //.put(80,new PaginationJson()); // P
        vhs.put(83,new SessionJson()); // S
        //vhs.put(115,new StoreJson()); // s
        vhs.put(122,new UserJson()); //z    
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
       
        HttpSession sessao = request.getSession();        
        String rca = request.getParameter("rca");
        
        String token  = (String)sessao.getAttribute("token");
            // Amarrar o token ao usuário evita roubo de token e evita que o cracker escale privilégios.
            // if(token != null && user != null && jwtUtil.tokenValido(token.substring(7), user)){ // A cada requisição verificar se o token pertence ao usário e se ainda é válido ou expirou.
            if(token == null){
                request.setAttribute("mensagemErro", "Sem token!!! ");
                // Habilitar somente após o filtro estar implementado:
                //request.getRequestDispatcher("/view/error/error.jsp").forward(request, response);
            }else if(jwtUtil.tokenValido(token.substring(7))){
                response.addHeader("Authorization", token); 
            }else{
                sessao.removeAttribute("token");
                sessao.removeAttribute("user");
                request.setAttribute("mensagemErro", "Token inválido!!! ");
                // Habilitar somente após o filtro estar implementado:
                // request.getRequestDispatcher("/view/error/error.jsp").forward(request, response);                
            }
            
        // Obtêm um viewhelper indexado pela uri que invocou esta servlet    
        this.vh = vhs.get((int)rca.charAt(0));
        IEntidade entidade = vh.getEntidade(request);  
        // Obtém o comando indexado a ser executado
        IComando command = commands.get((int)rca.charAt(1));
        // Executa comando indexado
        // if(true) throw new UnsupportedOperationException("MainServlet.doProcessRequest entidade=" + entidade.getClass().getSimpleName());
        Resultado resultado = command.execute(entidade);
        
        String pathUrl = "";
        if(resultado.getMsg() != null){ // Verifica se houve alguma mensagem de erro.
            request.setAttribute("mensagemErro", resultado.getMsg());
        }else{ // Se não houve erro, envia para tratamento de dados:
            // Envia para converter o resultado em objetos de páginas HTTP
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

            response.setContentType("application/json;charset=UTF-8");
            try {
                PrintWriter out = response.getWriter();
                out.print(objectMapper.writeValueAsString(resultado.getEntidades()));
                out.flush();
            } catch (JsonProcessingException ex) {
                Logger.getLogger(UserJson.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(UserJson.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        // Encaminha para a página JSP que receberá o conteúdo:       
        try {
            request.getRequestDispatcher(pathUrl).forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger("Erro " + ex);
        }
        
        // vh.setView(resultado, request, response);
       
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
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        processRequest(request, response);        
       
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
