package com.example.mentorshiptrackerapplication.seeders;

import com.example.mentorshiptrackerapplication.exceptions.RoleDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleSeedService {

    private final RoleRepository roleRepository;
    private static final Logger logger = LoggerFactory.getLogger(RoleSeedService.class);

    public Role createRole(Role role){

        if(roleRepository.existsRoleByName(role.getName())){
            logger.error("Role Already Exists: {}", role.getName());
            return roleRepository.findByNameIgnoreCase(role.getName());
        }else{
            return roleRepository.save(role);
        }
    }

    public Role setPermissions(Role role, Set<Permission> permissions){
        String roleName = role.getName();

        try{
            if(!(roleRepository.existsRoleByName(roleName))){

                throw new RoleDoesNotExistException("Role Does Not Exist " + roleName);
            }

        }catch(RoleDoesNotExistException e){
            logger.error(e.getMessage());
        }
        Role roleInDB = roleRepository.findByNameIgnoreCase(roleName);
        roleInDB.setPermissions(permissions);
        return roleRepository.save(roleInDB);
    }
}
