package com.example.mentorshiptrackerapplication.controllers;

import com.example.mentorshiptrackerapplication.dto.RoleDTO;
import com.example.mentorshiptrackerapplication.dto.UserDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.jpa.RoleRepository;
import com.example.mentorshiptrackerapplication.services.RoleService;
import com.example.mentorshiptrackerapplication.services.RoleServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping("api/role")
    public ResponseEntity<RoleDTO> createRole(@Valid @RequestBody RoleDTO roleDTO) throws EntityAlreadyExistsException {

        RoleDTO savedRole = roleService.createRole(roleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

}
