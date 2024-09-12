package com.movie_review.movie_review_back.mrv.domain;

import lombok.Data;

import java.util.List;

import com.movie_review.movie_review_back.mrv.domain.comment.CommentResponseDTO;

@Data
public class MrvResponseDTO {
    private Integer id;
    private String title;
    private String content;

    private List<CommentResponseDTO> comments;
}
