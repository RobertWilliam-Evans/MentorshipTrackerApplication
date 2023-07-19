package com.example.mentorshiptrackerapplication.services.auth;

import com.example.mentorshiptrackerapplication.dto.AuthenticationRequest;
import com.example.mentorshiptrackerapplication.dto.AuthenticationResponse;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.UserRequestDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.exceptions.EntityDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.AdvisorRepository;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Advisor;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import com.example.mentorshiptrackerapplication.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.mentorshiptrackerapplication.constants.Constants.*;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService{

    private final UserRepository userRepository;
    private final AdvisorRepository advisorRepository;
    private final UserService userService;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final ObjectMapper objectMapper;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    public AuthenticationResponse register(UserRequestDTO request) {

        if(userRepository.existsUserByEmail(request.getEmail())){
            throw new EntityAlreadyExistsException("User Already Exists");

        }

        request.setPassword(passwordEncoder.encode(request.getPassword()));
        User convertedUser = objectMapper.convertValue(request, User.class);
        Role role = roleRepository.findByNameIgnoreCase(ADMIN);
        convertedUser.setRole(role);
        userRepository.save(convertedUser);
        var jwtToken = jwtService.generateToken(request);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse registerAdvisor(AdvisorDTO request) {
        request.setPassword(passwordEncoder.encode(request.getPassword()));
        if(userRepository.existsUserByEmail(request.getEmail())){
            throw new EntityAlreadyExistsException("User Already Exists");

        }

        User convertedUser = objectMapper.convertValue(request, Advisor.class);
        Role role = roleRepository.findByNameIgnoreCase(MENTORSHIP_MANAGER);
        convertedUser.setRole(role);
        userRepository.save(convertedUser);
        var jwtToken = jwtService.generateToken(request);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        try{
            var user = userService.findUserByEmail(request.getEmail());
            var jwtToken = jwtService.generateToken(user);
            return AuthenticationResponse.builder()
                    .token(jwtToken)
                    .build();
        }catch (EntityDoesNotExistException e){
            throw new EntityDoesNotExistException("User Does Not Exist");

        }

    }
}
