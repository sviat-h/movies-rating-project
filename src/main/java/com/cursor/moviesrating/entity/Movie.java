package com.cursor.moviesrating.entity;

import com.cursor.moviesrating.enums.Category;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Movie {

    @Id
    private String id;

    private String name;

    private Category category;

    private String director;

    private String description;

    private Double averageRate;
}
