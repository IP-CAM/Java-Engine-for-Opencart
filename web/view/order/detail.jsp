<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp"%>
        <title>Detalhe do pedido</title>
    </head>
    <body style="background-color: #13181e;">
        <%@include file="/view/fragments/header.jsp" %>
        <%@include file="/view/fragments/navbar.jsp" %>

        <div id="information-information" class="container">
            <ul class="breadcrumb">
                <li><a href="#"><i class="fa fa-home"></i></a></li>                
            </ul>
            <div class="row">
                <div id="content" class="col-sm-9">
                    <c:choose>
                        <c:when test="${empty orderList}">
                            Nenhum pedido cadastrado
                        </c:when>
                        <c:otherwise> 
                            <h2>Detalhe de pedidos</h2>
                            <c:forEach var="order" items="${orderList}">
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <td class="text-left" colspan="2">Informações do pedido</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="text-left" style="width: 50%;"> <b>Pedido nº:</b> ${order.id}<br>
                                                <b>Data do pedido:</b> ${order.dateAdded}
                                            </td>
                                            <td class="text-left" style="width: 50%;"> <b>Forma de pagamento:</b>${order.paymentMethod}<br>
                                                <b>Tipo de frete:</b>${order.shippingMethod}
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                                <table class="table table-bordered table-hover">
                                    <thead>
                                        <tr>
                                            <td class="text-left" style="width: 50%; vertical-align: top;">Endereço de faturamento</td>
                                            <td class="text-left" style="width: 50%; vertical-align: top;">Endereço de entrega</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr>
                                            <td class="text-left">${order.shippingUsername}<br>${order.paymentAddress1}<br>${order.paymentAddress2}<br>${order.paymentCity} ${order.paymentPostcode}<br>${order.paymentCountry}</td>
                                            <td class="text-left">${order.shippingUsername}<br>${order.shippingAddress1}<br>${order.shippingAddress2}<br>${order.shippingCity} ${order.shippingPostcode}<br><br>${order.shippingCountry}</td>
                                        </tr>
                                    </tbody>
                                </table>
                                <div class="table-responsive">
                                    <table class="table table-bordered table-hover">
                                        <thead>
                                            <tr>
                                                <td class="text-left">Produto</td>
                                                <td class="text-left">Modelo</td>
                                                <td class="text-right">Quantidade</td>
                                                <td class="text-right">Preço</td>
                                                <td class="text-right">Total</td>
                                                <td style="width: 20px;"></td>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="product" items="${order.orderProductList}">
                                                <tr>
                                                    <td class="text-left">${product.name}</td>
                                                    <td class="text-left">${product.model}</td>
                                                    <td class="text-left">${product.quantity}</td>                                                    
                                                    <td class="text-right"><fmt:formatNumber value = "${product.price}" type = "currency"/></td>
                                                    <td class="text-right"><fmt:formatNumber value = "${product.quantity * product.price}" type = "currency"/></td>
                                                    <td class="text-right" style="white-space: nowrap;">                                                        
                                                        <a href="/ZZZ_ag_908/livraria?rca=PIOD&id=${product.id}" data-toggle="tooltip" title="Solicitar devolução deste produto." class="btn btn-danger" data-original-title="Solicitar devolução"><i class="fa fa-reply"></i></a>
                                                    </td>
                                                </tr>
                                            </c:forEach>                                           
                                        </tbody>
                                        <tfoot>
                                            <c:forEach var="total" items="${order.orderTotalList}">
                                                <tr>
                                                    <td colspan="3"></td>
                                                    <td class="text-right"><b>${total.title}</b></td>
                                                    <td class="text-right"><fmt:formatNumber value = "${total.value}" type = "currency"/></td>
                                                    <td></td>
                                                </tr>                                                
                                            </c:forEach> 
                                        </tfoot>

                                    </table>
                                </div>
                                <h3>Histórico deste pedido</h3>
                                <table class="table table-bordered table-hover">
                                    <thead>                                        
                                        <tr>
                                            <td class="text-left">Data</td>
                                            <td class="text-left">Situação</td>
                                            <td class="text-left">Comentário</td>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="history" items="${order.orderHistoryList}">
                                            <tr>                                                
                                                <td class="text-left">${history.dateAdded}</td>
                                                <td class="text-left">${history.orderStatus.name}</td>
                                                <td class="text-left">${history.comment}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>

                                </table>
                                <div class="buttons clearfix">
                                    <div class="pull-right"><a href="javascript:history.back()" class="btn btn-primary">Voltar</a></div>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>              
            </div>            
            <%@include file="/view/fragments/footer.jsp" %>            
        </div><!-- body_wrap -->
    </body>
</html>