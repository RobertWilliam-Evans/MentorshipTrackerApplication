package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;




    public User createUser(User user){
        if(userRepository.existsUserByEmail(user.getEmail())){
            return userRepository.findUserByEmail(user.getEmail());
        }else{
            return userRepository.save(user);
        }

    }

    public User setUserRole(User user, Role role) {
        String email = user.getEmail();

        User userInDB = userRepository.findUserByEmail(email);
        Role userRole = userInDB.getRole();
        if (userRole == null) {
            userInDB.setRole(role);
            return userRepository.save(userInDB);
        } else {

            return userInDB;

        }
    }




}
