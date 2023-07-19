package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.userDTOs.AdviseeDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorResponseDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.UserResponseDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.jpa.AdvisorRepository;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Advisor;
import com.example.mentorshiptrackerapplication.models.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import static com.example.mentorshiptrackerapplication.constants.Constants.DEFAULT_ROLE;
import static com.example.mentorshiptrackerapplication.constants.Constants.MENTORSHIP_MANAGER;

@Service
@RequiredArgsConstructor
public class AdvisorServiceImpl implements AdvisorService{
    private final AdvisorRepository advisorRepository;
    private final UserRepository userRepository;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;
    private final RoleRepository roleRepository;


    @Override
    public AdvisorResponseDTO createAdvisor(AdvisorDTO advisorDTO) {
        advisorDTO.setPassword(passwordEncoder.encode(advisorDTO.getPassword()));
        if(userRepository.existsUserByEmail(advisorDTO.getEmail())){
            throw new EntityAlreadyExistsException("This email is already in use");
        }
        Advisor advisor = objectMapper.convertValue(advisorDTO, Advisor.class);
        Role role = roleRepository.findByNameIgnoreCase(MENTORSHIP_MANAGER);
        advisor.setRole(role);
        advisorRepository.save(advisor);
        return objectMapper.convertValue(advisor, AdvisorResponseDTO.class);
    }
}
