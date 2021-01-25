package com.semarslan.ticketservice.service.impl;

import com.semarslan.client.AccountServiceClient;
import com.semarslan.client.contract.AccountDto;
import com.semarslan.ticketservice.dto.TicketDto;
import com.semarslan.ticketservice.entity.PriorityType;
import com.semarslan.ticketservice.entity.Ticket;
import com.semarslan.ticketservice.entity.TicketStatus;
import com.semarslan.ticketservice.entity.es.TicketEsModel;
import com.semarslan.ticketservice.repository.TicketRepository;
import com.semarslan.ticketservice.repository.es.TicketElasticRepository;
import com.semarslan.ticketservice.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TicketServiceImpl implements TicketService {

    private final TicketElasticRepository ticketElasticRepository;
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;
    private final AccountServiceClient accountServiceClient;

    /**
     * Ticket Entity
     * Postgresql kaydet
     * TicketModel nesnesi yarat
     * elastic kaydet
     * oluşan response dön
     */
    @Override
    @Transactional
    public TicketDto save(TicketDto ticketDto) {
        /**
         * Ticket Entity
         */
        Ticket ticket = new Ticket();
        ResponseEntity<AccountDto> accountDtoResponseEntity = accountServiceClient.getById(ticketDto.getAssignee());

        if (ticketDto.getDescription() == null)
            throw new IllegalArgumentException("Description not null");

        ticket.setDescription(ticketDto.getDescription());
        ticket.setNotes(ticketDto.getNotes());
        ticket.setTicketDate(ticketDto.getTicketDate());
        ticket.setTicketStatus(TicketStatus.valueOf(ticketDto.getTicketStatus()));
        ticket.setPriorityType(PriorityType.valueOf(ticketDto.getPriorityType()));
        ticket.setAssignee(accountDtoResponseEntity.getBody().getId());

        /**
         * postgre'ye kaydet.
         */
        ticket = ticketRepository.save(ticket);

        /**
         * TicketModel nesnesi yarat.
         */
        TicketEsModel ticketEsModel = TicketEsModel.builder()
                .description(ticket.getDescription())
                .notes(ticket.getNotes())
                .id(ticket.getId())
                .assignee(accountDtoResponseEntity.getBody().getNameSurname())
                .priorityType(ticket.getPriorityType().getLabel())
                .ticketStatus(ticket.getTicketStatus().getLabel())
                .ticketDate(ticket.getTicketDate()).build();

        /**
         * elasticSearch'e kaydet
         */
        ticketElasticRepository.save(ticketEsModel);

        /**
         * Oluşan nesneyi dön.
         */
        ticketDto.setId(ticket.getId());
        return ticketDto;
    }

    @Override
    public TicketDto update(String id, TicketDto ticketDto) {
        return null;
    }

    @Override
    public TicketDto getById(String id) {
        return null;
    }

    @Override
    public Page<TicketDto> getAll(Pageable pageable) {
        return null;
    }
}
