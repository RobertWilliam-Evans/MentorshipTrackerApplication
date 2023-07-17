package com.example.mentorshiptrackerapplication.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;


@Entity
@Data
@Table(name = "Advisor")
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@PrimaryKeyJoinColumn(name = "user_id")
public class Advisor extends User{

    @Column(name = "country")
    private String country;
    @Column(name = "city")
    private String city;
    @Column(name = "birth_date")
    private Date birthDate;

    @OneToMany(mappedBy = "advisor")
    private Set<Advisee> adviseeList;

}
