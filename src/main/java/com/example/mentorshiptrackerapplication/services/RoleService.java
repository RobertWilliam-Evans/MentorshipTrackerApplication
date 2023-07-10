package com.example.mentorshiptrackerapplication.services;
import com.example.mentorshiptrackerapplication.dto.RoleDTO;


import java.util.Set;

public interface RoleService {
    RoleDTO createRole(RoleDTO role);
    RoleDTO setPermissions(RoleDTO role, Set<String> permissions);

    RoleDTO findRole(String roleName);
}
