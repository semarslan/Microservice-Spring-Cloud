package com.semarslan.ticketservice.entity;

import lombok.Getter;

@Getter
public enum TicketStatus {
    OPEN("Open"),
    IN_PROGRESS("In Progress"),
    RESOLVED("Resolved"),
    CLOSED("Closed");


    private String label;

    TicketStatus(String label) {
        this.label = label;
    }
}
