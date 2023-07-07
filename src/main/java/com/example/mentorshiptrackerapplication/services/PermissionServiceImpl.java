package com.example.mentorshiptrackerapplication.services;


import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.exceptions.EntityDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.PermissionRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService{
    private final PermissionRepository permissionRepository;

    private static final Logger logger = LoggerFactory.getLogger(PermissionServiceImpl.class);

    public Permission createPermission(Permission permission) throws EntityAlreadyExistsException {

        String permissionName = permission.getName();

        if(permissionRepository.existsPermissionsByNameIgnoreCase(permissionName)){

            throw new EntityAlreadyExistsException("Permission Already Exists");

        }
        return permissionRepository.save(permission);

    }

    public Permission findPermission(Permission permission) throws EntityDoesNotExistException {

        String permissionName = permission.getName();

        if(permissionRepository.existsPermissionsByNameIgnoreCase(permissionName)){
            return permissionRepository.findByNameIgnoreCase(permissionName);

        }
        throw new EntityDoesNotExistException("Permission Does Not Exist");

    }

    public Permission setRoles(Permission permission, Set<Role> roles) throws EntityDoesNotExistException {
        String permissionName = permission.getName();

            if(!(permissionRepository.existsPermissionsByNameIgnoreCase(permissionName))){

                throw new EntityDoesNotExistException("Permission Does Not Exist");
            }

        Permission permissionInDB = permissionRepository.findByNameIgnoreCase(permissionName);
        permissionInDB.setRoles(roles);
        return permissionRepository.save(permissionInDB);
    }


}
