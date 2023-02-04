package com.suraj.hotel.service.HotelService.controllers;


import com.suraj.hotel.service.HotelService.entities.Hotel;
import com.suraj.hotel.service.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //get

    @GetMapping("/{id}")
    public  ResponseEntity<Hotel> getHotel(@PathVariable String id){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(id));
    }

    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return  ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    //getAll
    @GetMapping
    public  ResponseEntity<List<Hotel>> getAllHotels(){
        return  ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotels());
    }
}
