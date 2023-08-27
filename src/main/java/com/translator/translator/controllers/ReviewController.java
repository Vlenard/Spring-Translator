package com.translator.translator.controllers;

import com.translator.translator.entities.Review;
import com.translator.translator.repositories.ReviewsRepository;
import com.translator.translator.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    private ReviewsRepository reviewsRepository;
    private ReviewService reviewService;

    @Autowired
    public void setReviewService(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Autowired
    public void setReviewsRepository(ReviewsRepository reviewsRepository) {
        this.reviewsRepository = reviewsRepository;
    }

    @RequestMapping
    @ResponseBody
    public Iterable<Review> index(){
        return reviewService.all(reviewsRepository);
    }

    @PostMapping("/add")
    public String add(@RequestBody Review review){
        return reviewService.add(reviewsRepository, review);
    }

    @DeleteMapping("/delete")
    public String delete(@RequestParam String id, @RequestHeader(value = "authKey") String password){
        //starter project so this is the simplest way to auth user
        return reviewService.delete(reviewsRepository, id, password);
    }
}
