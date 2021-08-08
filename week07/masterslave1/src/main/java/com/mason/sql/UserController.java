package com.mason.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserServiceImpl userservice;

    @RequestMapping("/save")
    public String save(String name) {
        User use = new User(name);
        userservice.save(use);
        return "save successfully!";
    }
}
