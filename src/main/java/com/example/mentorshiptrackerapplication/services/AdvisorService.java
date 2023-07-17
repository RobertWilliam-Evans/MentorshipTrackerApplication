package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorResponseDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.UserResponseDTO;

public interface AdvisorService {

    AdvisorResponseDTO createAdvisor(AdvisorDTO advisorDTO);
}
