package com.movie_review.movie_review_back.mrv.dao;

import org.apache.ibatis.annotations.Mapper;

import com.movie_review.movie_review_back.mrv.domain.MrvRequestDTO;

@Mapper
public interface MrvMapper {

    public void saveRow(MrvRequestDTO params);
}
