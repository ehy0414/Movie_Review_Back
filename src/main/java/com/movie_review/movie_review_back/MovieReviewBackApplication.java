package com.movie_review.movie_review_back;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MovieReviewBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieReviewBackApplication.class, args);
	}

}
