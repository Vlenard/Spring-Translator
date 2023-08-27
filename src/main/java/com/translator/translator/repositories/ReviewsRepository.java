package com.translator.translator.repositories;

import com.translator.translator.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewsRepository extends JpaRepository<Review, Integer> {

}
