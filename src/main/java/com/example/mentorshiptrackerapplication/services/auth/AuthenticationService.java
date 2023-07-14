package com.example.mentorshiptrackerapplication.services.auth;

import com.example.mentorshiptrackerapplication.dto.AuthenticationRequest;
import com.example.mentorshiptrackerapplication.dto.AuthenticationResponse;
import com.example.mentorshiptrackerapplication.dto.UserRequestDTO;


public interface AuthenticationService {


    AuthenticationResponse register(UserRequestDTO request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
