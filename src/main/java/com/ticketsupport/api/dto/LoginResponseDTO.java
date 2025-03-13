package com.ticketsupport.api.dto;

public class LoginResponseDTO {

    private String token;
    private UserTicketDTO userTicketDTO;

    // Constructir sin argumentos
    public LoginResponseDTO() {}

    // Constructor con argumentos
    public LoginResponseDTO(String token, UserTicketDTO userTicketDTO) {
        this.token = token;
        this.userTicketDTO = userTicketDTO;
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserTicketDTO getUserTicketDTO() {
        return userTicketDTO;
    }

    public void setUserTicketDTO(UserTicketDTO userTicketDTO) {
        this.userTicketDTO = userTicketDTO;
    }
}
