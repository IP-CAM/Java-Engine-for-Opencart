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
        <%@include file="/view/fragments/head_datetimepicker.jsp" %>
        <link href="javascript/summernote/summernote.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="javascript/summernote/summernote.js"></script>
        <script type="text/javascript" src="javascript/summernote/lang/summernote-pt-BR.js"></script>         
        <link href="javascript/summernote/summernote.css" rel="stylesheet">
        <script type="text/javascript" src="javascript/summernote/summernote-image-attributes.js"></script>        
        <title>Editar produto</title>
        <script src="js/parameters.js" type="text/javascript"></script>
    </head>
    <body style="background-color: #13181e;">
        <div class="body_wrap">
            <%@include file="/view/fragments/header.jsp" %>
            <div id="checkout-checkout" class="container">                
                <ul class="breadcrumb">
                    <li><a href="home"><i class="fa fa-home"></i></a></li>
                    <li>Produto</li>
                    <li>Modificar</li>
                </ul>
                <div class="container-fluid">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            <h3 class="panel-title"><i class="fa fa-pencil"></i>Editar produto</h3>
                        </div>
                        <div class="panel-body">
                            <c:choose>
                                <c:when test="${empty productList}">
                                    Nenhum produto encontrado.
                                </c:when>
                                <c:otherwise>
                                    <c:forEach var="product" items="${productList}">
                                        <form action="http://localhost/admin/index.php?route=catalog/product/add&amp;user_token=o2lwBgL1Fk4340WOBU60JcUeHn99jjnS" method="post" enctype="multipart/form-data" id="form-product" class="form-horizontal">
                                            <ul class="nav nav-tabs">
                                                <li class="active"><a href="#tab-general" data-toggle="tab">Geral</a></li>
                                                <li><a href="#tab-data" data-toggle="tab">Dados</a></li>
                                                <li><a href="#tab-links" data-toggle="tab">Ligações</a></li>
                                                <li><a href="#tab-attribute" data-toggle="tab">Atributos</a></li>
                                                <li><a href="#tab-option" data-toggle="tab">Opções</a></li>
                                                <li><a href="#tab-discount" data-toggle="tab">Descontos</a></li>
                                                <li><a href="#tab-special" data-toggle="tab">Promoções</a></li>
                                                <li><a href="#tab-image" data-toggle="tab">Imagens</a></li>
                                                <li><a href="#tab-reward" data-toggle="tab">Pontos</a></li>
                                                <li><a href="#tab-seo" data-toggle="tab">SEO</a></li>
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
                                                                    <input type="text" name="product_description[2][name]" value="${product.name}" id="input-name2" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label" for="input-description2">Descrição</label>
                                                                <div class="col-sm-10">                                                                    
                                                                    <textarea id="summernote" name="editordata"></textarea>                        
                                                                    <script>                                                                        
                                                                        var decoded = $('<textarea/>').html(`${product.description}`).text();
                                                                        $('#summernote').summernote('code', decoded) ;
                                                                    </script>
                                                                </div>
                                                            </div>
                                                            <div class="form-group required">
                                                                <label class="col-sm-2 control-label" for="input-meta-title2">Meta título</label>
                                                                <div class="col-sm-10">
                                                                    <input type="text" name="product_description[2][meta_title]" value="${product.metaTitle}" id="input-meta-title2" class="form-control">
                                                                </div>
                                                            </div>
                                                            <div class="form-group">
                                                                <label class="col-sm-2 control-label" for="input-meta-description2">Meta descrição</label>
                                                                <div class="col-sm-10">
                                                                    <textarea name="product_description[2][meta_description]" rows="5" placeholder="${product.metaDescription}" id="input-meta-description2" class="form-control"></textarea>
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
                                                <!-- Aba "Dados do produto" -------------------------------------------------------------------------------------------------------- -->
                                                <div class="tab-pane" id="tab-data">
                                                    <div class="form-group required">
                                                        <label class="col-sm-2 control-label" for="input-model">Modelo</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="model" value="${product.model}" id="input-model" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-sku"><span data-toggle="tooltip" title="" data-original-title="É o código ligado à logística de armazém, e designa os diferentes produtos do estoque.">SKU</span></label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="sku" value="${product.sku}" id="input-sku" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-upc"><span data-toggle="tooltip" title="" data-original-title="É o mesmo que UPC, que significa Código Universal de Produtos.">Código de barras</span></label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="upc" value="${product.upc}" id="input-upc" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-ean"><span data-toggle="tooltip" title="" data-original-title="Significa Número de Artigo Europeu">EAN</span></label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="ean" value="${product.ean}" id="input-ean" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-jan"><span data-toggle="tooltip" title="" data-original-title="Significa Número de Artigo Japonês">JAN</span></label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="jan" value="${product.jan}" id="input-jan" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-isbn"><span data-toggle="tooltip" title="" data-original-title="Significa Número Padrão Internacional de Livro. É o código de identificação utilizado em livros.">ISBN</span></label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="isbn" value="${product.isbn}" id="input-isbn" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-mpn"><span data-toggle="tooltip" title="" data-original-title="Significa Número da Peça do Fabricante. É o código usado pelos fabricantes para identificar os seus produtos.">MPN</span></label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="mpn" value="${product.mpn}" id="input-mpn" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-location">Localização</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="location" value="${product.location}" id="input-location" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-price">Preço R$</label>
                                                        <div class="col-sm-2">
                                                            <fmt:setLocale value="pt-BR"/>
                                                            <input type="number" name="price" data-type="currency" id="input-price2" step="0.01" value="${product.price}" class="form-control" >                                                                
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-tax-class">Grupo de impostos</label>
                                                        <div class="col-sm-10">
                                                            <select name="tax_class_id" id="input-tax-class" class="form-control">
                                                                <option value="11" selected="selected">Simples nacional</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-quantity">Quantidade</label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="quantity" value="${product.quantity}" id="input-quantity" class="form-control">
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-minimum"><span data-toggle="tooltip" title="" data-original-title="Forçar uma quantidade mínima a ser vendida.">Mínimo por venda</span></label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="minimum" value="${product.minimum}" id="input-minimum" class="form-control">
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
                                                            <div id="stockStatus"></div>
                                                        </div>
                                                        <script>stockStatusFunction(${product.stockStatus.id});</script>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label">Precisa de frete?</label>
                                                        <div class="col-sm-10">
                                                            <label class="radio-inline">
                                                                <input type="radio" name="shipping" value="1" checked="checked">Sim</label>
                                                            <label class="radio-inline"><input type="radio" name="shipping" value="0">Não</label>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-date-available"> Disponível a partir de</label>
                                                        <div class="col-sm-3">
                                                            <div class="input-group date">                                                        
                                                                <input type="date" name="date_available" data-date-format="YYYY-MM-DD" id="input-date-available" class="form-control">
                                                                <script>$('#input-date-available').val("${product.dateAvailable}");</script>
                                                                <span class="input-group-btn">
                                                                    <button class="btn btn-default" type="button"><i class="fa fa-calendar"></i></button>
                                                                </span>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-length">Dimensões (C x L x A)</label>
                                                        <div class="col-sm-10">
                                                            <div class="row">
                                                                <div class="col-sm-4"><input type="number" name="length" id="input-length" min="0" class="form-control"></div>
                                                                <div class="col-sm-4"><input type="number" name="width"  id="input-width"  min="0" class="form-control"></div>
                                                                <div class="col-sm-4"><input type="number" name="height" id="input-height" min="0" class="form-control"></div>
                                                                <script>
                                                                    $('#input-length').val(<fmt:formatNumber type="number" maxFractionDigits="3" value="${product.length}" />);
                                                                    $('#input-width').val(<fmt:formatNumber type="number" maxFractionDigits="3" value="${product.width}" />);
                                                                    $('#input-height').val(<fmt:formatNumber type="number" maxFractionDigits="3" value="${product.height}" />);
                                                                </script>
                                                            </div>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-length-class">Unidade de medida</label>
                                                        <div class="col-sm-10">
                                                            <div id="length-unit"></div> 
                                                        </div>                                            
                                                        <script>lengthUnitFunction(${product.lengthClass.id});</script>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-weight">Peso</label>
                                                        <div class="col-sm-10">
                                                            <input type="number" name="weight" id="input-weight" min="0" class="form-control">
                                                            <script>
                                                                $('#input-weight').val(<fmt:formatNumber type="number" value="${product.weight}" />);
                                                            </script>
                                                        </div>
                                                    </div>
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-weight-class">Unidade de peso</label>
                                                        <div class="col-sm-10">
                                                            <div id="weight-unit"></div>                                                
                                                        </div>
                                                        <script>weightUnitFunction('${product.weightClass.id}');</script>
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
                                                            <input type="number" name="sort_order" value="1" placeholder="Posição" id="input-sort-order" min="0" class="form-control">
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- Aba "Ligação" -------------------------------------------------------------------------------------------------------- -->                                    
                                                <div class="tab-pane" id="tab-links">
                                                    <div class="form-group">
                                                        <label class="col-sm-2 control-label" for="input-manufacturer"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Marca</span></label>
                                                        <div class="col-sm-10">
                                                            <select name="manufacturer_id" id="input-manufacturer" class="form-control">
                                                                <c:forEach var="manufacturer" items="${manufacturerList}">
                                                                    <option value="${manufacturer.id}">${manufacturer.name}</option>
                                                                </c:forEach>
                                                            </select>                                                
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
                                                        <label class="col-sm-2 control-label" for="input-related"><span data-toggle="tooltip" title="" data-original-title="(autocompletar)">Produtos relacionados</span></label>
                                                        <div class="col-sm-10">
                                                            <input type="text" name="related" value="" placeholder="Produtos relacionados" id="input-related" class="form-control" autocomplete="off"><ul class="dropdown-menu"></ul>
                                                            <div id="product-related" class="well well-sm" style="height: 150px; overflow: auto;"> </div>
                                                        </div>
                                                    </div>
                                                </div>
                                                <!-- Aba "Atributos" -------------------------------------------------------------------------------------------------------- -->
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
                                                <!-- Aba "Opções" Variação do produto ---------------------------------------------------------------------------------------------------- -->
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
                                                <!-- Aba "Desconto" ---------------------------------------------------------------------------------------------------- -->
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
                                                <!-- Aba "Promoções" --------------------------------------------------------------------------------------------------- -->
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
                                                <!-- Aba "Imagem" --------------------------------------------------------------------------------------------------- -->
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
                                                                    <td class="text-left"><a href="" id="thumb-image" data-toggle="image" class="img-thumbnail"><img src="img/${product.image}" alt="" title="" data-placeholder="${product.name}"></a> <input type="hidden" name="image" value="" id="input-image"></td>
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
                                                                    <td class="text-left">
                                                                        <div class="input-group"><span class="input-group-addon"><img src="language/pt-br/pt-br.png" title="Português"></span> <input type="text" name="product_seo_url[0][2]" value="" placeholder="URL amigável" class="form-control"></div>
                                                                    </td>
                                                                </tr>
                                                            </tbody>
                                                        </table>
                                                    </div>
                                                </div>
                                            </div>
                                        </form>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
            <%@include file="/view/fragments/footer.jsp" %>
        </div>
    </body>
</html>
