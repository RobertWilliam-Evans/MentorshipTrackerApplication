package com.example.mentorshiptrackerapplication.seeders;


import com.example.mentorshiptrackerapplication.dto.PermissionDTO;
import com.example.mentorshiptrackerapplication.dto.RoleDTO;
import com.example.mentorshiptrackerapplication.dto.userDTOs.UserRequestDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.services.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TrackerCommandLineRunner implements CommandLineRunner {


    private final PermissionService permissionService;

    private final RoleService roleService;

    private final UserService userService;

    private final PasswordEncoder passwordEncoder;


    @Override
    public void run(String... args) throws Exception{

        String savedPassword = System.getenv("ADMIN_PASSWORD");

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
        RoleDTO r3  = new RoleDTO("Default role", "Default description");
        RoleDTO createdRole;
        try {
            createdRole = roleService.createRole(r1);

        } catch(EntityAlreadyExistsException e){
            createdRole = roleService.findRole(r1.getName());
        }

        try {
            roleService.createRole(r2);

        } catch(EntityAlreadyExistsException e){
            roleService.findRole(r2.getName());
        }
        try {
            roleService.createRole(r3);

        } catch(EntityAlreadyExistsException e){
            roleService.findRole(r3.getName());
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

        String password = passwordEncoder.encode(savedPassword);


//      Seeding User
        UserRequestDTO user = new UserRequestDTO("admin", "admin", "admin@gmail.com", password, createdRole);
        try {
            userService.createAdmin(user);

        } catch(EntityAlreadyExistsException e){
            userService.findUserByEmail(user.getEmail());
        }

    }
}
