package com.ticketsupport.api.dto.ticket;

import com.ticketsupport.api.model.ETicketStatus;

import java.time.LocalDateTime;

public class TicketListForADMIN {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime openingDate;
    private ETicketStatus status;
    private Long userId;
    private String userName;
    private String userEmail;

    // Constructor sin argumentos
    public TicketListForADMIN() {}

    // Constructor con argumentos
    public TicketListForADMIN(Long id, String title, String description, LocalDateTime openingDate,
                              ETicketStatus status, Long userId, String userName, String userEmail) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.openingDate = openingDate;
        this.status = status;
        this.userId = userId;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getOpeningDate() {
        return openingDate;
    }

    public void setOpeningDate(LocalDateTime openingDate) {
        this.openingDate = openingDate;
    }

    public ETicketStatus getStatus() {
        return status;
    }

    public void setStatus(ETicketStatus status) {
        this.status = status;
    }

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
}
