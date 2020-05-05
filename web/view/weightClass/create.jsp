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
        <title>Cadastrar unidade de medida de peso</title>
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">

            <%@include file="/view/fragments/header.jsp" %> 
            <div id="checkout-checkout" class="container">
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>
                    <li>Peso</li>
                    <li>Cadastrar</li>
                </ul>
                <div class="row">
                    <div id="content" class="col-sm-12">
                        <h1>Cadastrar peso</h1>
                        <div class="panel-group" id="customer-register">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><i class="fa fa-id-card"></i>Cadastrar uma nova unidadde de peso</h4>
                                </div>
                                <div class="panel-collapse collapse in" id="collapse-payment-address" aria-expanded="true" style="">
                                    <form class="panel-body" method="post" enctype="application/x-www-form-urlencoded" action="/ZZZ_ag_908/ag?rsa=wC">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <fieldset id="account">
                                                    <legend>Dados da medida peso</legend>
                                                    <div class="form-group" style="display:  none ;">
                                                        <label class="control-label">Quem está gerenciando?</label>
                                                    </div>
                                                    <div class="form-group required">
                                                        <label class="control-label" for="title">Descrição</label>
                                                        <input type="text" name="title" value="" placeholder="Descrição..." id="title" class="form-control">
                                                    </div>                                                    
                                                    <div class="form-group required">
                                                        <label class="control-label" for="unit">Unidade</label>
                                                        <input type="text" name="unit" value="" placeholder="Un" id="unit" class="form-control">
                                                    </div>
                                                </fieldset>
                                            </div>                                   
                                        </div>                                                                               
                                        <div class="buttons clearfix">											                                            
                                            <button id="customer-button-confirm" class="btn btn-primary pull-right" type="submit">Continuar</button>
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
