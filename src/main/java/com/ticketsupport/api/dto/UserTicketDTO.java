package com.ticketsupport.api.dto;

import com.ticketsupport.api.model.Role;

public class UserTicketDTO {

    private Long id;
    private String name;
    private String secretaria;
    private String direccion;
    private String email;
    private String phoneNumber;
    private Role role;

    // Constructor
    public UserTicketDTO() {}

    // Metodos Constructores
    public UserTicketDTO(Long id, String name, String secretaria, String direccion, String email, String phoneNumber, Role role) {
        this.id = id;
        this.name = name;
        this.secretaria = secretaria;
        this.direccion = direccion;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.role = role;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
