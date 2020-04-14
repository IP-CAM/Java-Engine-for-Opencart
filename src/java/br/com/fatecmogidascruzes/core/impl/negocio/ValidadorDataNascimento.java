/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.core.impl.negocio;

import br.com.fatecmogidascruzes.core.impl.IStrategy;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.IEntidade;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josias Wattrelos
 */

public class ValidadorDataNascimento implements IStrategy {

    @Override
    public String processar(IEntidade entidade) {
        String mensagem = null;
        if(entidade instanceof TableCustomer){           
            try {
                TableCustomer customer = (TableCustomer) entidade;
                Date dataNascimento = customer.getDateOfBirth();               
                
                LocalDateTime now = LocalDateTime.now();  
                String dataAtual = String.valueOf(now.getYear() - 18) + "-" + now.getMonthValue() + "-" + now.getDayOfMonth();               
                
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                Date date1 = sdf.parse("1900-01-01");
                Date date2 = sdf.parse(dataAtual); // Obter a data atual;
                System.out.println("Data de nascimento: " + dataAtual);                
                if (dataNascimento.compareTo(date2) > 0) {
                    mensagem = "\nNão é permitido o cadastro de menor de idade";
                } else if (dataNascimento.compareTo(date1) < 0) {
                    mensagem = "\nMatusalém! É você?";
                } else {
                    return null;
                } 
            } catch (ParseException ex) {
                Logger.getLogger(ValidadorDataNascimento.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            return "\nNão foi possível verificar data de nascimento de não-customer!";
        }
        return mensagem;
    }
    
}
