package com.example.mentorshiptrackerapplication.controllers;


import com.example.mentorshiptrackerapplication.dto.UserRequestDTO;
import com.example.mentorshiptrackerapplication.dto.UserResponseDTO;
import com.example.mentorshiptrackerapplication.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/")
public class UserController {
    private final UserService userService;

    @PostMapping("v1/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createAdmin(@Valid @RequestBody UserRequestDTO admin) {

        return userService.createAdmin(admin);

    }

}
