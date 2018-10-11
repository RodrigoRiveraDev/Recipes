package com.recipes.DTO;

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

    /**
     * @return It will return the fullName value
     */
    public String getFullName() {
        return fullName;
    }

    /**
     * @return It will return the email value
     */
    public String getEmail() {
        return email;
    }

    /**
     * @return It will return the password value
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return It will return the object as a String with Json format
     */
    @Override
    public String toString() {
        return "{"+
                "\"id\" : \"" + id + "\"" +
                ",\"fullName\" : \"" + fullName + "\"" +
                ",\"email\" : \"" + email + "\""
                +"}";
    }

}
