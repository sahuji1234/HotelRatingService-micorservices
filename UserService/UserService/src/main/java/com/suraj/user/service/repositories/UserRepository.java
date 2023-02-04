package com.suraj.user.service.repositories;

import com.suraj.user.service.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping
public interface UserRepository extends JpaRepository<User,String> {

    // if you want to implement any custom method or query you can write here
}
