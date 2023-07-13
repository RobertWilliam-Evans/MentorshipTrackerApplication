package com.example.mentorshiptrackerapplication.exceptions;

public class EntityAlreadyExistsException extends RuntimeException{
    public EntityAlreadyExistsException(String str){
        super(str);
    }

}
