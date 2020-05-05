/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.impl.UserDAO;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableUser;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author Josias Wattrelos
 */
public class ASCII {
     public static void main(String[] args) {  
        char c;
        for (int i=1;i<255;i++){
            c = (char) i;
            System.out.println(i + "i\t" + c);            
        }
     }
    
}
