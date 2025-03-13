package com.ticketsupport.api.service;

import com.ticketsupport.api.dto.TicketListDTO;
import com.ticketsupport.api.model.ETicketStatus;
import com.ticketsupport.api.model.Ticket;

import java.util.List;

public interface TicketService {

    Ticket saveTicket(Ticket ticket, Long userId);

    Ticket updateTicketStatus(Long ticketId, ETicketStatus status, Long userId);

    List<TicketListDTO> getTicketsByUserId(Long userId);
}
