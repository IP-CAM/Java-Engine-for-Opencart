/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function checkAgree(event){
    
    if($('#agree').is(':not(:checked)')){
        event.preventDefault();
        $('#alert-dismissible').html('<div class="alert alert-danger alert-dismissible">Atenção: Você deve aceitar o contrato de Termos e Condições.<button type="button" class="close" data-dismiss="alert">×</button></div>');
    }
    
}