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
                <li><a href="#"><i class="fa fa-home"></i></a></li>
                <li>Minha conta</li>
            </ul>
            <div class="row">
                <div id="content" class="col-sm-9">
                    
                    <c:choose>
                        <c:when test="${empty customerList}">
                            Nenhum cliente encontrado
                        </c:when>
                        <c:otherwise>                                                         
                            <h1>Informações da conta</h1>
                            <c:forEach var="customer" items="${customerList}">
                                <form action="/ZZZ_ag_908/Servlet?action=edit" method="post" enctype="multipart/form-data" class="form-horizontal">
                                    <fieldset>
                                        <legend>Caso deseje, modifique as informações da sua conta</legend>
                                        <div class="form-group required">
                                            <label class="col-sm-2 control-label" for="input-fullName">Nome: </label>
                                            <div class="col-sm-10">
                                                <input type="text" name="fullName" value="${customer.fullName}" placeholder="Nome" id="input-fullName" class="form-control">
                                            </div>
                                        </div>                         
                                        <div class="form-group required">
                                            <label class="col-sm-2 control-label" for="input-email">Email: </label>
                                            <div class="col-sm-10">
                                                <input type="email" name="email" value="${customer.email}" placeholder="E-mail" id="input-email" class="form-control">
                                            </div>
                                        </div>
                                        <div class="form-group required">
                                            <label class="col-sm-2 control-label" for="input-telephone">Telefone: </label>
                                            <div class="col-sm-10">
                                                <input type="tel" name="telephone" value="${customer.telephone}" placeholder="telephone" id="input-telephone" class="form-control">
                                            </div>
                                        </div>
                                    </fieldset>
                                    <div class="buttons clearfix">
                                        <div class="pull-left"><a href="/ZZZ_ag_908/Servlet?action=account" class="btn btn-default">Voltar</a></div>
                                        <div class="pull-right">
                                            <input type="submit" value="Continuar" class="btn btn-primary">
                                        </div>
                                    </div>
                                </form>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
                <%@include file="/view/fragments/asideRight.jsp" %>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>            
        </div><!-- body_wrap -->
    </body>
</html>