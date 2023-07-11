package com.example.mentorshiptrackerapplication.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.validation.constraints.*;
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

    @NotBlank(message = "field is required")
    @NotEmpty
    @NotNull
    private String name;

    @NotBlank(message = "field is required")
    private String description;
    private Set<PermissionDTO> permissions;

    public RoleDTO(@NotNull String name, @NotNull String description) {
        this.name = name;
        this.description = description;
    }
}
