package com.geodeveloper.todolist.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.geodeveloper.todolist.entities.UserModel;
import com.geodeveloper.todolist.repository.IUserRepository;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private IUserRepository iUserRepository;
    
    @PostMapping
    public UserModel create(@RequestBody UserModel userModel){
        var userCreated = this.iUserRepository.save(userModel);
        return userCreated;
    }
}
