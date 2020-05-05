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
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByNameCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.UpdateCommand;
import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.AddressViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.BannerViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.CartViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.CategoryViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.CreditcardViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.CurrencyViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.CustomerViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.FeaturedProductViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.InformationViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.ManufacturerViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.OrderHistoryViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.OrderViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.PaginationViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.ProductViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.ReturnReasonViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.ReturnViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.StockStatusViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.StoreViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.UserViewHelper;
import br.com.fatecmogidascruzes.controle.web.vh.impl.WeightClassViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableStore;
import br.com.fatecmogidascruzes.security.service.JWTUtil;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Administrador
 */
public class Servlet extends HttpServlet {
        
    private static Map<Integer, IViewHelper> vhs;
    private static Map<Integer, IComando> commands;
    private static JWTUtil jwtUtil;    
    
    public Servlet(){
        jwtUtil = new JWTUtil();
        
        /*
         * Utilizando o command para chamar a fachada e indexando cada command pela
         * operação garantimos que esta servelt atenderá qualquer operação
         */
        commands = new HashMap<>();

        commands.put(3, new CreateCommand()); //c
        commands.put(4, new DeleteCommand()); //d
        commands.put(1, new FindAllCommand()); //a
        commands.put(17,new FindAllPageCommand()); //q
        commands.put(10,new FindByColumn()); //j
        commands.put(16,new FindByPageCommand()); //p
        commands.put(9, new FindOneByIdCommand()); //i
        commands.put(14,new FindOneByNameCommand()); //n
        commands.put(21,new UpdateCommand()); //u


        /*
         * Utilizando o ViewHelper para tratar especificações de qualquer tela e
         * indexando cada viewhelper pela url em que esta servlet é chamada no form
         * garantimos que esta servelt atenderá qualquer entidade
         */
        vhs = new HashMap<>();
        //vhs.put(28,new BairroViewHelper());//ab
        //vhs.put(29,new CidadeViewHelper());//ac
        //vhs.put(31,new EstadoViewHelper());//ae
        //vhs.put(38,new LogradouroViewHelper());//al
        vhs.put(27,new AddressViewHelper());//aa
        //vhs.put(42,new ApiViewHelper());//ap
        //vhs.put(45,new ApiSessionViewHelper());//as
        vhs.put(53,new BannerViewHelper());//ba
        //vhs.put(61,new BannerImageViewHelper());//bi
        vhs.put(79,new CartViewHelper());//ca
        vhs.put(80,new CategoryViewHelper());//cb
        //vhs.put(81,new CountryViewHelper());//cc
        //vhs.put(82,new CouponViewHelper());//cd
        //vhs.put(83,new CouponHistoryViewHelper());//ce
        //vhs.put(84,new CouponProductViewHelper());//cf
        vhs.put(85,new CreditcardViewHelper());//cg
        vhs.put(86,new CurrencyViewHelper());//ch
        vhs.put(87,new CustomerViewHelper());//ci
        //vhs.put(88,new CustomerActivityViewHelper());//cj
        //vhs.put(89,new CustomerApprovalViewHelper());//ck
        //vhs.put(90,new CustomerGroupViewHelper());//cl
        //vhs.put(91,new CustomerHistoryViewHelper());//cm
        //vhs.put(92,new CustomerIpViewHelper());//cn
        //vhs.put(93,new CustomerLoginViewHelper());//co
        // //vhs.put(94,new CustomerOnlineViewHelper());//cp
        //vhs.put(96,new CustomerRewardViewHelper());//cr
        //vhs.put(97,new CustomerSearchViewHelper());//cs
        //vhs.put(98,new CustomerTransactionViewHelper());//ct
        //vhs.put(152,new EventViewHelper());//ev
        //vhs.put(154,new ExtensionViewHelper());//ex
        //vhs.put(139,new ExtensionInstallViewHelper());//ei
        //vhs.put(146,new ExtensionPathViewHelper());//ep
        vhs.put(172,new FeaturedProductViewHelper());//fp
        //vhs.put(176,new FilterViewHelper());//ft
        //vhs.put(208,new GeoZoneViewHelper());//gz
        vhs.put(240,new InformationViewHelper());//if
        //vhs.put(313,new LanguageViewHelper());//la
        //vhs.put(337,new LayoutViewHelper());//ly
        //vhs.put(325,new LayoutModuleViewHelper());//lm
        //vhs.put(330,new LayoutRouteViewHelper());//lr
        //vhs.put(319,new LengthClassViewHelper());//lg
        //vhs.put(315,new LocationViewHelper());//lc
        vhs.put(339,new ManufacturerViewHelper());//ma
        //vhs.put(349,new MarketingViewHelper());//mk
        //vhs.put(344,new ModificationViewHelper());//mf
        //vhs.put(353,new ModuleViewHelper());//mo
        //vhs.put(391,new OptionViewHelper());//oa
        //vhs.put(414,new OptionValueViewHelper());//ox
        vhs.put(394,new OrderViewHelper());//od
        vhs.put(398,new OrderHistoryViewHelper());//oh
        //vhs.put(405,new OrderOptionViewHelper());//oo
        //vhs.put(406,new OrderProductViewHelper());//op
        //vhs.put(408,new OrderRecurringViewHelper());//or
        //vhs.put(413,new OrderRecurringTransactionViewHelper());//ow
        //vhs.put(400,new OrderShipmentViewHelper());//oj
        //vhs.put(409,new OrderStatusViewHelper());//os
        //vhs.put(410,new OrderTotalViewHelper());//ot
        //vhs.put(412,new OrderVoucherViewHelper());//ov
        vhs.put(417,new PaginationViewHelper());//pa
        vhs.put(436,new ProductViewHelper());//pt
        //vhs.put(420,new ProductDiscountViewHelper());//pd
        //vhs.put(428,new ProductImageViewHelper());//pl
        //vhs.put(431,new ProductOptionViewHelper());//po
        //vhs.put(438,new ProductOptionValueViewHelper());//pv
        //vhs.put(434,new ProductRecurringViewHelper());//pr
        //vhs.put(435,new ProductSpecialViewHelper());//ps
        //vhs.put(471,new RecurringViewHelper());//rc
        vhs.put(488,new ReturnViewHelper());//rt
        //vhs.put(469,new ReturnActionViewHelper());//ra
        vhs.put(486,new ReturnReasonViewHelper());//rr
        //vhs.put(487,new ReturnStatusViewHelper());//rs
        //vhs.put(491,new ReviewViewHelper());//rw
        //vhs.put(515,new SeoUrlViewHelper());//su
        //vhs.put(499,new SessionViewHelper());//se
        //vhs.put(501,new SettingViewHelper());//sg
        //vhs.put(497,new ShippingCourierViewHelper());//sc
        //vhs.put(514,new StatisticsViewHelper());//st
        vhs.put(513,new StockStatusViewHelper());//ss
        vhs.put(512,new StoreViewHelper());//sr
        //vhs.put(544,new TaxClassViewHelper());//tx
        //vhs.put(538,new TaxRateViewHelper());//tr
        //vhs.put(541,new TaxRuleViewHelper());//tu
        vhs.put(565,new UserViewHelper());//us
        //vhs.put(553,new UserGroupViewHelper());//ug
        vhs.put(601,new WeightClassViewHelper());//wc
        //vhs.put(690,new ZoneViewHelper());//zn
        //vhs.put(683,new ZoneToGeoZoneViewHelper());//zg
        
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
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        HttpSession sessao = request.getSession(); 
        String rsa = request.getParameter("rsa");   
        Integer selectEntity = 26 * ((int)rsa.charAt(0) - 96) + ((int)rsa.charAt(1) - 96);
        Integer selectCommand = (int)rsa.charAt(2) - 96;
        String token  = (String)sessao.getAttribute("token");
        
        if(selectCommand != 1 && selectCommand != 9){ // Fitro provisório até implementação do filtro de privilégios
        // Amarrar o token ao usuário evita roubo de token e evita que o cracker escale privilégios.
        // if(token != null && user != null && jwtUtil.tokenValido(token.substring(7), user)){ // A cada requisição verificar se o token pertence ao usário e se ainda é válido ou expirou.        
            if(token == null){
                request.setAttribute("mensagemErro", "Erro! Sem token!!! ");
                request.getRequestDispatcher("/view/error/error.jsp").forward(request, response);
                // Habilitar somente após o filtro estar implementado:
            }else if(!jwtUtil.tokenValido(token.substring(7))){
                request.setAttribute("mensagemErro", "Erro! Token inválido!!!");
                request.getRequestDispatcher("/view/error/error.jsp").forward(request, response);
            }
        }            
        // EntidadeDominio entidade = eds.get(selectEntity);
        IViewHelper vh = vhs.get(selectEntity);
        IEntidade entity = vh.getEntidade(request);               
        IComando command = commands.get(selectCommand); 
        // if(true) throw new UnsupportedOperationException("Servlet.processRequest command=" + command.getClass().getSimpleName());
        Resultado resultado = command.execute(entity);
        FindOneByIdCommand findOneById  = new FindOneByIdCommand();                
        // Carrega os acessórios da página:
        request.setAttribute("store", findOneById.execute(new TableStore(1)).getEntidades().get(0));
        // Envia para a view específica            
        vh.setView(resultado, request, response);
        
       
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
