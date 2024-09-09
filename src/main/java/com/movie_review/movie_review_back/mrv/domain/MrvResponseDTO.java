package com.movie_review.movie_review_back.mrv.domain;

import lombok.Data;

@Data
public class MrvResponseDTO {
    private Integer id;
    private String title;
    private String content;
}
