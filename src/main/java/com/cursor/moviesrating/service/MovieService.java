package com.cursor.moviesrating.service;

import com.cursor.moviesrating.entity.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {

    Movie save(Movie movie);

    Movie findMovieById(String id);

    void updateMovieById(Movie id);

    List<String> listOfId();

    List<Movie> getAllMovie();
}
