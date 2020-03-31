package com.cursor.moviesrating.controller;

import com.cursor.moviesrating.entity.Movie;
import com.cursor.moviesrating.entity.User;
import com.cursor.moviesrating.service.impl.MovieServiceImpl;
import com.cursor.moviesrating.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userService;

    private final MovieServiceImpl movieService;

    @PostMapping("/addUser")
    public User addUser(@RequestBody User user) {
        return userService.save(user);
    }

    @RequestMapping("/delete/{username}")
    public String deleteUser(@PathVariable String username) {
        userService.deleteUserByUsername(username);
        return username + " has been deleted";
    }

    @PostMapping("/addMovie")
    public Movie addMovie(@RequestBody Movie movie) {
        return movieService.save(movie);
    }

}
