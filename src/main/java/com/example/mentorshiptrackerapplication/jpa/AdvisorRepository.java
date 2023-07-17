package com.example.mentorshiptrackerapplication.jpa;

import com.example.mentorshiptrackerapplication.models.Advisee;
import com.example.mentorshiptrackerapplication.models.Advisor;
import com.example.mentorshiptrackerapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdvisorRepository extends JpaRepository<Advisor, Integer> {

    Advisee findAdvisorByEmail(String email);
}
