package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.UserRequestDTO;

public interface UserService {
    UserRequestDTO createUser(UserRequestDTO user);
    UserRequestDTO setUserRole(UserRequestDTO user, String roleName);

    UserRequestDTO findUserByEmail(String email);

}
