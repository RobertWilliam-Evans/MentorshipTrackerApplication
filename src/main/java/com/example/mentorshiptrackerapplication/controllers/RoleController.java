package com.example.mentorshiptrackerapplication.controllers;

import com.example.mentorshiptrackerapplication.dto.RoleDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.services.RoleService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class RoleController {
    private final RoleService roleService;

    @PostMapping("v1/role")
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO createRole(@Valid @RequestBody RoleDTO roleDTO){
        return roleService.createRole(roleDTO);
    }

}
