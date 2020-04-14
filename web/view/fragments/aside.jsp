<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<aside id="column-left" class="col-sm-3 hidden-xs">
    <div class="list-group">
        <c:forEach var="categoryL1" items="${categoryList}">              
            <c:forEach var="categoryL2" items="${categoryL1.categoryList}">
                <c:choose>
                    <c:when test="${empty categoryL2.categoryList}">
                        <a href="/ZZZ_ag_908/livraria?rca=PPpL&findBy=Category&searchValue=${categoryL2.id}" class="list-group-item">${categoryL2.name}</a>
                    </c:when>
                    <c:otherwise>    
                        <a href="/ZZZ_ag_908/livraria?rca=PPpL&findBy=Category&searchValue=${categoryL2.id}" class="list-group-item">${categoryL2.name}</a>
                        <c:forEach var="categoryL3" items="${categoryL2.categoryList}">
                            <a href="/ZZZ_ag_908/livraria?rca=PPpL&findBy=Category&searchValue=${categoryL3.id}" class="list-group-item">&nbsp;&nbsp;&nbsp;- ${categoryL3.name}</a>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </c:forEach>
    </div>

    <div class="swiper-viewport">
        <div id="banner0" class="swiper-container swiper-container-horizontal swiper-container-fade">
            <div class="swiper-wrapper" style="transition-duration: 0ms;">      <div class="swiper-slide swiper-slide-prev" style="width: 255px; opacity: 1; transform: translate3d(0px, 0px, 0px); transition-duration: 0ms;"><a href="/ZZZ_ag_908?route=product/manufacturer/info&amp;manufacturer_id=12"><img src="http://localhost/image/cache/catalog/Campanha/krona-produtos-182x182.jpg" alt="Vedacit" class="img-responsive"></a></div>
                <div class="swiper-slide swiper-slide-active" style="width: 255px; opacity: 1; transform: translate3d(-255px, 0px, 0px); transition-duration: 0ms;"><a href="ZZZ_ag_908?route=product/manufacturer/info&amp;manufacturer_id=9"><img src="http://localhost/image/cache/catalog/Campanha/images-182x182.jpg" alt="Astra" class="img-responsive"></a></div>
                <div class="swiper-slide swiper-slide-next" style="width: 255px; opacity: 0; transform: translate3d(-510px, 0px, 0px); transition-duration: 0ms;"><a href="ZZZ_ag_908?route=product/category&amp;path=2"><img src="http://localhost/image/cache/catalog/Campanha/tubos_e_conexoes-182x182.jpg" alt="Tubos e Conexões" class="img-responsive"></a></div>
                <div class="swiper-slide" style="width: 255px; opacity: 0; transform: translate3d(-765px, 0px, 0px); transition-duration: 0ms;"><img src="http://localhost/image/cache/catalog/Campanha/índice-182x182.jpg" alt="Krona" class="img-responsive"></div>
            </div>
        </div>
    </div>
    <script type="text/javascript"><!--
    $('#banner0').swiper({
            effect: 'fade',
            autoplay: 2500,
            autoplayDisableOnInteraction: false
        });
    --></script> 
</aside>