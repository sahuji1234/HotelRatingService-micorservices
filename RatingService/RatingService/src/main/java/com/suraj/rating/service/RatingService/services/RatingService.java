package com.suraj.rating.service.RatingService.services;

import com.suraj.rating.service.RatingService.entities.Rating;

import java.util.List;

public interface RatingService {
    // create
    Rating create(Rating rating);

    //getAllRating
    List<Rating> getRatings();

    //get All rating by user ID
    List<Rating> getRatingsByUserId(String userId);

    //get All By hotel
    List<Rating> getRatingsByHotelId(String hotelId);
}
