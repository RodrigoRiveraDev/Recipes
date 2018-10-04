package com.recipes.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String fullName;
    private String password;
    private String email;

    public User(String fullName, String password, String email) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
    }

}