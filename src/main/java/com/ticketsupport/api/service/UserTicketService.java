package com.ticketsupport.api.service;

import com.ticketsupport.api.dto.UserTicketDTO;
import com.ticketsupport.api.model.UserTicket;

import java.util.List;

public interface UserTicketService {

    List<UserTicketDTO> findAll();

    UserTicket registerUser(UserTicket userTicket);

    UserTicket findUserTicketById(Long id);

    //UserTicket findUserTicketByEmail(String email);

    boolean existsByEmail(String email);

    UserTicketDTO findUserTicketByEmail(String email);
}
