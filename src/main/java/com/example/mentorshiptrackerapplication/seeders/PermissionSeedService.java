package com.example.mentorshiptrackerapplication.seeders;

import com.example.mentorshiptrackerapplication.jpa.PermissionRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class PermissionSeedService {
    private final PermissionRepository permissionRepository;

    public Permission createPermission(Permission permission){

        if(permissionRepository.existsPermissionsByName(permission.getName())){
            return permissionRepository.findByNameIgnoreCase(permission.getName());
        }else{
            return permissionRepository.save(permission);
        }

    }


    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission setRoles(Permission permission, Set<Role> roles){
        String permissionName = permission.getName();

        Permission permissionInDB = permissionRepository.findByNameIgnoreCase(permissionName);
        permissionInDB.setRoles(roles);
        return permissionRepository.save(permissionInDB);
    }


}
