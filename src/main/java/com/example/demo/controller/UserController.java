package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService service;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        // Define a ROLE padrão como "USERS" caso a lista de roles esteja vazia
        if (user.getRoles().isEmpty()) {
            user.getRoles().add("USERS");
        }

        // Lógica para salvar o usuário no banco de dados
        // ...
        service.createUser(user);
        return user;
    }

}