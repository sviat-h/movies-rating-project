package com.cursor.moviesrating.service.impl;

import com.cursor.moviesrating.entity.Movie;
import com.cursor.moviesrating.repository.MovieRepository;
import com.cursor.moviesrating.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    static Set<Integer> id = new HashSet<>();

    @Override
    public Movie save(Movie movie) {
        List<Movie> allMovie = movieRepository.findAll();

        for (Movie oneMovie : allMovie) {
            id.add(Integer.valueOf(oneMovie.getId()));
        }

        movie.setId(String.valueOf(generateUniqueIdToDb()));
        return movieRepository.save(movie);
    }

    @Override
    public Movie findMovieById(String id) {
        return movieRepository.findMovieById(id);
    }

    @Override
    public void updateMovieById(Movie movie) {
        movieRepository.save(movie);
    }

    @Override
    public List<String> listOfId() {

        List<Movie> allMovie = movieRepository.findAll();
        List<String> allId = new ArrayList<>();

        for (Movie movie : allMovie) {
            allId.add(movie.getId());
        }

        return allId;
    }

    @Override
    public List<Movie> getAllMovie() {
        return movieRepository.findAll();
    }

    public Integer generateUniqueIdToDb() {
        Integer uniqueId = null;

        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            if (id.contains(i)) {
                continue;
            } else {
                uniqueId = i;
                break;
            }
        }
        return uniqueId;
    }
}
