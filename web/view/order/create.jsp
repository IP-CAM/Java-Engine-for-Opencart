<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- 
    Document   : Inserir
    Created on : 13/09/2019, 01:26:27
    Author     : Administrador
--%>

<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Carrinho de compras</title>
    </head>
    <body style="background-color: #13181e;">
        <form method="post" action="/ZZZ_ag_908/livraria?rca=qCOC" class="panel-group" id="createCreditCard"></form>
        <div class="body_wrap">            
            <%@include file="/view/fragments/header.jsp" %>
            <div id="checkout-checkout" class="container">
                <ul class="breadcrumb">
                    <li><a href="/ZZZ_ag_908/home"><i class="fa fa-home"></i></a></li>
                    <li><a href="/ZZZ_ag_908/view/cart/detail.jsp">Carrinho de compras</a></li>
                    <li>Finalizar pedido</li>
                </ul>
                <div class="row">
                    <div id="content" class="col-sm-12">
                        <h1>Finalizar pedido de ${customer.fullName}</h1>
                        <form method="post" action="/ZZZ_ag_908/livraria?rca=OCOy" class="panel-group" id="accordion" onsubmit="checkAgree(event)">              
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h4 class="panel-title">
                                        <a href="#collapse-payment-address" data-toggle="collapse" data-parent="#accordion" class="accordion-toggle" aria-expanded="true">Endereço de faturamento<i class="fa fa-caret-down"></i></a></h4>
                                </div>
                                <div class="panel-collapse collapse in" id="collapse-payment-address" aria-expanded="true" style="">
                                    <div class="panel-body">
                                        <div class="form-horizontal">
                                            <div class="radio">
                                                <label><input type="radio" name="payment_address" value="existing" checked="checked">Utilizar um endereço cadastrado</label>
                                            </div>
                                            <div id="payment-existing">
                                                <c:choose>
                                                    <c:when test="${empty customer.addressList}">
                                                        Nenhum endereço cadastrado
                                                    </c:when>
                                                    <c:otherwise>                                                         
                                                        <select name="payment-address-id" class="form-control">
                                                            <c:forEach var="address" items="${customer.addressList}">                                                    
                                                                <option value="${address.id}" selected="selected">
                                                                    ${customer.fullName}
                                                                    , ${address.logradouro.postcode}
                                                                    , ${address.logradouro.tipoLogradouro} ${address.logradouro.logradouro}
                                                                    , ${address.houseNumbering}
                                                                    , ${address.complements}
                                                                    , ${address.logradouro.bairro.name}
                                                                    , ${address.logradouro.bairro.cidade.name}
                                                                    ${address.logradouro.bairro.cidade.estado.name}
                                                                </option>
                                                            </c:forEach> 
                                                        </select>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="radio">
                                                <label><input type="radio" name="payment_address" value="new">Utilizar um novo endereço</label>
                                            </div>
                                            <br>
                                            <div id="payment-new" style="display: none;">
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-payment-firstname">Nome</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="firstname" placeholder="Nome" id="input-payment-firstname" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-payment-lastname">Sobrenome</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="lastname" placeholder="Sobrenome" id="input-payment-lastname" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="input-payment-company">Referência</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="company" placeholder="Referência" id="input-payment-company" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="input-payment-postcode">CEP</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="postcode" placeholder="CEP" id="input-payment-postcode" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-payment-address-1">Endereço</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="address_1" placeholder="Endereço" id="input-payment-address-1" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="input-payment-address-2">Bairro</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="address_2" placeholder="Bairro" id="input-payment-address-2" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-payment-city">Cidade</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="city" placeholder="Cidade" id="input-payment-city" class="form-control">
                                                    </div>
                                                </div>
                                                <!-- 
                                                    <div class="form-group required">
                                                      <label class="col-sm-2 control-label" for="input-payment-postcode">CEP</label>
                                                      <div class="col-sm-10">
                                                        <input type="text" name="postcode" value="" placeholder="CEP" id="input-payment-postcode" class="form-control" />
                                                      </div>
                                                    </div>
                                                -->
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-payment-country">País</label>
                                                    <div class="col-sm-10">
                                                        <select name="country_id" id="input-payment-country" class="form-control">
                                                            <option value=""> --- Selecione --- </option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-payment-zone">Estado</label>
                                                    <div class="col-sm-10">
                                                        <select name="zone_id" id="input-payment-zone" class="form-control"><option value=""> --- Selecione --- </option><option value="440">Acre</option><option value="441">Alagoas</option><option value="442">Amapá</option><option value="443">Amazonas</option><option value="444">Bahia</option><option value="445">Ceará</option><option value="446">Distrito Federal</option><option value="447">Espírito Santo</option><option value="448">Goiás</option><option value="449">Maranhão</option><option value="450">Mato Grosso</option><option value="451">Mato Grosso do Sul</option><option value="452">Minas Gerais</option><option value="453">Pará</option><option value="454">Paraíba</option><option value="455">Paraná</option><option value="456">Pernambuco</option><option value="457">Piauí</option><option value="458">Rio de Janeiro</option><option value="459">Rio Grande do Norte</option><option value="460">Rio Grande do Sul</option><option value="461">Rondônia</option><option value="462">Roraima</option><option value="463">Santa Catarina</option><option value="464" selected="selected">São Paulo</option><option value="465">Sergipe</option><option value="466">Tocantins</option></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="buttons clearfix">
                                                <div class="pull-right">
                                                    <a href="#collapse-shipping-address" data-toggle="collapse" data-parent="#accordion" class="btn btn-primary">Continuar</a>
                                                </div>
                                            </div>
                                        </div>                                        
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a href="#collapse-shipping-address" data-toggle="collapse" data-parent="#accordion" class="accordion-toggle collapsed" aria-expanded="false">Endereço para entrega <i class="fa fa-caret-down"></i></a></h4>
                                </div>
                                <div class="panel-collapse collapse" id="collapse-shipping-address" aria-expanded="false" style="height: 0px;">
                                    <div class="panel-body">
                                        <div class="form-horizontal">
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="shipping_address" value="existing" checked="checked">
                                                    Utilizar um endereço cadastrado</label>
                                            </div>
                                            <div id="shipping-existing">
                                                <c:choose>
                                                    <c:when test="${empty customer.addressList}">
                                                        Nenhum endereço cadastrado
                                                    </c:when>
                                                    <c:otherwise>                                                         
                                                        <select name="shipping-address-id" class="form-control">
                                                            <c:forEach var="address" items="${customer.addressList}">                                                    
                                                                <option value="${address.id}" selected="selected">
                                                                    ${customer.fullName}
                                                                    , ${address.logradouro.postcode}
                                                                    , ${address.logradouro.tipoLogradouro} ${address.logradouro.logradouro}
                                                                    , ${address.houseNumbering}
                                                                    , ${address.complements}
                                                                    , ${address.logradouro.bairro.name}
                                                                    , ${address.logradouro.bairro.cidade.name}
                                                                    ${address.logradouro.bairro.cidade.estado.name}
                                                                </option>
                                                            </c:forEach> 
                                                        </select>
                                                    </c:otherwise>
                                                </c:choose>
                                            </div>
                                            <div class="radio">
                                                <label>
                                                    <input type="radio" name="shipping_address" value="new">
                                                    Utilizar um novo endereço</label>
                                            </div>
                                            <br>
                                            <div id="shipping-new" style="display: none;">
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-shipping-firstname">Nome</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="firstname" placeholder="Nome" id="input-shipping-firstname" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-shipping-lastname">Sobrenome</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="lastname" placeholder="Sobrenome" id="input-shipping-lastname" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="input-shipping-company">Referência</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="company" placeholder="Referência" id="input-shipping-company" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="input-shipping-postcode">CEP</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="postcode" placeholder="CEP" id="input-shipping-postcode" class="form-control">
                                                    </div>
                                                </div>

                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-shipping-address-1">Endereço</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="address_1" placeholder="Endereço" id="input-shipping-address-1" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="input-shipping-address-2">Bairro</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="address_2" placeholder="Bairro" id="input-shipping-address-2" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-shipping-city">Cidade</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="city" placeholder="Cidade" id="input-shipping-city" class="form-control">
                                                    </div>
                                                </div>
                                                <!-- 
                                                    <div class="form-group required">
                                                      <label class="col-sm-2 control-label" for="input-shipping-postcode">CEP</label>
                                                      <div class="col-sm-10">
                                                        <input type="text" name="postcode" value="08505-340" placeholder="CEP" id="input-shipping-postcode" class="form-control" />
                                                      </div>
                                                    </div>
                                                -->
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-shipping-country">País</label>
                                                    <div class="col-sm-10">
                                                        <select name="country_id" id="input-shipping-country" class="form-control">
                                                            <option value=""> --- Selecione --- </option>                                                           
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-shipping-zone">Estado</label>
                                                    <div class="col-sm-10">
                                                        <select name="zone_id" id="input-shipping-zone" class="form-control"><option value=""> --- Selecione --- </option><option value="440">Acre</option><option value="441">Alagoas</option><option value="442">Amapá</option><option value="443">Amazonas</option><option value="444">Bahia</option><option value="445">Ceará</option><option value="446">Distrito Federal</option><option value="447">Espírito Santo</option><option value="448">Goiás</option><option value="449">Maranhão</option><option value="450">Mato Grosso</option><option value="451">Mato Grosso do Sul</option><option value="452">Minas Gerais</option><option value="453">Pará</option><option value="454">Paraíba</option><option value="455">Paraná</option><option value="456">Pernambuco</option><option value="457">Piauí</option><option value="458">Rio de Janeiro</option><option value="459">Rio Grande do Norte</option><option value="460">Rio Grande do Sul</option><option value="461">Rondônia</option><option value="462">Roraima</option><option value="463">Santa Catarina</option><option value="464" selected="selected">São Paulo</option><option value="465">Sergipe</option><option value="466">Tocantins</option></select>
                                                    </div>
                                                </div>
                                            </div>
                                            <div class="buttons clearfix">
                                                <div class="pull-right">
                                                    <a href="#collapse-shipping-method" data-toggle="collapse" data-parent="#accordion" class="btn btn-primary">Continuar</a>
                                                </div>
                                            </div>
                                        </div>                                       
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a href="#collapse-shipping-method" data-toggle="collapse" data-parent="#accordion" class="accordion-toggle collapsed" aria-expanded="false">Detalhes do frete <i class="fa fa-caret-down"></i></a></h4>
                                </div>
                                <div class="panel-collapse collapse" id="collapse-shipping-method" aria-expanded="false" style="height: 0px;">
                                    <div class="panel-body"><p>Selecione como deseja receber o seu pedido.</p>
                                        <p><strong>Valor do frete:</strong></p>
                                        <div class="radio">
                                            <label><input type="radio" name="shipping-value" value="23.56" checked="checked">Transportadora - R$ 23,56</label>
                                        </div>
                                        <div class="buttons">
                                            <div class="pull-right">
                                                <a href="#collapse-payment-method" data-toggle="collapse" data-parent="#accordion" class="btn btn-primary">Continuar</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a href="#collapse-payment-method" data-toggle="collapse" data-parent="#accordion" class="accordion-toggle collapsed" aria-expanded="false">Detalhes do pagamento <i class="fa fa-caret-down"></i></a></h4>
                                </div>
                                <div class="panel-collapse collapse" id="collapse-payment-method" aria-expanded="false" style="height: 0px;">
                                    <div class="panel-body">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <fieldset id="account">
                                                  <legend>Selecione como deseja pagar o seu pedido.</legend>
                                                    <div class="radio">
                                                        <label><input type="radio" name="payment_method" value="cod" checked="checked">Pagar ao retirar na loja</label>
                                                    </div>
                                                    <div class="radio">
                                                        <label><input type="radio" name="payment_method" value="cod" checked="checked">Gerar boleto:</label>
                                                    </div>
                                                    <div class="radio">
                                                        <label><input type="radio" name="payment_method" value="cod" checked="checked">Pagar com cartão:</label>
                                                        <select name="shipping-payment-id" class="form-control">
                                                             <c:forEach var="creditcard" items="${customer.creditcardList}">                                                    
                                                                 <option value="${creditcard.id}" selected="selected">                                                                     
                                                                     Cartão final ${fn:substring(creditcard.number, 12, 16)}
                                                                 </option>
                                                             </c:forEach>
                                                         </select>
                                                    </div>
                                                </fieldset>
                                            </div>                                                                       
                                            <div class="col-sm-6">
                                                <fieldset id="account">
                                                    <legend>Cadastrar novo cartão</legend>                                             
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-payment-cardholder-name">Nome (Conforme aparece no cartão)</label>
                                                        <input form="createCreditCard" type="text" name="cardholder-name" placeholder="Nome" id="input-payment-cardholder-name" class="form-control">
                                                    </div>
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-payment-number">Número do cartão</label>
                                                        <input form="createCreditCard" type="number" name="number" id="input-payment-number" class="form-control">
                                                    </div> 
                                                        <div class="form-group required" data-toggle="tooltip" data-placement="top" title="">
                                                            <label class="control-label" for="input-card-member-since"><i class="fa fa-calendar"></i>Membro desde</label>
                                                            <input form="createCreditCard" type="date" name="member-since" id="input-card-member-since" class="form-control">                                                    
                                                        </div>
                                                        <div class="form-group required" data-toggle="tooltip" data-placement="top" title="">
                                                            <label class="control-label" for="input-card-expiration-date"><i class="fa fa-calendar"></i>Data de Validade</label>
                                                            <input form="createCreditCard" type="date" name="expiration-date" id="input-card-expiration-date" class="form-control">
                                                        </div>
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-payment-password">Código de Segurança</label>
                                                        <input form="createCreditCard" type="password" name="security-code" value="" id="input-payment-password" class="form-control">
                                                    </div> 
                                                    <button type="submit" form="createCreditCard" class="btn btn-success" value="Submit">Cadastrar cartão</button>
                                                </fieldset>
                                            </div>
                                        </div>                                         
                                        <div class="buttons">
                                            <div class="pull-left">
                                                <a href="#collapse-checkout-confirm" data-toggle="collapse" data-parent="#accordion" class="btn btn-primary">Continuar</a>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a href="#collapse-checkout-confirm" data-toggle="collapse" data-parent="#accordion" class="accordion-toggle collapsed" aria-expanded="false">Resumo do pedido <i class="fa fa-caret-down"></i></a></h4>
                                </div>
                                <div class="panel-collapse collapse" id="collapse-checkout-confirm" aria-expanded="false" style="height: 0px;">
                                    <div class="panel-body">
                                        <div class="table-responsive">
                                            <table class="table table-bordered">
                                                <thead>
                                                    <tr>
                                                        <td class="text-center">Imagem</td>
                                                        <td class="text-left">Produto</td>
                                                        <td class="text-left">Quantidade</td>
                                                        <td class="text-right">Preço</td>
                                                        <td class="text-right">Total</td>
                                                    </tr>
                                                </thead>
                                                <tbody id="checkout-product-list"></tbody>
                                            </table>
                                            
                                        </div>
                                        <p><strong>Adicione um comentários sobre o pedido (opcional):</strong></p>
                                        <p>
                                            <textarea name="comment" rows="8" class="form-control" placeholder=" "></textarea>
                                        </p>
                                        <span id="alert-dismissible"></span>                                        
                                        <div class="buttons">
                                            <div class="pull-right">Eu li e concordo com o contrato de <a href="/ZZZ_ag_908/livraria?rca=iIiD&information=5" class="agree" ><b>Termos e Condições</b></a>
                                                <input type="checkbox" name="agree" id="agree" value="1" data-toggle="tooltip" data-placement="top" title="Para solicitar o pedido, é necessáro ter lido e estar de acordo com os Termos e Condições.">
                                                &nbsp;                                                
                                                <!-- <input type="button" value="Confirmar pedido" id="button-confirm" data-loading-text="Carregando..." class="btn btn-primary"> -->
                                                <button id="header-authenticarion" type="submit" class="btn btn-primary">Confirmar pedido</button>
                                            </div>                                           
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <input type="hidden" name="orderProduct" value=""  id="orderProduct" >
                        </form>
                    </div>
                </div>
            </div>             
            <script src="js/checkout2.js" type="text/javascript"></script>
            <%@include file="/view/fragments/footer.jsp" %>            
        </div><!-- body_wrap -->
        
    </body>
</html>