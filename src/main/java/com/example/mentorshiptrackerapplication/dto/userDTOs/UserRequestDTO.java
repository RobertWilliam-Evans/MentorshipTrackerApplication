package com.example.mentorshiptrackerapplication.dto.userDTOs;

import com.example.mentorshiptrackerapplication.dto.RoleDTO;
import jakarta.validation.constraints.NotBlank;
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
    @NotNull(message = "field is required")
    private String firstName;

//    @Size(min = 2, message ="Username should have at least 2 characters")
//    @NotNull(message = "field is required")
    private String userName;

    @Pattern(regexp = "^(.+)@(.+)$")
    @NotBlank(message = "field is required")
    private String email;

    @NotBlank(message ="This field is required")
    private String password;
    private RoleDTO role;

    public UserRequestDTO(@NotNull String userName, @NotNull String firstName, String email, @NotNull String password){
        this.userName = userName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;

    }

    public UserRequestDTO(@NotNull String userName, @NotNull String firstName, String email, @NotNull String password, RoleDTO role){
        this.userName = userName;
        this.firstName = firstName;
        this.email = email;
        this.role = role;
        this.password = password;

    }

}
