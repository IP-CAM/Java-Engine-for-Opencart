<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<div class="swiper-viewport">
    <div id="carousel0" class="swiper-container swiper-container-horizontal">
        <div class="swiper-wrapper" style="transform: translate3d(-3622.4px, 0px, 0px); transition-duration: 0ms;">            
            <c:choose>
                <c:when test="${not empty bannerList}">                
                    <c:forEach var="banner_image" items="${bannerList[2].bannerImageList}"> 
                        <div class="swiper-slide text-center" data-swiper-slide-index="5" style="width: 226.4px;"><a href="${banner_image.link}"><img src="img/${banner_image.image}" alt="${banner_image.title}" class="img-responsive"></a></div>
                    </c:forEach>
                </c:when>
            </c:choose>
        </div>
        <div class="swiper-pagination carousel0 swiper-pagination-clickable swiper-pagination-bullets"><span class="swiper-pagination-bullet"></span>
            <span class="swiper-pagination-bullet"></span>
        </div>
        <div class="swiper-pager">
            <div class="swiper-button-next"></div>
            <div class="swiper-button-prev"></div>
        </div>
    </div>
</div>