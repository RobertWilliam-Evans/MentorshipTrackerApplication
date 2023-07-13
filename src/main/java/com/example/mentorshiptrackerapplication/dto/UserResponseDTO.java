package com.example.mentorshiptrackerapplication.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {

    private UUID id;
    private String firstName;

    private String userName;


    private String email;

    private RoleDTO role;


}
