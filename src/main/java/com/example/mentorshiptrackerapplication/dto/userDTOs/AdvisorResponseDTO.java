package com.example.mentorshiptrackerapplication.dto.userDTOs;

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
public class AdvisorResponseDTO extends UserResponseDTO{
    private Date birthDate;
    private String country;
    private String city;
    private Set<AdviseeDTO> adviseeList;
}
