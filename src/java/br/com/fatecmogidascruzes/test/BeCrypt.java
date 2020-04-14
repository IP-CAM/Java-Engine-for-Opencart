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
public class BeCrypt {
     public static void main(String[] args) {          
        BCryptPasswordEncoder pe = new BCryptPasswordEncoder();
        UserDAO userDAO = new UserDAO();        
        EntidadeDominio entidadeDominio = userDAO.findOneById(1);        
        TableUser user = (TableUser) entidadeDominio;
        user.setPassword("42010052");
        userDAO.update(user);
        System.out.println("Nome completo:" + user.getUsername());
        System.out.println("Senha (criptografada):" + user.getPassword());
        if(user != null){ // Comparar a senha fornecida pelo usuário com a registrada no banco de dados;
            if(user != null && pe.matches("42010052", user.getPassword())){ // Comparar a senha fornecida pelo usuário com a registrada no banco de dados;
                System.out.println("Password válido:");
            }else{
                System.out.println("Password inválido:");
            }
        }else{
            System.out.println("Usuário não encontrado!");
        }
          
          
          
     }
    
}
