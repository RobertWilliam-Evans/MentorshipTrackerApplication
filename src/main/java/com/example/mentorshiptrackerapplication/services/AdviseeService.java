package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.userDTOs.AdviseeDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorDTO;

public interface AdviseeService {
    AdviseeDTO createAdvisee(AdviseeDTO adviseeDTO);

    AdviseeDTO setAdvisor(AdviseeDTO adviseeDTO, AdvisorDTO advisorDTO);
}
