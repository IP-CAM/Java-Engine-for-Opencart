<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%-- 
    Document   : Inserir
    Created on : 13/09/2019, 01:26:27
    Author     : Administrador
--%>

<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Devoluções</title>
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">            
            <%@include file="/view/fragments/header.jsp" %>            
            <div id="checkout-checkout" class="container">
                <ul class="breadcrumb">
                    <li><a href="#"><i class="fa fa-home"></i></a></li>
                    <li>Pedido</li>
                    <li>Solicitar devolução</li>
                </ul>
                <div class="row"> 
                    <div id="content" class="col-sm-9">
                        <c:choose>
                            <c:when test="${empty orderList}">
                                Pedido não encontrado
                            </c:when>
                            <c:otherwise> 
                                <h2>Devoluções</h2>
                                <c:forEach var="order" items="${orderList}">
                                    <p>Preencha o formulário abaixo com as informações do seu pedido e do produto que deseja devolver.</p>
                                    <form action="/ZZZ_ag_908/ag?rsa=rtcvrtm" method="post" class="form-horizontal" onsubmit="checkAgree(event)">
                                        <fieldset>                                            
                                            <legend>Informações do pedido</legend>
                                            <div class="form-group required">
                                                <label class="col-sm-2 control-label">Nome</label>
                                                <div>${order.shippingFullname}</div>
                                            </div>                               
                                            <div class="form-group required">
                                                <label class="col-sm-2 control-label">E-mail</label>
                                                <div>${order.email}</div>
                                            </div>
                                            <div class="form-group required">
                                                <label class="col-sm-2 control-label">Telefone</label>
                                                <div>${order.telephone}</div>
                                            </div>
                                            <div class="form-group required">   
                                                <label class="col-sm-2 control-label">Pedido nº</label>
                                                <div>Pedido nº ${order.id}</div>
                                                <input type="hidden" name="order-id" value="${order.id}" id="orderId" >
                                            </div>
                                            <div class="form-group">
                                                <label class="col-sm-2 control-label">Data do pedido</label>
                                                <div class="col-sm-3">
                                                    <div class="input-group date">${order.dateAdded} <i class="fa fa-calendar"></i></div>
                                                </div>
                                            </div>
                                        </fieldset>
                                        <fieldset>
                                            <legend>Informações do produto</legend>
                                            <c:forEach var="product" items="${order.orderProductList}">
                                                <c:choose>
                                                    <c:when test="${product.id == productId}">
                                                        <input type="hidden" name="product-id" value="${product.id}" id="product-id" >
                                                        <div class="form-group required">
                                                            <label class="col-sm-2 control-label" for="input-product-name">Produto</label>
                                                            <div class="col-sm-10">
                                                                <input type="text" name="productName" value="${product.name}" id="input-product-name" class="form-control" disabled>
                                                            </div>
                                                        </div>
                                                        <div class="form-group required">
                                                            <label class="col-sm-2 control-label" for="input-product-model">Modelo</label>
                                                            <div class="col-sm-10">
                                                                <input type="text" name="productModel" value="${product.model}" id="input-product-model" class="form-control" disabled>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-2 control-label" for="input-quantity">Quantidade</label>
                                                            <div class="col-sm-3">
                                                                <input type="number" name="quantity" value="${product.quantity}" max="${product.quantity}" min="1" id="input-product-quantity" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="form-group required">
                                                            <label class="col-sm-2 control-label">Motivo</label>
                                                            <div id="return-reason" class="col-sm-10"></div>
                                                        </div>
                                                        <script>
                                                            $.ajax({
                                                                url: 'ag?rsa=rraj',
                                                                type: 'POST',
                                                                dataType: 'json',
                                                                success: function (returnReason) {  
                                                                        var reasonNode = '<select name="return-reason" id="input-return-reason" class="form-control">';
                                                                        returnReason.forEach(function (reason) {
                                                                            reasonNode += '<option value="' + reason.id + '">' + reason.name + '</option>';                                                                                
                                                                        });                
                                                                        $('#return-reason').html(reasonNode + '</select>');

                                                                },
                                                                error: function (xhr, ajaxOptions, thrownError) {
                                                                        alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
                                                                }       
                                                            });
                                                        </script>
                                                        <div class="form-group required">
                                                            <label class="col-sm-2 control-label">Embalagem aberta?</label>
                                                            <div class="col-sm-10">
                                                                <label class="radio-inline">
                                                                <input type="radio" name="opened" value="1">Sim</label>
                                                                <label class="radio-inline">
                                                                <input type="radio" name="opened" value="0" checked="checked">Não</label>
                                                            </div>
                                                        </div>
                                                        <div class="form-group">
                                                            <label class="col-sm-2 control-label" for="input-comment">Detalhes</label>
                                                            <div class="col-sm-10">
                                                                <textarea name="comment" rows="10" placeholder="Detalhes" id="input-comment" class="form-control"></textarea>
                                                            </div>
                                                        </div>
                                                    </c:when>
                                                </c:choose>
                                            </c:forEach>
                                        </fieldset>
                                        <span id="alert-dismissible"></span> 
                                        <div class="buttons clearfix">
                                            <div class="pull-right">Eu li e concordo com os <a href="http://localhost/index.php?route=information/information/agree&amp;information_id=5" class="agree"><b>Termos e Condições</b></a>
                                                <input type="checkbox" name="agree" id="agree" value="1" data-toggle="tooltip" data-placement="top" title="Para solicitar devolução, é necessáro ter lido e estar de acordo com os Termos e Condições.">
                                                <button id="button-return-reason" type="submit" class="btn btn-primary">submit</button>
                                            </div>
                                        </div>
                                    </form>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <%@include file="/view/fragments/asideRight.jsp" %>
                </div>
            </div>
            <script src="js/checkAgree.js" type="text/javascript"></script>
            <%@include file="/view/fragments/footer.jsp" %>            
        </div><!-- body_wrap -->
    </body>
</html>