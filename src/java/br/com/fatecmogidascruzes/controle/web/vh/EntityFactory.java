/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh;

import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByIdCommand;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.Bairro;
import br.com.fatecmogidascruzes.domain.impl.Cidade;
import br.com.fatecmogidascruzes.domain.impl.Estado;
import br.com.fatecmogidascruzes.domain.impl.Logradouro;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;
import br.com.fatecmogidascruzes.domain.impl.TableApi;
import br.com.fatecmogidascruzes.domain.impl.TableApiSession;
import br.com.fatecmogidascruzes.domain.impl.TableBanner;
import br.com.fatecmogidascruzes.domain.impl.TableBannerImage;
import br.com.fatecmogidascruzes.domain.impl.TableCart;
import br.com.fatecmogidascruzes.domain.impl.TableCategory;
import br.com.fatecmogidascruzes.domain.impl.TableCountry;
import br.com.fatecmogidascruzes.domain.impl.TableCoupon;
import br.com.fatecmogidascruzes.domain.impl.TableCouponHistory;
import br.com.fatecmogidascruzes.domain.impl.TableCouponProduct;
import br.com.fatecmogidascruzes.domain.impl.TableCreditCard;
import br.com.fatecmogidascruzes.domain.impl.TableCurrency;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerActivity;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerApproval;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerGroup;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerHistory;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerIp;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerLogin;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerReward;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerSearch;
import br.com.fatecmogidascruzes.domain.impl.TableCustomerTransaction;
import br.com.fatecmogidascruzes.domain.impl.TableEvent;
import br.com.fatecmogidascruzes.domain.impl.TableExtension;
import br.com.fatecmogidascruzes.domain.impl.TableExtensionInstall;
import br.com.fatecmogidascruzes.domain.impl.TableExtensionPath;
import br.com.fatecmogidascruzes.domain.impl.TableFeaturedProduct;
import br.com.fatecmogidascruzes.domain.impl.TableFilter;
import br.com.fatecmogidascruzes.domain.impl.TableGeoZone;
import br.com.fatecmogidascruzes.domain.impl.TableInformation;
import br.com.fatecmogidascruzes.domain.impl.TableLanguage;
import br.com.fatecmogidascruzes.domain.impl.TableLayout;
import br.com.fatecmogidascruzes.domain.impl.TableLayoutModule;
import br.com.fatecmogidascruzes.domain.impl.TableLayoutRoute;
import br.com.fatecmogidascruzes.domain.impl.TableLengthClass;
import br.com.fatecmogidascruzes.domain.impl.TableLocation;
import br.com.fatecmogidascruzes.domain.impl.TableManufacturer;
import br.com.fatecmogidascruzes.domain.impl.TableMarketing;
import br.com.fatecmogidascruzes.domain.impl.TableModification;
import br.com.fatecmogidascruzes.domain.impl.TableModule;
import br.com.fatecmogidascruzes.domain.impl.TableOption;
import br.com.fatecmogidascruzes.domain.impl.TableOptionValue;
import br.com.fatecmogidascruzes.domain.impl.TableOrder;
import br.com.fatecmogidascruzes.domain.impl.TableOrderHistory;
import br.com.fatecmogidascruzes.domain.impl.TableOrderOption;
import br.com.fatecmogidascruzes.domain.impl.TableOrderProduct;
import br.com.fatecmogidascruzes.domain.impl.TableOrderRecurring;
import br.com.fatecmogidascruzes.domain.impl.TableOrderRecurringTransaction;
import br.com.fatecmogidascruzes.domain.impl.TableOrderShipment;
import br.com.fatecmogidascruzes.domain.impl.TableOrderStatus;
import br.com.fatecmogidascruzes.domain.impl.TableOrderTotal;
import br.com.fatecmogidascruzes.domain.impl.TableOrderVoucher;
import br.com.fatecmogidascruzes.domain.impl.TableProduct;
import br.com.fatecmogidascruzes.domain.impl.TableProductDiscount;
import br.com.fatecmogidascruzes.domain.impl.TableProductImage;
import br.com.fatecmogidascruzes.domain.impl.TableProductOption;
import br.com.fatecmogidascruzes.domain.impl.TableProductOptionValue;
import br.com.fatecmogidascruzes.domain.impl.TableProductRecurring;
import br.com.fatecmogidascruzes.domain.impl.TableProductSpecial;
import br.com.fatecmogidascruzes.domain.impl.TableRecurring;
import br.com.fatecmogidascruzes.domain.impl.TableReturn;
import br.com.fatecmogidascruzes.domain.impl.TableReturnAction;
import br.com.fatecmogidascruzes.domain.impl.TableReturnReason;
import br.com.fatecmogidascruzes.domain.impl.TableReturnStatus;
import br.com.fatecmogidascruzes.domain.impl.TableReview;
import br.com.fatecmogidascruzes.domain.impl.TableSeoUrl;
import br.com.fatecmogidascruzes.domain.impl.TableSession;
import br.com.fatecmogidascruzes.domain.impl.TableSetting;
import br.com.fatecmogidascruzes.domain.impl.TableShippingCourier;
import br.com.fatecmogidascruzes.domain.impl.TableStatistics;
import br.com.fatecmogidascruzes.domain.impl.TableStockStatus;
import br.com.fatecmogidascruzes.domain.impl.TableStore;
import br.com.fatecmogidascruzes.domain.impl.TableTaxClass;
import br.com.fatecmogidascruzes.domain.impl.TableTaxRate;
import br.com.fatecmogidascruzes.domain.impl.TableTaxRule;
import br.com.fatecmogidascruzes.domain.impl.TableUser;
import br.com.fatecmogidascruzes.domain.impl.TableUserGroup;
import br.com.fatecmogidascruzes.domain.impl.TableWeightClass;
import br.com.fatecmogidascruzes.domain.impl.TableZone;
import br.com.fatecmogidascruzes.domain.impl.TableZoneToGeoZone;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Josias Wattrelos
 */
