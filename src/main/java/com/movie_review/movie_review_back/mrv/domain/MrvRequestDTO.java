package com.movie_review.movie_review_back.mrv.domain;

import lombok.Data;

@Data
public class MrvRequestDTO {
    
    private Integer id;
    private String title;
    private String content;
}
