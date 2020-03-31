package com.cursor.moviesrating.service.impl;

import com.cursor.moviesrating.entity.Rate;
import com.cursor.moviesrating.repository.RateRepository;
import com.cursor.moviesrating.service.RateService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateServiceImpl implements RateService {


    private final RateRepository rateRepository;

    @Override
    public Rate save(Rate rate) {

        return rateRepository.save(rate);
    }
}
