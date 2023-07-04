package com.example.mentorshiptrackerapplication;

import com.example.mentorshiptrackerapplication.jpa.PermissionRepository;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.jpa.UserRepository;
import com.example.mentorshiptrackerapplication.models.Permission;
import com.example.mentorshiptrackerapplication.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class TrackerCommandLineRunner implements CommandLineRunner {

    @Autowired
    private PermissionRepository permissionRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private UserRepository userRepository;



    @Override
    public void run(String... args) throws Exception{

        Permission p1 = new Permission("Manage Mentorship", "Create, view, update and delete on mentorship");
        Permission p2 = new Permission("View Mentorship", "View mentorship only");
        permissionRepository.save(p1);
        permissionRepository.save(p2);


        Role r1 = new Role("Administrator", "Perform all Actions");
        Role r2 = new Role("Mentorship manager", "Perform mentorship associated CRUD actions");
        roleRepository.save(r1);
        roleRepository.save(r2);

        Set<Role> newRoles = new HashSet<>();
        Set<Permission> newPermissions = new HashSet<>();
        newRoles.add(r2);

        newPermissions.add(p1);
        newPermissions.add(p2);

        r1.setPermissions(newPermissions);

        p1.setRoles(newRoles);
        p2.setRoles(newRoles);


        System.out.println(permissionRepository.findByName("Manage Mentorship"));
        System.out.println(roleRepository.findByName("Administrator"));












    }
}
