package com.example.mentorshiptrackerapplication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import org.springframework.data.relational.core.sql.In;

import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String description;
    @ManyToMany
    private Set<Permission> permissions;
}
