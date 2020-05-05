    <!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br">    <!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Lista de clientes</title>
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">
            <%@include file="/view/fragments/header.jsp" %>
            <%@include file="/view/fragments/navbar.jsp" %>

            <div id="customer-category" class="container">
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>                    
                </ul>
                <div class="row">
                    <div id="content" class="col-sm-9">
                        <div class="row">
                            <c:choose>
                                <c:when test="${empty customerList}">
                                    Nenhum resultado
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="customer" items="${customerList}">
                                       <div class="customer-layout customer-grid col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                            <div class="customer-thumb">
                                                <div>
                                                    <div class="caption">
                                                        <h4><a href="http://localhost:8084/ZZZ_ag_908/ag?rsa=ptivptv&id=${customer.id}">${customer.username}</a></h4>
                                                        <p>..</p>
                                                        <p class="price"> R$ ${customer.email}</p>
                                                    </div>
                                                    <div class="button-group">
                                                        <button type="button" onclick="cart.add('${customer.id}');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Comprar</span></button>
                                                        <button type="button" data-toggle="tooltip" title="" onclick="wishlist.add('${customer.id}');" data-original-title="Lista de desejos"><i class="fa fa-heart"></i></button>
                                                        <button type="button" data-toggle="tooltip" title="" onclick="compare.add('${customer.id}');" data-original-title="Comparar"><i class="fa fa-exchange"></i></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>           
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>
        </div><!-- body_wrap -->

    </body>
</html>