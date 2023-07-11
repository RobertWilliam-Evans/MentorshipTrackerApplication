package com.example.mentorshiptrackerapplication.controllers;

import com.example.mentorshiptrackerapplication.dto.PermissionDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.services.PermissionService;
import com.example.mentorshiptrackerapplication.services.PermissionServiceImpl;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("api/")
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping("v1/permission")
    @ResponseStatus(HttpStatus.CREATED)
    public PermissionDTO createPermission(@Valid @RequestBody PermissionDTO permissionDTO){
        return permissionService.createPermission(permissionDTO);
    }


}
