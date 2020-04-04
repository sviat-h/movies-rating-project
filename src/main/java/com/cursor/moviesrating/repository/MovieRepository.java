package com.cursor.moviesrating.repository;

import com.cursor.moviesrating.entity.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {

    Movie findMovieById(String id);
}
