<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]--><head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Lista de produtos por fabricante</title>        
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">
            <%@include file="/view/fragments/header.jsp" %>
            <%@include file="/view/fragments/navbar.jsp" %>

            <div id="product-manufacturer" class="container">
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>
                    <li><a href="">Produtos por marca</a></li>
                </ul>
                <div class="row">
                    <div id="content" class="col-sm-12">
                        <h1>Produtos por marca</h1>
                        <p><strong>Índice alfabético:</strong>&nbsp;&nbsp;&nbsp;
                            <a href="#A">A</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#B">B</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#C">C</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#D">D</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#E">E</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#F">F</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#G">G</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#H">H</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#I">I</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#J">J</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#K">K</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#L">L</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#M">M</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#N">N</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#O">O</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#P">P</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#Q">Q</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#R">R</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#S">S</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#T">T</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#U">U</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#V">V</a>         &nbsp;&nbsp;&nbsp;
                            <a href="#W">W</a>
                        </p>
                        <c:set var = "string1" value = "B"/>
                        <c:forEach var="manufacturer" items="${manufacturerList}">
                            <c:choose>
                               <c:when test="${string1.charAt(0) ne manufacturer.name.charAt(0)}">                                                                        
                                    <h2>${manufacturer.name.charAt(0)}</h2>
                                    <c:set var = "string1" value = "${manufacturer.name}"/>
                                </c:when>                              
                            </c:choose>
      
                            <div class="row">
                                <div class="col-sm-3"><a href="ag?rsa=qPrL&findBy=Manufacturer&findBy=${manufacturer.id}">${manufacturer.name}</a></div>                               
                            </div>
                        </c:forEach>                        
                    </div>
                </div>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>
        </div><!-- body_wrap -->

    </body>
</html>