updateCart();

function updateCart() {
    // Obter a quantidade de ítens
    if (localStorage.getItem("carrinho")) {
        // Obter a quantidade de ítens
        var carrinho = JSON.parse(localStorage.getItem("carrinho"));
        var quantidade = 0;
        var total = 0;
        var myCart =
                "<li>" +
                "<table class=\"table table-striped\">" +
                "<tbody>";
        carrinho.forEach(function (product, indice) {
            myCart +=
                    "<tr>" +
                    "<td class=\"text-left\"><a href=\"/ZZZ_ag_908/livraria?rca=pIpD&id=" + product.id + "\">" + product.description + "</a></td>" +
                    "<td class=\"text-right\">x " + product.quantity + "</td>" +
                    "<td class=\"text-right\">R$ " + product.price.toFixed(2) + "</td>" +
                    "<td class=\"text-center\"><button type=\"button\" onclick=\"cart.remove('" + product.id + "');\" title=\"Remover\" class=\"btn btn-danger btn-xs\"><i class=\"fa fa-times\"></i></button></td>" +
                    "</tr>";
            total += parseInt(product.quantity) * parseFloat(product.price);
            quantidade += parseInt(product.quantity);
        });
        myCart +=
                "</tbody></table>" +
                "</li>" +
                "<li>" +
                "<div>" +
                "<table class=\"table table-bordered\">" +
                "<tbody><tr>" +
                "<td class=\"text-right\"><strong>Sub-total</strong></td>" +
                "<td class=\"text-right\">R$ " + total.toFixed(2) + "</td>" +
                "</tr>" +
                "<tr>" +
                "<td class=\"text-right\"><strong>Total</strong></td>" +
                "<td class=\"text-right\">R$ " + total.toFixed(2) + "</td>" +
                "</tr>" +
                "</tbody></table>" +
                "<p class=\"text-right\"><a href=\"/ZZZ_ag_908/view/cart/detail.jsp\"><strong><i class=\"fa fa-shopping-cart\"></i> Exibir carrinho</strong></a>x'" +
                "</div>" +
                "</li>";

        $('#cart > button').html('<span id="cart-total"><i class="fa fa-shopping-cart"></i> (' + quantidade + ') - R$ ' + total.toFixed(2) + '</span>');
        $('#cart > ul').html(myCart);
    } else {
        $('#cart > button').html('<span id="cart-total"><i class="fa fa-shopping-cart"></i> Vazio</span>');
        $('#cart > ul').html("<li class=\"text-center\">Vazio</li>");
        $('#cartDetail').html('<span><i class="fa fa-shopping-cart"></i> Não há itens no carrinho! </span>');
    
    }
}


//  Adicionar item ao carrinho -----------------------------------------------------------
var cart = {
    'add': function (product_id) {
        $.ajax({
            url: 'JsonService?entity=Product&action=findOneById',
            type: 'post',
            data: 'id=' + product_id,
            dataType: 'json',
            success: function (json) {
                $('.alert-dismissible').remove();
                json.forEach(function (item, indice) {
                    var quantidade = 1;
                    var carrinho = [];
                    var estaNaLista = false;
                    var total = 0;
                    //Verifica se já tem o mesmo produto no carrinho 
                    if (localStorage.getItem("carrinho")) { // Verifica se o carrinho está vazio
                        carrinho = JSON.parse(localStorage.getItem("carrinho"));
                        carrinho.forEach(function (product, indice) {
                            // console.log(item);
                            if (product_id == product.id) {
                                // se tiver, apenas aumenta a quantidade.
                                product.quantity += 1;
                                estaNaLista = true;
                            }
                            total += parseInt(product.quantity) * parseFloat(product.price);
                            quantidade += parseInt(product.quantity);
                        });
                    }
                    if (!estaNaLista) { //Não está no carrinho
                        jsonProduct = new Object();
                        jsonProduct['id'] = product_id;
                        jsonProduct['image'] = item.image;
                        jsonProduct['quantity'] = 1;
                        jsonProduct['price'] = parseFloat(item.price);
                        jsonProduct['description'] = item.name;
                        carrinho.push(jsonProduct);
                    }
                    localStorage.setItem("carrinho", JSON.stringify(carrinho));
                    // Need to set timeout otherwise it wont update the total
                    setTimeout(function () {
                        // $('#cart > button').html('<span id="cart-total"><i class="fa fa-shopping-cart"></i> (' + quantidade + ') - R$ ' + total.toFixed(2) + '</span>');
                        updateCart();
                    }, 100);

                    $('#content').parent().before('<div class="alert alert-success alert-dismissible"> <i class="fa fa-check-circle"></i> ' + item.name + ' <button type="button" class="close" data-dismiss="alert">&times;</button></div>');
                    $('#compare-total').html(0);
                    $('html, body').animate({scrollTop: 0}, 'slow');
                });
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
            }
        });
    },
    'update': function (key) {
        if (localStorage.getItem("carrinho")) { // Verifica se o carrinho está vazio
            var carrinho = JSON.parse(localStorage.getItem("carrinho"));
            carrinho.forEach(function (product, indice) {
                if (key == product.id) {       
                    carrinho[indice].quantity = document.getElementById(key).value;
                }                
            });
            localStorage.setItem("carrinho", JSON.stringify(carrinho));
            console.log(carrinho);
        }
    },
    'remove': function (id) {
        carrinho = JSON.parse(localStorage.getItem("carrinho"));
        carrinho.forEach(function (item, indice) {
            if (id == item.id) {
                carrinho.splice(indice, 1);
            }
        });
        //Atualiza o LocalStorage
        localStorage.setItem("carrinho", JSON.stringify(carrinho));
        updateCart();
    },
    'confirm': function () {
        event.preventDefault();
        if (localStorage.getItem("carrinho")) { // Verifica se o carrinho está vazio
            var carrinho = JSON.parse(localStorage.getItem("carrinho"));
            $.ajax({
                url: 'JsonService?entity=Order&action=add',
                type: 'post',
                data: 'cart=' + carrinho,
                dataType: 'json',
                success: function (json) {
                    console.log(carrinho);
                },
                error: function (xhr, ajaxOptions, thrownError) {
                    alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
                }
            });
        }
    }
}