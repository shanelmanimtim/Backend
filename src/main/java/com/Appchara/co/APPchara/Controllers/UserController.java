package com.Appchara.co.APPchara.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Appchara.co.APPchara.Model.UserModel;

@RestController
public class UserController {

    @GetMapping("/User")
    public UserModel getUser(){
        return new UserModel(1, "jeven 11", "jeven.11@email.com", "jeven11");
    }
}
