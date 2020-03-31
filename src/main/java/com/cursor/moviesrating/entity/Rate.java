package com.cursor.moviesrating.entity;

import lombok.Data;

@Data
public class Rate {

    private Integer rateValue;

    private Integer countOfVotes;

    public Rate(Integer rateValue, Integer countOfVotes) {
        if (rateValue >= 1 && rateValue <= 10) {
            this.rateValue = rateValue;
        } else {
            throw new IllegalArgumentException("Rate value in range: 1 to 10");
        }
        this.countOfVotes = countOfVotes;
    }
}
