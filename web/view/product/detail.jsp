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
        <title>${product.name}</title>        
    </head>

    <body style="background-color: #13181e;">
        <div class="body_wrap">

            <%@include file="/view/fragments/header.jsp" %>
            <%@include file="/view/fragments/navbar.jsp" %>

            <div id="product-product" class="container">
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>
                    <li><a href="#">${product.name}</a></li>
                </ul>
                <div class="row">
                    <div id="content" class="col-sm-12">
                        <c:choose>
                            <c:when test="${empty productList}">
                                Nenhum produto encontrado.
                            </c:when>
                            <c:otherwise>
                                <c:forEach var="product" items="${productList}">
                                    <div class="row">
                                        <div class="col-sm-8">
                                            <ul class="thumbnails">
                                                <li><a class="thumbnail" href="${product.name}" title="${product.name}"><img src="img/${product.image}" title="${product.name}" alt="${product.name}"></a></li>
                                            </ul>
                                            <ul class="nav nav-tabs">
                                                <li class="active"><a href="#tab-description" data-toggle="tab">Descrição</a></li>
                                                <li><a href="#tab-review" data-toggle="tab">Comentários (0)</a></li>
                                            </ul>
                                            <div class="tab-content">
                                                <div class="tab-pane active" id="tab-description">
                                                    ${product.description}
                                                </div>
                                                <div class="tab-pane" id="tab-review">
                                                    <form class="form-horizontal" id="form-review">
                                                        <div id="review"><p>Não há comentários para este produto.</p>
                                                        </div>
                                                        <h2>Escreva um comentário</h2>
                                                        <div class="form-group required">
                                                            <div class="col-sm-12">
                                                                <label class="control-label" for="input-name">Seu name</label>
                                                                <input type="text" name="name" id="input-name" class="form-control">
                                                            </div>
                                                        </div>
                                                        <div class="form-group required">
                                                            <div class="col-sm-12">
                                                                <label class="control-label" for="input-review">Seu comentário</label>
                                                                <textarea name="text" rows="5" id="input-review" class="form-control"></textarea>
                                                                <div class="help-block"><span class="text-danger">Nota:</span> HTML não suportado.</div>
                                                            </div>
                                                        </div>
                                                        <div class="form-group required">
                                                            <div class="col-sm-12">
                                                                <label class="control-label">Avaliação</label>
                                                                &nbsp;&nbsp;&nbsp; Ruim&nbsp;
                                                                <input type="radio" name="rating" value="1">
                                                                &nbsp;
                                                                <input type="radio" name="rating" value="2">
                                                                &nbsp;
                                                                <input type="radio" name="rating" value="3">
                                                                &nbsp;
                                                                <input type="radio" name="rating" value="4">
                                                                &nbsp;
                                                                <input type="radio" name="rating" value="5">
                                                                &nbsp;Bom</div>
                                                        </div>
                                                        <div class="buttons clearfix">
                                                            <div class="pull-right">
                                                                <button type="button" id="button-review" data-loading-text="Carregando..." class="btn btn-primary">Continuar</button>
                                                            </div>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-sm-4">
                                            <div class="btn-group">
                                                <button type="button" data-toggle="tooltip" class="btn btn-default" title="" onclick="wishlist.add('${product.id}');" data-original-title="Lista de desejos"><i class="fa fa-heart"></i></button>
                                                <button type="button" data-toggle="tooltip" class="btn btn-default" title="" onclick="compare.add('${product.id}');" data-original-title="Comparar"><i class="fa fa-exchange"></i></button>
                                            </div>
                                            <h1>${product.name}</h1>
                                            <ul class="list-unstyled">
                                                <li>Marca: <a href="ag?rsa=ptpvptl&findBy=Manufacturer&searchValue=${product.manufacturer.id}">${product.manufacturer.name}</a></li>
                                                <li>Modelo: ${product.model}</li>
                                                <li>Disponibilidade:
                                                    <c:choose>                            
                                                        <c:when test="${product.quantity > 0}">
                                                            Em estoque
                                                        </c:when>
                                                        <c:otherwise>
                                                            ${product.stockStatus.name}
                                                        </c:otherwise>
                                                    </c:choose>
                                                </li>
                                                <li>
                                                    <c:forEach var="categoryL1" items="${product.categoryList}">
                                                        <a href="/ZZZ_ag_908/ag?rsa=ptpvptl&findBy=Category&searchValue=${categoryL1.id}">${categoryL1.name}</a>
                                                    </c:forEach>
                                                </li>
                                            </ul>
                                            <ul class="list-unstyled">
                                                <li>
                                                    <h2>
                                                        <span class="">R$ ${product.price}</span>
                                                    </h2>
                                                </li>
                                            </ul>
                                            <div id="product">
                                                <div class="form-group">                       
                                                    <button type="button" onclick="cart.add('${product.id}', '1');" id="button-cart" data-loading-text="Carregando..." class="btn btn-primary btn-lg btn-block">Comprar</button>
                                                </div>
                                            </div>
                                            <div class="rating">
                                                <p> 
                                                    <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                                    <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                                    <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                                    <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                                    <span class="fa fa-stack"><i class="fa fa-star-o fa-stack-1x"></i></span>
                                                    <a href="" onclick="$('a[href=\'#tab-review\']').trigger('click');
                                                    return false;">0 comentários</a> / <a href="" onclick="$('a[href=\'#tab-review\']').trigger('click');
                                                    return false;">Escreva um comentário</a>
                                                </p>                                                                      
                                            </div>
                                        </div>
                                    </div>
                                    <p>Etiquetas:
                                        <c:forEach var="tag" items="${fn:split(product.tag,',')}">
                                            <a href="/ZZZ_ag_908/Servlet?route=product/search&amp;tag=Banheiro">${tag}</a>,
                                        </c:forEach>
                                        <a href=""></a>
                                    </p>
                                </c:forEach>
                             </c:otherwise>
                        </c:choose>
                    </div>
                </div>
            </div>     
            <%@include file="/view/fragments/footer.jsp" %>
            
        </div>
    </body>
</html>
