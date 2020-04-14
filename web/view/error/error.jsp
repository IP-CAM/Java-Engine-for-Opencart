<!DOCTYPE html>
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>        
        <%@include file="/view/fragments/head.jsp" %>
        <title>Erro</title>
    </head>
    <body style="background-color: #13181e;">
         <div class="body_wrap">            
            <%@include file="/view/fragments/header.jsp" %>
            <div id="common-home" class="container">
                <div class="row">
                    <div id="content" class="col-sm-12"> 
                        <article>
                            <h1>Erro!!!</h1>  
                            <h3>${mensagemErro}</h3>
                            <button class="btn btn-lg btn-block btn-secondary text-uppercase" onclick="history.go(-1);" style="max-width: 300px;">Voltar</button>
                        </article>
                    </div>
                </div>
            </div>       
            <%@include file="/view/fragments/footer.jsp" %>
        </div> 
    </body>
</html>
