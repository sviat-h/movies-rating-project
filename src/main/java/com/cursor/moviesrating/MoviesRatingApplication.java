package com.cursor.moviesrating;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity
public class MoviesRatingApplication {

    public static void main(String[] args) {
        SpringApplication.run(MoviesRatingApplication.class, args);
    }
}
