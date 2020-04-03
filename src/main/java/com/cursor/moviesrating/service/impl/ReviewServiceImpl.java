package com.cursor.moviesrating.service.impl;

import com.cursor.moviesrating.entity.Review;
import com.cursor.moviesrating.repository.ReviewRepository;
import com.cursor.moviesrating.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;

    @Override
    public Review save(Review review) {
        return reviewRepository.save(review);
    }

    @Override
    public List<Review> findAllByIdOfAMovie(String idOfAMovie) {
        return reviewRepository.findAllByIdOfAMovie(idOfAMovie);
    }
}
