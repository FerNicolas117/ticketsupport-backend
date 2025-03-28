package com.ticketsupport.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
public class TicketSupportApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketSupportApplication.class, args);
	}

}
