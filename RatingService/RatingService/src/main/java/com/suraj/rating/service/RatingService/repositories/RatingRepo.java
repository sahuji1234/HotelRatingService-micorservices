package com.suraj.rating.service.RatingService.repositories;

import com.suraj.rating.service.RatingService.entities.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepo extends JpaRepository<Rating,String> {
    // custom finder methods



    List<Rating> findByUserId(String userId);
    List<Rating> findByHotelId(String hotelId);
}
