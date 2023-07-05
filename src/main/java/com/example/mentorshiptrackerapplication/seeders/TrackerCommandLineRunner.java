package com.example.mentorshiptrackerapplication.seeders;


import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import com.example.mentorshiptrackerapplication.models.User;
import com.example.mentorshiptrackerapplication.services.PermissionService;
import com.example.mentorshiptrackerapplication.services.RoleService;
import com.example.mentorshiptrackerapplication.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class TrackerCommandLineRunner implements CommandLineRunner {


    private final PermissionService permissionService;

    private final RoleService roleService;

    private final UserService userService;


    @Override
    public void run(String... args) throws Exception{

//       Creating permissions using the permission service
        Permission p1 = new Permission("Manage Mentorship", "Create, view, update and delete on mentorship");
        Permission p2 = new Permission("View Mentorship", "View mentorship only");
        Permission createdPermission1 = permissionService.createPermission(p1);
        Permission createdPermission2 = permissionService.createPermission(p2);

//      Creating roles using the role service
        Role r1 = new Role("Administrator", "Perform all Actions");
        Role r2 = new Role("Mentorship manager", "Perform mentorship associated CRUD actions");

        Role createdRole1 =roleService.createRole(r1);
        Role createdRole2 = roleService.createRole(r2);


//      Updating roles and permissions
        Set<Role> newRoles = new HashSet<>();
        Set<Permission> newPermissions = new HashSet<>();
//
        newRoles.add(createdRole2);


        newPermissions.add(createdPermission1);
        newPermissions.add(createdPermission2);
        roleService.setPermissions(r1, newPermissions);
        permissionService.setRoles(p1, newRoles);
        permissionService.setRoles(p2, newRoles);

//      Seeding User
        User user = new User("admin", "admin", "admin@gmail.com", "adminpassword123");
        User createdUser = userService.createUser(user);
        userService.setUserRole(createdUser, createdRole1);


    }
}
