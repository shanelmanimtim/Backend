package com.Appchara.co.APPchara.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Appchara.co.APPchara.Model.Order;
import com.Appchara.co.APPchara.NotFoundException.OrderNotFoundException;
import com.Appchara.co.APPchara.Repository.OrderRepository;

@RestController
public class OrderController {

    OrderRepository repo;

    public OrderController(OrderRepository repo) {
        this.repo =repo;
    }

    @GetMapping("/Order")
    public List<Order> getOrders(){
        return repo.findAll();
    }
    @GetMapping("/Order/{id}")
    public Order getOrder(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(() -> new OrderNotFoundException(id));
    }
    @PostMapping("/Order/new")
    public String addOrder(@RequestBody Order newOrder){
        repo.save(newOrder);
        return "A new order added. Yeahey!";
    }
    
    @DeleteMapping("/Order/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        repo.deleteById(id);
        return "A order is deleted!";
    }
}
