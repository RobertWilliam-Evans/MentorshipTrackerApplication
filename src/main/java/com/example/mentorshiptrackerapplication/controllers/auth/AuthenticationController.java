package com.example.mentorshiptrackerapplication.controllers.auth;


import com.example.mentorshiptrackerapplication.controllers.RegisterRequest;
import com.example.mentorshiptrackerapplication.dto.AuthenticationResponse;
import com.example.mentorshiptrackerapplication.dto.UserRequestDTO;
import com.example.mentorshiptrackerapplication.services.auth.AuthenticationService;
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
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){return ResponseEntity.ok(service.authenticate(request));}
}
