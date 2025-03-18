package com.ticketsupport.api.service.impl;

import com.ticketsupport.api.dto.TicketListDTO;
import com.ticketsupport.api.dto.ticket.TicketListForADMIN;
import com.ticketsupport.api.dto.ticket.TicketsForUserDTO;
import com.ticketsupport.api.exception.ResourceNotFoundException;
import com.ticketsupport.api.model.ETicketStatus;
import com.ticketsupport.api.model.Ticket;
import com.ticketsupport.api.model.UserTicket;
import com.ticketsupport.api.repository.TicketRespository;
import com.ticketsupport.api.repository.UserTicketRepository;
import com.ticketsupport.api.service.TicketService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketRespository ticketRespository;

    @Autowired
    private UserTicketRepository userTicketRepository;

    @Override
    @Transactional
    public Ticket saveTicket(Ticket ticket, Long userId) {

        // Buscar el usuario por su ID
        UserTicket userTicket = userTicketRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID:" + userId));

        // Establecer la relacion con el ticket y el usuario
        ticket.setUserTicket(userTicket);

        // Guardar el ticket
        return ticketRespository.save(ticket);
    }

    @Override
    @Transactional
    public Ticket updateTicketStatus(Long ticketId, ETicketStatus status, Long userId) {
        // Buscar el usuario por su ID
        UserTicket userTicket = userTicketRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID:" + userId));

        // Recuperar el ticket existente por su ID
        Ticket existingTicket = ticketRespository.findById(ticketId)
                .orElseThrow(() -> new ResourceNotFoundException("Ticket not found with ID:" + ticketId));

        // Verificar que el ticket pertenece al usuario
        if (!existingTicket.getUserTicket().getId().equals(userTicket.getId())) {
            throw new ResourceNotFoundException("The Ticket not is equal with the UserTicket: " + userId);
        }

        // Actualizar unicamente el status del ticket
        existingTicket.setStatus(status);

        // Guardar y retornar el ticket actualizado
        return ticketRespository.save(existingTicket);
    }

    @Override
    public List<TicketListDTO> getTicketsByUserId(Long userId) {
        return ticketRespository.findByUserId(userId);
    }

    @Override
    public List<TicketsForUserDTO> getAllTicketsGroupByUser() {
        List<Ticket> tickets = ticketRespository.findAll();

        Map<UserTicket, List<Ticket>> groupedByUser = tickets.stream()
                        .collect(Collectors.groupingBy(Ticket::getUserTicket));

        // Convertir a una lista de DTO
        return groupedByUser.entrySet().stream()
                .map(entry -> new TicketsForUserDTO(
                        entry.getKey().getId(),
                        entry.getKey().getName(),
                        entry.getKey().getEmail(),
                        entry.getKey().getPhoneNumber(),
                        entry.getKey().getSecretaria(),
                        entry.getKey().getDireccion(),
                        entry.getValue().stream()
                                .map(ticket -> new TicketListDTO(
                                        ticket.getId(),
                                        ticket.getTitle(),
                                        ticket.getDescription(),
                                        ticket.getTypeOfService(),
                                        ticket.getEquipment(),
                                        ticket.getPriority(),
                                        ticket.getOpeningDate(),
                                        ticket.getStatus()
                                ))
                                .collect(Collectors.toList())
                ))
                .collect(Collectors.toList());
    }


}
