package com.example.mentorshiptrackerapplication.controllers;


import com.example.mentorshiptrackerapplication.dto.UserDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.User;
import com.example.mentorshiptrackerapplication.services.UserService;
import com.example.mentorshiptrackerapplication.services.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.example.mentorshiptrackerapplication.constants.Constants.ADMIN;
@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserServiceImpl userService;


    @PostMapping("api/admin")
    public ResponseEntity<UserDTO> createAdmin(@Valid @RequestBody UserDTO admin) throws EntityAlreadyExistsException {

        UserDTO savedAdmin = userService.createUser(admin);
        UserDTO updatedAdmin = userService.setUserRole(savedAdmin, ADMIN);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedAdmin);
    }

}
