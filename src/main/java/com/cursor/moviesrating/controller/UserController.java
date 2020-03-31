package com.cursor.moviesrating.controller;

import com.cursor.moviesrating.entity.Rate;
import com.cursor.moviesrating.service.impl.MovieServiceImpl;
import com.cursor.moviesrating.service.impl.RateServiceImpl;
import com.cursor.moviesrating.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    private final RateServiceImpl rateService;

    private final MovieServiceImpl movieService;

    @RequestMapping("/rate/{id}")
    public Rate rate(@RequestBody Rate rate, @PathVariable String id) {

        rate.setIdOfAMovie(id);

        return rateService.save(rate);
    }
}
