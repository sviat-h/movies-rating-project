package com.cursor.moviesrating.controller;

import com.cursor.moviesrating.entity.Movie;
import com.cursor.moviesrating.entity.Rate;
import com.cursor.moviesrating.entity.Review;
import com.cursor.moviesrating.service.impl.MovieServiceImpl;
import com.cursor.moviesrating.service.impl.RateServiceImpl;
import com.cursor.moviesrating.service.impl.ReviewServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

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

            movie.setCategoryString(movie.getCategory().toString().substring(0, 1) + movie.getCategory().toString().toLowerCase().substring(1));

            return movie;
        } else {
            throw new IllegalArgumentException("There are no movies with such id");
        }
    }

    @GetMapping("/allMovie")
    public List<Movie> getAllMovie() {
        List<Movie> allMovies = movieService.getAllMovie();

        for (Movie movie : allMovies) {
            movie.setCategoryString(movie.getCategory().toString().substring(0, 1) + movie.getCategory().toString().toLowerCase().substring(1));
        }

        return allMovies;
    }

    @GetMapping("/sorted/{sortType}")
    public List<Movie> getMovieByRating(@PathVariable String sortType) {
        List<Movie> allMovies = movieService.getAllMovie();

        for (Movie movie : allMovies) {
            movie.setCategoryString(movie.getCategory().toString().substring(0, 1) + movie.getCategory().toString().toLowerCase().substring(1));
        }

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

    @GetMapping("/category/{sortType}")
    public List<Movie> getMovieByCategory(@PathVariable String sortType) {
        List<Movie> allMovies = movieService.getAllMovie();

        for (Movie movie : allMovies) {
            movie.setCategoryString(movie.getCategory().toString().substring(0, 1) + movie.getCategory().toString().toLowerCase().substring(1));
        }

        Comparator<Movie> movieComparatorASC = Comparator.comparing(Movie::getCategory);
        Comparator<Movie> movieComparatorDESC = (movie1, movie2) -> movie2.getCategory().compareTo(movie1.getCategory());

        if (sortType.equals("asc")) {
            allMovies.sort(movieComparatorASC);
        } else if (sortType.equals("desc")) {
            allMovies.sort(movieComparatorDESC);
        } else {
            throw new IllegalArgumentException("There are no such pages!");
        }

        return allMovies;
    }
}
