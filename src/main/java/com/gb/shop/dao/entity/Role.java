package com.gb.shop.dao.entity;

import com.gb.shop.dao.model.enums.RoleType;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@NoArgsConstructor
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID id;
    private RoleType role;
    @ManyToMany(mappedBy = "role")
    private Set<User> users = new HashSet<>();
}
