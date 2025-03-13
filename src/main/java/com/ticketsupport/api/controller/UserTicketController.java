package com.ticketsupport.api.controller;

import com.ticketsupport.api.model.UserTicket;
import com.ticketsupport.api.service.UserTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/userstickets")
public class UserTicketController {

    @Autowired
    private UserTicketService userTicketService;

    // Regiistrar a un usuario
    @PostMapping(path = "/registerUserTicket")
    public ResponseEntity<UserTicket> registerUserTicket(@RequestBody UserTicket userTicket) {
        System.out.println("UserTicketController registerUserTicket");
        UserTicket userTicketRegistered = userTicketService.registerUser(userTicket);
        return ResponseEntity.status(HttpStatus.CREATED).body(userTicketRegistered);
    }

    // Listar a todos los usuarios
    @GetMapping(path = "/getAllUsersTickets")
    public ResponseEntity<?> getAllUsersTickets() {
        return ResponseEntity.ok(userTicketService.findAll());
    }


}
