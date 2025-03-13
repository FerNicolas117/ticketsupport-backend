package com.ticketsupport.api.dto;

public class LoginUserDTO {

    // username = email
    public String email;
    public String password;

    // Constructor
    public LoginUserDTO() {}

    public LoginUserDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    // Getters y Setters
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
}
