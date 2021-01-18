package com.semarslan.ticketservice.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tickets")
@EqualsAndHashCode(of= {"id"})
@NoArgsConstructor
@AllArgsConstructor
public class Ticket extends BaseEntityModel{

    @Id
    @Getter
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "id")
    private String id;

    @Getter
    @Setter
    @Column(name = "description", length = 600)
    private String description;

    @Getter
    @Setter
    @Column(name = "notes", length = 4000)
    private String notes;

    @Getter
    @Setter
    @Column(name = "assignee", length = 50)
    private String assignee; //eureka server ile account-service'e bağlanıp alacak.

    @Getter
    @Setter
    @Column(name = "ticketDate")
    private Date ticketDate;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL) //for enum type -- ordinal sıralama 0,1,2 şeklinde tutulur.
    @Column(name = "priorityType")
    private PriorityType priorityType;

    @Getter
    @Setter
    @Enumerated(EnumType.ORDINAL) //for enum type
    @Column(name = "ticketStatus", length = 50)
    private TicketStatus ticketStatus;

}
