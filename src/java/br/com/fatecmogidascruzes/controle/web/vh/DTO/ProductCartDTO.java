/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.fatecmogidascruzes.controle.web.vh.DTO;

import java.math.BigDecimal;

/**
 *
 * @author Josias Wattrelos
 */

public class ProductCartDTO {    
    
    private Integer id;
    private String name;
    private String description;
    private String image;
    private String model;
    private int quantity;
    private BigDecimal price;
    
    public ProductCartDTO() {
        
    }

    public ProductCartDTO(Integer productId, String name, String metaDescription, String image, String model, int quantity, BigDecimal price) {
        this.id = productId;
        this.name = name;
        this.description = metaDescription;
        this.image = image;
        this.model = model;
        this.quantity = quantity;
        this.price = price;
    }
    
    // Setters and Getters -----------------------------------------------------------------------------------------------------------
    public Integer getId() {
        return id;
    }

    public void setId(Integer productId) {
        this.id = productId;
    }

    public String getDescription() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
    
    
}
