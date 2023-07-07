package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;

public interface UserService {
    User createUser(User user);
    User setUserRole(User user, Role role);

    User findUserByEmail(String email);

}
