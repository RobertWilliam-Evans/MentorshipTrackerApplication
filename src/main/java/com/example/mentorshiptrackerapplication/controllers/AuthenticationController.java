package com.example.mentorshiptrackerapplication.controllers;



import com.example.mentorshiptrackerapplication.dto.AuthenticationRequest;
import com.example.mentorshiptrackerapplication.dto.AuthenticationResponse;
import com.example.mentorshiptrackerapplication.dto.userDTOs.UserRequestDTO;
import com.example.mentorshiptrackerapplication.services.auth.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/v1/auth/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody UserRequestDTO request
    ){
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/v1/auth/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate( @Valid
            @RequestBody AuthenticationRequest request
    ){return ResponseEntity.ok(service.authenticate(request));}
}
