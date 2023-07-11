package com.example.mentorshiptrackerapplication.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {

    private UUID id;

    @Size(min = 2, message = "Firstname should have at least two characters")
    private String firstName;

    @Size(min = 2, message ="Username should have at least 2 characters")
    private String userName;

    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*" +
            "@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)" +
            "*(\\\\.[A-Za-z]{2,})$")
    private String email;

    @NotNull(message ="This field is required")
    private String password;
    private RoleDTO role;

    public UserRequestDTO(String userName, String firstName, String email, String password){
        this.userName = userName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;

    }

}
