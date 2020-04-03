package com.cursor.moviesrating.controller;

import com.cursor.moviesrating.entity.Movie;
import com.cursor.moviesrating.entity.Rate;
import com.cursor.moviesrating.entity.Review;
import com.cursor.moviesrating.service.impl.MovieServiceImpl;
import com.cursor.moviesrating.service.impl.RateServiceImpl;
import com.cursor.moviesrating.service.impl.ReviewServiceImpl;
import com.cursor.moviesrating.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserServiceImpl userService;

    private final RateServiceImpl rateService;

    private final MovieServiceImpl movieService;

    private final ReviewServiceImpl reviewService;

    @RequestMapping("/addRate/{id}")
    public Rate rate(@RequestBody Rate rate, @PathVariable String id) {

        if (movieService.listOfId().contains(id)) {

            rate.setIdOfAMovie(id);
        } else {
            throw new IllegalArgumentException("There are no movies with such id");
        }

        return rateService.save(rate);
    }

    @RequestMapping("/addReview/{id}")
    public Review addReview(@RequestBody Review review, @PathVariable String id) {

        if (movieService.listOfId().contains(id)) {
            review.setIdOfAMovie(id);
        } else {
            throw new IllegalArgumentException("There are no movies with such id");
        }

        return reviewService.save(review);
    }

    @GetMapping("/movie/{id}")
    public Movie getMovieInfo(@PathVariable String id) {
        if (movieService.listOfId().contains(id)) {

            Movie movie = movieService.findMovieById(id);
            List<Review> reviewList = reviewService.findAllByIdOfAMovie(id);

            movie.setReviews(reviewList);

            return movie;
        } else {
            throw new IllegalArgumentException("There are no movies with such id");
        }
    }

    @GetMapping("/allMovie")
    public List<Movie> getAllMovie() {
        return movieService.getAllMovie();
    }

    @GetMapping("/sorted/{sortType}")
    public List<Movie> getMovieByRating(@PathVariable String sortType) {
        List<Movie> allMovies = movieService.getAllMovie();

        Comparator<Movie> movieComparatorASC = Comparator.comparing(Movie::getAverageRate);
        Comparator<Movie> movieComparatorDESC = (movie1, movie2) -> movie2.getAverageRate().compareTo(movie1.getAverageRate());

        if (sortType.equals("asc")) {
            allMovies.sort(movieComparatorASC);
        } else if (sortType.equals("desc")) {
            allMovies.sort(movieComparatorDESC);
        } else {
            throw new IllegalArgumentException("There are no such pages!");
        }

        return allMovies;
    }

//    @GetMapping("/category")
//    public List<Movie> getMovieByCategory() {
//        List<Movie> allMovies = movieService.getAllMovie();
//
//        todo СОРТУВАТИ ПО КАТЕГОРІЇ
//
//
//        return allMovies;
//    }
}
