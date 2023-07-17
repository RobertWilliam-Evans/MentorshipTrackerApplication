package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.userDTOs.AdviseeDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdviseeResponseDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.AdvisorDTO;

public interface AdviseeService {
    AdviseeResponseDTO createAdvisee(AdviseeDTO adviseeDTO);

}
