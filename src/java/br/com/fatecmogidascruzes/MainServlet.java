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
import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.AddressViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.BannerViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.CartViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.CategoryViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.CreditcardViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.CustomerViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.FeaturedProductViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.InformationViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.ManufacturerViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.OrderTempViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.OrderViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.PaginationViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.ProductViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.StoreViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.UserViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.security.service.JWTUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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
public class MainServlet extends HttpServlet {
    
    
    private static Map<Integer, IViewHelper> vhs;
    private static Map<Integer, IComando> commands;
    private static Map<Integer, String> pagePath;
    private static JWTUtil jwtUtil;
    
    
    public MainServlet(){
        
        jwtUtil = new JWTUtil();
        
        /*
         * Utilizando o command para chamar a fachada e indexando cada command pela
         * operação garantimos que esta servelt atenderá qualquer operação
         */
        commands = new HashMap<Integer, IComando>();        
        commands.put(67,new CreateCommand());		// 'C' create 
        // commands.put(84,new FindByDateCommand());	// 'T' findByDate
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
        vhs = new HashMap<Integer, IViewHelper>();
        
        vhs.put(97, new AddressViewHelper()); // a
        vhs.put(98, new BannerViewHelper()); // b
        vhs.put(67, new CartViewHelper()); // C
        vhs.put(99, new CategoryViewHelper()); // c
        vhs.put(113,new CreditcardViewHelper()); // q
        vhs.put(117,new CustomerViewHelper()); // u
        vhs.put(102,new FeaturedProductViewHelper()); // f
        vhs.put(105,new InformationViewHelper()); // i
        vhs.put(109,new ManufacturerViewHelper());  // 'm'
        vhs.put(79, new OrderViewHelper()); // O
        vhs.put(100,new OrderTempViewHelper()); // d        
        vhs.put(112,new ProductViewHelper()); // p
        vhs.put(80, new PaginationViewHelper()); // P
        // vhs.put(83,new SessionViewHelper()); // S
        vhs.put(115,new StoreViewHelper()); // s
        vhs.put(122,new UserViewHelper()); //z
        
        /*
         * Utilizando o pagePath para encontrar o caminho das páginas da entidade na view
         */
        pagePath = new HashMap<Integer, String>();
        pagePath.put(97 ,"/view/address");   //\\ 'a'
        pagePath.put(98 ,"/view/banner");     //\\ 'b'
        pagePath.put(107,"/view/cart");        //\\ 'k'
        pagePath.put(99 ,"/view/category");     //\\ 'c'
        pagePath.put(113,"/view/creditcard");     //\\ 'q'
        pagePath.put(117,"/view/customer");      //\\ 'u'
        pagePath.put(102,"/view/featuredProduct"); // 'f'
        pagePath.put(105,"/view/information");    // 'i'
        pagePath.put(109,"/view/manufacturer");  // 'm'
        pagePath.put(79 ,"/view/order");        // 'O'
        pagePath.put(112,"/view/product");     // 'p'
        pagePath.put(83 ,"/view/session");    // 'S'
        pagePath.put(115,"/view/store");     // 's'
        pagePath.put(122,"/view/user");     // 'z'
        
        pagePath.put(120,"/view/message");     // 'x'
        
        /*
         * Utilizando o entityPage para mostrar uma página específica da entidade
         */
        pagePath.put(67,"/create.jsp"); // 'C' detalhes da entidade
        pagePath.put(85,"/update.jsp"); // 'U' formulário para atualizar da entidade
        pagePath.put(69,"/delete.jsp"); // 'E' formulário para atualizar da entidade
        pagePath.put(68,"/detail.jsp"); // 'D' detalhes da entidade
        pagePath.put(76,"/list.jsp"); // 'L' Listar todos
        pagePath.put(100,"/data.jsp"); // 'd' Listar todos
        
        // Principais páginas do sistema:
        pagePath.put(48,""); // '' Raiz do serviço web.
        pagePath.put(49,"/home.jsp"); // '1' Página de boas-vindas.
        pagePath.put(50,"/livraria"); // '2' Chamar servet principal
        pagePath.put(51,"/carrinho.jsp"); // 
        pagePath.put(52,"/enderecos.jsp"); // 
        pagePath.put(53,"/pagamento.jsp"); // 
        pagePath.put(54,"/revisarPedido.jsp"); //
        pagePath.put(55,"/confirmacao.jsp"); //
        pagePath.put(56,"/pagar2cartoes.jsp"); //
        pagePath.put(57,"/view/error/error.jsp"); //
        pagePath.put(121,"/message.jsp"); // 'y'
        pagePath.put(95,""); // '_'Vazio, porém não nulo.
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {                
         doProcessRequest(request, response);        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        doProcessRequest(request, response);        
    }
    
    protected void doProcessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession sessao = request.getSession();        
        String rca = request.getParameter("rca");
        
        //if(rca.charAt(0) != 's') {
            // Verifica se o token ainda é válido.        
            System.out.println("MainServlet.doProcessRequest rca=" + rca);    // requisições        

            // String token = request.getHeader("Authorization");
            
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
        //}
        
        // Carrega elementos da página principal (menu, nav, banners, estilos, temas... ----------------------------------------------------------------
        IViewHelper vh_home = vhs.get(115);
        IEntidade entidade_home = vh_home.getEntidade(request); 
        IComando command_home = commands.get(73);  // FindOneById
        Resultado resultado_home = command_home.execute(entidade_home);
        vh_home.setView(resultado_home, request, response);
        // EDD... --------------------------------------------------------------
        
        // Carrega banner ----------------------------------------------------------------
        IViewHelper vh_banner = vhs.get(98);
        IEntidade entidade_banner = vh_banner.getEntidade(request); 
        IComando command_banner = commands.get(65);  // FindOneById
        Resultado resultado_banner = command_banner.execute(entidade_banner);
        vh_banner.setView(resultado_banner, request, response);
        // EDD... --------------------------------------------------------------
        
        
        // Obtêm um viewhelper indexado pela uri que invocou esta servlet
        // if(true) throw new UnsupportedOperationException("MainServlet.doProcessRequest rca.charAt(0)=" + (int)rca.charAt(0));
        IViewHelper vh = vhs.get((int)rca.charAt(0));
        // Obtém a classe do objeto a ser trabalhado
        // if(true) throw new UnsupportedOperationException("MainServlet.doProcessRequest vh=" + vh.getClass().getSimpleName());
        IEntidade entidade = vh.getEntidade(request); 
        // Obtém o comando indexado a ser executado
        IComando command = commands.get((int)rca.charAt(1));
        // Executa comando indexado
        // if(true) throw new UnsupportedOperationException("MainServlet.doProcessRequest entidade=" + entidade.getClass().getSimpleName());
        Resultado resultado = command.execute(entidade);
        String pathUrl = "";
        if(resultado.getMsg() != null){ // Verifica se houve alguma mensagem de erro.
            request.setAttribute("mensagemErro", resultado.getMsg());
            pathUrl = pagePath.get(57);
        }else{ // Se não houve erro, envia para tratamento de dados:
            // Envia para converter o resultado em objetos de páginas HTTP
            vh.setView(resultado, request, response);
            // Obtém o caminho da página a ser encaminhada
            pathUrl = pagePath.get((int)rca.charAt(2)) + pagePath.get((int)rca.charAt(3));  
        }
        // Encaminha para a página JSP que receberá o conteúdo:       
        try {
            request.getRequestDispatcher(pathUrl).forward(request, response);
        } catch (IOException ex) {
            Logger.getLogger("Erro " + ex);
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
