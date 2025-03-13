package com.ticketsupport.api.dto;

import com.ticketsupport.api.model.ETicketStatus;

import java.time.LocalDateTime;

public class TicketListDTO {

    private Long id;
    private String title;
    private String description;
    private LocalDateTime openingDate;
    private ETicketStatus status;

    // Constructor
    public TicketListDTO() {}

    // Constructir con argumentos
    public TicketListDTO(Long id, String title, String description, LocalDateTime openingDate, ETicketStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.openingDate = openingDate;
        this.status = status;
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
}
