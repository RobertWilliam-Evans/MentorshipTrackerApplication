package com.example.mentorshiptrackerapplication;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;

public class User {

    @Id
    @GeneratedValue
    private Integer id;

    @Size(min=2, message ="Name should have at least two characters")
    private String firstName;

    private String userName;

    private String email;

    private String password;

    private LocalDate birtDate;

    private Role role;



    public User(){

    }



}
