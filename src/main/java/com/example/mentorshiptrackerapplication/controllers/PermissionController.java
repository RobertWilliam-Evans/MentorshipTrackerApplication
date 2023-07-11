package com.example.mentorshiptrackerapplication.controllers;

import com.example.mentorshiptrackerapplication.dto.PermissionDTO;
import com.example.mentorshiptrackerapplication.exceptions.EntityAlreadyExistsException;
import com.example.mentorshiptrackerapplication.services.PermissionService;
import com.example.mentorshiptrackerapplication.services.PermissionServiceImpl;
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
public class PermissionController {
    private final PermissionService permissionService;

    @PostMapping("v1/permission")
    public ResponseEntity<PermissionDTO> createPermission(@Valid @RequestBody PermissionDTO permissionDTO) throws EntityAlreadyExistsException {

        PermissionDTO savedPermission = permissionService.createPermission(permissionDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPermission);
    }


}
