package com.Appchara.co.APPchara.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Product {

    private @Id
    @GeneratedValue Long id;
    private String productname;
    private String description;
    private double price;

    Product(){}

    public Product(String productname, String description, double price) {
        this.productname = productname;
        this.description = description;
        this.price = price;
    }

    //setter
    public void setProductname(String productname) {
        this.productname = productname;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //getters
    public Long getId() {
        return id;
    }

    public String getProductname() {
        return productname;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    
    

    


}
