<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- 
    Document   : Inserir
    Created on : 13/09/2019, 01:26:27
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Detalhe do carrinho de compras</title>
    </head>

    <body style="background-color: #13181e;">
        <div class="body_wrap">
            <%@include file="/view/fragments/header.jsp" %>

            <div id="checkout-cart" class="container">
                <ul class="breadcrumb">
                    <li><a href="/ZZZ_ag_908/home"><i class="fa fa-home"></i></a></li>
                    <li><a href="/ZZZ_ag_908/view/cart/detail.jsp">Carrinho de compras</a></li>
                </ul>
                <div class="row">
                    <div id="content" class="col-sm-12">
                        <h1>Carrinho de compras
                        </h1>
                        <div id="cartDetail">
                            <div class="table-responsive">
                                <table class="table table-bordered">
                                    <thead>
                                        <tr>
                                            <td class="text-center">Imagem</td>
                                            <td class="text-left">Produto</td>
                                            <td class="text-left">Quantidade</td>
                                            <td class="text-right">Preço</td>
                                            <td class="text-right">Total</td>
                                        </tr>
                                    </thead>
                                    <tbody id="checkout-product-list">
                                        <tr>
                                            <td class="text-right"><strong>Sub-total:</strong></td>
                                            <td class="text-right" id="subtotal">R$ </td>
                                        </tr>
                                        <tr>
                                            <td class="text-right"><strong>Frete:</strong></td>
                                            <td class="text-right" id="frete">R$ </td>
                                        </tr>
                                        <tr>
                                            <td class="text-right"><strong>Total:</strong></td>
                                            <td class="text-right" id="total">R$ </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                        </div>
                        <div class="buttons clearfix">
                            <div class="pull-left"><a href="/ZZZ_ag_908/home" class="btn btn-default">Continuar comprando...</a></div>
                            <c:choose>
                                <c:when test="${empty user}">
                                    <button id="btn-authenticarion" type="button" class="btn btn-default pull-right" data-toggle="modal" data-target="#ModalAuthentication">Autenticar para finalizar pedido</button>
                                </c:when>
                                <c:otherwise>
                                    <div class="pull-right"><a href="/ZZZ_ag_908/livraria?rca=unOC" class="btn btn-primary">Finalizar pedido</a></div>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>
        </div>
        <script src="js/checkout.js" type="text/javascript"></script>
    </body>
</html>
