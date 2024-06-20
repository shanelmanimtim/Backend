package com.Appchara.co.APPchara.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.Appchara.co.APPchara.Model.UserModel;

@RestController
public class UserController {

    @GetMapping("/User")
    public UserModel getUser(){
        return new UserModel(1, "jeven 11", "jeven.11@email.com", "jeven11");
    }

    //http://localhost:8080/Users
    @GetMapping("/Users")
    public List <UserModel> getUsers(){
        List<UserModel> users = new ArrayList<>();
        users.add(new UserModel(1, "mario", "mario@email.com", "123456789"));
        users.add(new UserModel(2, "juan", "juan@email.com", "1234567810"));
        users.add(new UserModel(3, "pedro", "pedro@email.com", "1234567890"));
        return users;

    }

    //http:localhost:8080/users/jopay
    @GetMapping("/users/{name}")
    public UserModel getUserFromName(@PathVariable("name")String name){
        return new UserModel(1, "jopay", "jopay@email.com","wagkangmawala");
    }
}
