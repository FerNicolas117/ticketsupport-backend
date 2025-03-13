package com.ticketsupport.api.controller;

import com.ticketsupport.api.dto.TicketListDTO;
import com.ticketsupport.api.dto.TicketStatusDTO;
import com.ticketsupport.api.model.Ticket;
import com.ticketsupport.api.service.TicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/tickets")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    // Registrar un ticket
    @PostMapping(path = "/create/{userId}")
    public ResponseEntity<String> createTicket(@PathVariable Long userId,
                                               @Valid @RequestBody Ticket ticket) {
        Ticket savedTicket = ticketService.saveTicket(ticket, userId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Ticket created successfully: " + savedTicket.toString());
    }

    // Listar todos los tickets por usuario
    @GetMapping(path = "/get-all/{userId}")
    public List<TicketListDTO> getTicketByUserId(@PathVariable Long userId) {
        return ticketService.getTicketsByUserId(userId);
    }

    // Actualizar unicamente el status del ticket (USER_STAFF)
    @PatchMapping(path = "/update-status/{userId}")
    public ResponseEntity<String> updateTicketStatus(@PathVariable Long userId,
                                                     @Valid @RequestBody TicketStatusDTO ticketStatusDTO) {
        Ticket updatedTicket = ticketService.updateTicketStatus(
                ticketStatusDTO.getId(),
                ticketStatusDTO.getStatus(),
                userId);
        return ResponseEntity.status(HttpStatus.OK).body("Ticket Status updated Succesfully: " +
                updatedTicket.getUserTicket() + " " + updatedTicket.getStatus());
    }
}
