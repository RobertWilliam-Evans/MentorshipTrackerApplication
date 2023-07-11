package com.example.mentorshiptrackerapplication.controllers;

import com.example.mentorshiptrackerapplication.dto.RoleDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.services.RoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class RoleController {
    private final RoleService roleService;

    @PostMapping("v1/role")
    public ResponseEntity<RoleDTO> createRole(@Valid @RequestBody RoleDTO roleDTO) throws EntityAlreadyExistsException {

        RoleDTO savedRole = roleService.createRole(roleDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedRole);
    }

}
