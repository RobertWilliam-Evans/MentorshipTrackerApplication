package com.example.mentorshiptrackerapplication.seeders;

import com.example.mentorshiptrackerapplication.exceptions.RoleDoesNotExistException;
import com.example.mentorshiptrackerapplication.exceptions.UserDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@Service
@AllArgsConstructor
public class UserSeedService {
    private final UserRepository userRepository;
    private static final Logger logger = LoggerFactory.getLogger(UserSeedService.class);

    public User createUser(User user){
        if(userRepository.existsUserByEmail(user.getEmail())){
            logger.error("User Already exists: {} ", user.getEmail());
            return userRepository.findUserByEmailIgnoreCase(user.getEmail());
        }else{
            return userRepository.save(user);
        }

    }

    public User setUserRole(User user, Role role) {
        String email = user.getEmail();

        try{
            if(!(userRepository.existsUserByEmail(email))){

                throw new UserDoesNotExistException("User Does Not Exist " + email);
            }

        }catch(UserDoesNotExistException e){
            logger.error(e.getMessage());
        }

        User userInDB = userRepository.findUserByEmailIgnoreCase(email);
        Role userRole = userInDB.getRole();
        if (userRole == null) {
            userInDB.setRole(role);
            return userRepository.save(userInDB);
        } else {
            return userInDB;
        }
    }




}
