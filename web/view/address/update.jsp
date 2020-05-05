<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%-- 
    Document   : User register
    Created on : 05/03/2020, 01:26:27
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>        
        <%@include file="/view/fragments/head.jsp" %>
        <title>Atualizar endereço</title>
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">

            <%@include file="/view/fragments/header.jsp" %> 
            <div id="checkout-checkout" class="container">
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>
                    <li><a href="cart.html">Carrinho de compras</a></li>
                </ul>
                <div class="row">
                    <div id="content" class="col-sm-12">
                        <h1>Atualizar endereço</h1>
                        <c:choose>
                            <c:when test="${empty address}">
                                Nenhum endereço cadastrado
                            </c:when>
                            <c:otherwise>
                                <div class="panel-group" id="accordion">
                                    <div class="panel panel-default">                                       
                                        <div class="panel-collapse collapse in" id="collapse-payment-address" aria-expanded="true" style="">
                                            <form class="panel-body" method="post" action="/ZZZ_ag_908/ag?rsa=aUaL">
                                                <div class="row">   
                                                    <div class="col-sm-6">
                                                        <fieldset id="address">
                                                            <legend>Teu endereço</legend> 
                                                            <div class="form-group required">
                                                                <label class="control-label" for="input-address-postcode">CEP</label>
                                                                <input type="text" name="postcode" value="${address.logradouro.postcode}" placeholder="CEP" id="input-address-postcode" class="form-control">
                                                            </div>

                                                            <div class="form-group required">
                                                                <label class="control-label" for="input-address-address-1">Endereço</label>
                                                                <input type="text" name="address_1" value="${address.logradouro.tipoLogradouro} ${address.logradouro.logradouro}" placeholder="Endereço" id="input-address-address-1" class="form-control">
                                                            </div>

                                                            <div class="form-group required">
                                                                <label class="control-label" for="input-address-company">Número</label>
                                                                <input type="text" name="houseNumbering" value="${address.houseNumbering}" placeholder="000" id="input-address-house-numbering" class="form-control">
                                                            </div>

                                                            <div class="form-group">
                                                                <label class="control-label" for="input-address-company">Complemento</label>
                                                                <input type="text" name="complements" value="${address.complements}" placeholder="Complemento..." id="input-address-house-complements" class="form-control">
                                                            </div>

                                                            <div class="form-group required">
                                                                <label class="control-label" for="input-address-address-2">Bairro</label>
                                                                <input type="text" name="address_2" value="${address.logradouro.bairro.name}" placeholder="Bairro" id="input-address-address-2" class="form-control">
                                                            </div>
                                                            <div class="form-group required">
                                                                <label class="control-label" for="input-address-city">Cidade</label>
                                                                <input type="text" name="city" value="${address.logradouro.bairro.cidade.name}" placeholder="Cidade" id="input-address-city" class="form-control">
                                                            </div>                                                                                                        
                                                            <div class="form-group required">
                                                                <label class="control-label" for="input-address-zone">Estado</label>                                                        
                                                                <input type="text" name="zone_id" value="${address.logradouro.bairro.cidade.estado.name}" placeholder="Estado" id="input-address-zone" class="form-control">
                                                            </div>
                                                            <input type="hidden" name="addressId" value="${address.id}" id="input-address-id" >
                                                            <input type="hidden" name="customerId" value="${address.customer.id}" id="input-customer-id" >
                                                        </fieldset>
                                                    </div>
                                                </div>                                        
                                                <div class="checkbox">
                                                    <label><input type="checkbox" name="shipping_address" value="1" checked="checked">O endereço para entrega é o mesmo que estou cadastrando.</label>
                                                </div>
                                                <div class="buttons clearfix">											                                            
                                                    <button class="btn btn-primary pull-right" type="submit">Continuar</button>
                                                </div>
                                            </form>
                                        </div>
                                    </div> 
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>
        </div>
        <script src="/ZZZ_ag_908/js/formAddress.js"></script>
    </body>
</html>
