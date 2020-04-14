/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.impl.UserDAO;
import br.com.fatecmogidascruzes.domain.impl.Logradouro;
import br.com.fatecmogidascruzes.domain.impl.TableAddress;
import br.com.fatecmogidascruzes.domain.impl.TableUser;
import br.com.fatecmogidascruzes.domain.impl.TableUserGroup;
import br.com.fatecmogidascruzes.domain.impl.TableUserGroup;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Josias Wattrelos
 */
public class TestAddUser {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
                
                
                TableUser user = new TableUser();  
                user.setUsername("ThaisDaufouy");
                user.setPassword("42010052");
                user.setConfirmPassword("42010052");
                user.setUserGroup(new TableUserGroup(1));
                
                user.setStatus(true);
                user.setIp("::1");
                user.setCode("0");
                user.setSalt("0");;

                UserDAO userDao = new UserDAO();
                user = (TableUser) userDao.create(user);   
                                
            }
}
