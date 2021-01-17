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

    @NonNull
    @PrimaryKey
    private String id = UUID.randomUUID().toString();

    @Setter
    @Column(value = "username")
    private String username;

    @Setter
    @Column(value = "email")
    private String email;

    @Setter
    @Column(value = "passwd")
    private String passwd;

    @Column(value = "createdAT")
    private Date createdAt;

    @Column(value = "isActive")
    private Boolean isActive;
}
