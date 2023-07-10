package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.dto.PermissionDTO;
import com.example.mentorshiptrackerapplication.dto.RoleDTO;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;

import java.util.Set;

public interface PermissionService {
    PermissionDTO createPermission(PermissionDTO permission);
    PermissionDTO findPermission(String permissionName);

    PermissionDTO setRoles(PermissionDTO permission, Set<String> roles);
}
