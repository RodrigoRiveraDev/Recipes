package com.recipes.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private long id;
    @NotEmpty
    private String fullName;
    @NotEmpty
    private String password;
    @NotEmpty
    private String email;

    public User() {}

    public User(String fullName, String password, String email) {
        this.fullName = fullName;
        this.password = password;
        this.email = email;
    }

    /**
     * @return It will return the current object password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password param to replace the current password value
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return It will return the current object email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email param to replace the current email value
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return It will return the current object fullName
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @param fullName param to replace the current fullName value
     */
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    /**
     * @return It will return the current object id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id param to replace the current id value
     */
    public void setId(long id) {
        this.id = id;
    }

}