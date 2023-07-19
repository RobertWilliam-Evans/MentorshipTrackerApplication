package com.example.mentorshiptrackerapplication.dto.userDTOs;

import com.example.mentorshiptrackerapplication.models.Advisor;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdviseeDTO extends UserRequestDTO {
    @NotNull(message ="This field is required")
    @PastOrPresent(message ="Birthdate has to be in the past")
    private Date birthDate;

    @NotNull(message ="This field is required")
    private String country;

    @NotNull(message ="This field is required")
    private String city;

    @NotNull(message ="This field is required")
    private String advisorEmail;

}
