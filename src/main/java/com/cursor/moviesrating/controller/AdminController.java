package com.cursor.moviesrating.controller;

import com.cursor.moviesrating.entity.Movie;
import com.cursor.moviesrating.entity.Rate;
import com.cursor.moviesrating.entity.User;
import com.cursor.moviesrating.service.impl.MovieServiceImpl;
import com.cursor.moviesrating.service.impl.RateServiceImpl;
import com.cursor.moviesrating.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.apache.commons.math3.util.Precision;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminController {

    private final UserServiceImpl userService;

    private final MovieServiceImpl movieService;

    private final RateServiceImpl rateService;

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

    @PutMapping("/updateRate/{id}")
    public Movie allRate(@PathVariable String id, Movie movie) {
        movie = movieService.findMovieById(id);

        List<Integer> allSeparateRate = new ArrayList<>();
        List<Rate> allRate = rateService.findAllRateById(id);

        for (Rate rate : allRate) {
            allSeparateRate.add(rate.getRateValue());
        }

        double countOfVotes = allSeparateRate.size();
        double sumOfRate = 0;

        for (Integer separateRate : allSeparateRate) {
            sumOfRate = sumOfRate + separateRate;
        }

        double averageRate = sumOfRate / countOfVotes;

        movie.setId(id);
        movie.setAverageRate(Precision.round(averageRate, 2));
        movie.setCountOfVotes((int) countOfVotes);
        movieService.updateMovieById(movie);

        return movie;
    }
}
