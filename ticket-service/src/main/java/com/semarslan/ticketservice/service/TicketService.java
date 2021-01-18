package com.semarslan.ticketservice.service;

import com.semarslan.ticketservice.dto.TicketDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface TicketService {

    TicketDto save(TicketDto ticketDto);

    TicketDto update(String id, TicketDto ticketDto);

    TicketDto getById(String id);

    Page<TicketDto> getAll(Pageable pageable);
}
