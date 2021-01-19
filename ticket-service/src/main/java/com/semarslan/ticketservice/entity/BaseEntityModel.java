package com.semarslan.ticketservice.entity;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

@MappedSuperclass //pek çok tabloda kalıtım yoluyla her tabloya dahil emeyi sağlar
public abstract class BaseEntityModel implements Serializable {

    @CreatedDate
    @Column(name = "createdAt")
    private Date createdAt;

    @Column(name = "updatedAt")
    private Date updatedAt;
}
