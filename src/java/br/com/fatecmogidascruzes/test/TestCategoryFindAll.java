/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;
import br.com.fatecmogidascruzes.dao.AbstractDAO;
import br.com.fatecmogidascruzes.domain.EntidadeDominio;
import br.com.fatecmogidascruzes.domain.impl.TableCategory;
import java.util.List;

/**
 *
 * @author Josias Wattrelos
 */
public class TestCategoryFindAll {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AbstractDAO categoryDAO = new AbstractDAO(new TableCategory());        
        List<EntidadeDominio> entidadeDominio = categoryDAO.findAll();
        List<TableCategory> categoryList = (List<TableCategory>)(List<?>) entidadeDominio;  
        System.out.println("Categoria: ");
        for(TableCategory category : categoryList){
            System.out.println("\033[47m" + category.getName() + " "); 
            for(TableCategory category2 : category.getCategoryList()){
                System.out.println("Categoria: " + category2.getName()); 

            }
           
        }        
    }    
}
