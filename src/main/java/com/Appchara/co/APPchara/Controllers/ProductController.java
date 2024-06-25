package com.Appchara.co.APPchara.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Appchara.co.APPchara.Model.Product;
import com.Appchara.co.APPchara.Repository.ProductRepository;


@RestController
public class ProductController {

    ProductRepository repo;

    public ProductController(ProductRepository repo) {
        this.repo = repo;
    }


    @GetMapping("/Products")
    public List<Product> getProducts(){
        return repo.findAll();
    }

    /*public Product getProduct(Long id){
        return repo.findById(id);
    }*/


    @PostMapping("/product/new")
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is added. Yey!";
    }

}
