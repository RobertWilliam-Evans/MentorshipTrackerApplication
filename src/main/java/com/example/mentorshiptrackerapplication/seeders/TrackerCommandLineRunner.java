package com.example.mentorshiptrackerapplication.seeders;


import com.example.mentorshiptrackerapplication.dto.PermissionDTO;
import com.example.mentorshiptrackerapplication.dto.RoleDTO;
import com.example.mentorshiptrackerapplication.dto.UserDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import com.example.mentorshiptrackerapplication.services.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static com.example.mentorshiptrackerapplication.constants.Constants.ADMIN;

@Component
@RequiredArgsConstructor
public class TrackerCommandLineRunner implements CommandLineRunner {


    private final PermissionService permissionService;

    private final RoleService roleService;

    private final UserService userService;

    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    public void run(String... args) throws Exception{

//       Creating permissions using the permission service
        PermissionDTO p1 = new PermissionDTO("Manage Mentorship", "Create, view, update and delete on mentorship");
        PermissionDTO p2 = new PermissionDTO("View Mentorship", "View mentorship only");


        try {
             permissionService.createPermission(p1);

        } catch(EntityAlreadyExistsException e){
             permissionService.findPermission(p1.getName());
        }

        try {
            permissionService.createPermission(p2);

        } catch(EntityAlreadyExistsException e){
            permissionService.findPermission(p2.getName());
        }


//      Creating roles using the role service
        RoleDTO r1 = new RoleDTO("Administrator", "Perform all Actions");
        RoleDTO r2 = new RoleDTO("Mentorship manager", "Perform mentorship associated CRUD actions");

        try {
            roleService.createRole(r1);

        } catch(EntityAlreadyExistsException e){
            roleService.findRole(r1.getName());
        }

        try {
            roleService.createRole(r2);

        } catch(EntityAlreadyExistsException e){
            roleService.findRole(r2.getName());
        }




//      Updating roles and permissions
        Set<String> newRoles = new HashSet<>();
        Set<String> newPermissions = new HashSet<>();
//
        newRoles.add(r2.getName());


        newPermissions.add(p2.getName());
        newPermissions.add(p2.getName());
        roleService.setPermissions(r1, newPermissions);
        permissionService.setRoles(p1, newRoles);
        permissionService.setRoles(p2, newRoles);



//      Seeding User
        UserDTO user = new UserDTO("admin", "admin", "admin@gmail.com", "adminpassword123");
        UserDTO createdUser;

        try {
            createdUser = userService.createUser(user);

        } catch(EntityAlreadyExistsException e){
            createdUser = userService.findUserByEmail(user.getEmail());
        }


        userService.setUserRole(createdUser, r1.getName());


    }
}
