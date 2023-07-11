package com.example.mentorshiptrackerapplication.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    private UUID id;
    private String firstName;
    private String userName;
    private String email;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private RoleDTO role;

    public UserDTO(String userName, String firstName, String email, String password){
        this.userName = userName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;

    }

}
