<!DOCTYPE html>
<!--[if IE]><![endif]-->
<!--[if IE 8 ]><html dir="ltr" lang="pt-br" class="ie8"><![endif]-->
<!--[if IE 9 ]><html dir="ltr" lang="pt-br" class="ie9"><![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html dir="ltr" lang="pt-br"><!--<![endif]--><head>
        <%@include file="/view/fragments/head.jsp" %>
        <title>Categoria</title>
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">
            <%@include file="/view/fragments/header.jsp" %>
            <%@include file="/view/fragments/navbar.jsp" %>

            <div id="product-category" class="container">
                <ul class="breadcrumb">
                    <li><a href="/ZZZ_ag_908/livraria?route=common/home"><i class="fa fa-home"></i></a></li>
                    <li><a href="/ZZZ_ag_908/livraria?route=product/category&amp;path=1">Elétricos</a></li>
                    <li><a href="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70">Luminárias</a></li>
                </ul>
                <div class="row">
                    <%@include file="/view/fragments/aside.jsp" %>

                    <div id="content" class="col-sm-9">
                        <c:forEach var="categoryL1" items="${category}">
                            <h2>${categoryL1.name}</h2>
                        </c:forEach>
                        <div class="row">
                            <div class="col-md-2 col-sm-6 hidden-xs">
                                <div class="btn-group btn-group-sm">
                                    <button type="button" id="list-view" class="btn btn-default" data-toggle="tooltip" title="" data-original-title="Lista"><i class="fa fa-th-list"></i></button>
                                    <button type="button" id="grid-view" class="btn btn-default active" data-toggle="tooltip" title="" data-original-title="Grade"><i class="fa fa-th"></i></button>
                                </div>
                            </div>
                            <div class="col-md-3 col-sm-6">
                                <div class="form-group"><a href="/ZZZ_ag_908/livraria?route=product/compare" id="compare-total" class="btn btn-link">Produtos para comparar (0)</a></div>
                            </div>
                            <div class="col-md-4 col-xs-6">
                                <div class="form-group input-group input-group-sm">
                                    <label class="input-group-addon" for="input-sort">Organizar por:</label>
                                    <select id="input-sort" class="form-control" onchange="location = this.value;">
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;sort=p.sort_order&amp;order=ASC" selected="selected">Padrão</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;sort=pd.name&amp;order=ASC">Nome (A - Z)</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;sort=pd.name&amp;order=DESC">Nome (Z - A)</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;sort=p.price&amp;order=ASC">Preço (menor &gt; maior)</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;sort=p.price&amp;order=DESC">Preço (maior &gt; menor)</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;sort=rating&amp;order=DESC">Avaliação (maior)</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;sort=rating&amp;order=ASC">Avaliação (menor)</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;sort=p.model&amp;order=ASC">Modelo (A - Z)</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;sort=p.model&amp;order=DESC">Modelo (Z - A)</option>
                                    </select>
                                </div>
                            </div>
                            <div class="col-md-3 col-xs-6">
                                <div class="form-group input-group input-group-sm">
                                    <label class="input-group-addon" for="input-limit">Exibir:</label>
                                    <select id="input-limit" class="form-control" onchange="location = this.value;">
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;limit=15" selected="selected">15</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;limit=25">25</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;limit=50">50</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;limit=75">75</option>
                                        <option value="/ZZZ_ag_908/livraria?route=product/category&amp;path=1_70&amp;limit=100">100</option>
                                    </select>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            
                            <div class="product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <div class="product-thumb">
                                    <div class="image"><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=2962"><img src="Lumin%C3%A1rias_arquivos/placeholder-300x400.png" alt="ENGESUL LUMINARIA DE EMERGENCIA BIVOLT" title="ENGESUL LUMINARIA DE EMERGENCIA BIVOLT" class="img-responsive"></a></div>
                                    <div>
                                        <div class="caption">
                                            <h4><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=2962">ENGESUL LUMINARIA DE EMERGENCIA BIVOLT</a></h4>
                                            <p>..</p>
                                            <p class="price">                   R$22,00
                                            </p>
                                        </div>
                                        <div class="button-group">
                                            <button type="button" onclick="cart.add('2962', '1');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Comprar</span></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="wishlist.add('2962');" data-original-title="Lista de desejos"><i class="fa fa-heart"></i></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="compare.add('2962');" data-original-title="Comparar"><i class="fa fa-exchange"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <div class="product-thumb">
                                    <div class="image"><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=4716"><img src="Lumin%C3%A1rias_arquivos/placeholder-300x400.png" alt="FOXLUX LUMINARIA DE EMERGENCIA 30LEDS" title="FOXLUX LUMINARIA DE EMERGENCIA 30LEDS" class="img-responsive"></a></div>
                                    <div>
                                        <div class="caption">
                                            <h4><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=4716">FOXLUX LUMINARIA DE EMERGENCIA 30LEDS</a></h4>
                                            <p>..</p>
                                            <p class="price">                   R$37,00
                                            </p>
                                        </div>
                                        <div class="button-group">
                                            <button type="button" onclick="cart.add('4716', '1');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Comprar</span></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="wishlist.add('4716');" data-original-title="Lista de desejos"><i class="fa fa-heart"></i></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="compare.add('4716');" data-original-title="Comparar"><i class="fa fa-exchange"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <div class="product-thumb">
                                    <div class="image"><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=5391"><img src="Lumin%C3%A1rias_arquivos/placeholder-300x400.png" alt="LUMINARIA 2X20W BLUMENAU" title="LUMINARIA 2X20W BLUMENAU" class="img-responsive"></a></div>
                                    <div>
                                        <div class="caption">
                                            <h4><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=5391">LUMINARIA 2X20W BLUMENAU</a></h4>
                                            <p>..</p>
                                            <p class="price">                   R$36,00
                                            </p>
                                        </div>
                                        <div class="button-group">
                                            <button type="button" onclick="cart.add('5391', '1');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Comprar</span></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="wishlist.add('5391');" data-original-title="Lista de desejos"><i class="fa fa-heart"></i></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="compare.add('5391');" data-original-title="Comparar"><i class="fa fa-exchange"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <div class="product-thumb">
                                    <div class="image"><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=50479"><img src="Lumin%C3%A1rias_arquivos/placeholder-300x400.png" alt="LUMINARIA DE JARDIM (SOLAR)" title="LUMINARIA DE JARDIM (SOLAR)" class="img-responsive"></a></div>
                                    <div>
                                        <div class="caption">
                                            <h4><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=50479">LUMINARIA DE JARDIM (SOLAR)</a></h4>
                                            <p>..</p>
                                            <p class="price">                   R$17,00
                                            </p>
                                        </div>
                                        <div class="button-group">
                                            <button type="button" onclick="cart.add('50479', '1');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Comprar</span></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="wishlist.add('50479');" data-original-title="Lista de desejos"><i class="fa fa-heart"></i></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="compare.add('50479');" data-original-title="Comparar"><i class="fa fa-exchange"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="product-layout product-grid col-lg-4 col-md-4 col-sm-6 col-xs-12">
                                <div class="product-thumb">
                                    <div class="image"><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=7539"><img src="Lumin%C3%A1rias_arquivos/placeholder-300x400.png" alt="SAINT LUMINARIA LED " title="SAINT LUMINARIA LED " class="img-responsive"></a></div>
                                    <div>
                                        <div class="caption">
                                            <h4><a href="/ZZZ_ag_908/livraria?route=product/product&amp;path=1_70&amp;product_id=7539">SAINT LUMINARIA LED </a></h4>
                                            <p>..</p>
                                            <p class="price">                   R$14,00
                                            </p>
                                        </div>
                                        <div class="button-group">
                                            <button type="button" onclick="cart.add('7539', '1');"><i class="fa fa-shopping-cart"></i> <span class="hidden-xs hidden-sm hidden-md">Comprar</span></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="wishlist.add('7539');" data-original-title="Lista de desejos"><i class="fa fa-heart"></i></button>
                                            <button type="button" data-toggle="tooltip" title="" onclick="compare.add('7539');" data-original-title="Comparar"><i class="fa fa-exchange"></i></button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-6 text-left"></div>
                            <div class="col-sm-6 text-right">Exibindo de 1 a 5 do total de 5 (1 páginas)</div>
                        </div>
                    </div>
                </div>
            </div>
            <footer>
                <div class="container">
                    <div class="row">
                        <div class="col-sm-3">
                            <h5>Informações</h5>
                            <ul class="list-unstyled">
                                <li><a href="/ZZZ_ag_908/livraria?route=information/information&amp;information_id=4">Sobre nós</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=information/information&amp;information_id=6">Informação sobre fretes e entregas</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=information/information&amp;information_id=3">Política de Privacidade</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=information/information&amp;information_id=5">Termos e Condições</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-3">
                            <h5>Serviços ao cliente</h5>
                            <ul class="list-unstyled">
                                <li><a href="/ZZZ_ag_908/livraria?route=information/contact">Entre em contato</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=account/return/add">Solicitar devolução</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=information/sitemap">Mapa do site</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-3">
                            <h5>Outros serviços</h5>
                            <ul class="list-unstyled">
                                <li><a href="/ZZZ_ag_908/livraria?route=product/manufacturer">Produtos por marca</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=account/voucher">Comprar vale presentes</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=affiliate/login">Programa de afiliados</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=product/special">Produtos em promoção</a></li>
                            </ul>
                        </div>
                        <div class="col-sm-3">
                            <h5>Minha conta</h5>
                            <ul class="list-unstyled">
                                <li><a href="/ZZZ_ag_908/livraria?route=account/account">Minha conta</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=account/order">Histórico de pedidos</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=account/wishlist">Lista de desejos</a></li>
                                <li><a href="/ZZZ_ag_908/livraria?route=account/newsletter">Informativo</a></li>
                            </ul>
                        </div>
                    </div>
                    <hr>
                    <p>Desenvolvido com tecnologia <a href="http://www.opencart.com/">OpenCart</a><br> Sonhos e Construção © 2020</p>
                </div>
            </footer>
            <!--
            OpenCart is open source software and you are free to remove the powered by OpenCart if you want, but its generally accepted practise to make a small donation.
            Please donate via PayPal to donate@opencart.com
            //-->
        </div><!-- body_wrap -->

    </body></html>