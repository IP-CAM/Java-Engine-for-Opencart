/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.impl;

import br.com.fatecmogidascruzes.controle.web.command.IComando;
import br.com.fatecmogidascruzes.controle.web.command.impl.CreateCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByIdCommand;
import br.com.fatecmogidascruzes.controle.web.command.impl.FindOneByNameCommand;
import br.com.fatecmogidascruzes.controle.web.vh.DTO.ProductCartDTO;
import br.com.fatecmogidascruzes.controle.web.vh.IViewHelper;
import br.com.fatecmogidascruzes.core.aplicacao.Resultado;
import br.com.fatecmogidascruzes.domain.impl.TableOrder;
import br.com.fatecmogidascruzes.domain.IEntidade;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;
import br.com.fatecmogidascruzes.domain.impl.TableCurrency;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.impl.TableOrderHistory;
import br.com.fatecmogidascruzes.domain.impl.TableOrderProduct;
import br.com.fatecmogidascruzes.domain.impl.TableOrderStatus;
import br.com.fatecmogidascruzes.domain.impl.TableOrderTotal;
import br.com.fatecmogidascruzes.domain.impl.TableStore;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Josias Wattrelos
 */
public class OrderViewHelper implements IViewHelper {
    
    @Override
    public IEntidade getEntidade(HttpServletRequest request) {
        HttpSession sessao = request.getSession();
        TableOrder order = new TableOrder();
        switch(request.getParameter("rca").charAt(1)){
            case 'C':
                
                // Adiconar cliente (customer) ao pedido (order):
                TableCustomer customer = new TableCustomer();                       
                customer.setUsername((String)sessao.getAttribute("user"));
                IComando findOneByName = new FindOneByNameCommand(); 
                Resultado resultado = findOneByName.execute(customer);        
                customer = (TableCustomer) resultado.getEntidades().get(0);
                order.setCustomer(customer);
                order.setUsername(customer.getUsername());
                order.setFullname(customer.getFullName());
                order.setCustomerGroupId(customer.getCustomerGroup()); // 
                order.setEmail(customer.getEmail());
                order.setTelephone(customer.getTelephone());
                
                // Forma de pagamento Pagamento
               
                // Adicionar endereço de faturamento: ---------------------------------------------------------------
                TableAddress paymentAddress = new TableAddress(Integer.parseInt(request.getParameter("payment-address-id")));                
                IComando findOneById = new FindOneByIdCommand();
                resultado = findOneById.execute(paymentAddress);
                paymentAddress = (TableAddress)resultado.getEntidades().get(0);
                
                order.setPaymentMethod("Cartão de crédito");
                order.setPaymentFullname(customer.getFullName());
                order.setPaymentUsername(customer.getUsername());
                // Adicionar endereço de faturamento: ---------------------------------------------------------------
                order.setPaymentAddress1(paymentAddress.getLogradouro().getTipoLogradouro() + ", " + paymentAddress.getLogradouro().getLogradouro() + ", " + paymentAddress.getHouseNumbering());
                order.setPaymentAddress2(paymentAddress.getLogradouro().getBairro().getName());
                order.setPaymentAddressFormat(null);
                order.setPaymentPostcode(paymentAddress.getLogradouro().getPostcode().toString());                
                order.setPaymentCity(paymentAddress.getLogradouro().getBairro().getCidade().getName());
                order.setPaymentCountry(paymentAddress.getLogradouro().getBairro().getCidade().getEstado().getName());                
                order.setPaymentCode("20200130");
                order.setPaymentZoneId(paymentAddress.getLogradouro().getBairro().getCidade().getEstado().getId());
                order.setPaymentZone(paymentAddress.getLogradouro().getBairro().getCidade().getEstado().getName());
                order.setPaymentCompany("-");
                
                // Moeda ----------------------------------------------------------------------------
                TableCurrency currency = new TableCurrency(4);
                Resultado resultado2 = findOneById.execute(currency);
                currency = (TableCurrency)resultado2.getEntidades().get(0);
                order.setCurrencyId(currency);
                order.setCurrencyCode(currency.getCode());  
                order.setCurrencyValue(currency.getValue()); // Taxa de conversão de câmbio utilizada.
                
                // Adicionar endereço de entrega: ---------------------------------------------------------------
                TableAddress shippingAddress = new TableAddress(Integer.parseInt(request.getParameter("shipping-address-id")));                
                resultado = findOneById.execute(shippingAddress);
                shippingAddress = (TableAddress)resultado.getEntidades().get(0);
                
                order.setShippingMethod("Transportadora");
                order.setShippingFullname(customer.getFullName());
                order.setShippingUsername(customer.getUsername());
                
                order.setShippingAddress1(shippingAddress.getLogradouro().getTipoLogradouro() + ", " + shippingAddress.getLogradouro().getLogradouro()+ ", " + shippingAddress.getHouseNumbering());
                order.setShippingAddress2(shippingAddress.getLogradouro().getBairro().getName());
                order.setShippingPostcode(shippingAddress.getLogradouro().getPostcode().toString());
                order.setShippingCity(shippingAddress.getLogradouro().getBairro().getCidade().getName());
                order.setShippingCountry(shippingAddress.getLogradouro().getBairro().getCidade().getEstado().getName());
                
                order.setShippingZone(shippingAddress.getLogradouro().getBairro().getCidade().getEstado().getName());
                order.setShippingZoneId(shippingAddress.getLogradouro().getBairro().getCidade().getEstado().getId());
                order.setShippingCompany("-");
                order.setShippingCode("0000000000000");                
                order.setShippingAddressFormat("Retirar na loja");
                // -----------------------------------------------------------------==================-----------------------
                order.setTracking("0000000000000");
                
                order.setCommission(BigDecimal.ZERO);
                order.setComment(request.getParameter("comment"));                
                order.setTotal(null);
                order.setIp(request.getRemoteAddr());
                String ipAddress = request.getHeader("X-FORWARDED-FOR");  
                if (ipAddress == null) {  
                    ipAddress = request.getRemoteAddr();  
                }
                order.setForwardedIp(ipAddress);
                order.setUserAgent(request.getHeader("User-Agent"));
                order.setAcceptLanguage(request.getHeader("Accept-Language"));
                
                // Atribuir loja:
                TableStore store = new TableStore(1);
                Resultado resultado3 = findOneById.execute(store);
                store = (TableStore)resultado3.getEntidades().get(0);
                order.setStoreId(store);
                order.setStoreName(store.getName());
                order.setStoreUrl(store.getUrl());                
                order.setInvoicePrefix("AGSC");                
                order.setOrderStatusId(new TableOrderStatus(1)); // Attribui o estado (status) inicial do pedido (order).                
                break;
            case 'n':                
                order.setUsername(request.getParameter("name"));                
                break;
            case 'I':                
                order.setId(Integer.parseInt(request.getParameter("id")));
                break;
            default:
                order.setId(1);
        }
        return order;        
    }

