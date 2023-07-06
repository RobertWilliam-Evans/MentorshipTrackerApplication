package com.example.mentorshiptrackerapplication.seeders;


import com.example.mentorshiptrackerapplication.exceptions.PermissionDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.PermissionRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
@RequiredArgsConstructor
public class PermissionSeedService {
    private final PermissionRepository permissionRepository;

    private static final Logger logger = LoggerFactory.getLogger(PermissionSeedService.class);

    public Permission createPermission(Permission permission){

        String permissionName = permission.getName();

        if(permissionRepository.existsPermissionsByName(permissionName)){

            logger.error("Permission already exists: {}" , permission.getName());
            return permissionRepository.findByNameIgnoreCase(permissionName);

        }else{
            return permissionRepository.save(permission);
        }

    }

    public Permission setRoles(Permission permission, Set<Role> roles){
        String permissionName = permission.getName();
        try{
            if(!(permissionRepository.existsPermissionsByName(permissionName))){

                throw new PermissionDoesNotExistException("Permission Does Not Exist " + permissionName);
            }
        }catch(PermissionDoesNotExistException e){
            logger.error(e.getMessage());
        }
        Permission permissionInDB = permissionRepository.findByNameIgnoreCase(permissionName);
        permissionInDB.setRoles(roles);
        return permissionRepository.save(permissionInDB);
    }


}
