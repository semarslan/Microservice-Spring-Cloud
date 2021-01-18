package com.semarslan.ticketservice.service.impl;

import com.semarslan.ticketservice.dto.TicketDto;
import com.semarslan.ticketservice.service.TicketService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService {


    @Override
    public TicketDto save(TicketDto ticketDto) {
        return null;
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
