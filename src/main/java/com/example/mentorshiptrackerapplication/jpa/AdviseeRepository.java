package com.example.mentorshiptrackerapplication.jpa;

import com.example.mentorshiptrackerapplication.models.Advisee;
import com.example.mentorshiptrackerapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdviseeRepository extends JpaRepository<Advisee, Integer> {

    Advisee findAdviseeByEmail(String email);
}
