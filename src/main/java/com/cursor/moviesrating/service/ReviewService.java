package com.cursor.moviesrating.service;

import com.cursor.moviesrating.entity.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    Review save(Review review);

    List<Review> findAllByIdOfAMovie(String idOfAMovie);
}
