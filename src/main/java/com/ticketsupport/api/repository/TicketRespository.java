package com.ticketsupport.api.repository;

import com.ticketsupport.api.dto.TicketListDTO;
import com.ticketsupport.api.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRespository extends JpaRepository<Ticket, Long> {

    @Query("SELECT new com.ticketsupport.api.dto.TicketListDTO(" +
            "t.id, t.title, t.description, t.typeOfService, t.equipment, t.priority, t.openingDate, " +
            "t.status, t.supportStaffTicket.id, u.name) " +
            "FROM Ticket t " +
            "LEFT JOIN t.supportStaffTicket u " +
            "WHERE t.userTicket.id = :user_id")
    List<TicketListDTO> findByUserId(@Param("user_id") Long userId);
}
