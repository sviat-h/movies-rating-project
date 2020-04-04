package com.cursor.moviesrating.entity;

import com.cursor.moviesrating.enums.Category;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document
public class Movie {

    @Id
    private String id;

    private String name;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String categoryString;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Category category;

    private String director;

    private String description;

    private Double averageRate;

    private Integer countOfVotes;

    List<Review> reviews;

    public Movie(String name, Category category, String director, String description) {
        this.name = name;
        this.category = category;
        this.director = director;
        this.description = description;
    }
}
