package com.example.mentorshiptrackerapplication.resources;

import com.example.mentorshiptrackerapplication.jpa.PermissionRepository;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;

public class RoleResource {
    private RoleRepository repository;

    public RoleResource(RoleRepository repository){
        this.repository = repository;
    }
}
