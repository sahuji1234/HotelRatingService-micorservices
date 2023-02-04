package com.suraj.hotel.service.HotelService.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping
    public ResponseEntity<List<String>> getStafs(){
        List<String> list = Arrays.asList("Ram", "shyam", "krishna");
        return  new ResponseEntity<>(list, HttpStatus.OK);
    }
}
