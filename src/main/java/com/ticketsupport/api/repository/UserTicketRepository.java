package com.ticketsupport.api.repository;

import com.ticketsupport.api.model.UserTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserTicketRepository extends JpaRepository<UserTicket, Long> {

    // Buscar usuarios por su email
    Optional<UserTicket> findByName(String name); // Optional porque puede devolver un User o un null

    Optional<UserTicket> findByEmail(String email);

    boolean existsByEmail(String email);
}
