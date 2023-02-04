package com.suraj.user.service.entities;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="micro_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @Column(name="id")
    private String userId;
    @Column(name="name")
    private String name;
    @Column(name="email")
    private String email;
    @Column(name="about")
    private String about;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
    // other user properties that we want
}
