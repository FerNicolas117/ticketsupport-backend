package com.ticketsupport.api.service;

import com.ticketsupport.api.dto.NewUserTicketDTO;
import com.ticketsupport.api.model.ERole;
import com.ticketsupport.api.model.Role;
import com.ticketsupport.api.model.UserTicket;
import com.ticketsupport.api.repository.RoleRepository;
import com.ticketsupport.api.security.jwt.JwtUtil;
import com.ticketsupport.api.service.impl.UserTicketServiceImpl;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserTicketServiceImpl userTicketService;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final UserTicketServiceImpl userTicketServiceImpl;

    public AuthService(UserTicketServiceImpl userTicketService,
                       RoleRepository roleRepository,
                       BCryptPasswordEncoder bCryptPasswordEncoder,
                       JwtUtil jwtUtil,
                       AuthenticationManagerBuilder authenticationManagerBuilder, UserTicketServiceImpl userTicketServiceImpl) {
        this.userTicketService = userTicketService;
        this.roleRepository = roleRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.userTicketServiceImpl = userTicketServiceImpl;
    }

    public String authenticate(String username, String password) {
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authResult = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authResult);
        return jwtUtil.generateToken(authResult);
    }

    public void registerUserDTO(NewUserTicketDTO newUserTicketDTO) {
        if (userTicketService.existsByEmail(newUserTicketDTO.getEmail())) {
            throw new IllegalArgumentException("Email address already in use/exists");
        }

        Role roleUser = roleRepository.findByName(ERole.USER).orElseThrow(() ->
                new RuntimeException("Role not found"));
        UserTicket userTicket = new UserTicket(
                newUserTicketDTO.getEmail(),
                bCryptPasswordEncoder.encode(newUserTicketDTO.getPassword()),
                roleUser);
        userTicket.setName(newUserTicketDTO.getName());
        userTicket.setSecretaria(newUserTicketDTO.getSecretaria());
        userTicket.setDireccion(newUserTicketDTO.getDireccion());
        userTicket.setPhoneNumber(newUserTicketDTO.getPhoneNumber());
        userTicketServiceImpl.save(userTicket);
    }
}
