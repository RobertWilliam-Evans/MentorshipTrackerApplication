package com.example.mentorshiptrackerapplication.services.auth;

import com.example.mentorshiptrackerapplication.controllers.auth.AuthenticationRequest;
import com.example.mentorshiptrackerapplication.dto.AuthenticationResponse;
import com.example.mentorshiptrackerapplication.dto.UserRequestDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.exceptions.EntityDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.User;
import com.example.mentorshiptrackerapplication.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;



public interface AuthenticationService {


    AuthenticationResponse register(UserRequestDTO request);

    AuthenticationResponse authenticate(AuthenticationRequest request);
}
