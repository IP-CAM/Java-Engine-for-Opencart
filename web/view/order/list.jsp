<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp"%>
        <title>Histórico do pedido</title>
    </head>
    <body style="background-color: #13181e;">
        <%@include file="/view/fragments/header.jsp" %>
        <%@include file="/view/fragments/navbar.jsp" %>

        <div id="order-list" class="container">
            <ul class="breadcrumb">
                <li><a href="#"><i class="fa fa-home"></i></a></li> 
                <li><i class="fa fa-shopping-cart"></i></li>
            </ul>
            <div class="row">
                <div id="content" class="col-sm-12">
                    <h1>Lista de pedidos"></h1>
                    <c:choose>
                        <c:when test="${empty orderList}">
                            Nenhum pedido cadastrado
                        </c:when>
                        <c:otherwise>                                    
                            <div class="table-responsive">   
                                <!-- ${orderList} -->
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <td class="text-left">Data do pedido</td>
                                            <td class="text-left">Nome</td>
                                            <td class="text-left">Endereço de entrega</td>                                            
                                            <td class="text-left">Envio</td>
                                            <td class="text-left">Total</td>
                                        </tr>
                                    </thead>
                                    <tbody>                                                    
                                        <c:forEach var="order" items="${orderList}">
                                            <tr>
                                                
                                                    <td class="text-left">${order.dateAdded}</td>
                                                    <td class="text-left">${order.username}</td>                                                
                                                    <td class="text-left">${order.shippingAddress1}, ${order.shippingAddress2}, ${order.shippingAddress2}, ${order.shippingCity}, ${order.shippingZone}</td>                                                
                                                    <td class="text-left">${order.shippingMethod}</td>                                                
                                                    <td  class="tab-overflow">  
                                                        <span id="cart-total">
                                                            <fmt:formatNumber value = "${order.total}" type = "currency"/></span>
                                                    </td>
                                                    <td>
                                                        <form class="panel-body" method="post" action="/ZZZ_ag_908/livraria?rca=OIOD">
                                                            <input type="hidden" name="id" value="${order.id}" id="input-order-orderId" >
                                                            <button id="customer-button-confirm" class="btn btn-primary pull-right" type="submit">Exibir detalhe</button>
                                                        </form>
                                                    </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>                                        
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>            
        </div><!-- body_wrap -->
    </body>
</html>