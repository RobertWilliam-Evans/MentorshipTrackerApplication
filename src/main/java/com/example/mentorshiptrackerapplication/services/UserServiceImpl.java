package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.userDTOs.UserRequestDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.UserResponseDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.exceptions.EntityDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.mentorshiptrackerapplication.constants.Constants.ADMIN;
import static com.example.mentorshiptrackerapplication.constants.Constants.DEFAULT_ROLE;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;


    public UserResponseDTO createUser(UserRequestDTO user) throws EntityAlreadyExistsException {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User convertedUser = objectMapper.convertValue(user, User.class);
        if(userRepository.existsUserByEmail(convertedUser.getEmail())){
            throw new EntityAlreadyExistsException("User Already Exists");
        }
        Role role = roleRepository.findByNameIgnoreCase(DEFAULT_ROLE);
        convertedUser.setRole(role);
        User user1 = userRepository.save(convertedUser);
        return objectMapper.convertValue(user1, UserResponseDTO.class);

    }

    public UserResponseDTO createAdmin(UserRequestDTO user) throws EntityAlreadyExistsException {
        UserResponseDTO userDTO = createUser(user);
        UserResponseDTO admin = setUserRole(userDTO, ADMIN);
        return objectMapper.convertValue(admin, UserResponseDTO.class);

    }

    public UserResponseDTO setUserRole(UserResponseDTO user, String roleName) {
        String email = user.getEmail();

        if(!(userRepository.existsUserByEmail(email))){
            throw new EntityDoesNotExistException("User Does Not Exist ");
        }

        User userInDB = userRepository.findUserByEmail(email);
        if(!(roleRepository.existsRoleByNameIgnoreCase(roleName))){

            throw new EntityDoesNotExistException("Role Does Not Exist");
        }
        Role role = roleRepository.findByNameIgnoreCase(roleName);

        userInDB.setRole(role);
        User user1 = userRepository.save(userInDB);
        return objectMapper.convertValue(user1, UserResponseDTO.class);

    }

    public UserRequestDTO findUserByEmail(String email) throws EntityDoesNotExistException {

        if(userRepository.existsUserByEmail(email)){
            User user =  userRepository.findUserByEmail(email);
            return objectMapper.convertValue(user, UserRequestDTO.class);
        }
            throw new EntityDoesNotExistException("User Does Not Exist");

    }

}
