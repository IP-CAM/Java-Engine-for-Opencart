<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%-- 
    Document   : User register
    Created on : 05/03/2020, 01:26:27
    Author     : Administrador
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html dir="ltr" lang="pt-br"><!--<![endif]-->
    <head>        
        <%@include file="/view/fragments/head.jsp" %>
        <link href="javascript/summernote/summernote.css" rel="stylesheet" type="text/css">
        <title>Cadastrar produto</title>
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">

            <%@include file="/view/fragments/header.jsp" %> 
            <div id="checkout-checkout" class="container">
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>
                    <li>Produto</li>
                    <li>Cadastrar</li>
                </ul>

                <div class="container-fluid">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-pencil"></i> Novo produto</h3>
                        </div>
                        <div class="panel-body">
                            <form action="http://localhost/admin/index.php?route=catalog/product/add&amp;user_token=o2lwBgL1Fk4340WOBU60JcUeHn99jjnS" method="post" enctype="multipart/form-data" id="form-product" class="form-horizontal">
                                <ul class="nav nav-tabs">
                                    <li class="active"><a href="#tab-general" data-toggle="tab">Geral</a></li>
                                    <li><a href="#tab-data" data-toggle="tab">Dados</a></li>
                                    <li><a href="#tab-links" data-toggle="tab">Ligações</a></li>
                                    <li><a href="#tab-attribute" data-toggle="tab">Atributos</a></li>
                                    <li><a href="#tab-option" data-toggle="tab">Opções</a></li>
                                    <li><a href="#tab-recurring" data-toggle="tab">Assinaturas</a></li>
                                    <li><a href="#tab-discount" data-toggle="tab">Descontos</a></li>
                                    <li><a href="#tab-special" data-toggle="tab">Promoções</a></li>
                                    <li><a href="#tab-image" data-toggle="tab">Imagens</a></li>
                                    <li><a href="#tab-reward" data-toggle="tab">Pontos</a></li>
                                    <li><a href="#tab-seo" data-toggle="tab">SEO</a></li>
                                    <li><a href="#tab-design" data-toggle="tab">Design</a></li>
                                </ul>
                                <div class="tab-content">
                                    <div class="tab-pane active" id="tab-general">
                                        <ul class="nav nav-tabs" id="language">
                                            <li class="active"><a href="#language2" data-toggle="tab" aria-expanded="true"><img src="img/flag/pt-br.png" title="Português"> Português</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div class="tab-pane active" id="language2">
                                                <div class="form-group required">
                                                    <label class="col-sm-2 control-label" for="input-name2">Produto</label>
                                                    <div class="col-sm-10">
                                                        <input type="text" name="product_description[2][name]" value="" placeholder="Produto" id="input-name2" class="form-control">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="col-sm-2 control-label" for="input-description2">Descrição</label>
                                                    <div class="col-sm-10">
                                                        <textarea name="product_description[2][description]" placeholder="Descrição" id="input-description2" data-toggle="summernote" data-lang="pt-BR" class="form-control" style="display: none;">
                                                        </textarea>
                                                        <div class="note-editor note-frame panel panel-default">
                                                            <div class="note-dropzone">
                                                                <div class="note-dropzone-message"></div>
                                                            </div>
                                                            <div class="note-toolbar panel-heading">
                                                                <div class="note-btn-group btn-group note-style">
                                                                    <div class="note-btn-group btn-group">
                                                                        <button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Estilo"><i class="fa fa-magic"></i> <span class="note-icon-caret"></span></button>
                                                                        <div class="dropdown-menu dropdown-style">
                                                                            <ul class="nav nav-tabs">
                                                                                <li><a href="#" data-value="p"><p>p</p></a></li>
                                                                                <li><a href="#" data-value="blockquote"><blockquote>Citação</blockquote></a></li>
                                                                                <li><a href="#" data-value="pre"><pre>Código</pre></a></li>
                                                                                <li><a href="#" data-value="h1"><h1>Título 1</h1></a></li>
                                                                                <li><a href="#" data-value="h2"><h2>Título 2</h2></a></li>
                                                                                <li><a href="#" data-value="h3"><h3>Título 3</h3></a></li>
                                                                                <li><a href="#" data-value="h4"><h4>Título 4</h4></a></li>
                                                                                <li><a href="#" data-value="h5"><h5>Título 5</h5></a></li>
                                                                                <li><a href="#" data-value="h6"><h6>Título 6</h6></a></li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="note-btn-group btn-group note-font">
                                                                    <button type="button" class="note-btn btn btn-default btn-sm note-btn-bold" tabindex="-1" title="" data-original-title="Negrito (CTRL+B)"><i class="fa fa-bold"></i></button>
                                                                    <button type="button" class="note-btn btn btn-default btn-sm note-btn-underline" tabindex="-1" title="" data-original-title="Sublinhado (CTRL+U)"><i class="fa fa-underline"></i></button>
                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Remover estilo da fonte (CTRL+\)"><i class="fa fa-eraser"></i></button>
                                                                </div>
                                                                <div class="note-btn-group btn-group note-fontname">
                                                                    <div class="note-btn-group btn-group">
                                                                        <button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Fonte"><span class="note-current-fontname">Open Sans</span><span class="note-icon-caret"></span></button>
                                                                        <div class="dropdown-menu note-check dropdown-fontname">
                                                                            <ul class="nav nav-tabs">
                                                                                <li><a href="#" data-value="Arial" class=""><i class="note-icon-check"></i> <span style="font-family:Arial">Arial</span></a></li>
                                                                                <li><a href="#" data-value="Arial Black" class=""><i class="note-icon-check"></i> <span style="font-family:Arial Black">Arial Black</span></a></li>
                                                                                <li><a href="#" data-value="Comic Sans MS" class=""><i class="note-icon-check"></i> <span style="font-family:Comic Sans MS">Comic Sans MS</span></a></li>
                                                                                <li><a href="#" data-value="Courier New" class=""><i class="note-icon-check"></i> <span style="font-family:Courier New">Courier New</span></a></li>
                                                                                <li><a href="#" data-value="Helvetica" class=""><i class="note-icon-check"></i> <span style="font-family:Helvetica">Helvetica</span></a></li>
                                                                                <li><a href="#" data-value="Impact" class=""><i class="note-icon-check"></i> <span style="font-family:Impact">Impact</span></a></li>
                                                                                <li><a href="#" data-value="Tahoma" class=""><i class="note-icon-check"></i> <span style="font-family:Tahoma">Tahoma</span></a></li>
                                                                                <li><a href="#" data-value="Times New Roman" class=""><i class="note-icon-check"></i> <span style="font-family:Times New Roman">Times New Roman</span></a></li>
                                                                                <li><a href="#" data-value="Verdana" class=""><i class="note-icon-check"></i> <span style="font-family:Verdana">Verdana</span></a></li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="note-btn-group btn-group note-fontsize">
                                                                    <div class="note-btn-group btn-group">
                                                                        <button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Tamanho da fonte"><span class="note-current-fontsize">13</span><span class="note-icon-caret"></span></button>
                                                                        <div class="dropdown-menu note-check dropdown-fontsize">
                                                                            <ul class="nav nav-tabs">
                                                                                <li><a href="#" data-value="8" class=""><i class="note-icon-check"></i> 8</a></li>
                                                                                <li><a href="#" data-value="9" class=""><i class="note-icon-check"></i> 9</a></li>
                                                                                <li><a href="#" data-value="10" class=""><i class="note-icon-check"></i> 10</a></li>
                                                                                <li><a href="#" data-value="11" class=""><i class="note-icon-check"></i> 11</a></li>
                                                                                <li><a href="#" data-value="12" class=""><i class="note-icon-check"></i> 12</a></li>
                                                                                <li><a href="#" data-value="14" class=""><i class="note-icon-check"></i> 14</a></li>
                                                                                <li><a href="#" data-value="18" class=""><i class="note-icon-check"></i> 18</a></li>
                                                                                <li><a href="#" data-value="24" class=""><i class="note-icon-check"></i> 24</a></li>
                                                                                <li><a href="#" data-value="36" class=""><i class="note-icon-check"></i> 36</a></li>
                                                                            </ul>
                                                                        </div>
                                                                    </div>
                                                                </div>
                                                                <div class="note-btn-group btn-group note-color">
                                                                    <div class="note-btn-group btn-group note-color"><button type="button" class="note-btn btn btn-default btn-sm note-current-color-button" tabindex="-1" title="" data-original-title="Cor recente" data-backcolor="#FFFF00"><i class="fa fa-font note-recent-color"></i></button>
                                                                        <button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Mais cores"><i class="fa fa-caret-down"></i></button>
                                                                        <div class="dropdown-menu">
                                                                            <div class="btn-group">
                                                                                <div class="note-palette-title">Fundo</div>
                                                                                <div>
                                                                                    <button type="button" class="note-color-reset btn btn-default" data-event="backColor" data-value="inherit">Transparente    </button>
                                                                                        </div>
                                                                                        <div class="note-holder" data-event="backColor">
                                                                                            <div class="note-color-palette">
                                                                                                <div class="note-color-row">
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#000000" data-event="backColor" data-value="#000000" title="" data-toggle="button" tabindex="-1" data-original-title="#000000"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#424242" data-event="backColor" data-value="#424242" title="" data-toggle="button" tabindex="-1" data-original-title="#424242"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#636363" data-event="backColor" data-value="#636363" title="" data-toggle="button" tabindex="-1" data-original-title="#636363"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#9C9C94" data-event="backColor" data-value="#9C9C94" title="" data-toggle="button" tabindex="-1" data-original-title="#9C9C94"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#CEC6CE" data-event="backColor" data-value="#CEC6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#CEC6CE"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#EFEFEF" data-event="backColor" data-value="#EFEFEF" title="" data-toggle="button" tabindex="-1" data-original-title="#EFEFEF"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#F7F7F7" data-event="backColor" data-value="#F7F7F7" title="" data-toggle="button" tabindex="-1" data-original-title="#F7F7F7"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FFFFFF" data-event="backColor" data-value="#FFFFFF" title="" data-toggle="button" tabindex="-1" data-original-title="#FFFFFF"></button>
                                                                                                </div>
                                                                                                <div class="note-color-row">
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FF0000" data-event="backColor" data-value="#FF0000" title="" data-toggle="button" tabindex="-1" data-original-title="#FF0000"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FF9C00" data-event="backColor" data-value="#FF9C00" title="" data-toggle="button" tabindex="-1" data-original-title="#FF9C00"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FFFF00" data-event="backColor" data-value="#FFFF00" title="" data-toggle="button" tabindex="-1" data-original-title="#FFFF00"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#00FF00" data-event="backColor" data-value="#00FF00" title="" data-toggle="button" tabindex="-1" data-original-title="#00FF00"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#00FFFF" data-event="backColor" data-value="#00FFFF" title="" data-toggle="button" tabindex="-1" data-original-title="#00FFFF"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#0000FF" data-event="backColor" data-value="#0000FF" title="" data-toggle="button" tabindex="-1" data-original-title="#0000FF"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#9C00FF" data-event="backColor" data-value="#9C00FF" title="" data-toggle="button" tabindex="-1" data-original-title="#9C00FF"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FF00FF" data-event="backColor" data-value="#FF00FF" title="" data-toggle="button" tabindex="-1" data-original-title="#FF00FF"></button>
                                                                                                </div>
                                                                                                <div class="note-color-row">
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#F7C6CE" data-event="backColor" data-value="#F7C6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#F7C6CE"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FFE7CE" data-event="backColor" data-value="#FFE7CE" title="" data-toggle="button" tabindex="-1" data-original-title="#FFE7CE"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FFEFC6" data-event="backColor" data-value="#FFEFC6" title="" data-toggle="button" tabindex="-1" data-original-title="#FFEFC6"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#D6EFD6" data-event="backColor" data-value="#D6EFD6" title="" data-toggle="button" tabindex="-1" data-original-title="#D6EFD6"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#CEDEE7" data-event="backColor" data-value="#CEDEE7" title="" data-toggle="button" tabindex="-1" data-original-title="#CEDEE7"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#CEE7F7" data-event="backColor" data-value="#CEE7F7" title="" data-toggle="button" tabindex="-1" data-original-title="#CEE7F7"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#D6D6E7" data-event="backColor" data-value="#D6D6E7" title="" data-toggle="button" tabindex="-1" data-original-title="#D6D6E7"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#E7D6DE" data-event="backColor" data-value="#E7D6DE" title="" data-toggle="button" tabindex="-1" data-original-title="#E7D6DE"></button>
                                                                                                </div>
                                                                                                <div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#E79C9C" data-event="backColor" data-value="#E79C9C" title="" data-toggle="button" tabindex="-1" data-original-title="#E79C9C"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FFC69C" data-event="backColor" data-value="#FFC69C" title="" data-toggle="button" tabindex="-1" data-original-title="#FFC69C"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FFE79C" data-event="backColor" data-value="#FFE79C" title="" data-toggle="button" tabindex="-1" data-original-title="#FFE79C"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#B5D6A5" data-event="backColor" data-value="#B5D6A5" title="" data-toggle="button" tabindex="-1" data-original-title="#B5D6A5"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#A5C6CE" data-event="backColor" data-value="#A5C6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#A5C6CE"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#9CC6EF" data-event="backColor" data-value="#9CC6EF" title="" data-toggle="button" tabindex="-1" data-original-title="#9CC6EF"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#B5A5D6" data-event="backColor" data-value="#B5A5D6" title="" data-toggle="button" tabindex="-1" data-original-title="#B5A5D6"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#D6A5BD" data-event="backColor" data-value="#D6A5BD" title="" data-toggle="button" tabindex="-1" data-original-title="#D6A5BD"></button>
                                                                                                </div>
                                                                                                <div class="note-color-row">
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#E76363" data-event="backColor" data-value="#E76363" title="" data-toggle="button" tabindex="-1" data-original-title="#E76363"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#F7AD6B" data-event="backColor" data-value="#F7AD6B" title="" data-toggle="button" tabindex="-1" data-original-title="#F7AD6B"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FFD663" data-event="backColor" data-value="#FFD663" title="" data-toggle="button" tabindex="-1" data-original-title="#FFD663"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#94BD7B" data-event="backColor" data-value="#94BD7B" title="" data-toggle="button" tabindex="-1" data-original-title="#94BD7B"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#73A5AD" data-event="backColor" data-value="#73A5AD" title="" data-toggle="button" tabindex="-1" data-original-title="#73A5AD"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#6BADDE" data-event="backColor" data-value="#6BADDE" title="" data-toggle="button" tabindex="-1" data-original-title="#6BADDE"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#8C7BC6" data-event="backColor" data-value="#8C7BC6" title="" data-toggle="button" tabindex="-1" data-original-title="#8C7BC6"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#C67BA5" data-event="backColor" data-value="#C67BA5" title="" data-toggle="button" tabindex="-1" data-original-title="#C67BA5"></button>
                                                                                                </div>
                                                                                                <div class="note-color-row">
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#CE0000" data-event="backColor" data-value="#CE0000" title="" data-toggle="button" tabindex="-1" data-original-title="#CE0000"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#E79439" data-event="backColor" data-value="#E79439" title="" data-toggle="button" tabindex="-1" data-original-title="#E79439"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#EFC631" data-event="backColor" data-value="#EFC631" title="" data-toggle="button" tabindex="-1" data-original-title="#EFC631"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#6BA54A" data-event="backColor" data-value="#6BA54A" title="" data-toggle="button" tabindex="-1" data-original-title="#6BA54A"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#4A7B8C" data-event="backColor" data-value="#4A7B8C" title="" data-toggle="button" tabindex="-1" data-original-title="#4A7B8C"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#3984C6" data-event="backColor" data-value="#3984C6" title="" data-toggle="button" tabindex="-1" data-original-title="#3984C6"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#634AA5" data-event="backColor" data-value="#634AA5" title="" data-toggle="button" tabindex="-1" data-original-title="#634AA5"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#A54A7B" data-event="backColor" data-value="#A54A7B" title="" data-toggle="button" tabindex="-1" data-original-title="#A54A7B"></button>
                                                                                                </div>
                                                                                                <div class="note-color-row">
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#9C0000" data-event="backColor" data-value="#9C0000" title="" data-toggle="button" tabindex="-1" data-original-title="#9C0000"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#B56308" data-event="backColor" data-value="#B56308" title="" data-toggle="button" tabindex="-1" data-original-title="#B56308"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#BD9400" data-event="backColor" data-value="#BD9400" title="" data-toggle="button" tabindex="-1" data-original-title="#BD9400"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#397B21" data-event="backColor" data-value="#397B21" title="" data-toggle="button" tabindex="-1" data-original-title="#397B21"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#104A5A" data-event="backColor" data-value="#104A5A" title="" data-toggle="button" tabindex="-1" data-original-title="#104A5A"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#085294" data-event="backColor" data-value="#085294" title="" data-toggle="button" tabindex="-1" data-original-title="#085294"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#311873" data-event="backColor" data-value="#311873" title="" data-toggle="button" tabindex="-1" data-original-title="#311873"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#731842" data-event="backColor" data-value="#731842" title="" data-toggle="button" tabindex="-1" data-original-title="#731842"></button>
                                                                                                </div><div class="note-color-row">
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#630000" data-event="backColor" data-value="#630000" title="" data-toggle="button" tabindex="-1" data-original-title="#630000"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#7B3900" data-event="backColor" data-value="#7B3900" title="" data-toggle="button" tabindex="-1" data-original-title="#7B3900"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#846300" data-event="backColor" data-value="#846300" title="" data-toggle="button" tabindex="-1" data-original-title="#846300"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#295218" data-event="backColor" data-value="#295218" title="" data-toggle="button" tabindex="-1" data-original-title="#295218"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#083139" data-event="backColor" data-value="#083139" title="" data-toggle="button" tabindex="-1" data-original-title="#083139"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#003163" data-event="backColor" data-value="#003163" title="" data-toggle="button" tabindex="-1" data-original-title="#003163"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#21104A" data-event="backColor" data-value="#21104A" title="" data-toggle="button" tabindex="-1" data-original-title="#21104A"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#4A1031" data-event="backColor" data-value="#4A1031" title="" data-toggle="button" tabindex="-1" data-original-title="#4A1031"></button>
                                                                                                </div>
                                                                                            </div>
                                                                                        </div>
                                                                                    </div>
                                                                                    <div class="btn-group">
                                                                                        <div class="note-palette-title">Fonte</div>
                                                                                        <div><button type="button" class="note-color-reset btn btn-default" data-event="removeFormat" data-value="foreColor">Restaurar padrão    </button></div>
                                                                                        <div class="note-holder" data-event="foreColor">
                                                                                            <div class="note-color-palette">
                                                                                                <div class="note-color-row">
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#000000" data-event="foreColor" data-value="#000000" title="" data-toggle="button" tabindex="-1" data-original-title="#000000"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#424242" data-event="foreColor" data-value="#424242" title="" data-toggle="button" tabindex="-1" data-original-title="#424242"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#636363" data-event="foreColor" data-value="#636363" title="" data-toggle="button" tabindex="-1" data-original-title="#636363"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#9C9C94" data-event="foreColor" data-value="#9C9C94" title="" data-toggle="button" tabindex="-1" data-original-title="#9C9C94"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#CEC6CE" data-event="foreColor" data-value="#CEC6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#CEC6CE"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#EFEFEF" data-event="foreColor" data-value="#EFEFEF" title="" data-toggle="button" tabindex="-1" data-original-title="#EFEFEF"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#F7F7F7" data-event="foreColor" data-value="#F7F7F7" title="" data-toggle="button" tabindex="-1" data-original-title="#F7F7F7"></button>
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FFFFFF" data-event="foreColor" data-value="#FFFFFF" title="" data-toggle="button" tabindex="-1" data-original-title="#FFFFFF"></button>
                                                                                                </div>
                                                                                                <div class="note-color-row">
                                                                                                    <button type="button" class="note-color-btn" style="background-color:#FF0000" data-event="foreColor" data-value="#FF0000" title="" data-toggle="button" tabindex="-1" data-original-title="#FF0000"></button><button type="button" class="note-color-btn" style="background-color:#FF9C00" data-event="foreColor" data-value="#FF9C00" title="" data-toggle="button" tabindex="-1" data-original-title="#FF9C00"></button><button type="button" class="note-color-btn" style="background-color:#FFFF00" data-event="foreColor" data-value="#FFFF00" title="" data-toggle="button" tabindex="-1" data-original-title="#FFFF00"></button><button type="button" class="note-color-btn" style="background-color:#00FF00" data-event="foreColor" data-value="#00FF00" title="" data-toggle="button" tabindex="-1" data-original-title="#00FF00"></button><button type="button" class="note-color-btn" style="background-color:#00FFFF" data-event="foreColor" data-value="#00FFFF" title="" data-toggle="button" tabindex="-1" data-original-title="#00FFFF"></button><button type="button" class="note-color-btn" style="background-color:#0000FF" data-event="foreColor" data-value="#0000FF" title="" data-toggle="button" tabindex="-1" data-original-title="#0000FF"></button><button type="button" class="note-color-btn" style="background-color:#9C00FF" data-event="foreColor" data-value="#9C00FF" title="" data-toggle="button" tabindex="-1" data-original-title="#9C00FF"></button><button type="button" class="note-color-btn" style="background-color:#FF00FF" data-event="foreColor" data-value="#FF00FF" title="" data-toggle="button" tabindex="-1" data-original-title="#FF00FF"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#F7C6CE" data-event="foreColor" data-value="#F7C6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#F7C6CE"></button><button type="button" class="note-color-btn" style="background-color:#FFE7CE" data-event="foreColor" data-value="#FFE7CE" title="" data-toggle="button" tabindex="-1" data-original-title="#FFE7CE"></button><button type="button" class="note-color-btn" style="background-color:#FFEFC6" data-event="foreColor" data-value="#FFEFC6" title="" data-toggle="button" tabindex="-1" data-original-title="#FFEFC6"></button><button type="button" class="note-color-btn" style="background-color:#D6EFD6" data-event="foreColor" data-value="#D6EFD6" title="" data-toggle="button" tabindex="-1" data-original-title="#D6EFD6"></button><button type="button" class="note-color-btn" style="background-color:#CEDEE7" data-event="foreColor" data-value="#CEDEE7" title="" data-toggle="button" tabindex="-1" data-original-title="#CEDEE7"></button><button type="button" class="note-color-btn" style="background-color:#CEE7F7" data-event="foreColor" data-value="#CEE7F7" title="" data-toggle="button" tabindex="-1" data-original-title="#CEE7F7"></button><button type="button" class="note-color-btn" style="background-color:#D6D6E7" data-event="foreColor" data-value="#D6D6E7" title="" data-toggle="button" tabindex="-1" data-original-title="#D6D6E7"></button><button type="button" class="note-color-btn" style="background-color:#E7D6DE" data-event="foreColor" data-value="#E7D6DE" title="" data-toggle="button" tabindex="-1" data-original-title="#E7D6DE"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#E79C9C" data-event="foreColor" data-value="#E79C9C" title="" data-toggle="button" tabindex="-1" data-original-title="#E79C9C"></button><button type="button" class="note-color-btn" style="background-color:#FFC69C" data-event="foreColor" data-value="#FFC69C" title="" data-toggle="button" tabindex="-1" data-original-title="#FFC69C"></button><button type="button" class="note-color-btn" style="background-color:#FFE79C" data-event="foreColor" data-value="#FFE79C" title="" data-toggle="button" tabindex="-1" data-original-title="#FFE79C"></button><button type="button" class="note-color-btn" style="background-color:#B5D6A5" data-event="foreColor" data-value="#B5D6A5" title="" data-toggle="button" tabindex="-1" data-original-title="#B5D6A5"></button><button type="button" class="note-color-btn" style="background-color:#A5C6CE" data-event="foreColor" data-value="#A5C6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#A5C6CE"></button><button type="button" class="note-color-btn" style="background-color:#9CC6EF" data-event="foreColor" data-value="#9CC6EF" title="" data-toggle="button" tabindex="-1" data-original-title="#9CC6EF"></button><button type="button" class="note-color-btn" style="background-color:#B5A5D6" data-event="foreColor" data-value="#B5A5D6" title="" data-toggle="button" tabindex="-1" data-original-title="#B5A5D6"></button><button type="button" class="note-color-btn" style="background-color:#D6A5BD" data-event="foreColor" data-value="#D6A5BD" title="" data-toggle="button" tabindex="-1" data-original-title="#D6A5BD"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#E76363" data-event="foreColor" data-value="#E76363" title="" data-toggle="button" tabindex="-1" data-original-title="#E76363"></button><button type="button" class="note-color-btn" style="background-color:#F7AD6B" data-event="foreColor" data-value="#F7AD6B" title="" data-toggle="button" tabindex="-1" data-original-title="#F7AD6B"></button><button type="button" class="note-color-btn" style="background-color:#FFD663" data-event="foreColor" data-value="#FFD663" title="" data-toggle="button" tabindex="-1" data-original-title="#FFD663"></button><button type="button" class="note-color-btn" style="background-color:#94BD7B" data-event="foreColor" data-value="#94BD7B" title="" data-toggle="button" tabindex="-1" data-original-title="#94BD7B"></button><button type="button" class="note-color-btn" style="background-color:#73A5AD" data-event="foreColor" data-value="#73A5AD" title="" data-toggle="button" tabindex="-1" data-original-title="#73A5AD"></button><button type="button" class="note-color-btn" style="background-color:#6BADDE" data-event="foreColor" data-value="#6BADDE" title="" data-toggle="button" tabindex="-1" data-original-title="#6BADDE"></button><button type="button" class="note-color-btn" style="background-color:#8C7BC6" data-event="foreColor" data-value="#8C7BC6" title="" data-toggle="button" tabindex="-1" data-original-title="#8C7BC6"></button><button type="button" class="note-color-btn" style="background-color:#C67BA5" data-event="foreColor" data-value="#C67BA5" title="" data-toggle="button" tabindex="-1" data-original-title="#C67BA5"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#CE0000" data-event="foreColor" data-value="#CE0000" title="" data-toggle="button" tabindex="-1" data-original-title="#CE0000"></button><button type="button" class="note-color-btn" style="background-color:#E79439" data-event="foreColor" data-value="#E79439" title="" data-toggle="button" tabindex="-1" data-original-title="#E79439"></button><button type="button" class="note-color-btn" style="background-color:#EFC631" data-event="foreColor" data-value="#EFC631" title="" data-toggle="button" tabindex="-1" data-original-title="#EFC631"></button><button type="button" class="note-color-btn" style="background-color:#6BA54A" data-event="foreColor" data-value="#6BA54A" title="" data-toggle="button" tabindex="-1" data-original-title="#6BA54A"></button><button type="button" class="note-color-btn" style="background-color:#4A7B8C" data-event="foreColor" data-value="#4A7B8C" title="" data-toggle="button" tabindex="-1" data-original-title="#4A7B8C"></button><button type="button" class="note-color-btn" style="background-color:#3984C6" data-event="foreColor" data-value="#3984C6" title="" data-toggle="button" tabindex="-1" data-original-title="#3984C6"></button><button type="button" class="note-color-btn" style="background-color:#634AA5" data-event="foreColor" data-value="#634AA5" title="" data-toggle="button" tabindex="-1" data-original-title="#634AA5"></button><button type="button" class="note-color-btn" style="background-color:#A54A7B" data-event="foreColor" data-value="#A54A7B" title="" data-toggle="button" tabindex="-1" data-original-title="#A54A7B"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#9C0000" data-event="foreColor" data-value="#9C0000" title="" data-toggle="button" tabindex="-1" data-original-title="#9C0000"></button><button type="button" class="note-color-btn" style="background-color:#B56308" data-event="foreColor" data-value="#B56308" title="" data-toggle="button" tabindex="-1" data-original-title="#B56308"></button><button type="button" class="note-color-btn" style="background-color:#BD9400" data-event="foreColor" data-value="#BD9400" title="" data-toggle="button" tabindex="-1" data-original-title="#BD9400"></button><button type="button" class="note-color-btn" style="background-color:#397B21" data-event="foreColor" data-value="#397B21" title="" data-toggle="button" tabindex="-1" data-original-title="#397B21"></button><button type="button" class="note-color-btn" style="background-color:#104A5A" data-event="foreColor" data-value="#104A5A" title="" data-toggle="button" tabindex="-1" data-original-title="#104A5A"></button><button type="button" class="note-color-btn" style="background-color:#085294" data-event="foreColor" data-value="#085294" title="" data-toggle="button" tabindex="-1" data-original-title="#085294"></button><button type="button" class="note-color-btn" style="background-color:#311873" data-event="foreColor" data-value="#311873" title="" data-toggle="button" tabindex="-1" data-original-title="#311873"></button><button type="button" class="note-color-btn" style="background-color:#731842" data-event="foreColor" data-value="#731842" title="" data-toggle="button" tabindex="-1" data-original-title="#731842"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#630000" data-event="foreColor" data-value="#630000" title="" data-toggle="button" tabindex="-1" data-original-title="#630000"></button><button type="button" class="note-color-btn" style="background-color:#7B3900" data-event="foreColor" data-value="#7B3900" title="" data-toggle="button" tabindex="-1" data-original-title="#7B3900"></button><button type="button" class="note-color-btn" style="background-color:#846300" data-event="foreColor" data-value="#846300" title="" data-toggle="button" tabindex="-1" data-original-title="#846300"></button><button type="button" class="note-color-btn" style="background-color:#295218" data-event="foreColor" data-value="#295218" title="" data-toggle="button" tabindex="-1" data-original-title="#295218"></button><button type="button" class="note-color-btn" style="background-color:#083139" data-event="foreColor" data-value="#083139" title="" data-toggle="button" tabindex="-1" data-original-title="#083139"></button><button type="button" class="note-color-btn" style="background-color:#003163" data-event="foreColor" data-value="#003163" title="" data-toggle="button" tabindex="-1" data-original-title="#003163"></button><button type="button" class="note-color-btn" style="background-color:#21104A" data-event="foreColor" data-value="#21104A" title="" data-toggle="button" tabindex="-1" data-original-title="#21104A"></button><button type="button" class="note-color-btn" style="background-color:#4A1031" data-event="foreColor" data-value="#4A1031" title="" data-toggle="button" tabindex="-1" data-original-title="#4A1031"></button></div></div></div></div></li></div></div></div><div class="note-btn-group btn-group note-para">
                                                                                                        <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Lista com marcadores (CTRL+SHIFT+NUM7)"><i class="fa fa-list"></i></button>
                                                                                                        <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Lista numerada (CTRL+SHIFT+NUM8)"><i class="fa fa-list"></i></button>
                                                                                                        <div class="note-btn-group btn-group">
                                                                                                            <button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Parágrafo"><i class="fa fa-align-left"></i><span class="note-icon-caret"></span></button>
                                                                                                            <div class="dropdown-menu">
                                                                                                                <div class="note-btn-group btn-group note-align">
                                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Alinhar à esquerda (CTRL+SHIFT+L)"><i class="fa fa-align-left"></i></button>
                                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Alinhar ao centro (CTRL+SHIFT+E)"><i class="fa fa-align-center"></i></button>
                                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Alinha à direita (CTRL+SHIFT+R)"><i class="fa fa-align-right"></i></button>
                                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Justificado (CTRL+SHIFT+J)"><i class="fa fa-align-justify"></i></button>
                                                                                                                </div>
                                                                                                                <div class="note-btn-group btn-group note-list">
                                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Menor tabulação (CTRL+[)"><i class="fa fa-align-outdent"></i></button>
                                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Maior tabulação (CTRL+])"><i class="fa fa-align-indent"></i></button>
                                                                                                                </div>
                                                                                                            </div>
                                                                                                        </div>
                                                                                                    </div>
                                                                                                    <div class="note-btn-group btn-group note-table">
                                                                                                        <div class="note-btn-group btn-group">
                                                                                                            <button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Tabela"><i class="fa fa-table"></i> <span class="note-icon-caret"></span></button>
                                                                                                            <div class="dropdown-menu note-table">
                                                                                                                <div class="note-dimension-picker">
                                                                                                                    <div class="note-dimension-picker-mousecatcher" data-event="insertTable" data-value="1x1" style="width: 10em; height: 10em;"></div>  <div class="note-dimension-picker-highlighted"></div>
                                                                                                                    <div class="note-dimension-picker-unhighlighted"></div>
                                                                                                                </div>
                                                                                                                <div class="note-dimension-display">1 x 1</div>
                                                                                                            </div> 
                                                                                                        </div>     
                                                                                                    </div>
                                                                                                <div class="note-btn-group btn-group note-insert">
                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Link (CTRL+K)"><i class="fa fa-link"></i></button>
                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Picture"><i class="fa fa-picture-o"></i></button>
                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Vídeo"><i class="fa fa-video-camera"></i></button>
                                                                                                </div>
                                                                                                <div class="note-btn-group btn-group note-view">
                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm btn-fullscreen" tabindex="-1" title="" data-original-title="Tela cheia"><i class="fa fa-arrows-alt"></i></button>
                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm btn-codeview" tabindex="-1" title="" data-original-title="Ver código-fonte"><i class="fa fa-code"></i></button>
                                                                                                    <button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Ajuda"><i class="fa fa-question"></i></button>
                                                                                                </div>
                                                            </div>
                                                            <div class="note-editing-area"><div class="note-handle"><div class="note-control-selection"><div class="note-control-selection-bg"></div><div class="note-control-holder note-control-nw"></div><div class="note-control-holder note-control-ne"></div><div class="note-control-holder note-control-sw"></div><div class="note-control-sizing note-control-se"></div><div class="note-control-selection-info"></div></div></div><textarea class="note-codable"></textarea><div tabindex="-1" style="position: absolute; left: -100000px; opacity: 0;" contenteditable="true"></div><div class="note-editable panel-body" style="height: 300px;" contenteditable="true"><p><br></p></div></div><div class="note-statusbar">  <div class="note-resizebar">    <div class="note-icon-bar"></div>    <div class="note-icon-bar"></div>    <div class="note-icon-bar"></div>  </div></div><div class="modal link-dialog" aria-hidden="false" tabindex="-1"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Inserir link</h4>    </div>    <div class="modal-body"><div class="form-group"><label>Texto para exibir</label><input class="note-link-text form-control" type="text"></div><div class="form-group"><label>Para qual URL esse link leva?</label><input class="note-link-url form-control" type="text" value="http://"></div><div class="checkbox"><label><input type="checkbox" checked=""> Abrir em uma nova janela</label></div></div>    <div class="modal-footer"><button href="#" class="btn btn-primary note-link-btn disabled" disabled="">Inserir link</button></div>  </div></div></div><div class="modal" aria-hidden="false" tabindex="-1"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Inserir imagem</h4>    </div>    <div class="modal-body"><div class="form-group note-group-select-from-files"><label>Selecione a partir dos arquivos</label><input class="note-image-input form-control" type="file" name="files" accept="image/*" multiple="multiple"></div><div class="form-group note-group-image-url" style="overflow:auto;"><label>URL da imagem</label><input class="note-image-url form-control col-md-12" type="text"></div></div>    <div class="modal-footer"><button href="#" class="btn btn-primary note-image-btn disabled" disabled="">Inserir imagem</button></div>  </div></div></div><div class="modal" aria-hidden="false" tabindex="-1"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Inserir vídeo</h4>    </div>    <div class="modal-body"><div class="form-group row-fluid"><label>URL do vídeo? <small class="text-muted">(YouTube, Vimeo, Vine, Instagram, DailyMotion ou Youku)</small></label><input class="note-video-url form-control span12" type="text"></div></div>    <div class="modal-footer"><button href="#" class="btn btn-primary note-video-btn disabled" disabled="">Inserir vídeo</button></div>  </div></div></div><div class="modal" aria-hidden="false" tabindex="-1"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Ajuda</h4>    </div>    <div class="modal-body" style="max-height: 300px; overflow: scroll;"><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>ENTER</kbd></label><span>Inserir Parágrafo</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+Z</kbd></label><span>Desfazer o último comando</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+Y</kbd></label><span>Refazer o último comando</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>TAB</kbd></label><span>Tab</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>SHIFT+TAB</kbd></label><span>Desfazer tab</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+B</kbd></label><span>Colocar em negrito</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+I</kbd></label><span>Colocar em itálico</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+U</kbd></label><span>Sublinhado</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+S</kbd></label><span>Tachado</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+BACKSLASH</kbd></label><span>Remover estilo</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+L</kbd></label><span>Alinhar à esquerda</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+E</kbd></label><span>Centralizar</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+R</kbd></label><span>Alinhar à esquerda</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+J</kbd></label><span>Justificar</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+NUM7</kbd></label><span>Lista não ordenada</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+NUM8</kbd></label><span>Lista ordenada</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+LEFTBRACKET</kbd></label><span>Recuar parágrafo atual</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+RIGHTBRACKET</kbd></label><span>Avançar parágrafo atual</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM0</kbd></label><span>Alterar formato do bloco para parágrafo(tag P)</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM1</kbd></label><span>Alterar formato do bloco para H1</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM2</kbd></label><span>Alterar formato do bloco para H2</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM3</kbd></label><span>Alterar formato do bloco para H3</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM4</kbd></label><span>Alterar formato do bloco para H4</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM5</kbd></label><span>Alterar formato do bloco para H5</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM6</kbd></label><span>Alterar formato do bloco para H6</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+ENTER</kbd></label><span>Inserir régua horizontal</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+K</kbd></label><span>Inserir um Hiperlink</span></div>    <div class="modal-footer"><p class="text-center"><a href="http://summernote.org/" target="_blank">Summernote 0.8.2</a> · <a href="https://github.com/summernote/summernote" target="_blank">Project</a> · <a href="https://github.com/summernote/summernote/issues" target="_blank">Issues</a></p></div>  </div></div></div><div class="modal" aria-hidden="false" tabindex="-1"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Image Attributes</h4>    </div>    <div class="modal-body"><div class="form-group"><label for="note-image-attributes-title" class="control-label col-xs-2">Title</label><div class="input-group col-xs-10"><input type="text" id="note-image-attributes-title" class="note-image-attributes-title form-control"></div></div><div class="form-group"><label for="note-image-attributes-src" class="control-label col-xs-2">Source</label><div class="input-group col-xs-10"><input type="text" id="note-image-attributes-src" class="note-image-attributes-src form-control"></div></div><div class="form-group note-group-select-from-files"><label class="control-label col-xs-2"></label><div class="input-group col-xs-10"><input class="note-image-input form-control" type="file" name="file" accept="image/*"><small class="help-block">Selecting an image will replace existing image with an Inlined Image.</small></div></div><div class="form-group"><label for="note-image-attributes-alt" class="control-label col-xs-2">Alt</label><div class="input-group col-xs-10"><input type="text" id="note-image-attributes-alt" class="note-image-attributes-alt form-control"></div></div><h4>Link Attributes</h4><hr><div class="form-group"><label for="note-image-attributes-link-href" class="control-label col-xs-2">URL</label><div class="input-group col-xs-10"><input type="text" id="note-image-attributes-link-href" class="note-image-attributes-href form-control"></div></div><div class="form-group"><label for="note-image-attributes-link-target" class="control-label col-xs-2">Target</label><div class="input-group col-xs-10"><select id="note-image-attributes-link-target" class="note-image-attributes-target form-control"><option value="_self">Self</option><option value="_blank">Blank</option><option value="_top">Top</option><option value="_parent">Parent</option></select>
                                                                                </div>
                                                                            </div>
                                                                        </div>
                                                                        <div class="modal-footer"><button class="btn btn-primary note-image-attributes-btn">OK</button></div>
                                                                    </div>
                                                                </div>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                    <div class="form-group required">
                      <label class="col-sm-2 control-label" for="input-meta-title2">Meta título</label>
                      <div class="col-sm-10">
                        <input type="text" name="product_description[2][meta_title]" value="" placeholder="Meta título" id="input-meta-title2" class="form-control">
                         </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label" for="input-meta-description2">Meta descrição</label>
                      <div class="col-sm-10">
                        <textarea name="product_description[2][meta_description]" rows="5" placeholder="Meta descrição" id="input-meta-description2" class="form-control"></textarea>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label" for="input-meta-keyword2">Meta palavras-chave</label>
                      <div class="col-sm-10">
                        <textarea name="product_description[2][meta_keyword]" rows="5" placeholder="Meta palavras-chave" id="input-meta-keyword2" class="form-control"></textarea>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label" for="input-tag2"><span data-toggle="tooltip" title="" data-original-title="Separadas por vírgulas">Etiquetas</span></label>
                      <div class="col-sm-10">
                        <input type="text" name="product_description[2][tag]" value="" placeholder="Etiquetas" id="input-tag2" class="form-control">
                      </div>
                    </div>
                  </div>
                </div>
            </div>
            <div class="tab-pane" id="tab-data">
              <div class="form-group required">
                <label class="col-sm-2 control-label" for="input-model">Modelo</label>
                <div class="col-sm-10">
                  <input type="text" name="model" value="" placeholder="Modelo" id="input-model" class="form-control">
                  </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-sku"><span data-toggle="tooltip" title="" data-original-title="É o código ligado à logística de armazém, e designa os diferentes produtos do estoque.">SKU</span></label>
                <div class="col-sm-10">
                  <input type="text" name="sku" value="" placeholder="SKU" id="input-sku" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-upc"><span data-toggle="tooltip" title="" data-original-title="É o mesmo que UPC, que significa Código Universal de Produtos.">Código de barras</span></label>
                <div class="col-sm-10">
                  <input type="text" name="upc" value="" placeholder="Código de barras" id="input-upc" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-ean"><span data-toggle="tooltip" title="" data-original-title="Significa Número de Artigo Europeu">EAN</span></label>
                <div class="col-sm-10">
                  <input type="text" name="ean" value="" placeholder="EAN" id="input-ean" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-jan"><span data-toggle="tooltip" title="" data-original-title="Significa Número de Artigo Japonês">JAN</span></label>
                <div class="col-sm-10">
                  <input type="text" name="jan" value="" placeholder="JAN" id="input-jan" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-isbn"><span data-toggle="tooltip" title="" data-original-title="Significa Número Padrão Internacional de Livro. É o código de identificação utilizado em livros.">ISBN</span></label>
                <div class="col-sm-10">
                  <input type="text" name="isbn" value="" placeholder="ISBN" id="input-isbn" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-mpn"><span data-toggle="tooltip" title="" data-original-title="Significa Número da Peça do Fabricante. É o código usado pelos fabricantes para identificar os seus produtos.">MPN</span></label>
                <div class="col-sm-10">
                  <input type="text" name="mpn" value="" placeholder="MPN" id="input-mpn" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-location">Localização</label>
                <div class="col-sm-10">
                  <input type="text" name="location" value="" placeholder="Localização" id="input-location" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-price">Preço</label>
                <div class="col-sm-10">
                  <input type="text" name="price" value="" placeholder="Preço" id="input-price" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-tax-class">Grupo de impostos</label>
                <div class="col-sm-10">
                  <select name="tax_class_id" id="input-tax-class" class="form-control">
                    <option value="0"> --- Vazio --- </option>


                                          

                        <option value="9">Taxable Goods</option>


                                                                

                        <option value="10">Downloadable Products</option>


                                                                

                        <option value="11">Simples nacional</option>


                                          

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-quantity">Quantidade</label>
                <div class="col-sm-10">
                  <input type="text" name="quantity" value="1" placeholder="Quantidade" id="input-quantity" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="" data-original-title="Forçar uma quantidade mínima a ser vendida.">Mínimo por venda</span></label>
                <div class="col-sm-10">
                  <input type="text" name="minimum" value="1" placeholder="Mínimo por venda" id="input-minimum" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-subtract">Reduzir estoque?</label>
                <div class="col-sm-10">
                  <select name="subtract" id="input-subtract" class="form-control">


                    

                      <option value="1" selected="selected">Sim</option>
                      <option value="0">Não</option>


                    

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-stock-status"><span data-toggle="tooltip" title="" data-original-title="Situação do produto quando está fora de estoque">Se esgotado</span></label>
                <div class="col-sm-10">
                  <select name="stock_status_id" id="input-stock-status" class="form-control">


                                          

                        <option value="6">2-3 dias</option>


                                                                

                        <option value="7">Em estoque</option>


                                                                

                        <option value="8">Encomendar</option>


                                                                

                        <option value="5">Esgotado</option>


                                          

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Precisa de frete?</label>
                <div class="col-sm-10">
                  <label class="radio-inline">                       <input type="radio" name="shipping" value="1" checked="checked">
                      Sim
                     </label> <label class="radio-inline">                       <input type="radio" name="shipping" value="0">
                      Não
                     </label>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-date-available">Disponível a partir de</label>
                <div class="col-sm-3">
                  <div class="input-group date">
                    <input type="text" name="date_available" value="2020-04-25" placeholder="Disponível a partir de" data-date-format="YYYY-MM-DD" id="input-date-available" class="form-control"> <span class="input-group-btn">
                    <button class="btn btn-default" type="button"><i class="fa fa-calendar"></i></button>
                    </span></div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-length">Dimensões (C x L x A)</label>
                <div class="col-sm-10">
                  <div class="row">
                    <div class="col-sm-4">
                      <input type="text" name="length" value="" placeholder="Comprimento" id="input-length" class="form-control">
                    </div>
                    <div class="col-sm-4">
                      <input type="text" name="width" value="" placeholder="Largura" id="input-width" class="form-control">
                    </div>
                    <div class="col-sm-4">
                      <input type="text" name="height" value="" placeholder="Altura" id="input-height" class="form-control">
                    </div>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-length-class">Unidade de medida</label>
                <div class="col-sm-10">
                  <select name="length_class_id" id="input-length-class" class="form-control">


                                          

                        <option value="1" selected="selected">Centímetros</option>


                                                                

                        <option value="2">Millimetro</option>


                                                                

                        <option value="3">Polegada</option>


                                                                

                        <option value="4">Litros</option>


                                                                

                        <option value="5">Mililitros</option>


                                          

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-weight">Peso</label>
                <div class="col-sm-10">
                  <input type="text" name="weight" value="" placeholder="Peso" id="input-weight" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-weight-class">Unidade de peso</label>
                <div class="col-sm-10">
                  <select name="weight_class_id" id="input-weight-class" class="form-control">


                                          

                        <option value="1" selected="selected">Kilograma</option>


                                                                

                        <option value="2">Grama</option>


                                                                

                        <option value="5">Libra</option>


                                                                

                        <option value="6">Onça</option>


                                          

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-status">Situação</label>
                <div class="col-sm-10">
                  <select name="status" id="input-status" class="form-control">


                    

                      <option value="1" selected="selected">Habilitado</option>
                      <option value="0">Desabilitado</option>


                    

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-sort-order">Posição</label>
                <div class="col-sm-10">
                  <input type="text" name="sort_order" value="1" placeholder="Posição" id="input-sort-order" class="form-control">
                </div>
              </div>
            </div>
            <div class="tab-pane" id="tab-links">
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-manufacturer"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Marcas</span></label>
                <div class="col-sm-10">
                  <input type="text" name="manufacturer" value="" placeholder="Marcas" id="input-manufacturer" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul> <input type="hidden" name="manufacturer_id" value="0">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-category"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Departamentos</span></label>
                <div class="col-sm-10">
                  <input type="text" name="category" value="" placeholder="Departamentos" id="input-category" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                  <div id="product-category" class="well well-sm" style="height: 150px; overflow: auto;"> </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-filter"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Filtros</span></label>
                <div class="col-sm-10">
                  <input type="text" name="filter" value="" placeholder="Filtros" id="input-filter" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                  <div id="product-filter" class="well well-sm" style="height: 150px; overflow: auto;"> </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Loja</label>
                <div class="col-sm-10">
                  <div class="well well-sm" style="height: 150px; overflow: auto;">                       <div class="checkbox">
                        <label>                             <input type="checkbox" name="product_store[]" value="0" checked="checked">
                            Padrão
                           </label>
                      </div>
                    </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-download"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Downloads</span></label>
                <div class="col-sm-10">
                  <input type="text" name="download" value="" placeholder="Downloads" id="input-download" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                  <div id="product-download" class="well well-sm" style="height: 150px; overflow: auto;"> </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-related"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Produtos relacionados</span></label>
                <div class="col-sm-10">
                  <input type="text" name="related" value="" placeholder="Produtos relacionados" id="input-related" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                  <div id="product-related" class="well well-sm" style="height: 150px; overflow: auto;"> </div>
                </div>
              </div>
            </div>
            <div class="tab-pane" id="tab-attribute">
              <div class="table-responsive">
                <table id="attribute" class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Atributo</td>
                      <td class="text-left">Texto</td>
                      <td></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="2"></td>
                      <td class="text-right"><button type="button" onclick="addAttribute();" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar atributo"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-option">
              <div class="row">
                <div class="col-sm-2">
                  <ul class="nav nav-pills nav-stacked" id="option">
                                                            <li>
                      <input type="text" name="option" value="" placeholder="Opção" id="input-option" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                    </li>
                  </ul>
                </div>
                <div class="col-sm-10">
                  <div class="tab-content">                                          </div>
                </div>
              </div>
            </div>
            <div class="tab-pane" id="tab-recurring">
              <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Tipo de assinatura</td>
                      <td class="text-left">Tipo de cliente</td>
                      <td class="text-left"></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="2"></td>
                      <td class="text-left"><button type="button" onclick="addRecurring()" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar assinatura"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-discount">
              <div class="table-responsive">
                <table id="discount" class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Tipo de cliente</td>
                      <td class="text-right">Quantidade</td>
                      <td class="text-right">Prioridade</td>
                      <td class="text-right">Preço</td>
                      <td class="text-left">Data inicial</td>
                      <td class="text-left">Data final</td>
                      <td></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="6"></td>
                      <td class="text-left"><button type="button" onclick="addDiscount();" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar desconto"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-special">
              <div class="table-responsive">
                <table id="special" class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Tipo de cliente</td>
                      <td class="text-right">Prioridade</td>
                      <td class="text-right">Preço</td>
                      <td class="text-left">Data inicial</td>
                      <td class="text-left">Data final</td>
                      <td></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="5"></td>
                      <td class="text-left"><button type="button" onclick="addSpecial();" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar promoção"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-image">
              <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Imagem</td>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td class="text-left"><a href="" id="thumb-image" data-toggle="image" class="img-thumbnail"><img src="http://localhost/image/cache/no_image-100x100.png" alt="" title="" data-placeholder="http://localhost/image/cache/no_image-100x100.png"></a> <input type="hidden" name="image" value="" id="input-image"></td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="table-responsive">
                <table id="images" class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Imagens adicionais</td>
                      <td class="text-right">Posição</td>
                      <td></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="2"></td>
                      <td class="text-left"><button type="button" onclick="addImage();" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar imagem"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-reward">
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-points"><span data-toggle="tooltip" title="" data-original-title="Número de pontos necessários para comprar este produto. Se você não deseja que este produto seja comprado com pontos, coloque 0.">Pontos</span></label>
                <div class="col-sm-10">
                  <input type="text" name="points" value="" placeholder="Pontos" id="input-points" class="form-control">
                </div>
              </div>
              <div class="table-responsive">
                <table class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Tipo de cliente</td>
                      <td class="text-right">Pontos</td>
                    </tr>
                  </thead>
                  <tbody>

                                          <tr>
                        <td class="text-left">Default</td>
                        <td class="text-right"><input type="text" name="product_reward[1][points]" value="" class="form-control"></td>
                      </tr>
                                      </tbody>

                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-seo">
              <div class="alert alert-info"><i class="fa fa-info-circle"></i> Não utilize espaços, substitua os espaços por - (hífen), e certifique-se que a palavra é exclusiva em toda a loja.</div>
              <div class="table-responsive">
                <table class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Loja</td>
                      <td class="text-left">URL amigável</td>
                    </tr>
                  </thead>
                  <tbody>
                                          <tr>
                        <td class="text-left">Padrão</td>
                        <td class="text-left">                            <div class="input-group"><span class="input-group-addon"><img src="language/pt-br/pt-br.png" title="Português"></span> <input type="text" name="product_seo_url[0][2]" value="" placeholder="URL amigável" class="form-control">
                            </div>
                                                      </td>
                      </tr>
                                      </tbody>

                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-design">
              <div class="table-responsive">
                <table class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Loja</td>
                      <td class="text-left">Layout para este produto</td>
                    </tr>
                  </thead>
                  <tbody>
                                          <tr>
                        <td class="text-left">Padrão</td>
                        <td class="text-left"><select name="product_layout[0]" class="form-control">
                            <option value=""></option>


                                                          

                                <option value="6">Account</option>


                                                                                        

                                <option value="10">Affiliate</option>


                                                                                        

                                <option value="3">Category</option>


                                                                                        

                                <option value="7">Checkout</option>


                                                                                        

                                <option value="12">Compare</option>


                                                                                        

                                <option value="8">Contact</option>


                                                                                        

                                <option value="4">Default</option>


                                                                                        

                                <option value="1">Home</option>


                                                                                        

                                <option value="11">Information</option>


                                                                                        

                                <option value="5">Manufacturer</option>


                                                                                        

                                <option value="2">Product</option>


                                                                                        

                                <option value="14">Produtos em destaque na primeira página</option>


                                                                                        

                                <option value="13">Search</option>


                                                                                        

                                <option value="9">Sitemap</option>


                                                          

                          </select></td>
                      </tr>
                                      </tbody>
                </table>
              </div>
            </div>
          </div>
        </form>
                        </div>
                  </div>
                </div>
           
            </div>

            <div class="panel-body">
        <form action="http://localhost/admin/index.php?route=catalog/product/add&amp;user_token=o2lwBgL1Fk4340WOBU60JcUeHn99jjnS" method="post" enctype="multipart/form-data" id="form-product" class="form-horizontal">
          <ul class="nav nav-tabs">
            <li class="active"><a href="#tab-general" data-toggle="tab" aria-expanded="true">Geral</a></li>
            <li class=""><a href="#tab-data" data-toggle="tab" aria-expanded="false">Dados</a></li>
            <li><a href="#tab-links" data-toggle="tab">Ligações</a></li>
            <li class=""><a href="#tab-attribute" data-toggle="tab" aria-expanded="false">Atributos</a></li>
            <li><a href="#tab-option" data-toggle="tab">Opções</a></li>
            <li><a href="#tab-recurring" data-toggle="tab">Assinaturas</a></li>
            <li><a href="#tab-discount" data-toggle="tab">Descontos</a></li>
            <li><a href="#tab-special" data-toggle="tab">Promoções</a></li>
            <li><a href="#tab-image" data-toggle="tab">Imagens</a></li>
            <li><a href="#tab-reward" data-toggle="tab">Pontos</a></li>
            <li><a href="#tab-seo" data-toggle="tab">SEO</a></li>
            <li><a href="#tab-design" data-toggle="tab">Design</a></li>
          </ul>
          <div class="tab-content">
            <div class="tab-pane active" id="tab-general">
              <ul class="nav nav-tabs" id="language">
                                  <li class="active"><a href="#language2" data-toggle="tab" aria-expanded="true"><img src="language/pt-br/pt-br.png" title="Português"> Português</a></li>
                              </ul>
              <div class="tab-content">                  <div class="tab-pane active" id="language2">
                    <div class="form-group required">
                      <label class="col-sm-2 control-label" for="input-name2">Produto</label>
                      <div class="col-sm-10">
                        <input type="text" name="product_description[2][name]" value="" placeholder="Produto" id="input-name2" class="form-control">
                         </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label" for="input-description2">Descrição</label>
                      <div class="col-sm-10">
                        <textarea name="product_description[2][description]" placeholder="Descrição" id="input-description2" data-toggle="summernote" data-lang="pt-BR" class="form-control" style="display: none;"></textarea><div class="note-editor note-frame panel panel-default"><div class="note-dropzone">  <div class="note-dropzone-message"></div></div><div class="note-toolbar panel-heading"><div class="note-btn-group btn-group note-style"><div class="note-btn-group btn-group"><button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Estilo" aria-expanded="false"><i class="note-icon-magic"></i> <span class="note-icon-caret"></span></button><div class="dropdown-menu dropdown-style"><li><a href="#" data-value="p"><p>p</p></a></li><li><a href="#" data-value="blockquote"><blockquote>Citação</blockquote></a></li><li><a href="#" data-value="pre"><pre>Código</pre></a></li><li><a href="#" data-value="h1"><h1>Título 1</h1></a></li><li><a href="#" data-value="h2"><h2>Título 2</h2></a></li><li><a href="#" data-value="h3"><h3>Título 3</h3></a></li><li><a href="#" data-value="h4"><h4>Título 4</h4></a></li><li><a href="#" data-value="h5"><h5>Título 5</h5></a></li><li><a href="#" data-value="h6"><h6>Título 6</h6></a></li></div></div></div><div class="note-btn-group btn-group note-font"><button type="button" class="note-btn btn btn-default btn-sm note-btn-bold" tabindex="-1" title="" data-original-title="Negrito (CTRL+B)"><i class="note-icon-bold"></i></button><button type="button" class="note-btn btn btn-default btn-sm note-btn-underline" tabindex="-1" title="" data-original-title="Sublinhado (CTRL+U)"><i class="note-icon-underline"></i></button><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Remover estilo da fonte (CTRL+\)"><i class="note-icon-eraser"></i></button></div><div class="note-btn-group btn-group note-fontname"><div class="note-btn-group btn-group"><button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Fonte" aria-expanded="false"><span class="note-current-fontname">Open Sans</span> <span class="note-icon-caret"></span></button><div class="dropdown-menu note-check dropdown-fontname"><li><a href="#" data-value="Arial" class=""><i class="note-icon-check"></i> <span style="font-family:Arial">Arial</span></a></li><li><a href="#" data-value="Arial Black" class=""><i class="note-icon-check"></i> <span style="font-family:Arial Black">Arial Black</span></a></li><li><a href="#" data-value="Comic Sans MS" class=""><i class="note-icon-check"></i> <span style="font-family:Comic Sans MS">Comic Sans MS</span></a></li><li><a href="#" data-value="Courier New" class=""><i class="note-icon-check"></i> <span style="font-family:Courier New">Courier New</span></a></li><li><a href="#" data-value="Helvetica" class=""><i class="note-icon-check"></i> <span style="font-family:Helvetica">Helvetica</span></a></li><li><a href="#" data-value="Impact" class=""><i class="note-icon-check"></i> <span style="font-family:Impact">Impact</span></a></li><li><a href="#" data-value="Tahoma" class=""><i class="note-icon-check"></i> <span style="font-family:Tahoma">Tahoma</span></a></li><li><a href="#" data-value="Times New Roman" class=""><i class="note-icon-check"></i> <span style="font-family:Times New Roman">Times New Roman</span></a></li><li><a href="#" data-value="Verdana" class=""><i class="note-icon-check"></i> <span style="font-family:Verdana">Verdana</span></a></li></div></div></div><div class="note-btn-group btn-group note-fontsize"><div class="note-btn-group btn-group"><button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Tamanho da fonte" aria-expanded="false"><span class="note-current-fontsize">13</span><span class="note-icon-caret"></span></button><div class="dropdown-menu note-check dropdown-fontsize"><li><a href="#" data-value="8" class=""><i class="note-icon-check"></i> 8</a></li><li><a href="#" data-value="9" class=""><i class="note-icon-check"></i> 9</a></li><li><a href="#" data-value="10" class=""><i class="note-icon-check"></i> 10</a></li><li><a href="#" data-value="11" class=""><i class="note-icon-check"></i> 11</a></li><li><a href="#" data-value="12" class=""><i class="note-icon-check"></i> 12</a></li><li><a href="#" data-value="14" class=""><i class="note-icon-check"></i> 14</a></li><li><a href="#" data-value="18" class=""><i class="note-icon-check"></i> 18</a></li><li><a href="#" data-value="24" class=""><i class="note-icon-check"></i> 24</a></li><li><a href="#" data-value="36" class=""><i class="note-icon-check"></i> 36</a></li></div></div></div><div class="note-btn-group btn-group note-color"><div class="note-btn-group btn-group note-color"><button type="button" class="note-btn btn btn-default btn-sm note-current-color-button" tabindex="-1" title="" data-original-title="Cor recente" data-backcolor="#FFFF00"><i class="note-icon-font note-recent-color" style="background-color: rgb(255, 255, 0);"></i></button><button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Mais cores" aria-expanded="false"><span class="note-icon-caret"></span></button><div class="dropdown-menu"><li><div class="btn-group">  <div class="note-palette-title">Fundo</div>  <div>    <button type="button" class="note-color-reset btn btn-default" data-event="backColor" data-value="inherit">Transparente    </button>  </div>  <div class="note-holder" data-event="backColor"><div class="note-color-palette"><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#000000" data-event="backColor" data-value="#000000" title="" data-toggle="button" tabindex="-1" data-original-title="#000000"></button><button type="button" class="note-color-btn" style="background-color:#424242" data-event="backColor" data-value="#424242" title="" data-toggle="button" tabindex="-1" data-original-title="#424242"></button><button type="button" class="note-color-btn" style="background-color:#636363" data-event="backColor" data-value="#636363" title="" data-toggle="button" tabindex="-1" data-original-title="#636363"></button><button type="button" class="note-color-btn" style="background-color:#9C9C94" data-event="backColor" data-value="#9C9C94" title="" data-toggle="button" tabindex="-1" data-original-title="#9C9C94"></button><button type="button" class="note-color-btn" style="background-color:#CEC6CE" data-event="backColor" data-value="#CEC6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#CEC6CE"></button><button type="button" class="note-color-btn" style="background-color:#EFEFEF" data-event="backColor" data-value="#EFEFEF" title="" data-toggle="button" tabindex="-1" data-original-title="#EFEFEF"></button><button type="button" class="note-color-btn" style="background-color:#F7F7F7" data-event="backColor" data-value="#F7F7F7" title="" data-toggle="button" tabindex="-1" data-original-title="#F7F7F7"></button><button type="button" class="note-color-btn" style="background-color:#FFFFFF" data-event="backColor" data-value="#FFFFFF" title="" data-toggle="button" tabindex="-1" data-original-title="#FFFFFF"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#FF0000" data-event="backColor" data-value="#FF0000" title="" data-toggle="button" tabindex="-1" data-original-title="#FF0000"></button><button type="button" class="note-color-btn" style="background-color:#FF9C00" data-event="backColor" data-value="#FF9C00" title="" data-toggle="button" tabindex="-1" data-original-title="#FF9C00"></button><button type="button" class="note-color-btn" style="background-color:#FFFF00" data-event="backColor" data-value="#FFFF00" title="" data-toggle="button" tabindex="-1" data-original-title="#FFFF00"></button><button type="button" class="note-color-btn" style="background-color:#00FF00" data-event="backColor" data-value="#00FF00" title="" data-toggle="button" tabindex="-1" data-original-title="#00FF00"></button><button type="button" class="note-color-btn" style="background-color:#00FFFF" data-event="backColor" data-value="#00FFFF" title="" data-toggle="button" tabindex="-1" data-original-title="#00FFFF"></button><button type="button" class="note-color-btn" style="background-color:#0000FF" data-event="backColor" data-value="#0000FF" title="" data-toggle="button" tabindex="-1" data-original-title="#0000FF"></button><button type="button" class="note-color-btn" style="background-color:#9C00FF" data-event="backColor" data-value="#9C00FF" title="" data-toggle="button" tabindex="-1" data-original-title="#9C00FF"></button><button type="button" class="note-color-btn" style="background-color:#FF00FF" data-event="backColor" data-value="#FF00FF" title="" data-toggle="button" tabindex="-1" data-original-title="#FF00FF"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#F7C6CE" data-event="backColor" data-value="#F7C6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#F7C6CE"></button><button type="button" class="note-color-btn" style="background-color:#FFE7CE" data-event="backColor" data-value="#FFE7CE" title="" data-toggle="button" tabindex="-1" data-original-title="#FFE7CE"></button><button type="button" class="note-color-btn" style="background-color:#FFEFC6" data-event="backColor" data-value="#FFEFC6" title="" data-toggle="button" tabindex="-1" data-original-title="#FFEFC6"></button><button type="button" class="note-color-btn" style="background-color:#D6EFD6" data-event="backColor" data-value="#D6EFD6" title="" data-toggle="button" tabindex="-1" data-original-title="#D6EFD6"></button><button type="button" class="note-color-btn" style="background-color:#CEDEE7" data-event="backColor" data-value="#CEDEE7" title="" data-toggle="button" tabindex="-1" data-original-title="#CEDEE7"></button><button type="button" class="note-color-btn" style="background-color:#CEE7F7" data-event="backColor" data-value="#CEE7F7" title="" data-toggle="button" tabindex="-1" data-original-title="#CEE7F7"></button><button type="button" class="note-color-btn" style="background-color:#D6D6E7" data-event="backColor" data-value="#D6D6E7" title="" data-toggle="button" tabindex="-1" data-original-title="#D6D6E7"></button><button type="button" class="note-color-btn" style="background-color:#E7D6DE" data-event="backColor" data-value="#E7D6DE" title="" data-toggle="button" tabindex="-1" data-original-title="#E7D6DE"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#E79C9C" data-event="backColor" data-value="#E79C9C" title="" data-toggle="button" tabindex="-1" data-original-title="#E79C9C"></button><button type="button" class="note-color-btn" style="background-color:#FFC69C" data-event="backColor" data-value="#FFC69C" title="" data-toggle="button" tabindex="-1" data-original-title="#FFC69C"></button><button type="button" class="note-color-btn" style="background-color:#FFE79C" data-event="backColor" data-value="#FFE79C" title="" data-toggle="button" tabindex="-1" data-original-title="#FFE79C"></button><button type="button" class="note-color-btn" style="background-color:#B5D6A5" data-event="backColor" data-value="#B5D6A5" title="" data-toggle="button" tabindex="-1" data-original-title="#B5D6A5"></button><button type="button" class="note-color-btn" style="background-color:#A5C6CE" data-event="backColor" data-value="#A5C6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#A5C6CE"></button><button type="button" class="note-color-btn" style="background-color:#9CC6EF" data-event="backColor" data-value="#9CC6EF" title="" data-toggle="button" tabindex="-1" data-original-title="#9CC6EF"></button><button type="button" class="note-color-btn" style="background-color:#B5A5D6" data-event="backColor" data-value="#B5A5D6" title="" data-toggle="button" tabindex="-1" data-original-title="#B5A5D6"></button><button type="button" class="note-color-btn" style="background-color:#D6A5BD" data-event="backColor" data-value="#D6A5BD" title="" data-toggle="button" tabindex="-1" data-original-title="#D6A5BD"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#E76363" data-event="backColor" data-value="#E76363" title="" data-toggle="button" tabindex="-1" data-original-title="#E76363"></button><button type="button" class="note-color-btn" style="background-color:#F7AD6B" data-event="backColor" data-value="#F7AD6B" title="" data-toggle="button" tabindex="-1" data-original-title="#F7AD6B"></button><button type="button" class="note-color-btn" style="background-color:#FFD663" data-event="backColor" data-value="#FFD663" title="" data-toggle="button" tabindex="-1" data-original-title="#FFD663"></button><button type="button" class="note-color-btn" style="background-color:#94BD7B" data-event="backColor" data-value="#94BD7B" title="" data-toggle="button" tabindex="-1" data-original-title="#94BD7B"></button><button type="button" class="note-color-btn" style="background-color:#73A5AD" data-event="backColor" data-value="#73A5AD" title="" data-toggle="button" tabindex="-1" data-original-title="#73A5AD"></button><button type="button" class="note-color-btn" style="background-color:#6BADDE" data-event="backColor" data-value="#6BADDE" title="" data-toggle="button" tabindex="-1" data-original-title="#6BADDE"></button><button type="button" class="note-color-btn" style="background-color:#8C7BC6" data-event="backColor" data-value="#8C7BC6" title="" data-toggle="button" tabindex="-1" data-original-title="#8C7BC6"></button><button type="button" class="note-color-btn" style="background-color:#C67BA5" data-event="backColor" data-value="#C67BA5" title="" data-toggle="button" tabindex="-1" data-original-title="#C67BA5"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#CE0000" data-event="backColor" data-value="#CE0000" title="" data-toggle="button" tabindex="-1" data-original-title="#CE0000"></button><button type="button" class="note-color-btn" style="background-color:#E79439" data-event="backColor" data-value="#E79439" title="" data-toggle="button" tabindex="-1" data-original-title="#E79439"></button><button type="button" class="note-color-btn" style="background-color:#EFC631" data-event="backColor" data-value="#EFC631" title="" data-toggle="button" tabindex="-1" data-original-title="#EFC631"></button><button type="button" class="note-color-btn" style="background-color:#6BA54A" data-event="backColor" data-value="#6BA54A" title="" data-toggle="button" tabindex="-1" data-original-title="#6BA54A"></button><button type="button" class="note-color-btn" style="background-color:#4A7B8C" data-event="backColor" data-value="#4A7B8C" title="" data-toggle="button" tabindex="-1" data-original-title="#4A7B8C"></button><button type="button" class="note-color-btn" style="background-color:#3984C6" data-event="backColor" data-value="#3984C6" title="" data-toggle="button" tabindex="-1" data-original-title="#3984C6"></button><button type="button" class="note-color-btn" style="background-color:#634AA5" data-event="backColor" data-value="#634AA5" title="" data-toggle="button" tabindex="-1" data-original-title="#634AA5"></button><button type="button" class="note-color-btn" style="background-color:#A54A7B" data-event="backColor" data-value="#A54A7B" title="" data-toggle="button" tabindex="-1" data-original-title="#A54A7B"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#9C0000" data-event="backColor" data-value="#9C0000" title="" data-toggle="button" tabindex="-1" data-original-title="#9C0000"></button><button type="button" class="note-color-btn" style="background-color:#B56308" data-event="backColor" data-value="#B56308" title="" data-toggle="button" tabindex="-1" data-original-title="#B56308"></button><button type="button" class="note-color-btn" style="background-color:#BD9400" data-event="backColor" data-value="#BD9400" title="" data-toggle="button" tabindex="-1" data-original-title="#BD9400"></button><button type="button" class="note-color-btn" style="background-color:#397B21" data-event="backColor" data-value="#397B21" title="" data-toggle="button" tabindex="-1" data-original-title="#397B21"></button><button type="button" class="note-color-btn" style="background-color:#104A5A" data-event="backColor" data-value="#104A5A" title="" data-toggle="button" tabindex="-1" data-original-title="#104A5A"></button><button type="button" class="note-color-btn" style="background-color:#085294" data-event="backColor" data-value="#085294" title="" data-toggle="button" tabindex="-1" data-original-title="#085294"></button><button type="button" class="note-color-btn" style="background-color:#311873" data-event="backColor" data-value="#311873" title="" data-toggle="button" tabindex="-1" data-original-title="#311873"></button><button type="button" class="note-color-btn" style="background-color:#731842" data-event="backColor" data-value="#731842" title="" data-toggle="button" tabindex="-1" data-original-title="#731842"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#630000" data-event="backColor" data-value="#630000" title="" data-toggle="button" tabindex="-1" data-original-title="#630000"></button><button type="button" class="note-color-btn" style="background-color:#7B3900" data-event="backColor" data-value="#7B3900" title="" data-toggle="button" tabindex="-1" data-original-title="#7B3900"></button><button type="button" class="note-color-btn" style="background-color:#846300" data-event="backColor" data-value="#846300" title="" data-toggle="button" tabindex="-1" data-original-title="#846300"></button><button type="button" class="note-color-btn" style="background-color:#295218" data-event="backColor" data-value="#295218" title="" data-toggle="button" tabindex="-1" data-original-title="#295218"></button><button type="button" class="note-color-btn" style="background-color:#083139" data-event="backColor" data-value="#083139" title="" data-toggle="button" tabindex="-1" data-original-title="#083139"></button><button type="button" class="note-color-btn" style="background-color:#003163" data-event="backColor" data-value="#003163" title="" data-toggle="button" tabindex="-1" data-original-title="#003163"></button><button type="button" class="note-color-btn" style="background-color:#21104A" data-event="backColor" data-value="#21104A" title="" data-toggle="button" tabindex="-1" data-original-title="#21104A"></button><button type="button" class="note-color-btn" style="background-color:#4A1031" data-event="backColor" data-value="#4A1031" title="" data-toggle="button" tabindex="-1" data-original-title="#4A1031"></button></div></div></div></div><div class="btn-group">  <div class="note-palette-title">Fonte</div>  <div>    <button type="button" class="note-color-reset btn btn-default" data-event="removeFormat" data-value="foreColor">Restaurar padrão    </button>  </div>  <div class="note-holder" data-event="foreColor"><div class="note-color-palette"><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#000000" data-event="foreColor" data-value="#000000" title="" data-toggle="button" tabindex="-1" data-original-title="#000000"></button><button type="button" class="note-color-btn" style="background-color:#424242" data-event="foreColor" data-value="#424242" title="" data-toggle="button" tabindex="-1" data-original-title="#424242"></button><button type="button" class="note-color-btn" style="background-color:#636363" data-event="foreColor" data-value="#636363" title="" data-toggle="button" tabindex="-1" data-original-title="#636363"></button><button type="button" class="note-color-btn" style="background-color:#9C9C94" data-event="foreColor" data-value="#9C9C94" title="" data-toggle="button" tabindex="-1" data-original-title="#9C9C94"></button><button type="button" class="note-color-btn" style="background-color:#CEC6CE" data-event="foreColor" data-value="#CEC6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#CEC6CE"></button><button type="button" class="note-color-btn" style="background-color:#EFEFEF" data-event="foreColor" data-value="#EFEFEF" title="" data-toggle="button" tabindex="-1" data-original-title="#EFEFEF"></button><button type="button" class="note-color-btn" style="background-color:#F7F7F7" data-event="foreColor" data-value="#F7F7F7" title="" data-toggle="button" tabindex="-1" data-original-title="#F7F7F7"></button><button type="button" class="note-color-btn" style="background-color:#FFFFFF" data-event="foreColor" data-value="#FFFFFF" title="" data-toggle="button" tabindex="-1" data-original-title="#FFFFFF"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#FF0000" data-event="foreColor" data-value="#FF0000" title="" data-toggle="button" tabindex="-1" data-original-title="#FF0000"></button><button type="button" class="note-color-btn" style="background-color:#FF9C00" data-event="foreColor" data-value="#FF9C00" title="" data-toggle="button" tabindex="-1" data-original-title="#FF9C00"></button><button type="button" class="note-color-btn" style="background-color:#FFFF00" data-event="foreColor" data-value="#FFFF00" title="" data-toggle="button" tabindex="-1" data-original-title="#FFFF00"></button><button type="button" class="note-color-btn" style="background-color:#00FF00" data-event="foreColor" data-value="#00FF00" title="" data-toggle="button" tabindex="-1" data-original-title="#00FF00"></button><button type="button" class="note-color-btn" style="background-color:#00FFFF" data-event="foreColor" data-value="#00FFFF" title="" data-toggle="button" tabindex="-1" data-original-title="#00FFFF"></button><button type="button" class="note-color-btn" style="background-color:#0000FF" data-event="foreColor" data-value="#0000FF" title="" data-toggle="button" tabindex="-1" data-original-title="#0000FF"></button><button type="button" class="note-color-btn" style="background-color:#9C00FF" data-event="foreColor" data-value="#9C00FF" title="" data-toggle="button" tabindex="-1" data-original-title="#9C00FF"></button><button type="button" class="note-color-btn" style="background-color:#FF00FF" data-event="foreColor" data-value="#FF00FF" title="" data-toggle="button" tabindex="-1" data-original-title="#FF00FF"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#F7C6CE" data-event="foreColor" data-value="#F7C6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#F7C6CE"></button><button type="button" class="note-color-btn" style="background-color:#FFE7CE" data-event="foreColor" data-value="#FFE7CE" title="" data-toggle="button" tabindex="-1" data-original-title="#FFE7CE"></button><button type="button" class="note-color-btn" style="background-color:#FFEFC6" data-event="foreColor" data-value="#FFEFC6" title="" data-toggle="button" tabindex="-1" data-original-title="#FFEFC6"></button><button type="button" class="note-color-btn" style="background-color:#D6EFD6" data-event="foreColor" data-value="#D6EFD6" title="" data-toggle="button" tabindex="-1" data-original-title="#D6EFD6"></button><button type="button" class="note-color-btn" style="background-color:#CEDEE7" data-event="foreColor" data-value="#CEDEE7" title="" data-toggle="button" tabindex="-1" data-original-title="#CEDEE7"></button><button type="button" class="note-color-btn" style="background-color:#CEE7F7" data-event="foreColor" data-value="#CEE7F7" title="" data-toggle="button" tabindex="-1" data-original-title="#CEE7F7"></button><button type="button" class="note-color-btn" style="background-color:#D6D6E7" data-event="foreColor" data-value="#D6D6E7" title="" data-toggle="button" tabindex="-1" data-original-title="#D6D6E7"></button><button type="button" class="note-color-btn" style="background-color:#E7D6DE" data-event="foreColor" data-value="#E7D6DE" title="" data-toggle="button" tabindex="-1" data-original-title="#E7D6DE"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#E79C9C" data-event="foreColor" data-value="#E79C9C" title="" data-toggle="button" tabindex="-1" data-original-title="#E79C9C"></button><button type="button" class="note-color-btn" style="background-color:#FFC69C" data-event="foreColor" data-value="#FFC69C" title="" data-toggle="button" tabindex="-1" data-original-title="#FFC69C"></button><button type="button" class="note-color-btn" style="background-color:#FFE79C" data-event="foreColor" data-value="#FFE79C" title="" data-toggle="button" tabindex="-1" data-original-title="#FFE79C"></button><button type="button" class="note-color-btn" style="background-color:#B5D6A5" data-event="foreColor" data-value="#B5D6A5" title="" data-toggle="button" tabindex="-1" data-original-title="#B5D6A5"></button><button type="button" class="note-color-btn" style="background-color:#A5C6CE" data-event="foreColor" data-value="#A5C6CE" title="" data-toggle="button" tabindex="-1" data-original-title="#A5C6CE"></button><button type="button" class="note-color-btn" style="background-color:#9CC6EF" data-event="foreColor" data-value="#9CC6EF" title="" data-toggle="button" tabindex="-1" data-original-title="#9CC6EF"></button><button type="button" class="note-color-btn" style="background-color:#B5A5D6" data-event="foreColor" data-value="#B5A5D6" title="" data-toggle="button" tabindex="-1" data-original-title="#B5A5D6"></button><button type="button" class="note-color-btn" style="background-color:#D6A5BD" data-event="foreColor" data-value="#D6A5BD" title="" data-toggle="button" tabindex="-1" data-original-title="#D6A5BD"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#E76363" data-event="foreColor" data-value="#E76363" title="" data-toggle="button" tabindex="-1" data-original-title="#E76363"></button><button type="button" class="note-color-btn" style="background-color:#F7AD6B" data-event="foreColor" data-value="#F7AD6B" title="" data-toggle="button" tabindex="-1" data-original-title="#F7AD6B"></button><button type="button" class="note-color-btn" style="background-color:#FFD663" data-event="foreColor" data-value="#FFD663" title="" data-toggle="button" tabindex="-1" data-original-title="#FFD663"></button><button type="button" class="note-color-btn" style="background-color:#94BD7B" data-event="foreColor" data-value="#94BD7B" title="" data-toggle="button" tabindex="-1" data-original-title="#94BD7B"></button><button type="button" class="note-color-btn" style="background-color:#73A5AD" data-event="foreColor" data-value="#73A5AD" title="" data-toggle="button" tabindex="-1" data-original-title="#73A5AD"></button><button type="button" class="note-color-btn" style="background-color:#6BADDE" data-event="foreColor" data-value="#6BADDE" title="" data-toggle="button" tabindex="-1" data-original-title="#6BADDE"></button><button type="button" class="note-color-btn" style="background-color:#8C7BC6" data-event="foreColor" data-value="#8C7BC6" title="" data-toggle="button" tabindex="-1" data-original-title="#8C7BC6"></button><button type="button" class="note-color-btn" style="background-color:#C67BA5" data-event="foreColor" data-value="#C67BA5" title="" data-toggle="button" tabindex="-1" data-original-title="#C67BA5"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#CE0000" data-event="foreColor" data-value="#CE0000" title="" data-toggle="button" tabindex="-1" data-original-title="#CE0000"></button><button type="button" class="note-color-btn" style="background-color:#E79439" data-event="foreColor" data-value="#E79439" title="" data-toggle="button" tabindex="-1" data-original-title="#E79439"></button><button type="button" class="note-color-btn" style="background-color:#EFC631" data-event="foreColor" data-value="#EFC631" title="" data-toggle="button" tabindex="-1" data-original-title="#EFC631"></button><button type="button" class="note-color-btn" style="background-color:#6BA54A" data-event="foreColor" data-value="#6BA54A" title="" data-toggle="button" tabindex="-1" data-original-title="#6BA54A"></button><button type="button" class="note-color-btn" style="background-color:#4A7B8C" data-event="foreColor" data-value="#4A7B8C" title="" data-toggle="button" tabindex="-1" data-original-title="#4A7B8C"></button><button type="button" class="note-color-btn" style="background-color:#3984C6" data-event="foreColor" data-value="#3984C6" title="" data-toggle="button" tabindex="-1" data-original-title="#3984C6"></button><button type="button" class="note-color-btn" style="background-color:#634AA5" data-event="foreColor" data-value="#634AA5" title="" data-toggle="button" tabindex="-1" data-original-title="#634AA5"></button><button type="button" class="note-color-btn" style="background-color:#A54A7B" data-event="foreColor" data-value="#A54A7B" title="" data-toggle="button" tabindex="-1" data-original-title="#A54A7B"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#9C0000" data-event="foreColor" data-value="#9C0000" title="" data-toggle="button" tabindex="-1" data-original-title="#9C0000"></button><button type="button" class="note-color-btn" style="background-color:#B56308" data-event="foreColor" data-value="#B56308" title="" data-toggle="button" tabindex="-1" data-original-title="#B56308"></button><button type="button" class="note-color-btn" style="background-color:#BD9400" data-event="foreColor" data-value="#BD9400" title="" data-toggle="button" tabindex="-1" data-original-title="#BD9400"></button><button type="button" class="note-color-btn" style="background-color:#397B21" data-event="foreColor" data-value="#397B21" title="" data-toggle="button" tabindex="-1" data-original-title="#397B21"></button><button type="button" class="note-color-btn" style="background-color:#104A5A" data-event="foreColor" data-value="#104A5A" title="" data-toggle="button" tabindex="-1" data-original-title="#104A5A"></button><button type="button" class="note-color-btn" style="background-color:#085294" data-event="foreColor" data-value="#085294" title="" data-toggle="button" tabindex="-1" data-original-title="#085294"></button><button type="button" class="note-color-btn" style="background-color:#311873" data-event="foreColor" data-value="#311873" title="" data-toggle="button" tabindex="-1" data-original-title="#311873"></button><button type="button" class="note-color-btn" style="background-color:#731842" data-event="foreColor" data-value="#731842" title="" data-toggle="button" tabindex="-1" data-original-title="#731842"></button></div><div class="note-color-row"><button type="button" class="note-color-btn" style="background-color:#630000" data-event="foreColor" data-value="#630000" title="" data-toggle="button" tabindex="-1" data-original-title="#630000"></button><button type="button" class="note-color-btn" style="background-color:#7B3900" data-event="foreColor" data-value="#7B3900" title="" data-toggle="button" tabindex="-1" data-original-title="#7B3900"></button><button type="button" class="note-color-btn" style="background-color:#846300" data-event="foreColor" data-value="#846300" title="" data-toggle="button" tabindex="-1" data-original-title="#846300"></button><button type="button" class="note-color-btn" style="background-color:#295218" data-event="foreColor" data-value="#295218" title="" data-toggle="button" tabindex="-1" data-original-title="#295218"></button><button type="button" class="note-color-btn" style="background-color:#083139" data-event="foreColor" data-value="#083139" title="" data-toggle="button" tabindex="-1" data-original-title="#083139"></button><button type="button" class="note-color-btn" style="background-color:#003163" data-event="foreColor" data-value="#003163" title="" data-toggle="button" tabindex="-1" data-original-title="#003163"></button><button type="button" class="note-color-btn" style="background-color:#21104A" data-event="foreColor" data-value="#21104A" title="" data-toggle="button" tabindex="-1" data-original-title="#21104A"></button><button type="button" class="note-color-btn" style="background-color:#4A1031" data-event="foreColor" data-value="#4A1031" title="" data-toggle="button" tabindex="-1" data-original-title="#4A1031"></button></div></div></div></div></li></div></div></div><div class="note-btn-group btn-group note-para"><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Lista com marcadores (CTRL+SHIFT+NUM7)"><i class="note-icon-unorderedlist"></i></button><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Lista numerada (CTRL+SHIFT+NUM8)"><i class="note-icon-orderedlist"></i></button><div class="note-btn-group btn-group"><button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Parágrafo" aria-expanded="false"><i class="note-icon-align-left"></i> <span class="note-icon-caret"></span></button><div class="dropdown-menu"><div class="note-btn-group btn-group note-align"><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Alinhar à esquerda (CTRL+SHIFT+L)"><i class="note-icon-align-left"></i></button><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Alinhar ao centro (CTRL+SHIFT+E)"><i class="note-icon-align-center"></i></button><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Alinha à direita (CTRL+SHIFT+R)"><i class="note-icon-align-right"></i></button><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Justificado (CTRL+SHIFT+J)"><i class="note-icon-align-justify"></i></button></div><div class="note-btn-group btn-group note-list"><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Menor tabulação (CTRL+[)"><i class="note-icon-align-outdent"></i></button><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Maior tabulação (CTRL+])"><i class="note-icon-align-indent"></i></button></div></div></div></div><div class="note-btn-group btn-group note-table"><div class="note-btn-group btn-group"><button type="button" class="note-btn btn btn-default btn-sm dropdown-toggle" tabindex="-1" data-toggle="dropdown" title="" data-original-title="Tabela"><i class="note-icon-table"></i> <span class="note-icon-caret"></span></button><div class="dropdown-menu note-table"><div class="note-dimension-picker">  <div class="note-dimension-picker-mousecatcher" data-event="insertTable" data-value="1x1" style="width: 10em; height: 10em;"></div>  <div class="note-dimension-picker-highlighted"></div>  <div class="note-dimension-picker-unhighlighted"></div></div><div class="note-dimension-display">1 x 1</div></div></div></div><div class="note-btn-group btn-group note-insert"><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Link (CTRL+K)"><i class="note-icon-link"></i></button><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Picture"><i class="note-icon-picture"></i></button><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Vídeo"><i class="note-icon-video"></i></button></div><div class="note-btn-group btn-group note-view"><button type="button" class="note-btn btn btn-default btn-sm btn-fullscreen" tabindex="-1" title="" data-original-title="Tela cheia"><i class="note-icon-arrows-alt"></i></button><button type="button" class="note-btn btn btn-default btn-sm btn-codeview" tabindex="-1" title="" data-original-title="Ver código-fonte"><i class="note-icon-code"></i></button><button type="button" class="note-btn btn btn-default btn-sm" tabindex="-1" title="" data-original-title="Ajuda"><i class="note-icon-question"></i></button></div></div><div class="note-editing-area"><div class="note-handle"><div class="note-control-selection" style="display: none;"><div class="note-control-selection-bg"></div><div class="note-control-holder note-control-nw"></div><div class="note-control-holder note-control-ne"></div><div class="note-control-holder note-control-sw"></div><div class="note-control-sizing note-control-se"></div><div class="note-control-selection-info"></div></div></div><textarea class="note-codable"></textarea><div tabindex="-1" style="position: absolute; left: -100000px; opacity: 0;" contenteditable="true"></div><div class="note-editable panel-body" style="height: 300px;" contenteditable="true"><ol><li><br></li></ol></div></div><div class="note-statusbar">  <div class="note-resizebar">    <div class="note-icon-bar"></div>    <div class="note-icon-bar"></div>    <div class="note-icon-bar"></div>  </div></div><div class="modal link-dialog" aria-hidden="false" tabindex="-1" style="display: none;"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Inserir link</h4>    </div>    <div class="modal-body"><div class="form-group"><label>Texto para exibir</label><input class="note-link-text form-control" type="text"></div><div class="form-group"><label>Para qual URL esse link leva?</label><input class="note-link-url form-control" type="text" value="http://"></div><div class="checkbox"><label><input type="checkbox" checked=""> Abrir em uma nova janela</label></div></div>    <div class="modal-footer"><button href="#" class="btn btn-primary note-link-btn disabled" disabled="disabled">Inserir link</button></div>  </div></div></div><div class="modal" aria-hidden="false" tabindex="-1"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Inserir imagem</h4>    </div>    <div class="modal-body"><div class="form-group note-group-select-from-files"><label>Selecione a partir dos arquivos</label><input class="note-image-input form-control" type="file" name="files" accept="image/*" multiple="multiple"></div><div class="form-group note-group-image-url" style="overflow:auto;"><label>URL da imagem</label><input class="note-image-url form-control col-md-12" type="text"></div></div>    <div class="modal-footer"><button href="#" class="btn btn-primary note-image-btn disabled" disabled="">Inserir imagem</button></div>  </div></div></div><div class="modal" aria-hidden="false" tabindex="-1"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Inserir vídeo</h4>    </div>    <div class="modal-body"><div class="form-group row-fluid"><label>URL do vídeo? <small class="text-muted">(YouTube, Vimeo, Vine, Instagram, DailyMotion ou Youku)</small></label><input class="note-video-url form-control span12" type="text"></div></div>    <div class="modal-footer"><button href="#" class="btn btn-primary note-video-btn disabled" disabled="">Inserir vídeo</button></div>  </div></div></div><div class="modal" aria-hidden="false" tabindex="-1"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Ajuda</h4>    </div>    <div class="modal-body" style="max-height: 300px; overflow: scroll;"><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>ENTER</kbd></label><span>Inserir Parágrafo</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+Z</kbd></label><span>Desfazer o último comando</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+Y</kbd></label><span>Refazer o último comando</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>TAB</kbd></label><span>Tab</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>SHIFT+TAB</kbd></label><span>Desfazer tab</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+B</kbd></label><span>Colocar em negrito</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+I</kbd></label><span>Colocar em itálico</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+U</kbd></label><span>Sublinhado</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+S</kbd></label><span>Tachado</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+BACKSLASH</kbd></label><span>Remover estilo</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+L</kbd></label><span>Alinhar à esquerda</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+E</kbd></label><span>Centralizar</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+R</kbd></label><span>Alinhar à esquerda</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+J</kbd></label><span>Justificar</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+NUM7</kbd></label><span>Lista não ordenada</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+SHIFT+NUM8</kbd></label><span>Lista ordenada</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+LEFTBRACKET</kbd></label><span>Recuar parágrafo atual</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+RIGHTBRACKET</kbd></label><span>Avançar parágrafo atual</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM0</kbd></label><span>Alterar formato do bloco para parágrafo(tag P)</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM1</kbd></label><span>Alterar formato do bloco para H1</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM2</kbd></label><span>Alterar formato do bloco para H2</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM3</kbd></label><span>Alterar formato do bloco para H3</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM4</kbd></label><span>Alterar formato do bloco para H4</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM5</kbd></label><span>Alterar formato do bloco para H5</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+NUM6</kbd></label><span>Alterar formato do bloco para H6</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+ENTER</kbd></label><span>Inserir régua horizontal</span><div class="help-list-item"></div><label style="width: 180px; margin-right: 10px;"><kbd>CTRL+K</kbd></label><span>Inserir um Hiperlink</span></div>    <div class="modal-footer"><p class="text-center"><a href="http://summernote.org/" target="_blank">Summernote 0.8.2</a> · <a href="https://github.com/summernote/summernote" target="_blank">Project</a> · <a href="https://github.com/summernote/summernote/issues" target="_blank">Issues</a></p></div>  </div></div></div><div class="modal" aria-hidden="false" tabindex="-1"><div class="modal-dialog">  <div class="modal-content">    <div class="modal-header">      <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span></button>      <h4 class="modal-title">Image Attributes</h4>    </div>    <div class="modal-body"><div class="form-group"><label for="note-image-attributes-title" class="control-label col-xs-2">Title</label><div class="input-group col-xs-10"><input type="text" id="note-image-attributes-title" class="note-image-attributes-title form-control"></div></div><div class="form-group"><label for="note-image-attributes-src" class="control-label col-xs-2">Source</label><div class="input-group col-xs-10"><input type="text" id="note-image-attributes-src" class="note-image-attributes-src form-control"></div></div><div class="form-group note-group-select-from-files"><label class="control-label col-xs-2"></label><div class="input-group col-xs-10"><input class="note-image-input form-control" type="file" name="file" accept="image/*"><small class="help-block">Selecting an image will replace existing image with an Inlined Image.</small></div></div><div class="form-group"><label for="note-image-attributes-alt" class="control-label col-xs-2">Alt</label><div class="input-group col-xs-10"><input type="text" id="note-image-attributes-alt" class="note-image-attributes-alt form-control"></div></div><h4>Link Attributes</h4><hr><div class="form-group"><label for="note-image-attributes-link-href" class="control-label col-xs-2">URL</label><div class="input-group col-xs-10"><input type="text" id="note-image-attributes-link-href" class="note-image-attributes-href form-control"></div></div><div class="form-group"><label for="note-image-attributes-link-target" class="control-label col-xs-2">Target</label><div class="input-group col-xs-10"><select id="note-image-attributes-link-target" class="note-image-attributes-target form-control"><option value="_self">Self</option><option value="_blank">Blank</option><option value="_top">Top</option><option value="_parent">Parent</option></select></div></div></div>    <div class="modal-footer"><button href="#" class="btn btn-primary note-image-attributes-btn">OK</button></div>  </div></div></div></div>
                      </div>
                    </div>
                    <div class="form-group required">
                      <label class="col-sm-2 control-label" for="input-meta-title2">Meta título</label>
                      <div class="col-sm-10">
                        <input type="text" name="product_description[2][meta_title]" value="" placeholder="Meta título" id="input-meta-title2" class="form-control">
                         </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label" for="input-meta-description2">Meta descrição</label>
                      <div class="col-sm-10">
                        <textarea name="product_description[2][meta_description]" rows="5" placeholder="Meta descrição" id="input-meta-description2" class="form-control"></textarea>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label" for="input-meta-keyword2">Meta palavras-chave</label>
                      <div class="col-sm-10">
                        <textarea name="product_description[2][meta_keyword]" rows="5" placeholder="Meta palavras-chave" id="input-meta-keyword2" class="form-control"></textarea>
                      </div>
                    </div>
                    <div class="form-group">
                      <label class="col-sm-2 control-label" for="input-tag2"><span data-toggle="tooltip" title="" data-original-title="Separadas por vírgulas">Etiquetas</span></label>
                      <div class="col-sm-10">
                        <input type="text" name="product_description[2][tag]" value="" placeholder="Etiquetas" id="input-tag2" class="form-control">
                      </div>
                    </div>
                  </div>
                </div>
            </div>
            <div class="tab-pane" id="tab-data">
              <div class="form-group required">
                <label class="col-sm-2 control-label" for="input-model">Modelo</label>
                <div class="col-sm-10">
                  <input type="text" name="model" value="" placeholder="Modelo" id="input-model" class="form-control">
                  </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-sku"><span data-toggle="tooltip" title="" data-original-title="É o código ligado à logística de armazém, e designa os diferentes produtos do estoque.">SKU</span></label>
                <div class="col-sm-10">
                  <input type="text" name="sku" value="" placeholder="SKU" id="input-sku" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-upc"><span data-toggle="tooltip" title="" data-original-title="É o mesmo que UPC, que significa Código Universal de Produtos.">Código de barras</span></label>
                <div class="col-sm-10">
                  <input type="text" name="upc" value="" placeholder="Código de barras" id="input-upc" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-ean"><span data-toggle="tooltip" title="" data-original-title="Significa Número de Artigo Europeu">EAN</span></label>
                <div class="col-sm-10">
                  <input type="text" name="ean" value="" placeholder="EAN" id="input-ean" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-jan"><span data-toggle="tooltip" title="" data-original-title="Significa Número de Artigo Japonês">JAN</span></label>
                <div class="col-sm-10">
                  <input type="text" name="jan" value="" placeholder="JAN" id="input-jan" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-isbn"><span data-toggle="tooltip" title="" data-original-title="Significa Número Padrão Internacional de Livro. É o código de identificação utilizado em livros.">ISBN</span></label>
                <div class="col-sm-10">
                  <input type="text" name="isbn" value="" placeholder="ISBN" id="input-isbn" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-mpn"><span data-toggle="tooltip" title="" data-original-title="Significa Número da Peça do Fabricante. É o código usado pelos fabricantes para identificar os seus produtos.">MPN</span></label>
                <div class="col-sm-10">
                  <input type="text" name="mpn" value="" placeholder="MPN" id="input-mpn" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-location">Localização</label>
                <div class="col-sm-10">
                  <input type="text" name="location" value="" placeholder="Localização" id="input-location" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-price">Preço</label>
                <div class="col-sm-10">
                  <input type="text" name="price" value="" placeholder="Preço" id="input-price" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-tax-class">Grupo de impostos</label>
                <div class="col-sm-10">
                  <select name="tax_class_id" id="input-tax-class" class="form-control">
                    <option value="0"> --- Vazio --- </option>


                                          

                        <option value="9">Taxable Goods</option>


                                                                

                        <option value="10">Downloadable Products</option>


                                                                

                        <option value="11">Simples nacional</option>


                                          

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-quantity">Quantidade</label>
                <div class="col-sm-10">
                  <input type="text" name="quantity" value="1" placeholder="Quantidade" id="input-quantity" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="" data-original-title="Forçar uma quantidade mínima a ser vendida.">Mínimo por venda</span></label>
                <div class="col-sm-10">
                  <input type="text" name="minimum" value="1" placeholder="Mínimo por venda" id="input-minimum" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-subtract">Reduzir estoque?</label>
                <div class="col-sm-10">
                  <select name="subtract" id="input-subtract" class="form-control">


                    

                      <option value="1" selected="selected">Sim</option>
                      <option value="0">Não</option>


                    

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-stock-status"><span data-toggle="tooltip" title="" data-original-title="Situação do produto quando está fora de estoque">Se esgotado</span></label>
                <div class="col-sm-10">
                  <select name="stock_status_id" id="input-stock-status" class="form-control">


                                          

                        <option value="6">2-3 dias</option>


                                                                

                        <option value="7">Em estoque</option>


                                                                

                        <option value="8">Encomendar</option>


                                                                

                        <option value="5">Esgotado</option>


                                          

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Precisa de frete?</label>
                <div class="col-sm-10">
                  <label class="radio-inline">                       <input type="radio" name="shipping" value="1" checked="checked">
                      Sim
                     </label> <label class="radio-inline">                       <input type="radio" name="shipping" value="0">
                      Não
                     </label>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-date-available">Disponível a partir de</label>
                <div class="col-sm-3">
                  <div class="input-group date">
                    <input type="text" name="date_available" value="2020-04-25" placeholder="Disponível a partir de" data-date-format="YYYY-MM-DD" id="input-date-available" class="form-control"> <span class="input-group-btn">
                    <button class="btn btn-default" type="button"><i class="fa fa-calendar"></i></button>
                    </span></div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-length">Dimensões (C x L x A)</label>
                <div class="col-sm-10">
                  <div class="row">
                    <div class="col-sm-4">
                      <input type="text" name="length" value="" placeholder="Comprimento" id="input-length" class="form-control">
                    </div>
                    <div class="col-sm-4">
                      <input type="text" name="width" value="" placeholder="Largura" id="input-width" class="form-control">
                    </div>
                    <div class="col-sm-4">
                      <input type="text" name="height" value="" placeholder="Altura" id="input-height" class="form-control">
                    </div>
                  </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-length-class">Unidade de medida</label>
                <div class="col-sm-10">
                  <select name="length_class_id" id="input-length-class" class="form-control">


                                          

                        <option value="1" selected="selected">Centímetros</option>


                                                                

                        <option value="2">Millimetro</option>


                                                                

                        <option value="3">Polegada</option>


                                                                

                        <option value="4">Litros</option>


                                                                

                        <option value="5">Mililitros</option>


                                          

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-weight">Peso</label>
                <div class="col-sm-10">
                  <input type="text" name="weight" value="" placeholder="Peso" id="input-weight" class="form-control">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-weight-class">Unidade de peso</label>
                <div class="col-sm-10">
                  <select name="weight_class_id" id="input-weight-class" class="form-control">


                                          

                        <option value="1" selected="selected">Kilograma</option>


                                                                

                        <option value="2">Grama</option>


                                                                

                        <option value="5">Libra</option>


                                                                

                        <option value="6">Onça</option>


                                          

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-status">Situação</label>
                <div class="col-sm-10">
                  <select name="status" id="input-status" class="form-control">


                    

                      <option value="1" selected="selected">Habilitado</option>
                      <option value="0">Desabilitado</option>


                    

                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-sort-order">Posição</label>
                <div class="col-sm-10">
                  <input type="text" name="sort_order" value="1" placeholder="Posição" id="input-sort-order" class="form-control">
                </div>
              </div>
            </div>
            <div class="tab-pane" id="tab-links">
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-manufacturer"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Marcas</span></label>
                <div class="col-sm-10">
                  <input type="text" name="manufacturer" value="" placeholder="Marcas" id="input-manufacturer" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul> <input type="hidden" name="manufacturer_id" value="0">
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-category"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Departamentos</span></label>
                <div class="col-sm-10">
                  <input type="text" name="category" value="" placeholder="Departamentos" id="input-category" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                  <div id="product-category" class="well well-sm" style="height: 150px; overflow: auto;"> </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-filter"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Filtros</span></label>
                <div class="col-sm-10">
                  <input type="text" name="filter" value="" placeholder="Filtros" id="input-filter" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                  <div id="product-filter" class="well well-sm" style="height: 150px; overflow: auto;"> </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label">Loja</label>
                <div class="col-sm-10">
                  <div class="well well-sm" style="height: 150px; overflow: auto;">                       <div class="checkbox">
                        <label>                             <input type="checkbox" name="product_store[]" value="0" checked="checked">
                            Padrão
                           </label>
                      </div>
                    </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-download"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Downloads</span></label>
                <div class="col-sm-10">
                  <input type="text" name="download" value="" placeholder="Downloads" id="input-download" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                  <div id="product-download" class="well well-sm" style="height: 150px; overflow: auto;"> </div>
                </div>
              </div>
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-related"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Produtos relacionados</span></label>
                <div class="col-sm-10">
                  <input type="text" name="related" value="" placeholder="Produtos relacionados" id="input-related" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                  <div id="product-related" class="well well-sm" style="height: 150px; overflow: auto;"> </div>
                </div>
              </div>
            </div>
            <div class="tab-pane" id="tab-attribute">
              <div class="table-responsive">
                <table id="attribute" class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Atributo</td>
                      <td class="text-left">Texto</td>
                      <td></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="2"></td>
                      <td class="text-right"><button type="button" onclick="addAttribute();" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar atributo"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-option">
              <div class="row">
                <div class="col-sm-2">
                  <ul class="nav nav-pills nav-stacked" id="option">
                                                            <li>
                      <input type="text" name="option" value="" placeholder="Opção" id="input-option" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                    </li>
                  </ul>
                </div>
                <div class="col-sm-10">
                  <div class="tab-content">                                          </div>
                </div>
              </div>
            </div>
            <div class="tab-pane" id="tab-recurring">
              <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Tipo de assinatura</td>
                      <td class="text-left">Tipo de cliente</td>
                      <td class="text-left"></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="2"></td>
                      <td class="text-left"><button type="button" onclick="addRecurring()" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar assinatura"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-discount">
              <div class="table-responsive">
                <table id="discount" class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Tipo de cliente</td>
                      <td class="text-right">Quantidade</td>
                      <td class="text-right">Prioridade</td>
                      <td class="text-right">Preço</td>
                      <td class="text-left">Data inicial</td>
                      <td class="text-left">Data final</td>
                      <td></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="6"></td>
                      <td class="text-left"><button type="button" onclick="addDiscount();" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar desconto"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-special">
              <div class="table-responsive">
                <table id="special" class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Tipo de cliente</td>
                      <td class="text-right">Prioridade</td>
                      <td class="text-right">Preço</td>
                      <td class="text-left">Data inicial</td>
                      <td class="text-left">Data final</td>
                      <td></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="5"></td>
                      <td class="text-left"><button type="button" onclick="addSpecial();" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar promoção"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-image">
              <div class="table-responsive">
                <table class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Imagem</td>
                    </tr>
                  </thead>
                  <tbody>
                    <tr>
                      <td class="text-left"><a href="" id="thumb-image" data-toggle="image" class="img-thumbnail"><img src="http://localhost/image/cache/no_image-100x100.png" alt="" title="" data-placeholder="http://localhost/image/cache/no_image-100x100.png"></a> <input type="hidden" name="image" value="" id="input-image"></td>
                    </tr>
                  </tbody>
                </table>
              </div>
              <div class="table-responsive">
                <table id="images" class="table table-striped table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Imagens adicionais</td>
                      <td class="text-right">Posição</td>
                      <td></td>
                    </tr>
                  </thead>
                  <tbody>

                                                          </tbody>

                  <tfoot>
                    <tr>
                      <td colspan="2"></td>
                      <td class="text-left"><button type="button" onclick="addImage();" data-toggle="tooltip" title="" class="btn btn-primary" data-original-title="Adicionar imagem"><i class="fa fa-plus-circle"></i></button></td>
                    </tr>
                  </tfoot>
                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-reward">
              <div class="form-group">
                <label class="col-sm-2 control-label" for="input-points"><span data-toggle="tooltip" title="" data-original-title="Número de pontos necessários para comprar este produto. Se você não deseja que este produto seja comprado com pontos, coloque 0.">Pontos</span></label>
                <div class="col-sm-10">
                  <input type="text" name="points" value="" placeholder="Pontos" id="input-points" class="form-control">
                </div>
              </div>
              <div class="table-responsive">
                <table class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Tipo de cliente</td>
                      <td class="text-right">Pontos</td>
                    </tr>
                  </thead>
                  <tbody>

                                          <tr>
                        <td class="text-left">Default</td>
                        <td class="text-right"><input type="text" name="product_reward[1][points]" value="" class="form-control"></td>
                      </tr>
                                      </tbody>

                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-seo">
              <div class="alert alert-info"><i class="fa fa-info-circle"></i> Não utilize espaços, substitua os espaços por - (hífen), e certifique-se que a palavra é exclusiva em toda a loja.</div>
              <div class="table-responsive">
                <table class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Loja</td>
                      <td class="text-left">URL amigável</td>
                    </tr>
                  </thead>
                  <tbody>
                                          <tr>
                        <td class="text-left">Padrão</td>
                        <td class="text-left">                            <div class="input-group"><span class="input-group-addon"><img src="language/pt-br/pt-br.png" title="Português"></span> <input type="text" name="product_seo_url[0][2]" value="" placeholder="URL amigável" class="form-control">
                            </div>
                                                      </td>
                      </tr>
                                      </tbody>

                </table>
              </div>
            </div>
            <div class="tab-pane" id="tab-design">
              <div class="table-responsive">
                <table class="table table-bordered table-hover">
                  <thead>
                    <tr>
                      <td class="text-left">Loja</td>
                      <td class="text-left">Layout para este produto</td>
                    </tr>
                  </thead>
                  <tbody>
                                          <tr>
                        <td class="text-left">Padrão</td>
                        <td class="text-left"><select name="product_layout[0]" class="form-control">
                            <option value=""></option>


                                                          

                                <option value="6">Account</option>


                                                                                        

                                <option value="10">Affiliate</option>


                                                                                        

                                <option value="3">Category</option>


                                                                                        

                                <option value="7">Checkout</option>


                                                                                        

                                <option value="12">Compare</option>


                                                                                        

                                <option value="8">Contact</option>


                                                                                        

                                <option value="4">Default</option>


                                                                                        

                                <option value="1">Home</option>


                                                                                        

                                <option value="11">Information</option>


                                                                                        

                                <option value="5">Manufacturer</option>


                                                                                        

                                <option value="2">Product</option>


                                                                                        

                                <option value="14">Produtos em destaque na primeira página</option>


                                                                                        

                                <option value="13">Search</option>


                                                                                        

                                <option value="9">Sitemap</option>


                                                          

                          </select></td>
                      </tr>
                                      </tbody>
                </table>
              </div>
            </div>
          </div>
        </form>
      </div>
            <%@include file="/view/fragments/footer.jsp" %>
        </div>
        <script src="/ZZZ_ag_908/js/formAddress.js"></script>
    </body>
</html>
