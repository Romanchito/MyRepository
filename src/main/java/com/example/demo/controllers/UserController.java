package com.example.demo.controllers;

import com.example.demo.entities.User;
import com.example.demo.services.Interfaces.Serviceable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;


@RestController
@RequestMapping(value = "/api/users")
public class UserController {

    private Serviceable<User> userService;

    @Autowired
    public UserController(Serviceable<User> userService) {
        this.userService = userService;
    }
    @GetMapping(value = "/list")
    public Set<User> getUsers() {

        return userService.getAll();
    }
    @GetMapping(value = "/{id}")
    public User getUserById(@PathVariable("id") Integer id) {

        return userService.getById(id);
    }

    @PostMapping(value = "/update")
    public Boolean updateUser(@RequestBody User user) {

        return userService.update(user);
    }

    @PostMapping(value = "/save")
    public Boolean saveUser(@RequestBody User user) {

        return userService.save(user);
    }
}
