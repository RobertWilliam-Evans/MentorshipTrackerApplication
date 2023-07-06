package com.example.mentorshiptrackerapplication.seeders;

import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleSeedService {

    private final RoleRepository roleRepository;

    public Role createRole(Role role){
        if(roleRepository.existsRoleByName(role.getName())){
            return roleRepository.findByNameIgnoreCase(role.getName());
        }else{
            return roleRepository.save(role);
        }
    }

    public List<Role> getAllRole() {
        return roleRepository.findAll();
    }



    public Role setPermissions(Role role, Set<Permission> permissions){
        String roleName = role.getName();
        Role roleInDB = roleRepository.findByNameIgnoreCase(roleName);
        roleInDB.setPermissions(permissions);
        return roleRepository.save(roleInDB);
    }
}
