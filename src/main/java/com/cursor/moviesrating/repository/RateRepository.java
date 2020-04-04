package com.cursor.moviesrating.repository;

import com.cursor.moviesrating.entity.Rate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RateRepository extends MongoRepository<Rate, String> {

    List<Rate> findAllByIdOfAMovie(String idOfAMovie);
}
