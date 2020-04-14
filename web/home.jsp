<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%-- 
    Document   : Inserir
    Created on : 13/09/2019, 01:26:27
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>        
        <%@include file="/view/fragments/head.jsp" %> 
        <title>Sonhos e Construção</title> 
        
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">
            
            <%@include file="/view/fragments/header.jsp" %>            
            
            <div id="common-home" class="container">
                <div class="row">
                    <div id="content" class="col-sm-12">
                        <div class="swiper-viewport">
                            <div id="slideshow0" class="swiper-container swiper-container-horizontal">
                                 <div class="swiper-wrapper" style="transform: translate3d(-3486px, 0px, 0px); transition-duration: 0ms;">
                                   <c:forEach var="banner_image" items="${banner[3].bannerImageList}">                                   
                                        <div class="swiper-slide text-center swiper-slide-active" data-swiper-slide-index="2" style="width: 1132px; margin-right: 30px;">
                                            <a href="${banner_image.link}">
                                                <img src="img/${banner_image.image}" alt="${banner_image.title}" class="img-responsive"></a>
                                        </div>
                                    </c:forEach>                                    
                                </div>
                            </div>
                            <div class="swiper-pagination slideshow0 swiper-pagination-clickable swiper-pagination-bullets"><span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span></div>
                            <div class="swiper-pager">
                                <div class="swiper-button-next"></div>
                                <div class="swiper-button-prev"></div>
                            </div>
                        </div>
                        <script type="text/javascript"><!--
                        $('#slideshow0').swiper({
                                mode: 'horizontal',
                                slidesPerView: 1,
                                pagination: '.slideshow0',
                                paginationClickable: true,
                                nextButton: '.swiper-button-next',
                                prevButton: '.swiper-button-prev',
                                spaceBetween: 30,
                                autoplay: 2500,
                                autoplayDisableOnInteraction: true,
                                loop: true
                            });
                        --></script>
                        
                        <%@include file="/view/fragments/featured_products.jsp" %>                        
                        <%@include file="/view/fragments/banner_manufacturer.jsp"%>
                        
                        <script type="text/javascript"><!--
                        $('#carousel0').swiper({
                                mode: 'horizontal',
                                slidesPerView: 5,
                                pagination: '.carousel0',
                                paginationClickable: true,
                                nextButton: '.swiper-button-next',
                                prevButton: '.swiper-button-prev',
                                autoplay: 2500,
                                loop: true
                            });
                        --></script>
                    </div>
                </div>
            </div>       
            <%@include file="/view/fragments/footer.jsp" %>
        </div>        
    </body>
</html>
   