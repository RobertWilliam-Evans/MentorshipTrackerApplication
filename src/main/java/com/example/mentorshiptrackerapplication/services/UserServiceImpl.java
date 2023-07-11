package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.UserRequestDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.exceptions.EntityDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;

    public UserRequestDTO createUser(UserRequestDTO user) throws EntityAlreadyExistsException {
        User convertedUser = objectMapper.convertValue(user, User.class);
        if(userRepository.existsUserByEmail(convertedUser.getEmail())){
            throw new EntityAlreadyExistsException("User Does Not Exist");
        }
        User user1 = userRepository.save(convertedUser);
        return objectMapper.convertValue(user1, UserRequestDTO.class);

    }

    public UserRequestDTO setUserRole(UserRequestDTO user, String roleName) {
        String email = user.getEmail();

        if(!(userRepository.existsUserByEmail(email))){
            throw new EntityDoesNotExistException("User Does Not Exist ");
        }

        User userInDB = userRepository.findUserByEmail(email);
        if(!(roleRepository.existsRoleByNameIgnoreCase(roleName))){

            throw new EntityDoesNotExistException("Role Does Not Exist");
        }
        Role role = roleRepository.findByNameIgnoreCase(roleName);
        Role userRole = userInDB.getRole();
        if (userRole == null) {
            userInDB.setRole(role);
            User user1 = userRepository.save(userInDB);
            return objectMapper.convertValue(user1, UserRequestDTO.class);
        }

        return objectMapper.convertValue(userInDB, UserRequestDTO.class);

    }

    public UserRequestDTO findUserByEmail(String email) throws EntityDoesNotExistException {



        if(userRepository.existsUserByEmail(email)){
            User user =  userRepository.findUserByEmail(email);
            return objectMapper.convertValue(user, UserRequestDTO.class);
        }
            throw new EntityDoesNotExistException("User Does Not Exist");

    }

}
