package com.movie_review.movie_review_back.mrv.ctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie_review.movie_review_back.mrv.domain.MrvRequestDTO;
import com.movie_review.movie_review_back.mrv.service.MrvService;

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
}
