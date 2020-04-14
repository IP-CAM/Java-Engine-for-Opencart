/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.core.impl.negocio;

import br.com.fatecmogidascruzes.core.impl.IStrategy;
import br.com.fatecmogidascruzes.domain.impl.TableCustomer;
import br.com.fatecmogidascruzes.domain.IEntidade;

/**
 *
 * @author Josias Wattrelos
 */
public class ValidadorEmail implements IStrategy {

    @Override
    public String processar(IEntidade entidade) {
        TableCustomer customer = (TableCustomer) entidade;
        String email = customer.getEmail();
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        if(email.matches(regex)){
            return null;
        }
        return "Email inválido!";
    }
    
}
