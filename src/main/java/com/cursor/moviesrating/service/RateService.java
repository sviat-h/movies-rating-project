package com.cursor.moviesrating.service;

import com.cursor.moviesrating.entity.Rate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RateService {

    Rate save(Rate rate);

    List<Rate> findAllRateById(String id);
}
