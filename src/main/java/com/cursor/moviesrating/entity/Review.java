package com.cursor.moviesrating.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Review {

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String idOfAMovie;

    private String reviewMessage;

    private boolean isLiked;

    public Review(String reviewMessage, boolean isLiked) {
        this.reviewMessage = reviewMessage;
        this.isLiked = isLiked;
    }
}