public class EntityFactory implements IViewHelper {
    
    private static Map<Integer, IEntidade> eds;
    private static Map<Integer, String> pagePath;

    public EntityFactory() {
        
        eds = new HashMap<>();
    	
        eds.put(28,new Bairro()); //ab
        eds.put(29,new Cidade()); //ac
        eds.put(31,new Estado()); //ae
        eds.put(38,new Logradouro()); //al
        eds.put(27,new TableAddress()); //aa
        eds.put(42,new TableApi()); //ap
        eds.put(45,new TableApiSession()); //as
        eds.put(53,new TableBanner()); //ba
        eds.put(61,new TableBannerImage()); //bi
        eds.put(79,new TableCart()); //ca
        eds.put(80,new TableCategory()); //cb
        eds.put(81,new TableCountry()); //cc
        eds.put(82,new TableCoupon()); //cd
        eds.put(83,new TableCouponHistory()); //ce
        eds.put(84,new TableCouponProduct()); //cf
        eds.put(85,new TableCreditCard()); //cg
        eds.put(86,new TableCurrency()); //ch
        eds.put(87,new TableCustomer()); //ci
        eds.put(88,new TableCustomerActivity()); //cj
        eds.put(89,new TableCustomerApproval()); //ck
        eds.put(90,new TableCustomerGroup()); //cl
        eds.put(91,new TableCustomerHistory()); //cm
        eds.put(92,new TableCustomerIp()); //cn
        eds.put(93,new TableCustomerLogin()); //co
        // eds.put(94,new TableCustomerOnline()); //cp
        eds.put(96,new TableCustomerReward()); //cr
        eds.put(97,new TableCustomerSearch()); //cs
        eds.put(98,new TableCustomerTransaction()); //ct
        eds.put(152,new TableEvent()); //ev
        eds.put(154,new TableExtension()); //ex
        eds.put(139,new TableExtensionInstall()); //ei
        eds.put(146,new TableExtensionPath()); //ep
        eds.put(172,new TableFeaturedProduct()); //fp
        eds.put(176,new TableFilter()); //ft
        eds.put(208,new TableGeoZone()); //gz
        eds.put(240,new TableInformation()); //if
        eds.put(313,new TableLanguage()); //la
        eds.put(337,new TableLayout()); //ly
        eds.put(325,new TableLayoutModule()); //lm
        eds.put(330,new TableLayoutRoute()); //lr
        eds.put(319,new TableLengthClass()); //lg
        eds.put(315,new TableLocation()); //lc
        eds.put(339,new TableManufacturer()); //ma
        eds.put(349,new TableMarketing()); //mk
        eds.put(344,new TableModification()); //mf
        eds.put(353,new TableModule()); //mo
        eds.put(391,new TableOption()); //oa
        eds.put(414,new TableOptionValue()); //ox
        eds.put(394,new TableOrder()); //od
        eds.put(398,new TableOrderHistory()); //oh
        eds.put(405,new TableOrderOption()); //oo
        eds.put(406,new TableOrderProduct()); //op
        eds.put(408,new TableOrderRecurring()); //or
        eds.put(413,new TableOrderRecurringTransaction()); //ow
        eds.put(400,new TableOrderShipment()); //oj
        eds.put(409,new TableOrderStatus()); //os
        eds.put(410,new TableOrderTotal()); //ot
        eds.put(412,new TableOrderVoucher()); //ov
        eds.put(436,new TableProduct()); //pt
        eds.put(420,new TableProductDiscount()); //pd
        eds.put(428,new TableProductImage()); //pl
        eds.put(431,new TableProductOption()); //po
        eds.put(438,new TableProductOptionValue()); //pv
        eds.put(434,new TableProductRecurring()); //pr
        eds.put(435,new TableProductSpecial()); //ps
        eds.put(471,new TableRecurring()); //rc
        eds.put(488,new TableReturn()); //rt
        eds.put(469,new TableReturnAction()); //ra
        eds.put(486,new TableReturnReason()); //rr
        eds.put(487,new TableReturnStatus()); //rs
        eds.put(491,new TableReview()); //rw
        eds.put(515,new TableSeoUrl()); //su
        eds.put(499,new TableSession()); //se
        eds.put(501,new TableSetting()); //sg
        eds.put(497,new TableShippingCourier()); //sc
        eds.put(514,new TableStatistics()); //st
        eds.put(513,new TableStockStatus()); //ss
        eds.put(512,new TableStore()); //sr
        eds.put(544,new TableTaxClass()); //tx
        eds.put(538,new TableTaxRate()); //tr
        eds.put(541,new TableTaxRule()); //tu
        eds.put(565,new TableUser()); //us
        eds.put(553,new TableUserGroup()); //ug
        eds.put(601,new TableWeightClass()); //wc
        eds.put(690,new TableZone()); //zn
        eds.put(683,new TableZoneToGeoZone()); //zg
        
        pagePath = new HashMap<>();
        pagePath.put(28,"/view/Bairro"); //ab
        pagePath.put(29,"/view/Cidade"); //ac
        pagePath.put(31,"/view/Estado"); //ae
        pagePath.put(38,"/view/Logradouro"); //al
        pagePath.put(27,"/view/Address"); //aa
        pagePath.put(42,"/view/Api"); //ap
        pagePath.put(45,"/view/ApiSession"); //as
        pagePath.put(53,"/view/Banner"); //ba
        pagePath.put(61,"/view/BannerImage"); //bi
        pagePath.put(79,"/view/Cart"); //ca
        pagePath.put(80,"/view/Category"); //cb
        pagePath.put(81,"/view/Country"); //cc
        pagePath.put(82,"/view/Coupon"); //cd
        pagePath.put(83,"/view/CouponHistory"); //ce
        pagePath.put(84,"/view/CouponProduct"); //cf
        pagePath.put(85,"/view/CreditCard"); //cg
        pagePath.put(86,"/view/Currency"); //ch
        pagePath.put(87,"/view/Customer"); //ci
        pagePath.put(88,"/view/CustomerActivity"); //cj
        pagePath.put(89,"/view/CustomerApproval"); //ck
        pagePath.put(90,"/view/CustomerGroup"); //cl
        pagePath.put(91,"/view/CustomerHistory"); //cm
        pagePath.put(92,"/view/CustomerIp"); //cn
        pagePath.put(93,"/view/CustomerLogin"); //co
        pagePath.put(94,"/view/CustomerOnline"); //cp
        pagePath.put(96,"/view/CustomerReward"); //cr
        pagePath.put(97,"/view/CustomerSearch"); //cs
        pagePath.put(98,"/view/CustomerTransaction"); //ct
        pagePath.put(152,"/view/Event"); //ev
        pagePath.put(154,"/view/Extension"); //ex
        pagePath.put(139,"/view/ExtensionInstall"); //ei
        pagePath.put(146,"/view/ExtensionPath"); //ep
        pagePath.put(172,"/view/FeaturedProduct"); //fp
        pagePath.put(176,"/view/Filter"); //ft
        pagePath.put(208,"/view/GeoZone"); //gz
        pagePath.put(240,"/view/Information"); //if
        pagePath.put(313,"/view/Language"); //la
        pagePath.put(337,"/view/Layout"); //ly
        pagePath.put(325,"/view/LayoutModule"); //lm
        pagePath.put(330,"/view/LayoutRoute"); //lr
        pagePath.put(319,"/view/LengthClass"); //lg
        pagePath.put(315,"/view/Location"); //lc
        pagePath.put(339,"/view/Manufacturer"); //ma
        pagePath.put(349,"/view/Marketing"); //mk
        pagePath.put(344,"/view/Modification"); //mf
        pagePath.put(353,"/view/Module"); //mo
        pagePath.put(391,"/view/Option"); //oa
        pagePath.put(414,"/view/OptionValue"); //ox
        pagePath.put(394,"/view/Order"); //od
        pagePath.put(398,"/view/OrderHistory"); //oh
        pagePath.put(405,"/view/OrderOption"); //oo
        pagePath.put(406,"/view/OrderProduct"); //op
        pagePath.put(408,"/view/OrderRecurring"); //or
        pagePath.put(413,"/view/OrderRecurringTransaction"); //ow
        pagePath.put(400,"/view/OrderShipment"); //oj
        pagePath.put(409,"/view/OrderStatus"); //os
        pagePath.put(410,"/view/OrderTotal"); //ot
        pagePath.put(412,"/view/OrderVoucher"); //ov
        pagePath.put(436,"/view/Product"); //pt
        pagePath.put(420,"/view/ProductDiscount"); //pd
        pagePath.put(428,"/view/ProductImage"); //pl
        pagePath.put(431,"/view/ProductOption"); //po
        pagePath.put(438,"/view/ProductOptionValue"); //pv
        pagePath.put(434,"/view/ProductRecurring"); //pr
        pagePath.put(435,"/view/ProductSpecial"); //ps
        pagePath.put(471,"/view/Recurring"); //rc
        pagePath.put(488,"/view/Return"); //rt
        pagePath.put(469,"/view/ReturnAction"); //ra
        pagePath.put(486,"/view/ReturnReason"); //rr
        pagePath.put(487,"/view/ReturnStatus"); //rs
        pagePath.put(491,"/view/Review"); //rw
        pagePath.put(515,"/view/SeoUrl"); //su
        pagePath.put(499,"/view/Session"); //se
        pagePath.put(501,"/view/Setting"); //sg
        pagePath.put(497,"/view/ShippingCourier"); //sc
        pagePath.put(514,"/view/Statistics"); //st
        pagePath.put(513,"/view/StockStatus"); //ss
        pagePath.put(512,"/view/Store"); //sr
        pagePath.put(544,"/view/TaxClass"); //tx
        pagePath.put(538,"/view/TaxRate"); //tr
        pagePath.put(541,"/view/TaxRule"); //tu
        pagePath.put(565,"/view/User"); //us
        pagePath.put(553,"/view/UserGroup"); //ug
        pagePath.put(601,"/view/WeightClass"); //wc
        pagePath.put(690,"/view/Zone"); //zn
        pagePath.put(683,"/view/ZoneToGeoZone"); //zg
        
        pagePath.put(3 ,"/Create.jsp"); //c
        pagePath.put(4 ,"/Delete.jsp"); //d
        pagePath.put(21,"/Update.jsp"); //u

        /*
         * Utilizando o entityPage para mostrar uma página específica da entidade
         */
       
        pagePath.put(12,"/list.jsp"); // 'l' Listar todos
        pagePath.put(5 ,"/error.jsp"); // 'd' Listar todos
        
        // Principais páginas do sistema:
        pagePath.put(32,""); // 'b' Vazio, porém não nulo.
        pagePath.put(8 ,"/home.jsp"); // 'h' Página de boas-vindas.
        pagePath.put(13,"/message.jsp"); // 'y'
        pagePath.put(22,"/detail.jsp"); // 'v'   
    } 
    
    
    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        String rsa = request.getParameter("rsa");
        Integer selectEntity = 26 * ((int)rsa.charAt(0) - 96) + ((int)rsa.charAt(1) - 96);
        IEntidade entity = eds.get(selectEntity);
        switch(request.getParameter("rsa").charAt(1)){
            case 'i': // Se a rota for para buscar category por ID
            case 'd': // Se a rota for para escluir product por ID
                entity.setId(Integer.parseInt(request.getParameter("id")));
            break;
            case 'n':
                //entity.setName(request.getParameter("name"));
            break; 
            
            default:
        }
        return eds.get(selectEntity);
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
                pathUrl = pagePath.get(selectpath).toLowerCase() + pagePath.get(selectPage).toLowerCase();
                
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
    
    public String getPath(Integer pathIndex){
        return pagePath.get(pathIndex);        
    }
}
