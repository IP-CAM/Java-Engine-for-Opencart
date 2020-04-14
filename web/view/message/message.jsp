<%-- 
    Document   : teste
    Created on : 10/03/2020, 19:54:01
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/view/fragments/head.jsp"%>
        <title>Mensagem</title>
    </head>
   <body style="background-color: #13181e;">
        <div class="body_wrap">            
            <%@include file="/view/fragments/header.jsp" %>
            <div id="common-home" class="container">
                <div class="row">
                    <div id="content" class="col-sm-12"> 
                        <article>                            
                            <h3>${mensagemErro}</h3>                            
                        </article>
                    </div>
                </div>
            </div>       
            <%@include file="/view/fragments/footer.jsp" %>
        </div> 
    </body>
</html>
