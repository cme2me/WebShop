package com.gb.shop.dao.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
public class User {
    @Id
    @GeneratedValue
    private UUID id;
    private String login;
    private String password;
    @ManyToMany
    @JoinColumn
    private Set<Role> roles;
}
