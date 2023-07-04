package com.example.mentorshiptrackerapplication.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Past;
import java.time.LocalDate;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    private UUID id;

    @Size(min=2, message ="Name should have at least two characters")
    private String firstName;

    @Size(min=2, message ="Name should have at least two characters")
    private String userName;


    private String email;

    private String password;
    @Past(message = "Birthdate should be in the past")
    private LocalDate birtDate;

    @ManyToOne
    private Role role;



    public User(){

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
        if (validateFirstName(firstName)){
            this.firstName = firstName;
        }
        System.out.println("Error");
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        if (validateUserName(userName)){
            this.userName = userName;
        }
        System.out.println("Error");

    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (validateEmail(email)){
            this.email = email;
        }
        System.out.println("Error");
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

    public boolean validateEmail(String email){
        Pattern pattern = Pattern.compile(
                "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*" +
                        "@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)" +
                        "*(\\\\.[A-Za-z]{2,})$");
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();

    }

    public boolean validateUserName(String userName){
        Pattern pattern = Pattern.compile(
                "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9])" +
                        "{3,18}[a-zA-Z0-9]$");
        Matcher matcher = pattern.matcher(userName);
        return matcher.matches();

    }

    public boolean validateFirstName(String firstName){
        Pattern pattern = Pattern.compile(
                "(?i)(^[a-z])((?![ .,'-]$)[a-z .,'-]){0,24}$");
        Matcher matcher = pattern.matcher(firstName);
        return matcher.matches();

    }
}
