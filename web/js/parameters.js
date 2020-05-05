function stockStatusFunction(stockStatusId) {   
    $.ajax({
        url: 'ag?rsa=ssaj',
        type: 'POST',
        dataType: 'json',
        success: function (stockStatusjson)   {          
            var stockStatusNode = '<select name="stockStatus_class_id" id="input-stockStatus-class" class="form-control">';
            stockStatusjson.forEach(function (stockStatus) {
                console.log("stockStatusId=" + stockStatusId + "  stockStatus.id=" + stockStatus.id +"  stockStatus.id == stockStatusId=" + (stockStatus.id == stockStatusId));
                if(stockStatus.id == stockStatusId){
                    stockStatusNode += '<option value="' + stockStatus.id + '" selected>' + stockStatus.name +'</option>';
                }else{
                    stockStatusNode += '<option value="' + stockStatus.id + '">' + stockStatus.name +'</option>';
                }
            });                
            $('#stockStatus').html(stockStatusNode + '</select>');
                
        },
        error: function (xhr, ajaxOptions, thrownError) {
                alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
        }       
    });    
}
    
function lengthUnitFunction(lengthId){
    
    $.ajax({
        url: 'ag?rsa=lgaj',
        type: 'POST',
        dataType: 'json',
        success: function (lengthjson) {  
                var lengthNode = '<select name="length_class_id" id="input-length-class" class="form-control">';
                lengthjson.forEach(function (length) {
                    if(length.id == lengthId){
                        lengthNode += '<option value="' + length.id + '" selected>' + length.name +' (' + length.unit +')</option>';
                    }else{
                        lengthNode += '<option value="' + length.id + '">' + length.name +' (' + length.unit +')</option>';
                    }
                });                
                $('#length-unit').html(lengthNode + '</select>');
                
        },
        error: function (xhr, ajaxOptions, thrownError) {
                alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
        }       
    });
}

function weightUnitFunction(weightId) {
    $.ajax({
        url: 'ag?rsa=wcaj',
        type: 'POST',
        dataType: 'json',
        success: function (weightjson) {
                var weightNode = '<select name="weight_class_id" id="input-weight-class" class="form-control">';
                weightjson.forEach(function (weight) {
                    if(weight.id == weightId){
                        weightNode += '<option value="' + weight.id + '" selected>' + weight.name +' (' + weight.unit +')</option>';
                    }else{
                        weightNode += '<option value="' + weight.id + '">' + weight.name +' (' + weight.unit +')</option>';
                    }
                });                
                $('#weight-unit').html(weightNode + '</select>');
                
        },
        error: function (xhr, ajaxOptions, thrownError) {
                alert(thrownError + "\r\n" + xhr.statusText + "\r\n" + xhr.responseText);
        }       
    });    
}

                                       