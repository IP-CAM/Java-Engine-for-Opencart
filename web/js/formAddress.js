var endereco = new Object();
document.getElementById("input-address-postcode").addEventListener("change", function (doThing) {
    var cep = this.value.replace(/[^\d]+/g, '');
    // console.log(cep);
    if (cep.length == 8) {
        $.ajax({
            type: "GET",
            headers: {"Authorization": window.sessionStorage.getItem('token')},            
            url: "http://localhost:8084/ZZZ_ag_908/JsonService?entity=Logradouro&action=findOneById&cep=" + cep,
            dataType: 'json', // tipo de dados da requisição.
            contentType: "application/json; charset=utf-8",
            success: function (result) {
                console.log(result);                
                result.forEach(function(item, indice){
                    document.getElementById("input-address-address-1").value = item.tipoLogradouro + " " + item.logradouro;
                    document.getElementById("input-address-address-2").value = item.bairro.name;
                    document.getElementById("input-address-city").value = item.bairro.cidade.name;
                    document.getElementById("input-address-zone").value = item.bairro.cidade.estado.name;
                    // endereco["logradouro"] = result;
                });
            },
            error: function (erro, textStatus, xhr) {
                document.getElementById("input-address-address-1").value = "CEP não encontrado!";
                console.log("Erro: " + erro + " Status: " + textStatus);
            }
        });
    }
});
function doThing(){
   alert('Horray! Someone wrote "' + this.value + '"!');
}


