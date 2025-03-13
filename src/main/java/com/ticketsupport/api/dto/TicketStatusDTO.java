package com.ticketsupport.api.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ticketsupport.api.model.ETicketStatus;

@JsonIgnoreProperties(ignoreUnknown = false)
public class TicketStatusDTO {

    private Long id;
    private ETicketStatus status;

    // Constructor sin argumentos
    public TicketStatusDTO() {}

    // Constructor con argumentos
    public TicketStatusDTO(Long id, ETicketStatus status) {
        this.id = id;
        this.status = status;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ETicketStatus getStatus() {
        return status;
    }

    public void setStatus(ETicketStatus status) {
        this.status = status;
    }
}
