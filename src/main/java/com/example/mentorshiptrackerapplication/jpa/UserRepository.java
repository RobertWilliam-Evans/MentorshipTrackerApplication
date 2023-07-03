package com.example.mentorshiptrackerapplication.jpa;

import com.example.mentorshiptrackerapplication.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
