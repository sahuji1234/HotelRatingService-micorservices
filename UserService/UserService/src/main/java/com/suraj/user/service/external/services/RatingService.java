package com.suraj.user.service.external.services;


import com.suraj.user.service.entities.Rating;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@FeignClient(name="RATING-SERVICE")
public interface RatingService {

    //GET

    //POST
     @PostMapping("/ratings")
     ResponseEntity<Rating> createRating(Rating values);
    //PUT
    @PutMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> updateRating(@PathVariable("ratingId") String ratingId, Rating rating);

    @DeleteMapping("/ratings/{ratingId}")
    void deleteRating(@PathVariable String ratingId);
}
