/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;


import br.com.fatecmogidascruzes.dao.impl.UserDAO;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableUser;
import java.util.List;

/**
 *
 * @author Josias Wattrelos
 */
public class TestUserFindAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       UserDAO userDAO = new UserDAO();        
        List<EntidadeDominio> entidadeDominio = userDAO.findAll();
        List<TableUser> userList = (List<TableUser>)(List<?>) entidadeDominio;  
        for(TableUser user : userList){
            System.out.println("\033[47m" + user.getUsername()+ " "
                    + "\tId: " + user.getId()
                    + "\tProfile: " + user.getUserGroup().getName()
                    
            );
        }
    }    
}
