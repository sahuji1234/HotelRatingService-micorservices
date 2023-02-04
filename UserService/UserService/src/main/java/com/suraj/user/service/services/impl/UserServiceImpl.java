package com.suraj.user.service.services.impl;

import com.suraj.user.service.entities.Hotel;
import com.suraj.user.service.entities.Rating;
import com.suraj.user.service.entities.User;
import com.suraj.user.service.exceptions.ResourceNotFoundException;
import com.suraj.user.service.external.services.HotelService;
import com.suraj.user.service.repositories.UserRepository;
import com.suraj.user.service.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

   private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

   @Autowired
   private HotelService hotelService;

    @Override
    public User saveUser(User user) {

        // generte an uniue random user id
        String randomUserId= UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
       User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user not found with id"+userId));

       // fetch rating of above user from rating service
        //http://localhost:9097/ratings/user/9dc674ce-dcfa-469e-a45c-192e7183a4a3

       Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/user/"+user.getUserId(), Rating[].class);
       logger.info(" ratings of user", ratingsOfUser);
       List<Rating> ratings=  Arrays.stream(ratingsOfUser).collect(Collectors.toList());

       List<Rating> ratingList= ratings.stream().map(rating -> {
          // api call to hotel service to get the hotel
         // http://localhost:9098/hotels
       //   ResponseEntity<Hotel> forEntity= restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);

     //     Hotel hotel = forEntity.getBody();
           Hotel hotel = hotelService.getHotel(rating.getHotelId());
          // set the hotel rating
          rating.setHotel(hotel);
           // return the rating
           return rating;


       }).collect(Collectors.toList());

       user.setRatings(ratingList);
       return  user;
    }
}
