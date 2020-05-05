<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<h3>Destaques</h3>
<div class="row">
    <c:forEach var="featuredProductList" items="${store.featuredProduct}">
        <c:forEach var="product" items="${featuredProductList.productList}">
            <div class="product-layout col-lg-3 col-md-3 col-sm-6 col-xs-12">
                <div class="product-thumb transition">
                    <div class="image"><a href="/ZZZ_ag_908/ag?rsa=ptivptv&id=${product.id}"><img src="/ZZZ_ag_908/img/${product.image}" alt="${product.metaTitle}" title="${product.name}" class="img-responsive"></a></div>
                    <div class="caption">
                        <h4><a href="/ZZZ_ag_908/ag?rsa=ptivptv&id=${product.id}">${product.name}</a></h4>
                        <!-- <p>${product.description}</p> -->
                        <p class="price">
                            R$ ${product.price}
                        </p>
                    </div>
                    <div class="button-group">
                        <button type="button" onclick="cart.add('${product.id}');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Comprar</span></button>
                        <button type="button" data-toggle="tooltip" title="" onclick="wishlist.add('${product.id}');" data-original-title="Lista de desejos"><i class="fa fa-heart"></i></button>
                        <button type="button" data-toggle="tooltip" title="" onclick="compare.add('${product.id}');" data-original-title="Comparar"><i class="fa fa-exchange"></i></button>
                    </div>
                </div>
            </div>
        </c:forEach>
    </c:forEach>
</div>