    @Override
    public void setView(Resultado resultado, HttpServletRequest request, HttpServletResponse response) throws ServletException {
       
        List<TableOrder> orderList = (List<TableOrder>)(List<?>) resultado.getEntidades();
        request.setAttribute("orderList", orderList);
        
        if(request.getParameter("rca").charAt(1) == 'C'){
            String productCart;
            productCart = request.getParameter("orderProduct");
            
            TableOrder order = orderList.get(0);
            IComando create = new CreateCommand();
            
            Gson json = new Gson();

            Type collectionType = new TypeToken<List<ProductCartDTO>>() {}.getType();

            List<ProductCartDTO> productCartDtoList = json.fromJson(productCart, collectionType);
            String product = "";
            BigDecimal subtotal = new BigDecimal(0.0);
            for (ProductCartDTO productCartDTO: productCartDtoList){
                
                TableOrderProduct orderProduct = new TableOrderProduct();
                orderProduct.setProductId(productCartDTO.getId()); // Em OrderProduct é o id do produto referenciado (cópia). Não é o id do indice!
                orderProduct.setOrder(order);
                orderProduct.setQuantity(productCartDTO.getQuantity());
                orderProduct.setPrice(productCartDTO.getPrice());
                
                subtotal = subtotal.add(orderProduct.getPrice().multiply(new BigDecimal(orderProduct.getQuantity())));
                
                create.execute(orderProduct);
            }
            
            // Gravar total ------------------------------------------------------------------------------
            //subtotal
            TableOrderTotal orderSubtotal = new TableOrderTotal();            
            orderSubtotal.setOrder(order);
            orderSubtotal.setTitle("Subtotal");
            orderSubtotal.setCode("subtotal");
            orderSubtotal.setValue(subtotal);
            
            //Frete
            TableOrderTotal ordershipping = new TableOrderTotal();
            ordershipping.setOrder(order);
            ordershipping.setTitle("Transportadora"); // Atualizar este campo quando o cálculo do frete for implementado.
            ordershipping.setCode("shipping");
            ordershipping.setValue(new BigDecimal(request.getParameter("shipping-value"))); // Atualizar este campo quando o cálculo do frete for implementado.
            
            //total
            TableOrderTotal orderTotal = new TableOrderTotal();
            orderTotal.setOrder(order);
            orderTotal.setTitle("Total");
            orderTotal.setCode("total");
            orderTotal.setValue(subtotal.add(ordershipping.getValue()));
            //
            create.execute(orderSubtotal);
            create.execute(ordershipping);
            create.execute(orderTotal);
            // Criar histórico inicial do pedido após criação d o pedido (dependencia hierárquica) -----------------------------------------------------------------------                
                
            TableOrderHistory orderHistory = new TableOrderHistory();
            orderHistory.setOrder(order);
            orderHistory.setOrderStatus(new TableOrderStatus(1)); // Todo pedido se inicia como pendente;
            orderHistory.setNotify(false); // Receber notificação sobre o andamento do pedido.
            orderHistory.setComment("");
            create.execute(orderHistory);
        }        
    }
}
