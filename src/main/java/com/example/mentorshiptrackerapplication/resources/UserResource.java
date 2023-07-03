package com.example.mentorshiptrackerapplication.resources;


import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserResource {

    private UserRepository repository;

    public UserResource(UserRepository repository){
        this.repository = repository;
    }
}
