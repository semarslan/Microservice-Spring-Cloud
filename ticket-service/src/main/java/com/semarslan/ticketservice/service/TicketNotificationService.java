package com.semarslan.ticketservice.service;

import com.semarslan.ticketservice.entity.Ticket;

public interface TicketNotificationService {

    void sendToQueue(Ticket ticket);
}
