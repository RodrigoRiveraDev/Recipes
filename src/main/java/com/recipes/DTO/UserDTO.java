package com.recipes.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private long id;
    private String fullName;
    private String email;
    private String password;

    public UserDTO() {
        this.fullName = "";
        this.email = "";
        this.password = "";
    }

    public UserDTO(long id, String fullName, String email, String password) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
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

    @Override
    public String toString() {
        return "{"+
                "\"id\" : \"" + id + "\"" +
                ",\"fullName\" : \"" + fullName + "\"" +
                ",\"email\" : \"" + email + "\""
                +"}";
    }

    public boolean hasId(int otherId) {
        return id == otherId;
    }

    public boolean hasAllParameters() {
        return  !fullName.isEmpty() &&
                !email.isEmpty() &&
                !password.isEmpty();
    }

    @Override
    public boolean equals(Object obj) {
        UserDTO other = (UserDTO)obj;
        return this.password.equals(other.password) &&
                this.email.equals(other.email) && this.fullName.equals(other.email);
    }

    public void updateInfo(UserDTO info) {
        if(!info.getEmail().isEmpty()) {
            this.email = info.getEmail();
        }
        if(!info.getFullName().isEmpty()) {
            this.fullName = info.getFullName();
        }
        if(!info.getPassword().isEmpty()) {
            this.password = info.getPassword();
        }
    }
}
