package com.cursor.moviesrating.entity;

import lombok.Data;

@Data
public class Review {

    private String idOfAMovie;

    private String reviewMessage;

    private boolean isLiked;
}
