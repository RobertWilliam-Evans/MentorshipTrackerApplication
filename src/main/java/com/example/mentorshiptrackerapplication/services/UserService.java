package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.userDTOs.UserRequestDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.UserResponseDTO;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO user);
    UserResponseDTO setUserRole(UserResponseDTO user, String roleName);

    UserResponseDTO createAdmin(UserRequestDTO user);

    UserRequestDTO findUserByEmail(String email);

}
