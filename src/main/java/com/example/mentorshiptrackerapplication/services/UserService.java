package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.exceptions.EntityDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    public User createUser(User user) throws EntityAlreadyExistsException {
        if(userRepository.existsUserByEmail(user.getEmail())){
            throw new EntityAlreadyExistsException("User Does Not Exist");
        }else{
            return userRepository.save(user);
        }

    }

    public User setUserRole(User user, Role role) {
        String email = user.getEmail();

        if(!(userRepository.existsUserByEmail(email))){
            throw new EntityDoesNotExistException("User Does Not Exist ");
        }

        User userInDB = userRepository.findUserByEmail(email);
        Role userRole = userInDB.getRole();
        if (userRole == null) {
            userInDB.setRole(role);
            return userRepository.save(userInDB);
        } else {
            return userInDB;
        }
    }

    public User findUserByEmail(String email) throws EntityDoesNotExistException {



        if(userRepository.existsUserByEmail(email)){
            return userRepository.findUserByEmail(email);

        }else{
            throw new EntityDoesNotExistException("User Does Not Exist");

        }

    }




}
