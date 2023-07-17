package com.example.mentorshiptrackerapplication.dto.userDTOs;

import com.example.mentorshiptrackerapplication.models.Advisor;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdvisorDTO extends UserRequestDTO {
    @NotNull(message ="This field is required")
    @PastOrPresent(message ="Birthdate has to be in the past")
    private Date birthDate;

    @NotBlank
    private String country;

    @NotBlank
    private String city;

    private Set<AdviseeDTO> adviseeList;
}
