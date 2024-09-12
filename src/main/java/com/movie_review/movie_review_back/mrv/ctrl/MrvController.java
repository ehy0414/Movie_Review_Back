package com.movie_review.movie_review_back.mrv.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie_review.movie_review_back.mrv.domain.MrvRequestDTO;
import com.movie_review.movie_review_back.mrv.domain.MrvResponseDTO;
import com.movie_review.movie_review_back.mrv.domain.comment.CommentRequestDTO;
import com.movie_review.movie_review_back.mrv.domain.comment.CommentResponseDTO;
import com.movie_review.movie_review_back.mrv.service.MrvService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/movie")
public class MrvController {
    
    @Autowired
    private MrvService mrvService;

    @PostMapping("/save")
    public ResponseEntity<Void> save(@RequestBody MrvRequestDTO params) {

        mrvService.save(params);
        System.out.println("client save endpoint : "+params);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        
    }

    @GetMapping("/index")
    public ResponseEntity<Object> landing() {
        List<MrvResponseDTO> list = mrvService.findAll();
        if( list.size() == 0) {
            Map<String, String> map = new HashMap<>();
            map.put("info", "저장된 데이터가 존재하지 않습니다.");
            return new ResponseEntity<>(map, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(list, HttpStatus.OK);
        }
    }
    
    @GetMapping("/view/{id}")
    public ResponseEntity<MrvResponseDTO> view(@PathVariable(name = "id") Integer id) {
        System.out.println("debug >>> bbs controller client path /view");
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);
        MrvResponseDTO result = mrvService.find(map);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    
    @PostMapping("/comments/save")
    public ResponseEntity<Void> commentSave(@RequestBody CommentRequestDTO params) {
        System.out.println("debug >>> save comment " + params);
        mrvService.commentSave(params);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    
    @GetMapping("/comments/getComment/{id}")
    public ResponseEntity<List<CommentResponseDTO>> getComment(@PathVariable(name ="id") Integer id) {
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        List<CommentResponseDTO> result = mrvService.findComment(map);
        return new ResponseEntity<List<CommentResponseDTO>>( result , HttpStatus.OK);
    }
    
    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteBbs(@PathVariable(name ="id") Integer id) {
        System.out.println("debug >>> id param value " + id);
        Map<String, Integer> map = new HashMap<>();
        map.put("id", id);

        mrvService.deleteMovie(map);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
