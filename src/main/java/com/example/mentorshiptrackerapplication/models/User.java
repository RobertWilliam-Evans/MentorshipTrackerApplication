package com.example.mentorshiptrackerapplication.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Matcher;


@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @Pattern(regexp = "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$")
    private String firstName;

    @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9])" +
            "{3,18}[a-zA-Z0-9]$")
    private String userName;

    @Pattern(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*" +
            "@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)" +
            "*(\\\\.[A-Za-z]{2,})$")
    private String email;

    private String password;
    @Past(message = "Birthdate should be in the past")
    private LocalDate birtDate;

    @ManyToOne
    private Role role;



    public User(){

    }

    public User(String userName, String firstName, String email, String password){
        this.userName = userName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {

            this.firstName = firstName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {

            this.userName = userName;

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirtDate() {
        return birtDate;
    }

    public void setBirtDate(LocalDate birtDate) {
        this.birtDate = birtDate;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", birtDate=" + birtDate +
                ", role=" + role +
                '}';
    }


}
