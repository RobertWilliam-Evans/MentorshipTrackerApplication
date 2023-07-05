package com.example.mentorshiptrackerapplication.jpa;

import com.example.mentorshiptrackerapplication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoleRepository extends JpaRepository<Role, Integer>{

    List<Role> findByName(String name);

    boolean existsRoleByName(String name);
}
