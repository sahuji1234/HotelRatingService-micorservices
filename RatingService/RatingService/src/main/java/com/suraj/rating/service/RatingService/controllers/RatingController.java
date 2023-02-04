package com.suraj.rating.service.RatingService.controllers;


import com.suraj.rating.service.RatingService.entities.Rating;
import com.suraj.rating.service.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private RatingService ratingService;


    // create Rating
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
        return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
    }

    @GetMapping
    public  ResponseEntity<List<Rating>> getRatings(){
        return  ResponseEntity.ok(ratingService.getRatings());
    }

    @GetMapping("/user/{userId}")
    public  ResponseEntity<List<Rating>> getRatingsByUserId(@PathVariable String userId){
        return  ResponseEntity.ok(ratingService.getRatingsByUserId(userId));
    }

    @GetMapping("/hotels/{hotelId}")
    public  ResponseEntity<List<Rating>> getRatingsByHotelId(@PathVariable String hotelId){
        return  ResponseEntity.ok(ratingService.getRatingsByHotelId(hotelId));
    }
}
