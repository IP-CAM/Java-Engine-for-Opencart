<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Política de Privacidade</title>
    </head>
    <body style="background-color: #13181e;">
        <%@include file="/view/fragments/header.jsp" %>
        <%@include file="/view/fragments/navbar.jsp" %>

        <div id="information-information" class="container">
            <ul class="breadcrumb">
                <li><a href="http://localhost/loja?route=common/home"><i class="fa fa-home"></i></a></li>
                <li><a href="http://localhost/loja?route=information/information&amp;information_id=3">Política de Privacidade</a></li>
            </ul>
            <div class="row">
                <div id="content" class="col-sm-12">${information}%></div>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>            
        </div><!-- body_wrap -->
    </body>
</html>