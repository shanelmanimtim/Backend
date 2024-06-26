package com.Appchara.co.APPchara.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Appchara.co.APPchara.Model.Product;
import com.Appchara.co.APPchara.NotFoundException.ProductNotFoundException;
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

    @GetMapping("/products/{id}")
    public Product getProduct(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(()-> new ProductNotFoundException(id));
    }


    @PostMapping("/product/new")
    public String addProduct(@RequestBody Product newProduct){
        repo.save(newProduct);
        return "A new product is added. Yey!";
    }

    //UPDATE ENDPOINTS
    //http://127.0.0.1:8080/product/edit/1
    @PutMapping("/product/edit/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product newProduct){
        return repo.findById(id)
        .map(product ->{
            product.setProductname(newProduct.getProductname());
            product.setDescription(newProduct.getDescription());
            product.setPrice(newProduct.getPrice());
            return repo.save(product);
        }).orElseGet(()->{
            return repo.save(newProduct);
        });
    }

    //delete
    //http://127.0.0.1:8080/product/delete/1
    @DeleteMapping("/product/delete/{id}")
    public String deleteProduct(@PathVariable Long id){
        repo.deleteById(id);
        return "A product is deleted!";
    }

}
