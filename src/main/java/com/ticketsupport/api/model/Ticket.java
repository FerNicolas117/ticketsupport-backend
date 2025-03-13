package com.ticketsupport.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "title", nullable = false)
    private String title;

    @NotBlank
    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "opening_date", updatable = false)
    private LocalDateTime openingDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private ETicketStatus status = ETicketStatus.NOT_STARTED;

    // Relacion con UserTicket
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserTicket userTicket;

    // Constructur con arguments
    public Ticket(Long id, String title, String description, LocalDateTime openingDate) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.openingDate = openingDate;
        this.status = ETicketStatus.NOT_STARTED;
    }

    // Constructor sin argumentos
    public Ticket() {}

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

    public UserTicket getUserTicket() {
        return userTicket;
    }

    public void setUserTicket(UserTicket userTicket) {
        this.userTicket = userTicket;
    }

    public ETicketStatus getStatus() {
        return status;
    }

    public void setStatus(ETicketStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", openingDate=" + openingDate +
                ", userTicket=" + userTicket.getEmail() +
                '}';
    }

    @PrePersist
    protected void onCreate() {
        this.openingDate = LocalDateTime.now(ZoneId.of("America/Mexico_City"));
        if (this.status == null) {
            this.status = ETicketStatus.NOT_STARTED;
        }
    }
}
