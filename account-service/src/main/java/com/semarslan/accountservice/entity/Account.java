package com.semarslan.accountservice.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = {"id"})
@ToString
@Table(value = "accounts")
public class Account implements Serializable {

    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Setter
    @Column(value = "username")
    private String username;

    @Setter
    @Column(value = "name")
    private String name;

    @Setter
    @Column(value = "surname")
    private String surname;

    @Setter
    @Column(value = "email")
    private String email;

    @Setter
    @Column(value = "birthDate")
    private Date birthDate;

    @Setter
    @Column(value = "passwd")
    private String passwd;

    @Column(value = "createdAt")
    private Date createdAt;

    @Column(value = "isActive")
    private Boolean isActive;
}
