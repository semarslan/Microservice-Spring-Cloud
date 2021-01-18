package com.semarslan.ticketservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TicketConfiguration {

    @Bean //dependency inj ile her yerde kullanmak için.
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
