package com.cursor.moviesrating.repository;

import com.cursor.moviesrating.entity.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

    List<Review> findAllByIdOfAMovie(String idOfAMovie);
}
