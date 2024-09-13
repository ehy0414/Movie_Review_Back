package com.movie_review.movie_review_back.mrv.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie_review.movie_review_back.mrv.dao.MrvMapper;
import com.movie_review.movie_review_back.mrv.domain.MrvRequestDTO;
import com.movie_review.movie_review_back.mrv.domain.MrvResponseDTO;
import com.movie_review.movie_review_back.mrv.domain.comment.CommentRequestDTO;
import com.movie_review.movie_review_back.mrv.domain.comment.CommentResponseDTO;

import java.util.List;
import java.util.Map;

@Service
public class MrvService {
    
    @Autowired
    private MrvMapper mrvMapper;

    public void save(MrvRequestDTO params) {
        mrvMapper.saveRow(params);
    }

    public List<MrvResponseDTO> findAll() {
        return mrvMapper.findAllRow();
    }

    public MrvResponseDTO find(Map<String, Integer> map) {
        MrvResponseDTO result = mrvMapper.findRow(map);
        List<CommentResponseDTO> list = mrvMapper.findByIdComment(map);
        result.setComments(list);
        return result;
    }

    public void commentSave(CommentRequestDTO params) {
        System.out.println("client endpoint : /bbs/comments/save");
        mrvMapper.commentSaveRow(params);
    }

    public List<CommentResponseDTO> findComment(Map<String, Integer> map) {
        List<CommentResponseDTO> result = mrvMapper.findByIdComment(map);
        return result;
    }

    public void deleteMovie(Map<String, Integer> map) {
        mrvMapper.deleteRow(map);
    }

    public void deleteComment(Map<String, Integer> map) {
        mrvMapper.deleteCommentRow(map);
    }
}
