package com.movie_review.movie_review_back.mrv.domain.comment;

import lombok.Data;

@Data
public class CommentRequestDTO {
    
    private String content;
    private Integer movieid;
}
