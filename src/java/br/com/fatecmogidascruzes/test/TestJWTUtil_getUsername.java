/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.test;

import br.com.fatecmogidascruzes.security.service.JWTUtil;

/**
 *
 * @author Josias Wattrelos
 */
public class TestJWTUtil_getUsername {
    public static void main(String[] args) {
    JWTUtil jwtUtil =  new JWTUtil();
        System.out.println(jwtUtil.getUsername("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJKb3NpYXNXYXR0cmVsb3MiLCJleHAiOjE1ODQzNDQ0MDl9.IoeNykqZ8DyNp4EHgC3NCjqeYGholec-6ugdLRm9Zirzl4vdEFqDBfFlRlNSiWnUxcxOZ_HnhCgFcSOezn4-zA"));

    }
    
}
