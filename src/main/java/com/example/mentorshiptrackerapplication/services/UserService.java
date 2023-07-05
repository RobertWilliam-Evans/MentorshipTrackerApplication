package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user){

        if(userRepository.existsUserByEmail(user.getEmail())){
            User userInDB = userRepository.findUserByEmail(user.getEmail()).get(0);
            System.out.println("User exists" + " " + userInDB);
            return userInDB;
        }else{
            return userRepository.save(user);
        }

    }

    public User setUserRole(User user, Role role) {
        String email = user.getEmail();

        User userInDB = userRepository.findUserByEmail(email).get(0);
        Role userRole = userInDB.getRole();
        if (userRole == null) {
            userInDB.setRole(role);
            return userRepository.save(userInDB);
        } else {
            System.out.println("User already has a role");
            return userInDB;

        }
    }




}
