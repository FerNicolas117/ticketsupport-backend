package com.ticketsupport.api.dto;

import com.ticketsupport.api.model.ETicketStatus;

import java.time.LocalDateTime;

public class TicketListDTO {

    private Long id;
    private String title;
    private String description;
    private String typeOfService;
    private String equipment;
    private String priority;
    private LocalDateTime openingDate;
    private ETicketStatus status;

    // Constructor
    public TicketListDTO() {}

    // Constructir con argumentos
    public TicketListDTO(Long id, String title, String description, String typeOfService, String equipment,
                         String priority, LocalDateTime openingDate, ETicketStatus status) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.typeOfService = typeOfService;
        this.equipment = equipment;
        this.priority = priority;
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

    public String getTypeOfService() {
        return typeOfService;
    }

    public void setTypeOfService(String typeOfService) {
        this.typeOfService = typeOfService;
    }

    public String getEquipment() {
        return equipment;
    }

    public void setEquipment(String equipment) {
        this.equipment = equipment;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
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
