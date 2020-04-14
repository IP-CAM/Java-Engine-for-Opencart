<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br">    <!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Lista de endereços</title>        
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">
            <%@include file="/view/fragments/header.jsp" %>           

            <div id="product-category" class="container">
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>
                    <li><a href="#">Cliente</a></li>
                    <li><a href="#">Endereço</a></li>
                </ul>
                <div class="row">
                    <div id="content" class="col-sm-12 col-lg-12 col-xs-12">
                        <h2>Lista de endereços</h2>
                        <c:choose>
                                <c:when test="${empty addressList}">
                                    Nenhum endereço cadastrado
                                </c:when>
                                <c:otherwise>                                    
                                        <div class="table-responsive">   
                                            <!-- ${addressList} -->
                                            <table class="table table-bordered table-hover">
                                                <thead>
                                                    <tr>
                                                        <td class="text-left">CEP</td>
                                                        <td class="text-left">Endereço</td>
                                                        <td class="text-left">Número</td>
                                                        <td class="text-left">Complemento</td>
                                                        <td class="text-left">Bairro</td>
                                                        <td class="text-left">Cidade</td>
                                                        <td class="text-left">Estado</td>
                                                    </tr>
                                                </thead>
                                                <tbody>                                                    
                                                    <c:forEach var="address" items="${addressList}">
                                                        <tr>
                                                            <td class="text-left">${address.logradouro.postcode}</td>
                                                            <td class="text-left">${address.logradouro.tipoLogradouro} ${address.logradouro.logradouro}</td>
                                                            <td class="text-left">${address.houseNumbering}</td>
                                                            <td class="text-left">${address.complements}</td>
                                                            <td class="text-left">${address.logradouro.bairro.name}</td>
                                                            <td class="text-left">${address.logradouro.bairro.cidade.name}</td>
                                                            <td class="text-left">${address.logradouro.bairro.cidade.estado.name}</td>
                                                            <td class="text-right"><a href="/ZZZ_ag_908/livraria?rca=aIaU&addressId=${address.id}" class="btn btn-info">Editar</a></td>
                                                            <td class="text-right"><a href="/ZZZ_ag_908/livraria?rca=aIaE&addressId=${address.id}" class="btn btn-danger">Excluir</a></td>
                                                        </tr>
                                                    </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>                                        
                                </c:otherwise>
                        </c:choose>
                        <div class="buttons clearfix">
                            <div class="pull-left"><a href="javascript:window.history.go(-1)" class="btn btn-default">Voltar</a></div>
                            <div class="pull-right"><a href="/ZZZ_ag_908/livraria?rca=unaC" class="btn btn-primary">Novo endereço</a></div>
                        </div>
                    </div>
                </div>

            </div>
            <%@include file="/view/fragments/footer.jsp" %>
        </div><!-- body_wrap -->

    </body>
</html>