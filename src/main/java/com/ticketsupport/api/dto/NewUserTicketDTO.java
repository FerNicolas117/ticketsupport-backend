package com.ticketsupport.api.dto;

public class NewUserTicketDTO {

    public String name;
    public String secretaria;
    public String direccion;
    public String email;
    public String phoneNumber;
    public String password;

    // Constructor
    public NewUserTicketDTO() {}

    public NewUserTicketDTO(String name, String secretaria, String direccion, String email, String phoneNumber, String password) {
        this.name = name;
        this.secretaria = secretaria;
        this.direccion = direccion;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
    }

    // Getters y Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecretaria() {
        return secretaria;
    }

    public void setSecretaria(String secretaria) {
        this.secretaria = secretaria;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
