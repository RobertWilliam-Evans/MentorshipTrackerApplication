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
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final ObjectMapper objectMapper;

    public RoleDTO createRole(RoleDTO role) throws EntityAlreadyExistsException {
        Role convertedRole = objectMapper.convertValue(role, Role.class);
        if(roleRepository.existsRoleByNameIgnoreCase(role.getName())){

            throw new EntityAlreadyExistsException("Role Already Exists");
        }
        Role role1 = roleRepository.save(convertedRole);
        return objectMapper.convertValue(role1, RoleDTO.class);

    }

    public RoleDTO setPermissions(RoleDTO role, Set<String> permissions){

        String roleName = role.getName();
        Set<Permission> convertedPermissions = new HashSet<>();
        for (String permissionName : permissions) {

            if(!(permissionRepository.existsPermissionsByNameIgnoreCase(permissionName))){
                throw new EntityDoesNotExistException("Permission Does Not Exist: " + permissionName);

            }
                Permission permission = permissionRepository.findByNameIgnoreCase(permissionName);
                convertedPermissions.add(objectMapper.convertValue(permission, Permission.class));


        }

        if(!(roleRepository.existsRoleByNameIgnoreCase(roleName))){

            throw new EntityDoesNotExistException("Role Does Not Exist ");
        }

        Role roleInDB = roleRepository.findByNameIgnoreCase(roleName);
        roleInDB.setPermissions(convertedPermissions);
        Role role1 = roleRepository.save(roleInDB);
        return objectMapper.convertValue(role1, RoleDTO.class);
    }

    public RoleDTO findRole(String roleName) throws EntityDoesNotExistException {


        if(roleRepository.existsRoleByNameIgnoreCase(roleName)){
            Role role1=  roleRepository.findByNameIgnoreCase(roleName);
            return objectMapper.convertValue(role1, RoleDTO.class);

        } throw new EntityDoesNotExistException("Role Does Not Exist");

    }
}
