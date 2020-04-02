package com.cursor.moviesrating.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Review {

    private String idOfAMovie;

    private String reviewMessage;

    private boolean isLiked;
}
