package com.cursor.moviesrating.service;

import com.cursor.moviesrating.entity.Rate;
import org.springframework.stereotype.Service;

@Service
public interface RateService {

    Rate save (Rate rate);
}
