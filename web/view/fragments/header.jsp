<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<script src="js/cart.js" type="text/javascript"></script>

<nav id="top">
    <div class="container"> 
        <div id="top-links" class="nav pull-right">
            <ul class="list-inline">
                <li><a href="/ZZZ_ag_908/view/information/privacyPolicy.jsp"><i class="fa fa-phone"></i></a> <span class="hidden-xs hidden-sm hidden-md">Fale conosco: (11) 0000 0000</span></li>
                    <c:choose>
                        <c:when test="${empty user}">
                            <li class="dropdown"><a href="#" title="Minha conta" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <span class="hidden-xs hidden-sm hidden-md">Minha conta</span><span class="caret"></span></a>
                                <ul class="dropdown-menu dropdown-menu-right">
                                    <li>
                                        <button id="header-registration" type="button" class="btn btn-inverse btn-block btn-sm dropdown-toggle"><a href="/ZZZ_ag_908/view/customer/register.jsp">Cadastre-se</a></button>
                                    </li>                                   
                                    <li>
                                        <button id="header-authenticarion" type="button" class="btn btn-inverse btn-block btn-sm dropdown-toggle" data-toggle="modal" data-target="#ModalAuthentication">Autenticar</button>
                                    </li>
                                </ul>
                             </li>
                        </c:when>
                        <c:otherwise>
                            <li class="dropdown"><a href="/ZZZ_ag_908/ag?rsa=cinvciv" title="Customer" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> <span class="hidden-xs hidden-sm hidden-md">${user}</span><span class="caret"></span></a>
                                <ul class="dropdown-menu dropdown-menu-right">                                
                                    <li><a href="/ZZZ_ag_908/ag?rsa=cinvciv">Minha conta</a></li>
                                    <li><a href="/ZZZ_ag_908/ag?rsa=odnvodl">Histórico de pedidos</a></li>
                                    <li><a href="/ZZZ_ag_908/Autenticacao?action=sair">Sair</a></li>
                                </ul>
                            </li>
                        </c:otherwise>
                    </c:choose>
               
                <li><a href="/ZZZ_ag_908/Servlet?route=account/wishlist" id="wishlist-total" title="Lista de desejos (0)"><i class="fa fa-heart"></i> <span class="hidden-xs hidden-sm hidden-md">Lista de desejos (0)</span></a></li>
                <li><a href="/ZZZ_ag_908/view/cart/detail.jsp" title="Carrinho de compras"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Carrinho de compras</span></a></li>
                <c:choose>
                    <c:when test="${!empty user}">
                        <li><a href="/ZZZ_ag_908/ag?rsa=cinvodc" title="Finalizar pedido"><i class="fa fa-share"></i> <span class="hidden-xs hidden-sm hidden-md">Finalizar pedido</span></a></li>
                    </c:when>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
<header>       
    <div class="container">
        <div class="row">
            <div class="col-sm-4">
                <div id="logo"><a href="/ZZZ_ag_908/home">
                    <img src="img/catalog/ag_logo1.png" title="${store}" alt="${store}" class="img-responsive"></a>
                </div>
            </div>
            <div class="col-sm-5">
                <div id="search" class="input-group">
                    <input type="text" name="search" value="" placeholder="Busca" class="form-control input-lg">
                    <span class="input-group-btn">
                        <button type="button" class="btn btn-default btn-lg"><i class="fa fa-search"></i></button>
                    </span>
                </div></div>
            <div class="col-sm-3">
                <div id="cart" class="btn-group btn-block">
                    <button type="button" data-toggle="dropdown" data-loading-text="Carregando..." class="btn btn-inverse btn-block btn-lg dropdown-toggle">
                        <i class="fa fa-shopping-cart"></i> 
                        <span id="cart-total">0 - R$0,00</span>
                    </button>
                    <ul class="dropdown-menu pull-right">
                        <li></li>                        
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <script src="js/cart.js" type="text/javascript"></script>
    
    <!-- Modal para login  --> 
    <div class="modal fade" id="ModalAuthentication"  role="dialog" aria-labelledby="Autenticação" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <form method="post" class="modal-content" action="/ZZZ_ag_908/Autenticacao">
                <div class="modal-header">
                    <div class="buttons clearfix">
                        <h5 class="pull-left modal-title" id="ModalLongTitle">Autenticação</h5>
                        <button type="button" class="close btn btn-primary pull-right" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">Fechar  </span><i class="fa fa-window-close"></i></button>
                    </div>                   
                </div>
                <div class="modal-body">  
                    <fieldset id="login">
                          <div class="form-group required">
                              <label for="login-username" class="control-label"><b>Nome de usuário</b></label>
                              <input id="login-username" type="text" placeholder="Apelido" name="username" class="form-control" required/>
                          <div class="form-group required">
                          </div>
                              <label for="login-password" class="control-label"><b>Senha</b></label>
                              <input id="login-password" type="password" placeholder="Digite tua senha" name="password" class="form-control" required/>				                            
                          </div>                         
                    </fieldset>
                </div>
                <div class="modal-footer">
                    <div class="buttons clearfix">
                        <button id="login-authentication" class="btn btn-success pull-left" type="submit">Autenticar</button>
                        <div class="pull-right  "><a href="/ZZZ_ag_908/view/customer/register.jsp" class="btn btn-default">Cadastrar</a></div>                                            
                    </div>
                </div>
            </form>                
        </div>
    </div>   
<!-- Fim do Modal para login  -->
</header>