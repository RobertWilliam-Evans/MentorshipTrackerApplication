package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.UserRequestDTO;
import com.example.mentorshiptrackerapplication.dto.UserResponseDTO;

public interface UserService {
    UserRequestDTO createUser(UserRequestDTO user);
    UserRequestDTO setUserRole(UserRequestDTO user, String roleName);

    UserResponseDTO createAdmin(UserRequestDTO user);

    UserRequestDTO findUserByEmail(String email);

}
