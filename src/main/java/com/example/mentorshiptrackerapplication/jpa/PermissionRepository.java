package com.example.mentorshiptrackerapplication.jpa;

import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {
    Permission findByNameIgnoreCase(String name);


    boolean existsPermissionsByNameIgnoreCase(String name);
}
