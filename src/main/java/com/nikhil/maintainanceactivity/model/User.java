package com.nikhil.maintainanceactivity.model;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

@Document
@Data
public class User {
    @Id
    @Field(name = "identifier" )
    private int id;
    @Field(name = "userRoll" )
    private int roll;
    @Field(name = "userName")
    private String name;
    @Field(name ="userEmail")
    private String email;
    @Field(name = "userPass")
    private String password;
}