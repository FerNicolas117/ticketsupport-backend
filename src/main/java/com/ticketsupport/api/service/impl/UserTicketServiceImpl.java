package com.ticketsupport.api.service.impl;

import com.ticketsupport.api.dto.UserTicketDTO;
import com.ticketsupport.api.model.UserTicket;
import com.ticketsupport.api.repository.UserTicketRepository;
import com.ticketsupport.api.service.UserTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserTicketServiceImpl implements UserTicketService, UserDetailsService {

    @Autowired
    private UserTicketRepository userTicketRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserTicketServiceImpl(UserTicketRepository userTicketRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userTicketRepository = userTicketRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public UserTicketServiceImpl() {}

    // Listar a todos los usuarios
    @Override
    public List<UserTicketDTO> findAll() {
        return userTicketRepository.findAll().stream()
                .map(user -> new UserTicketDTO(
                        user.getId(),
                        user.getName(),
                        user.getSecretaria(),
                        user.getDireccion(),
                        user.getEmail(),
                        user.getPhoneNumber(),
                        user.getRole()))
                .collect(Collectors.toList());
    }

    // Registrar a un nuveo usuario almacenando todos sus datos
    @Override
    public UserTicket registerUser(UserTicket userTicket) {
        // Verificar si el usuario ya ha sido registrado
        if (userTicketRepository.findByEmail(userTicket.getEmail()) != null) {
            throw new RuntimeException("User Ticket already registered: " + userTicket.getEmail());
        }

        userTicket.setPassword(bCryptPasswordEncoder.encode(userTicket.getPassword()));
        System.out.println("User Ticket new registered: " + userTicket.getEmail());
        return userTicketRepository.save(userTicket);
    }

    @Override
    public UserTicket findUserTicketById(Long id) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserTicket userTicket = userTicketRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with Email: " + email));
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userTicket.getRole().getRole().toString());

        return new org.springframework.security.core.userdetails.User(
                userTicket.getEmail(),
                userTicket.getPassword(),
                Collections.singleton(authority)
        );
    }

    public boolean existsByEmail(String email) {
        return userTicketRepository.existsByEmail(email);
    }

    @Override
    public UserTicketDTO findUserTicketByEmail(String email) {
        UserTicket userTicket = userTicketRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with Email: " + email));

        return new UserTicketDTO(
                userTicket.getId(),
                userTicket.getName(),
                userTicket.getSecretaria(),
                userTicket.getDireccion(),
                userTicket.getEmail(),
                userTicket.getPhoneNumber(),
                userTicket.getRole()
        );
    }

    public void save(UserTicket userTicket) {
        userTicketRepository.save(userTicket);
    }

}
