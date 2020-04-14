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
public class UserUpdateBeCrypt {
     public static void main(String[] args) {          
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        UserDAO userDAO = new UserDAO();        
        EntidadeDominio entidadeDominio = userDAO.findOneById(1);        
        TableUser user = (TableUser) entidadeDominio;
        user.setPassword("42010052");
        userDAO.update(user);        
     }
}
