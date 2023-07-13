package com.example.mentorshiptrackerapplication.services;


import com.example.mentorshiptrackerapplication.dto.PermissionDTO;
import com.example.mentorshiptrackerapplication.dto.RoleDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.exceptions.EntityDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.PermissionRepository;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import com.example.mentorshiptrackerapplication.services.PermissionServiceImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService{
    private final PermissionRepository permissionRepository;
    private final RoleRepository roleRepository;
    private final ObjectMapper objectMapper;

    public PermissionDTO createPermission(PermissionDTO permission) throws EntityAlreadyExistsException {
        Permission convertedPermission = objectMapper.convertValue(permission, Permission.class);
        String permissionName = permission.getName();

        if(permissionRepository.existsPermissionsByNameIgnoreCase(permissionName)){

            throw new EntityAlreadyExistsException("Permission Already Exists");

        }

        Permission permission1 = permissionRepository.save(convertedPermission);
        return objectMapper.convertValue(permission1, PermissionDTO.class);

    }

    public PermissionDTO findPermission(String permissionName) throws EntityDoesNotExistException {


        if(permissionRepository.existsPermissionsByNameIgnoreCase(permissionName)){
            Permission permission1 = permissionRepository.findByNameIgnoreCase(permissionName);
            return objectMapper.convertValue(permission1, PermissionDTO.class);

        }
        throw new EntityDoesNotExistException("Permission Does Not Exist");

    }

    public PermissionDTO setRoles(PermissionDTO permission, Set<String> roles) throws EntityDoesNotExistException {
        String permissionName = permission.getName();
        Set<Role> convertedRoles = new HashSet<>();

        //Finding roles
        for (String roleName : roles) {
            if(!(roleRepository.existsRoleByNameIgnoreCase(roleName))){
                throw new EntityDoesNotExistException("Role Does Not Exist: " + roleName);
            }
            Role role = roleRepository.findByNameIgnoreCase(roleName);
            convertedRoles.add(role);
        }

        //Checking whether permission exist
        if(!(permissionRepository.existsPermissionsByNameIgnoreCase(permissionName))){
            throw new EntityDoesNotExistException("Permission Does Not Exist: "+ permissionName);
        }

        //Setting roles
        Permission permissionInDB = permissionRepository.findByNameIgnoreCase(permissionName);
        permissionInDB.setRoles(convertedRoles);
        Permission permission1 = permissionRepository.save(permissionInDB);
        return objectMapper.convertValue(permission1, PermissionDTO.class);
    }


}
