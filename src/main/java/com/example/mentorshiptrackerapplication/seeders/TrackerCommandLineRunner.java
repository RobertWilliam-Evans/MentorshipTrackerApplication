package com.example.mentorshiptrackerapplication.seeders;


import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import com.example.mentorshiptrackerapplication.services.PermissionServiceImpl;
import com.example.mentorshiptrackerapplication.services.RoleServiceImpl;
import com.example.mentorshiptrackerapplication.services.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TrackerCommandLineRunner implements CommandLineRunner {


    private final PermissionServiceImpl permissionServiceImpl;

    private final RoleServiceImpl roleServiceImpl;

    private final UserServiceImpl userServiceImpl;


    @Override
    public void run(String... args) throws Exception{

//       Creating permissions using the permission service
        Permission p1 = new Permission("Manage Mentorship", "Create, view, update and delete on mentorship");
        Permission p2 = new Permission("View Mentorship", "View mentorship only");
        Permission createdPermission1;
        Permission createdPermission2;

        try {
             createdPermission1 = permissionServiceImpl.createPermission(p1);

        } catch(EntityAlreadyExistsException e){
             createdPermission1 = permissionServiceImpl.findPermission(p1);
        }

        try {
            createdPermission2 = permissionServiceImpl.createPermission(p2);

        } catch(EntityAlreadyExistsException e){
            createdPermission2 = permissionServiceImpl.findPermission(p2);
        }


//      Creating roles using the role service
        Role r1 = new Role("Administrator", "Perform all Actions");
        Role r2 = new Role("Mentorship manager", "Perform mentorship associated CRUD actions");

        Role createdRole1;
        Role createdRole2;

        try {
            createdRole1 = roleServiceImpl.createRole(r1);

        } catch(EntityAlreadyExistsException e){
            createdRole1 = roleServiceImpl.findRole(r1);
        }

        try {
            createdRole2 = roleServiceImpl.createRole(r2);

        } catch(EntityAlreadyExistsException e){
            createdRole2 = roleServiceImpl.findRole(r2);
        }


//      Updating roles and permissions
        Set<Role> newRoles = new HashSet<>();
        Set<Permission> newPermissions = new HashSet<>();
//
        newRoles.add(createdRole2);


        newPermissions.add(createdPermission1);
        newPermissions.add(createdPermission2);
        roleServiceImpl.setPermissions(r1, newPermissions);
        permissionServiceImpl.setRoles(p1, newRoles);
        permissionServiceImpl.setRoles(p2, newRoles);



//      Seeding User
        User user = new User("admin", "admin", "admin@gmail.com", "adminpassword123");
        User createdUser;

        try {
            createdUser = userServiceImpl.createUser(user);

        } catch(EntityAlreadyExistsException e){
            createdUser = userServiceImpl.findUserByEmail(user.getEmail());
        }
        userServiceImpl.setUserRole(createdUser, createdRole1);


    }
}
