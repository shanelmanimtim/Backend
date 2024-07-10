package com.Appchara.co.APPchara.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Appchara.co.APPchara.Model.OrderItem;
import com.Appchara.co.APPchara.NotFoundException.OrderNotFoundException;
import com.Appchara.co.APPchara.Repository.OrderItemRepository;

@RestController
@RequestMapping("/api/v1/auth/orderItem")
public class OrdeItemController {

    OrderItemRepository repo;

    public OrdeItemController(OrderItemRepository repo) {
        this.repo =repo;
    }

    @GetMapping("/all")
    public List<OrderItem> getOrderItem(){
        return repo.findAll();
    }
    @GetMapping("/OrderItem/{id}")
    public OrderItem getOrderItemId (@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(() -> new OrderNotFoundException(id));
    }
    @PostMapping("/orderitem/new")
    public String addOrderItem(@RequestBody OrderItem newOrderItem){
        repo.save(newOrderItem);
        return "A new order added. Yeahey!";
    }
    
    @DeleteMapping("/OrderItem/delete/{id}")
    public String deleteOrder(@PathVariable Long id){
        repo.deleteById(id);
        return "A order is deleted!";
    }
}
