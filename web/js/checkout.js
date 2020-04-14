checkoutCart();
function checkoutCart(){
    // Obter a quantidade de ítens
    if (localStorage.getItem("carrinho")) {
        // Obter a quantidade de ítens
        carrinho = JSON.parse(localStorage.getItem("carrinho"));
        var quantidade = 0;
        var total = 0;
        var myCart = "";
        carrinho.forEach(function (product, indice) {
            myCart +=                 
            "<tr>" +
            "<td><a href=\"/ZZZ_ag_908/livraria?rca=pIpD&id=" + product.id + "\">" +
            "<img src=\"img/" + product.image + "\" alt=\"" + product.name + "\" title=\"" + product.name+ "\" class=\"img-thumbnail\" width=\"52\" height=\"52\">" +
            "</a></td>" +
            "<td class=\"text-left\"><a href=\"/ZZZ_ag_908/livraria?rca=pIpD&id=" + product.id + "\">" + product.description + "</a></td>" +
            "<td class=\"text-right\">" +
            "<input type=\"number\" name=\"quantity\" value=\"" + product.quantity + "\" onclick=\"cart.update('" + product.id + "');checkoutCart();\" id=\"" + product.id + "\" min=\"0\" class=\"form-control\">" +
            "</td>" +
            "<td class=\"text-right\">R$ " + product.price.toFixed(2) + "</td>" +
            "<td class=\"text-right\">R$ " + (product.price * product.quantity).toFixed(2) + "</td>" +
            "<td class=\"text-center\"><button type=\"button\" onclick=\"cart.remove('" + product.id + "');checkoutCart();\" title=\"Remover\" class=\"btn btn-danger btn-xs\"><i class=\"fa fa-times\"></i></button></td>" +
            "</tr>";
            total += parseInt(product.quantity) * parseFloat(product.price);
            quantidade += parseInt(product.quantity);
        });        
        $('#subtotal').html("R$ " + total.toFixed(2));
        $('#frete').html("R$ 0,00 (retirar na loja)");
        $('#total').html("R$ " + total.toFixed(2));
        $('#checkout-product-list').html(myCart);

    }else{
        $('#checkout-product-listt').html('<tr><td><i class="fa fa-shopping-cart"></i> vazio </span></td></tr>');    
    }
}