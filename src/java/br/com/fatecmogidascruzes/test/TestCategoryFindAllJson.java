/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.dao.AbstractDAO;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableCategory;
import com.google.gson.Gson;
import java.util.List;

/**
 *
 * @author Josias Wattrelos
 */
public class TestCategoryFindAllJson {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractDAO categoryDAO = new AbstractDAO(new TableCategory());        
        List<EntidadeDominio> entidadeDominio = categoryDAO.findAll();
        List<TableCategory> categoryList = (List<TableCategory>)(List<?>) entidadeDominio;  
        
        String arrayToJson = new Gson().toJson(categoryList);
        System.out.println("Categoria:" + arrayToJson);
        
    }
    
}
