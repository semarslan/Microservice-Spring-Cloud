package com.semarslan.ticketservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TicketDto {

    private String id;
    private String description;
    private String notes;
    private String assignee; //eureka server ile account-service'e bağlanıp alacak.
    private Date ticketDate;
    private String priorityType; //api kullananların enum bilgilerine ihtiyacı yok, string dönmesi yeterli.
    private String ticketStatus;

}
