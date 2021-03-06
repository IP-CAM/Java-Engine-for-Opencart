    <!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br">    <!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp" %>         
        <title>Lista de produtos</title>        
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">
            <%@include file="/view/fragments/header.jsp" %>
            <%@include file="/view/fragments/navbar.jsp" %>

            <div id="product-category" class="container">
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>
                    <li><a href="#">CategoriaL1</a></li>
                    <li><a href="#">CategoriaL2</a></li>
                </ul>
                <div class="row">
                    <%@include file="/view/fragments/aside.jsp"%>
                    <div id="content" class="col-sm-9">
                        <c:choose>
                            <c:when test="${findBy eq 'Category'}">
                                ${productList[0].categoryList[0].name}
                            </c:when>
                            <c:when test="${findBy eq 'Manufacturer'}">
                                ${productList[0].manufacturer.name}
                            </c:when>
                        </c:choose>        
                        <div class="row">
                            <div class="col-md-2 col-sm-6 hidden-xs">
                                <div class="btn-group btn-group-sm">
                                    <button type="button" id="list-view" class="btn btn-default" data-toggle="tooltip" title="" data-original-title="Lista"><i class="fa fa-th-list"></i></button>
                                    <button type="button" id="grid-view" class="btn btn-default active" data-toggle="tooltip" title="" data-original-title="Grade"><i class="fa fa-th"></i></button>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6">
                                <div class="form-group"><a href="/ZZZ_ag_908/Servlet?route=product/compare" id="compare-total" class="btn btn-link">Produtos para comparar (0)</a></div>
                            </div>
                            <div class="col-md-4 col-xs-6">
                                <div class="form-group input-group input-group-sm">
                                    <label class="input-group-addon" for="input-sort">Organizar por:</label>
                                    <select id="input-sort" class="form-control" onchange="location = this.value;">
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;sort=p.sort_order&amp;order=ASC" selected="selected">Padrão</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;sort=pd.name&amp;order=ASC">Nome (A - Z)</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;sort=pd.name&amp;order=DESC">Nome (Z - A)</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;sort=p.price&amp;order=ASC">Preço (menor &gt; maior)</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;sort=p.price&amp;order=DESC">Preço (maior &gt; menor)</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;sort=rating&amp;order=DESC">Avaliação (maior)</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;sort=rating&amp;order=ASC">Avaliação (menor)</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;sort=p.model&amp;order=ASC">Modelo (A - Z)</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;sort=p.model&amp;order=DESC">Modelo (Z - A)</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3 col-xs-6">
                                <div class="form-group input-group input-group-sm">
                                    <label class="input-group-addon" for="input-limit">Exibir:</label>
                                    <select id="input-limit" class="form-control" onchange="location = this.value;">
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;limit=15" selected="selected">15</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;limit=25">25</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;limit=50">50</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;limit=75">75</option>
                                        <option value="/ZZZ_ag_908/Servlet?route=product/category&amp;path=1_70&amp;limit=100">100</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <c:choose>
                                <c:when test="${empty productList}">
                                    Nenhum resultado
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="product" items="${productList}">
                                        <div class="product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                            <div class="product-thumb">
                                                <div class="image">
                                                    <a href="/ZZZ_ag_908/ag?rsa=ptivptv&id=${product.id}">
                                                        <img src="img/${product.image}" alt="${product.name}" title="${product.name}" class="img-responsive">
                                                    </a>
                                                </div>
                                                <div>
                                                    <div class="caption">
                                                        <h4><a href="http://localhost:8084/ZZZ_ag_908/ag?rsa=ptivptv&id=${product.id}">${product.name}</a></h4>
                                                        <p>..</p>
                                                        <p class="price"> R$ ${product.price}</p>
                                                    </div>
                                                    <div class="button-group">
                                                        <button type="button" title="Adicioar ao carrinho de compras" onclick="cart.add('${product.id}');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Comprar</span></button>
                                                        <button type="button" data-toggle="tooltip" title="Adicionar à lista de desejo" onclick="wishlist.add('${product.id}');" data-original-title="Lista de desejos"><i class="fa fa-heart"></i></button>
                                                        <button type="button" data-toggle="tooltip" title="Adicioar à lista de comparação entre produtos" onclick="compare.add('${product.id}');" data-original-title="Comparar"><i class="fa fa-exchange"></i></button>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>                
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-left">                                
                                    <ul class="pagination">                                        
                                        <c:choose>
                                            <c:when test="${pageNumber == 0}">
                                                <li><span><i class="fa fa-arrow-stop"></i></span></li> 
                                            </c:when>
                                            <c:otherwise>
                                                <li><a href="/ZZZ_ag_908/ag?rsa=pgpvptl&page=0"><i class="fa fa-step-backward"></i></a></li>
                                                <li><a href="/ZZZ_ag_908/ag?rsa=pgpvptl&page=${pageNumber - 1}"><i class="fa fa-caret-left"></i></a></li>                                                
                                            </c:otherwise>
                                        </c:choose>
                                        <%
                                            int initial_Page = (Integer) request.getAttribute("initialPage");
                                            int final_Page = (Integer) request.getAttribute("finalPage");
                                            int pageNav = (Integer) request.getAttribute("pageNumber");
                                            for(int i = initial_Page; i <= final_Page ; i += 1) {
                                               if(pageNav == i){
                                                    %>
                                                        <li class="active"><span>${pageNumber + 1 }</span></li> <!-- A numerção da página começa em um, mas a variável começa em zero. -->
                                                    <%
                                                }else{
                                                    %>
                                                        <li><a href="/ZZZ_ag_908/ag?rsa=pgpvptl&page=<%=i%>"><%=i + 1 %></a></li> <!-- A numerção da página começa em um, mas a variável começa em zero. -->
                                                    <%
                                                }
                                            }
                                        %>                                        
                                        <c:choose>
                                            <c:when test="${lastPage == true}">
                                                <li><span><i class="fa fa-arrow-stop"></i></span></li>
                                            </c:when>
                                            <c:otherwise>                                                
                                                <li><a href="/ZZZ_ag_908/ag?rsa=papvptl&page=${pageNumber + 1}&findBy=${pagination.findBy}&searchValue=${pagination.searchValue}"><i class="fa fa-caret-right"></i></a></li>
                                                <li><a href="/ZZZ_ag_908/ag?rsa=papvptl&page=${pageQuantity}"><i class="fa fa-step-forward"></i></a></li>
                                            </c:otherwise>
                                        </c:choose>
                                    </ul>
                            </div>
                            <div class="col-sm-6 text-right">Exibindo de 1 a 15 do total de ${itensQuantity} (${pageQuantity+1} páginas)</div>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>
        </div><!-- body_wrap -->

    </body>
</html>