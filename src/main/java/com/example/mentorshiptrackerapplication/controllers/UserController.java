package com.example.mentorshiptrackerapplication.controllers;


import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorResponseDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.UserRequestDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.UserResponseDTO;
import com.example.mentorshiptrackerapplication.services.AdvisorService;
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
    private final AdvisorService advisorService;

    @PostMapping("v1/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createAdmin(@Valid @RequestBody UserRequestDTO admin) {

        return userService.createAdmin(admin);

    }

    @PostMapping("v1/advisor")
    @ResponseStatus(HttpStatus.CREATED)
    public AdvisorResponseDTO createAdvisor(@Valid @RequestBody AdvisorDTO user) {

        return advisorService.createAdvisor(user);

    }

}
