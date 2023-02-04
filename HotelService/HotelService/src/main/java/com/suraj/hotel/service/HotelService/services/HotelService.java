package com.suraj.hotel.service.HotelService.services;

import com.suraj.hotel.service.HotelService.entities.Hotel;


import java.util.List;

public interface HotelService {
    // create
    Hotel create(Hotel hotel);
    //get all
    List<Hotel> getAllHotels();

    //get single
    Hotel getHotel(String id);
}
