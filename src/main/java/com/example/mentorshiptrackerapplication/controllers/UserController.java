package com.example.mentorshiptrackerapplication.controllers;


import com.example.mentorshiptrackerapplication.dto.UserRequestDTO;
import com.example.mentorshiptrackerapplication.dto.UserResponseDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.mentorshiptrackerapplication.constants.Constants.ADMIN;
@RequiredArgsConstructor
@RestController
@RequestMapping("api/")
public class UserController {
    private final UserService userService;
    private final ObjectMapper objectMapper;


    @PostMapping("v1/admin")
    public ResponseEntity<UserResponseDTO> createAdmin(@Valid @RequestBody UserRequestDTO admin) throws EntityAlreadyExistsException {

        UserRequestDTO savedAdmin = userService.createUser(admin);
        UserRequestDTO updatedAdmin = userService.setUserRole(savedAdmin, ADMIN);
        UserResponseDTO responseAdmin = objectMapper.convertValue(updatedAdmin, UserResponseDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseAdmin);
    }

}
