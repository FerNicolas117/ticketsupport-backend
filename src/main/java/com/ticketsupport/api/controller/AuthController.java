package com.ticketsupport.api.controller;

import com.ticketsupport.api.dto.LoginResponseDTO;
import com.ticketsupport.api.dto.LoginUserDTO;
import com.ticketsupport.api.dto.NewUserTicketDTO;
import com.ticketsupport.api.dto.UserTicketDTO;
import com.ticketsupport.api.model.UserTicket;
import com.ticketsupport.api.service.AuthService;
import com.ticketsupport.api.service.UserTicketService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/auth")
public class AuthController {

    @Autowired
    private final AuthService authService;

    @Autowired
    private final UserTicketService userTicketService;

    public AuthController(AuthService authService, UserTicketService userTicketService) {
        this.authService = authService;
        this.userTicketService = userTicketService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@Valid
                                                  @RequestBody LoginUserDTO loginUserDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().build();
        }

        try {
            // Autenticar al usuario y generar el token
            String jwt = authService.authenticate(loginUserDTO.getEmail(), loginUserDTO.getPassword());

            // Obtener los datos del usuario
            UserTicketDTO userTicketDTO = userTicketService.findUserTicketByEmail(loginUserDTO.getEmail());

            // Construccion de la respuesta
            LoginResponseDTO response = new LoginResponseDTO(jwt, userTicketDTO);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new LoginResponseDTO(e.getMessage(), null));
        }
    }

    @PostMapping(path = "/register")
    public ResponseEntity<String> register(@Valid @RequestBody NewUserTicketDTO newUserTicketDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return ResponseEntity.badRequest().body("Check the camps");
        }

        try {
            authService.registerUserDTO(newUserTicketDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("User registered successfully");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping(path = "/check-auth")
    public ResponseEntity<String> checkAuth() {
        return ResponseEntity.ok().body("Authenticated! You are authorized to access this resource");
    }
}
