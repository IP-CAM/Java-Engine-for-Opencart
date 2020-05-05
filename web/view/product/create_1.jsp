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
        <title>Cadastrar produto</title>
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">

            <%@include file="/view/fragments/header.jsp" %> 
            <div id="checkout-checkout" class="container">
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>
                    <li>Produto</li>
                    <li>Cadastrar</li>
                </ul>
                <div class="row">
                    <div id="content" class="col-sm-12">
                        <h1>Cadastrar produto</h1>
                        <div class="panel-group" id="customer-register">
                            <div class="panel panel-primary">
                                <div class="panel-heading">
                                    <h4 class="panel-title"><i class="fa fa-id-card"></i>Cadastrar um novo produto</h4>
                                </div>
                                <div class="panel-collapse collapse in" id="collapse-payment-address" aria-expanded="true" style="">
                                    <form class="panel-body" method="post" action="/ZZZ_ag_908/ag?rsa=uCaC">
                                        <div class="row">
                                            <div class="col-sm-6">
                                                <fieldset id="account">
                                                    <legend>Dados do produto</legend>
                                                    <div class="form-group" style="display:  none ;">
                                                        <label class="control-label">Quem está gerenciando?</label>
                                                    </div>
                                                    <div class="form-group required">
                                                        <label class="control-label" for="name">Nome do produto</label>
                                                        <input type="text" name="name" value="" placeholder="Nome" id="input-customer-fullname" class="form-control">
                                                    </div>                                                    
                                                    <div class="form-group required">
                                                        <label class="control-label" for="description">Descrição</label>
                                                        <input type="text" name="description" value="" placeholder="Descrição" id="input-customer-email" class="form-control">
                                                    </div>
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-customer-telephone"><i class="fa fa-phone"></i> Telefone</label>
                                                        <input type="text" name="telephone" value="" placeholder="Telefone" id="input-customer-telephone" class="form-control">
                                                    </div>
                                                    <div class="form-group required">
                                                        <label class="control-label" for="input-customer-taxid" ><i class="fa fa-id-card-o"></i> CPF</label>
                                                        <input type="text" name="taxid" value="" placeholder="CPF" id="input-customer-taxid" class="form-control" data-toggle="tooltip" data-placement="top" title="Necessário para emissão de nota fiscal">
                                                    </div>
                                                    <div class="form-group required" data-toggle="tooltip" data-placement="top" title="Necessário em respeito à Legislação sobre restrição de idade. Exemplo: maior de 18 anos.">
                                                        <label class="control-label" for="input-customer-date-of-birthday"><i class="fa fa-calendar"></i>  Data de nascimento</label>
                                                        <input type="date" name="birthday" id="input-customer-date-of-birthday" class="form-control">
                                                    </div>
                                                    <div class="form-group required radio-red" data-toggle="tooltip" data-placement="top" title="Importante, mas não obrigatório, para campanhas, tais como Ouutubro Rosa e Novembro Azul">
                                                        <label class="label">Sexo:</label>
                                                       
                                                        <label for="male"><i class="fa fa-mars"></i>  Masculino</label>
                                                        <input type="radio" name="gender" value="m" id="input-customer-gender-male">
                                                        <label for="female"><i class="fa fa-venus"></i>  Feminino</label>
                                                        <input type="radio" name="gender" value="f" id="input-customer-gender-female">                                                        
                                                        
                                                    </div>
                                                </fieldset>
                                                <fieldset>
                                                    <legend>Credenciais de acesso à conta</legend>
                                                    <div class="form-group required" data-toggle="tooltip" data-placement="top" title="Apelido de livre escolha utilizado para acessar a conta.">
                                                        <label class="control-label" for="username"><i class="fa fa-tag"></i>  Nome de usuário (apelido)</label>
                                                        <input type="text" name="username" placeholder="Nome de usuário" id="input-customer-username" class="form-control">
                                                    </div> 
                                                    <div class="form-group required" data-toggle="tooltip" data-placement="top" title="Senha utilizada para acessar a conta.">
                                                        <label class="control-label" for="input-customer-password"><i class="fa fa-key"></i>  Senha</label>
                                                        <input type="password" name="password" value="" placeholder="Senha" id="input-customer-password" class="form-control">
                                                    </div>
                                                    <div class="form-group required" data-toggle="tooltip" data-placement="top" title="Repetição da senha acima.">
                                                        <label class="control-label" for="input-customer-confirm"><i class="fa fa-key"></i>  Repetir a senha</label>
                                                        <input type="password" name="confirmpassword" value="" placeholder="Repetir a senha" id="input-customer-confirm" class="form-control">
                                                    </div>
                                                </fieldset>
                                            </div>                                   
                                        </div>
                                        <div class="checkbox">
                                            <label for="newsletter">
                                                <input type="checkbox" name="newsletter" value="1" id="newsletter">
                                                Deseja receber novidades, ofertas e promoções da loja Sonhos e Construção em seu e-mail?</label>
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
