package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.jpa.PermissionRepository;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;

    public Role createRole(Role role){

        if(roleRepository.existsRoleByName(role.getName())){
            Role roleInDB = roleRepository.findByName(role.getName()).get(0);
            System.out.println("Role exists" + " " + roleInDB);
            return roleInDB;
        }else{
            return roleRepository.save(role);
        }

    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }



    public Role setPermissions(Role role, Set<Permission> permissions){
        String roleName = role.getName();

        Role roleInDB = roleRepository.findByName(roleName).get(0);
        roleInDB.setPermissions(permissions);
        System.out.println(roleInDB.getPermissions());
        return roleRepository.save(roleInDB);
    }
}
