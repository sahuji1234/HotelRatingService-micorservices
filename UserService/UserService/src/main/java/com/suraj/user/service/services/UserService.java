package com.suraj.user.service.services;

import com.suraj.user.service.entities.User;

import java.util.List;

public interface UserService {
    // user operations

    //create
    User saveUser(User user);

    // get all users
    List<User> getAllUser();

    // get single user of given userId

    User getUser(String userId);


}
