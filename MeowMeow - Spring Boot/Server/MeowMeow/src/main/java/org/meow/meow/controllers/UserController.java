package org.meow.meow.controllers;

import org.meow.meow.entities.User;
import org.meow.meow.services.implementations.UserServiceImpl;
import org.meow.meow.services.interfaces.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private UserService service;

    public UserController() {
        this.service = new UserServiceImpl();
    }
    @PostMapping("/users/login")
    public HttpStatus login(@RequestBody User user) {
        this.service.login(user);
        return HttpStatus.OK;
    }
}