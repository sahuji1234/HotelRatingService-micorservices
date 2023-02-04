package com.suraj.user.service;

import com.suraj.user.service.entities.Rating;
import com.suraj.user.service.external.services.RatingService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private RatingService ratingService;

	@Test
	void createRating(){
		Rating rating =Rating.builder().rating(10).userId("64a6daa0-cc9a-46f0-b618-0279177c0364").hotelId("80132945-532a-453c-b15a-97e17d9a43d6").feedback("this is created using feign client").build();
	    ResponseEntity<Rating> ratingResponseEntity=	ratingService.createRating(rating);
		System.out.println("new Rating created"+ratingResponseEntity.getStatusCode()+"  "+	ratingResponseEntity.getBody());


	}

}
