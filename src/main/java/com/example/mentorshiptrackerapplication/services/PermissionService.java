package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.jpa.PermissionRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class PermissionService {
    private final PermissionRepository permissionRepository;

    public Permission createPermission(Permission permission){

        if(permissionRepository.existsPermissionsByName(permission.getName())){
            Permission permissionInDB = permissionRepository.findByName(permission.getName()).get(0);
            System.out.println("Permission exists" + " " + permissionInDB);
            return permissionInDB;
        }else{
            return permissionRepository.save(permission);
        }

    }


    public List<Permission> getAllPermissions() {
        return permissionRepository.findAll();
    }

    public Permission setRoles(Permission permission, Set<Role> roles){
        String permissionName = permission.getName();

        Permission permissionInDB = permissionRepository.findByName(permissionName).get(0);
        permissionInDB.setRoles(roles);
        System.out.println(permissionInDB.getRoles());
        return permissionRepository.save(permissionInDB);
    }


}
