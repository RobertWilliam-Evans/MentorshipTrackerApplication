package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;

import java.util.Set;

public interface PermissionService {
    Permission createPermission(Permission permission);
    Permission findPermission(Permission permission);

    Permission setRoles(Permission permission, Set<Role> roles);
}
