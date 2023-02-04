package com.suraj.user.service.controllers;


import com.suraj.user.service.entities.User;
import com.suraj.user.service.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    //create user
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
      User savedUser=  userService.saveUser(user);
      return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);

    }


    //get All users
    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return  ResponseEntity.ok(users);
    }

    int retryCount =1;
    // get Single user
    @GetMapping("/{userId}")
    //@CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    //@Retry(name="ratingHotelservice",fallbackMethod ="ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
        System.out.println("Retry count"+retryCount);
        retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }
    // creating fall back method for circuit breaker

    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){
      // System.out.println("fallback is executed bevause service is down :"+ex.getMessage());

       User user = User.builder()
               .email("dummy@gmail.com")
               .name("Dummy")
               .about("Dummy user created because some services is down")
               .userId("user id:"+userId)
               .build();
       return  new ResponseEntity<>(user,HttpStatus.OK);
    }


}
