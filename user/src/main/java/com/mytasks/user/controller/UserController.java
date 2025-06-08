package com.mytasks.user.controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController 
@RequestMapping("/user")
public class UserController {

    @GetMapping
    public String getUser(){
        return "User 1 has returned";
    }

    @PostMapping
    public String createUser(){
        return "User has been Created";
    }

    @PatchMapping
    public String updateUser(){
        return "user has been Updated";
    }

    @DeleteMapping
    public String deleteUser(){
        return "user has been Deleted";
    }
}
