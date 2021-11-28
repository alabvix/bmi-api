package com.bmiapi.framework.spring.user.web;

import com.bmiapi.framework.spring.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService service) {
        this.userService = service;
    }

    @PostMapping
    public void createUser(@RequestBody UserWebInput user) {
        userService.createUser(user);
    }

    @GetMapping
    public List<UserWebOutput> findAll() {
        return userService.findAll();
    }

}
