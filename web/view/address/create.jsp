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
        <title>Cadastrar endereço</title>
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
                        <h1>Cadastrar endereço de ${customerUserName}</h1>
                        <div class="panel-group" id="accordion">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><a href="#collapse-payment-address" data-toggle="collapse" data-parent="#accordion" class="accordion-toggle" aria-expanded="true">Detalhes da sua conta <i class="fa fa-caret-down"></i></a></h4>
                                </div>
                                <div class="panel-collapse collapse in" id="collapse-payment-address" aria-expanded="true" style="">
                                    <form class="panel-body" method="post" action="/ZZZ_ag_908/livraria?rca=aC1_">
                                        <div class="row">   
                                            <div class="col-sm-6">
                                                <fieldset id="address">
                                                    <legend>Seu endereço</legend>
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-address-postcode">CEP</label>
                                                        <input type="text" name="postcode" placeholder="CEP" id="input-address-postcode" class="form-control">
                                                    </div>

                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-address-address-1">Endereço</label>
                                                        <input type="text" name="address_1" placeholder="Endereço" id="input-address-address-1" class="form-control">
                                                    </div>
                                                    
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-address-company">Número</label>
                                                        <input type="text" name="houseNumbering" placeholder="000" id="input-address-house-numbering" class="form-control">
                                                    </div>
                                                    
                                                    <div class="form-group">
                                                        <label class="control-label" for="input-address-company">Complemento</label>
                                                        <input type="text" name="complements" placeholder="Complemento..." id="input-address-house-complements" class="form-control">
                                                    </div>
                                                    
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-address-address-2">Bairro</label>
                                                        <input type="text" name="address_2" placeholder="Bairro" id="input-address-address-2" class="form-control">
                                                    </div>
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-address-city">Cidade</label>
                                                        <input type="text" name="city" placeholder="Cidade" id="input-address-city" class="form-control">
                                                    </div>                                                                                                        
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-address-zone">Estado</label>                                                        
                                                        <input type="text" name="zone_id" placeholder="Estado" id="input-address-zone" class="form-control">
                                                    </div>
                                                    <input type="hidden" name="customerId" value="${customerId}" id="input-address-customerId" >
                                                </fieldset>
                                            </div>
                                        </div>                                        
                                        <div class="checkbox">
                                            <label><input type="checkbox" name="shipping_address" value="1" checked="checked">O endereço para entrega é o mesmo que estou cadastrando.</label>
                                        </div>
                                        
                                        <div class="buttons clearfix">	
                                            <button id="address-button-confirm" class="btn btn-primary pull-right" type="submit">Continuar</button>
                                        </div>
                                    </form>
                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>

            <%@include file="/view/fragments/footer.jsp" %>
        </div>
        <script src="/ZZZ_ag_908/js/formAddress.js"></script>
    </body>
</html>
