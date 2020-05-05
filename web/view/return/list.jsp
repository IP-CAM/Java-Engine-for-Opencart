<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp"%>
        <title>Histórico de devoluções</title>
    </head>
    <body style="background-color: #13181e;">
        <%@include file="/view/fragments/header.jsp" %>
        <%@include file="/view/fragments/navbar.jsp" %>

        <div id="return-list" class="container">
            <ul class="breadcrumb">
                <li><a href="#"><i class="fa fa-home"></i></a></li> 
                <li><i class="fa fa-shopping-cart"></i></li>
            </ul>
            <div class="row">
                <div id="content" class="col-sm-12">
                    <h1>Lista de pedidos devoluções</h1>
                    <div class="table-responsive">                                                                                
                        <c:choose>
                            <c:when test="${empty customerList}">
                                Não há nenhum pedido de devolução.
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="customer" items="${customerList}">
                                    <div class="table-responsive"> 
                                        <table class="table table-breturned table-hover">
                                            <thead>
                                                <tr>
                                                    <td class="text-left">Data</td>
                                                    <td class="text-left">Nome</td>
                                                    <td class="text-left">Pedido Nº</td>
                                                    <td class="text-left">Produto</td>
                                                    <td class="text-left">Atividades</td>                                            
                                                    <td class="text-left">Motivo</td>
                                                    <td class="text-left">Situação</td>
                                                </tr>
                                            </thead>
                                            <tbody>                                                    
                                                <c:forEach var="returnEach" items="${customer.returnList}">
                                                    <tr>
                                                        <td class="text-left">${returnEach.dateAdded}</td>
                                                        <td class="text-left">${returnEach.fullname}</td>
                                                        <td class="text-left">${returnEach.order.id}</td>
                                                        <td class="text-left">${returnEach.productName}</td>
                                                        <td class="text-left">${returnEach.returnAction.name}</td>
                                                        <td class="text-left">${returnEach.returnReason.name}</td>
                                                        <td class="text-left">${returnEach.returnStatus.name}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>            
        </div><!-- body_wrap -->
    </body>
</html>