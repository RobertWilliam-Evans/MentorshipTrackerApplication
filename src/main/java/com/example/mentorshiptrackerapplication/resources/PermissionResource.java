package com.example.mentorshiptrackerapplication.resources;

import com.example.mentorshiptrackerapplication.jpa.PermissionRepository;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;

public class PermissionResource {

    private PermissionRepository repository;

    public PermissionResource(PermissionRepository repository){
        this.repository = repository;
    }
}
