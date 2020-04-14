var quantidadeCarrinho = document.getElementById("quantidadeCarrinho");
if(localStorage.getItem("carrinho")){
    // Obter a quantidade de ítens
	quantidadeCarrinho.innerHTML = (JSON.parse(localStorage.getItem("carrinho"))).length;
}

function irCarrinho() {
    document.getElementById("compras").value = localStorage.getItem("carrinho");
    // console.log("carrinho");
    return true;
}
var cart = {
    'add': function (product_id, quantity) {        
         var quantidade = 1;
         var carrinho = [];
         var estaNaLista = false;
         //Verifica se já tem o mesmo livro no carrinho 
         if (localStorage.getItem("carrinho")) { // Verifica se o carrinho está vazio
         carrinho = JSON.parse(localStorage.getItem("carrinho"));
         carrinho.forEach(function (item, indice) {
         // console.log(item);
         if (product_id == item.id) {
         // se tiver, apenas aumenta a quantidade.
         item.quantidade += parseInt(quantity);
         estaNaLista = true;
         }
         quantidade += parseInt(item.quantidade);
         });
         }
         if (!estaNaLista) {
         jsonLivro = new Object();
         jsonLivro['id'] = product_id;
         jsonLivro['quantidade'] = quantidade;
         carrinho.push(jsonLivro);
         }
         localStorage.setItem("carrinho", JSON.stringify(carrinho));
         // console.log(carrinho);
         $('#content').parent().before('<div class="alert alert-success alert-dismissible"><i class="fa fa-check-circle"></i> Você adicionou ' + name + ' ao seu carrinho de compras</a> <button type="button" class="close" data-dismiss="alert">&times;</button></div>');
         $('#cart > button').html('<span id="cart-total"><i class="fa fa-shopping-cart"></i> ' + quantidade + '</span>');
      
    },
    'update': function (key, quantity) {
        $.ajax({
            url: 'JsonService?route=checkout/cart/edit',
            type: 'post',
            data: 'key=' + key + '&quantity=' + (typeof (quantity) != 'undefined' ? quantity : 1),
            dataType: 'json',
            beforeSend: function () {
                $('#cart > button').button('loading');
            },
            complete: function () {
                $('#cart > button').button('reset');
            },
            success: function (json) {
                // Need to set timeout otherwise it wont update the total
                setTimeout(function () {
                    $('#cart > button').html('<span id="cart-total"><i class="fa fa-shopping-cart"></i> ' + json['total'] + '</span>');
                }, 100);

                if (getURLVar('route') == 'checkout/cart' || getURLVar('route') == 'checkout/checkout') {
                    location = 'JsonService?route=checkout/cart';
                } else {
                    $('#cart > ul').load('JsonService?route=common/cart/info ul li');
                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
            }
        });
    },
    'remove': function (key) {
        $.ajax({
            url: 'JsonService?route=checkout/cart/remove',
            type: 'post',
            data: 'key=' + key,
            dataType: 'json',
            beforeSend: function () {
                $('#cart > button').button('loading');
            },
            complete: function () {
                $('#cart > button').button('reset');
            },
            success: function (json) {
                // Need to set timeout otherwise it wont update the total
                setTimeout(function () {
                    $('#cart > button').html('<span id="cart-total"><i class="fa fa-shopping-cart"></i> ' + json['total'] + '</span>');
                }, 100);

                if (getURLVar('route') == 'checkout/cart' || getURLVar('route') == 'checkout/checkout') {
                    location = 'JsonService?route=checkout/cart';
                } else {
                    $('#cart > ul').load('JsonService?route=common/cart/info ul li');
                }
            },
            error: function (xhr, ajaxOptions, thrownError) {
                alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
            }
        });
    }
}

//  Adicionar item ao carrinho -----------------------------------------------------------
function adicionarAoCarrinho(product_id, quantity){
	var quantidade = 1;
	var carrinho = [];
	var estaNaLista = false;
	//Verifica se já tem o mesmo livro no carrinho 
	if(localStorage.getItem("carrinho")){ // Verifica se o carrinho está vazio
		carrinho = JSON.parse(localStorage.getItem("carrinho"));
		carrinho.forEach(function(item, indice){
			// console.log(item);
			if(livroId == item.id){
				// se tiver, apenas aumenta a quantidade.
				item.quantidade += 1;
				estaNaLista = true;
			}
		});
	}
	if(!estaNaLista){
		jsonLivro = new Object(); 
		jsonLivro['id'] = livroId;
		jsonLivro['quantidade'] = quantidade;
		carrinho.push(jsonLivro);
	}	
	localStorage.setItem("carrinho", JSON.stringify(carrinho));
	// console.log(carrinho);
	quantidadeCarrinho.innerHTML = carrinho.length;
}