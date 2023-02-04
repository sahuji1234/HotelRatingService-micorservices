package com.suraj.rating.service.RatingService.services.impl;

import com.suraj.rating.service.RatingService.entities.Rating;
import com.suraj.rating.service.RatingService.repositories.RatingRepo;
import com.suraj.rating.service.RatingService.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

   @Autowired
   private RatingRepo ratingRepo;

    @Override
    public Rating create(Rating rating) {
        String randomId = UUID.randomUUID().toString();
        rating.setRatingId(randomId);
        return ratingRepo.save(rating);
    }

    @Override
    public List<Rating> getRatings() {
        return ratingRepo.findAll();
    }

    @Override
    public List<Rating> getRatingsByUserId(String userId) {
        return ratingRepo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(String hotelId) {
        return ratingRepo.findByHotelId(hotelId);
    }
}
