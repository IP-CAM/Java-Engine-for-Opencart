<%-- 
    Document   : teste
    Created on : 10/03/2020, 19:54:01
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Página de resposta de teste</title>
    </head>
   <body style="background-color: #13181e;">
        <%@include file="/view/fragments/header.jsp" %> 
        <div>
            <label>User</label>${user}<br>
            <label>Token</label>${token}<br>
            <label>Authorities</label>${authorities}<br>
        </div>
    </body>
</html>
