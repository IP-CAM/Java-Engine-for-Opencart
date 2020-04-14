<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Detalhe da conta</title> 
    </head>
    <body style="background-color: #13181e;">
        <%@include file="/view/fragments/header.jsp" %>

        <div id="information-information" class="container">
            <ul class="breadcrumb">
                <li><a href="http://localhost/loja?route=common/home"><i class="fa fa-home"></i></a></li>
                <li><a href="http://localhost/loja?route=information/information&amp;information_id=3">Política de Privacidade</a></li>
            </ul>
            <div class="row">
                <div id="content" class="col-sm-9">
                    <h1>Informações da conta</h1>
                    <form action="/ZZZ_ag_908/livraria?action=edit" method="post" enctype="multipart/form-data" class="form-horizontal">
                        <fieldset>
                            <legend>Caso deseje, modifique as informações da sua conta</legend>
                            <div class="form-group required">
                                <label class="col-sm-2 control-label" for="input-fullName">${customer.fullName} </label>
                                <div class="col-sm-10">
                                    <input type="text" name="fullName" value="${customer.fullName}" placeholder="Nome" id="input-fullName" class="form-control">
                                </div>
                            </div>                         
                            <div class="form-group required">
                                <label class="col-sm-2 control-label" for="input-email">${customer.email}</label>
                                <div class="col-sm-10">
                                    <input type="email" name="email" value="${customer.email}" placeholder="E-mail" id="input-email" class="form-control">
                                </div>
                            </div>
                            <div class="form-group required">
                                <label class="col-sm-2 control-label" for="input-telephone">${customer.telephone}</label>
                                <div class="col-sm-10">
                                    <input type="tel" name="telephone" value="${customer.telephone}" placeholder="telephone" id="input-telephone" class="form-control">
                                </div>
                            </div>
                        </fieldset>
                        <div class="buttons clearfix">
                            <div class="pull-left"><a href="/ZZZ_ag_908/livraria?action=account" class="btn btn-default">Voltar</a></div>
                            <div class="pull-right">
                                <input type="submit" value="Continuar" class="btn btn-primary">
                            </div>
                        </div>
                    </form>
                </div>
                <%@include file="/view/fragments/asideRight.jsp" %>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>            
        </div><!-- body_wrap -->
    </body>
</html>