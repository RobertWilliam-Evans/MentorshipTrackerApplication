package com.example.mentorshiptrackerapplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;


@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Advisee")
@PrimaryKeyJoinColumn(name = "user_id")
public class Advisee extends User {

    @Column(name= "birth_date")
    private Date birthDate;

    @Column(name = "country")
    private String country;

    @Column(name ="city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "advisor_id")
    private Advisor advisor;
}
