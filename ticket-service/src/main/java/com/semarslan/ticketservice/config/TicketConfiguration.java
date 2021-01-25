package com.semarslan.ticketservice.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.semarslan")
@EnableElasticsearchRepositories
@ComponentScan("com.semarslan")
public class TicketConfiguration {

    @Bean //dependency inj ile her yerde kullanmak için.
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
