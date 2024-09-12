package com.movie_review.movie_review_back.mrv.domain.comment;

import lombok.Data;

@Data
public class CommentResponseDTO {

    private Integer id;
    private String content;
    private Integer movieid;
}
