package com.ticketsupport.api.dto.ticket;

import com.ticketsupport.api.dto.TicketListDTO;

import java.util.List;

public class TicketsForUserDTO {

    private Long userId;
    private String userName;
    private String userEmail;
    private String userPhone;
    private String userSecretary;
    private String userDirecction;
    private List<TicketListDTO> ticketList;

    // Constructor sin argumentos
    public TicketsForUserDTO() {}

    // Constructor con argumentos
    public TicketsForUserDTO(Long userId, String userName, String userEmail, String userPhone,
                             String userSecretary, String userDirecction, List<TicketListDTO> ticketList) {
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPhone = userPhone;
        this.userSecretary = userSecretary;
        this.userDirecction = userDirecction;
        this.ticketList = ticketList;
    }

    // Getters y Setters
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserSecretary() {
        return userSecretary;
    }

    public void setUserSecretary(String userSecretary) {
        this.userSecretary = userSecretary;
    }

    public String getUserDirecction() {
        return userDirecction;
    }

    public void setUserDirecction(String userDirecction) {
        this.userDirecction = userDirecction;
    }

    public List<TicketListDTO> getTicketList() {
        return ticketList;
    }

    public void setTicketList(List<TicketListDTO> ticketList) {
        this.ticketList = ticketList;
    }
}
