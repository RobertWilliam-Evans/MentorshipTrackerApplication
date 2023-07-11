package com.example.mentorshiptrackerapplication.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleDTO {

    private UUID id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
    private Set<PermissionDTO> permissions;

    public RoleDTO(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
