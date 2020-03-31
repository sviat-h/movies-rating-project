package com.cursor.moviesrating.controller;

import com.cursor.moviesrating.entity.User;
import com.cursor.moviesrating.enums.Role;
import com.cursor.moviesrating.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class UserController {

    private final UserServiceImpl userService;

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping("/hello")
    public String hello(Principal principal) {
        if (userService.findUserByUsername(principal.getName()).getRole() == Role.ADMIN) {
            return "Hello, mr." + principal.getName() + "!";
        }
        return "Hi, " + principal.getName() + "!";
    }

}
