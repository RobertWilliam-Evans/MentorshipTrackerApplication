package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.RoleDTO;
import com.example.mentorshiptrackerapplication.dto.UserDTO;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;

public interface UserService {
    UserDTO createUser(UserDTO user);
    UserDTO setUserRole(UserDTO user, String roleName);

    UserDTO findUserByEmail(String email);

}
