package com.cursor.moviesrating.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Rate {

    private String idOfAMovie;

    private Integer rateValue;

    public Rate(String idOfAMovie, Integer rateValue) {

        this.idOfAMovie = idOfAMovie;

        if (rateValue >= 1 && rateValue <= 10) {
            this.rateValue = rateValue;
        } else {
            throw new IllegalArgumentException("Rate value in range: 1 to 10");
        }
    }
}
