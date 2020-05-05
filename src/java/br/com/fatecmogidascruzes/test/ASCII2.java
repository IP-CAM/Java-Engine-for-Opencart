/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

/**
 *
 * @author Josias Wattrelos
 */
public class ASCII2 {
     public static void main(String[] args) {  
        String characterArray = "abcdefghijklmnopqrstuvwxyz";
        for(char character2 : characterArray.toCharArray()){           
            for(char character : characterArray.toCharArray()){
                // System.out.println("character= " + character + character2 + "\tvalue = " + ((int)character - 96) + 26 * ((int)character2 - 97) ); 
                Integer count = 26 * ((int)character2 - 96) + ((int)character - 96);
                System.out.println("character21= " + character2  + character + "\tvalue = " + count); 
            }
        }
     }
    
}
