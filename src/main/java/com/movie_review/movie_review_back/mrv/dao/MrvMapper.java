package com.movie_review.movie_review_back.mrv.dao;

import org.apache.ibatis.annotations.Mapper;

import com.movie_review.movie_review_back.mrv.domain.MrvRequestDTO;
import com.movie_review.movie_review_back.mrv.domain.MrvResponseDTO;
import com.movie_review.movie_review_back.mrv.domain.comment.CommentRequestDTO;
import com.movie_review.movie_review_back.mrv.domain.comment.CommentResponseDTO;

import java.util.List;
import java.util.Map;

@Mapper
public interface MrvMapper {

    public void saveRow(MrvRequestDTO params);

    public List<MrvResponseDTO> findAllRow();

    public MrvResponseDTO findRow(Map<String, Integer> map);

    public List<CommentResponseDTO> findByIdComment(Map<String, Integer> map);

    public void commentSaveRow(CommentRequestDTO params);

    public void deleteRow(Map<String, Integer> map);
}
