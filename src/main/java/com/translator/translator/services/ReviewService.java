package com.translator.translator.services;

import com.translator.translator.entities.Review;
import com.translator.translator.repositories.ReviewsRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ReviewService {

    @Value("${translator.authKey}")
    private String authKey;

    public Iterable<Review> all(ReviewsRepository repo){
        List<Review> res = new ArrayList<>();
        List<Integer> reviewsIds = new ArrayList<>();
        int count = (int)repo.count();

        if(count < 10){
            res = repo.findAll();
        }else{
            Random rand = new Random();
            for (int i = 0; i < 10; i++) {
                boolean valid = false;
                while (!valid){
                    int randomId = rand.nextInt(count - 1);
                    if(!reviewsIds.contains(randomId)) {
                        valid = true;
                        reviewsIds.add(randomId);
                    }
                }
            }
            res = repo.findAllById(reviewsIds);
        }

        return res;
    }

    public String add(ReviewsRepository repo, Review review){
        repo.save(review);
        return "Saved";
    }


    public String delete(ReviewsRepository repo, String str_id, String password){
        try {
            if(!password.equals(authKey)) return "failed to auth";

            int id = Integer.parseInt(str_id);

            repo.deleteById(id);

        }catch (NumberFormatException ex){
            return "Invalid parameter";
        }

        return "Deleted";
    }
}
