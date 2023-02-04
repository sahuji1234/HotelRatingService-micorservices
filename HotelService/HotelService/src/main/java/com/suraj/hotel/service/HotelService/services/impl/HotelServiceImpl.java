package com.suraj.hotel.service.HotelService.services.impl;

import com.suraj.hotel.service.HotelService.entities.Hotel;
import com.suraj.hotel.service.HotelService.exception.ResourceNotFoundException;
import com.suraj.hotel.service.HotelService.repositories.HotelRepo;
import com.suraj.hotel.service.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Override
    public Hotel create(Hotel hotel) {
        String randomId = UUID.randomUUID().toString();
        hotel.setId(randomId);
        return hotelRepo.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepo.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel not found with given id"));
    }
}
