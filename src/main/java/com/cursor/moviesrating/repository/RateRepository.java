package com.cursor.moviesrating.repository;

import com.cursor.moviesrating.entity.Rate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RateRepository extends MongoRepository<Rate, String> {
}
