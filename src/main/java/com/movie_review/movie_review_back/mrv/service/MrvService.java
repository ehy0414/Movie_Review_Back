package com.movie_review.movie_review_back.mrv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_review.movie_review_back.mrv.dao.MrvMapper;
import com.movie_review.movie_review_back.mrv.domain.MrvRequestDTO;

@Service
public class MrvService {
    @Autowired
    private MrvMapper mrvMapper;

    public void save(MrvRequestDTO params) {
        mrvMapper.saveRow(params);
    }
}
