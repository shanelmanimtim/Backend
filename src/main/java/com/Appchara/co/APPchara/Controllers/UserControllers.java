package com.Appchara.co.APPchara.Controllers;


import com.Appchara.co.APPchara.Model.User;
import com.Appchara.co.APPchara.NotFoundException.UserNotFoundException;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.Appchara.co.APPchara.Repository.UserRepository;


@RestController
public class UserControllers {

    UserRepository repo;

    public UserControllers(UserRepository repo) {
        this.repo = repo;
    }
    @GetMapping("/User")
    public List<User> getUser(){
        return repo.findAll();
    }
    @GetMapping("/User/{id}")
    public User getUser(@PathVariable Long id){
        return repo.findById(id)
        .orElseThrow(() -> new UserNotFoundException(id));
    }
    @PostMapping("/User/new")
    public String addName(@RequestBody User newUser){
        repo.save(newUser);
        return "A new name added. Yeahey!";
    }
    
    @PutMapping("/User/edit/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User newUser){
        return repo.findById(id)
        .map(user ->{
            user.setName(newUser.getName());
            user.setEmail(newUser.getEmail());
            return repo.save(user);
        }).orElseGet(()->{
            return repo.save(newUser);
        });
    }
    @DeleteMapping("/User/delete/{id}")
    public String deleteUser(@PathVariable Long id){
        repo.deleteById(id);
        return "A user is deleted!";
    }
}
