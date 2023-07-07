package com.example.mentorshiptrackerapplication.services;

import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.exceptions.EntityDoesNotExistException;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class RoleService {

    private final RoleRepository roleRepository;
    private static final Logger logger = LoggerFactory.getLogger(RoleService.class);

    public Role createRole(Role role) throws EntityAlreadyExistsException {

        if(roleRepository.existsRoleByName(role.getName())){

            throw new EntityAlreadyExistsException("Role Does Not Exist");
        }else{
            return roleRepository.save(role);
        }
    }

    public Role setPermissions(Role role, Set<Permission> permissions){
        String roleName = role.getName();


        if(!(roleRepository.existsRoleByName(roleName))){

            throw new EntityDoesNotExistException("Role Does Not Exist ");
        }

        Role roleInDB = roleRepository.findByNameIgnoreCase(roleName);
        roleInDB.setPermissions(permissions);
        return roleRepository.save(roleInDB);
    }

    public Role findRole(Role role) throws EntityDoesNotExistException {

        String roleName = role.getName();

        if(roleRepository.existsRoleByName(roleName)){
            return roleRepository.findByNameIgnoreCase(roleName);

        }else{
            throw new EntityDoesNotExistException("Role Does Not Exist");

        }

    }
}
