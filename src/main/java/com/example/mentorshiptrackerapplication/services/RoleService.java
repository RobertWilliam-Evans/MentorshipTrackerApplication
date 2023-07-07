package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;

import java.util.Set;

public interface RoleService {
    Role createRole(Role role);
    Role setPermissions(Role role, Set<Permission> permissions);

    Role findRole(Role role);
}
