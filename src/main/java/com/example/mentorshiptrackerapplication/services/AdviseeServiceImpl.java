package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.userDTOs.AdviseeDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdviseeResponseDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorResponseDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.exceptions.EntityDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.AdviseeRepository;
import com.example.mentorshiptrackerapplication.jpa.AdvisorRepository;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Advisee;
import com.example.mentorshiptrackerapplication.models.Advisor;
import com.example.mentorshiptrackerapplication.models.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.mentorshiptrackerapplication.constants.Constants.DEFAULT_ROLE;
import static com.example.mentorshiptrackerapplication.constants.Constants.MENTORSHIP_MANAGER;

@RequiredArgsConstructor
@Service
public class AdviseeServiceImpl implements AdviseeService {
    private final AdvisorRepository advisorRepository;
    private final AdviseeRepository adviseeRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    @Override
    public AdviseeResponseDTO createAdvisee(AdviseeDTO adviseeDTO) {
        adviseeDTO.setPassword(passwordEncoder.encode(adviseeDTO.getPassword()));
        if(userRepository.existsUserByEmail(adviseeDTO.getEmail())){
            throw new EntityAlreadyExistsException("This email is already in use");
        }
        Advisee advisee = objectMapper.convertValue(adviseeDTO, Advisee.class);
        Role role = roleRepository.findByNameIgnoreCase(DEFAULT_ROLE);
        Advisor advisor = advisorRepository.findAdvisorByEmail(adviseeDTO.getAdvisorEmail());
        advisee.setRole(role);
        advisee.setAdvisor(advisor);
        adviseeRepository.save(advisee);
        return objectMapper.convertValue(advisee, AdviseeResponseDTO.class);
    }



}
