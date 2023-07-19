package com.example.mentorshiptrackerapplication.dto.userDTOs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import java.util.Date;
import java.util.Set;
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdviseeResponseDTO extends UserResponseDTO{
    private Date birthDate;
    private String country;
    private String city;

    @JsonBackReference
    private AdvisorResponseDTO advisor;
}
