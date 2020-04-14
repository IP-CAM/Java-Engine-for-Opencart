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
            "<td class=\"text-right\">" + product.quantity + "</td>" +
            "<td class=\"text-right\">R$ " + product.price.toFixed(2) + "</td>" +
            "<td class=\"text-right\">R$ " + (product.price * product.quantity).toFixed(2) + "</td>" +            
            "</tr>";
            total += parseInt(product.quantity) * parseFloat(product.price);
            quantidade += parseInt(product.quantity);            
        });
        myCart +=  "<tr>" +
                            "<td colspan=\"3\" rowspan=\"3\"></td>   " +                                                     
                            "<td class=\"text-right\"><strong>Sub-total: </strong></td>" +
                            "<td class=\"text-right\" id=\"subtotal\">R$ " + total.toFixed(2) +"</td>" +
                        "</tr>" +
                        "<tr> " +
                            "<td class=\"text-right\"><strong>Frete:</strong></td>" +
                            "<td class=\"text-right\" id=\"frete\">(retirar na loja)</td>" +
                        "</tr>" +
                        "<tr> " +
                            "<td class=\"text-right\"><strong>Total:</strong></td>" +
                            "<td class=\"text-right\" id=\"total\">R$ " + total.toFixed(2) + "</td>" +
                        "</tr>";
        $('#checkout-product-list').html(myCart);
        $('#orderProduct').val(localStorage.getItem("carrinho"));

    }else{
        $('#checkout-product-listt').html('<tr><td><i class="fa fa-shopping-cart"></i> vazio </span></td></tr>');    
    }
}

function checkAgree(event){
    
    if($('#agree').is(':not(:checked)')){
        event.preventDefault();
        $('#alert-dismissible').html('<div class="alert alert-danger alert-dismissible">Atenção: Você deve aceitar o contrato de Termos e Condições.<button type="button" class="close" data-dismiss="alert">×</button></div>');
    }
    
}
