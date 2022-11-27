package com.gb.shop.service;

import com.gb.shop.dao.RoleRepository;
import com.gb.shop.dao.entity.Role;
import com.gb.shop.dao.model.enums.RoleType;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RoleService {
    private final RoleRepository repository;

    public RoleService(RoleRepository repository) {
        this.repository = repository;
    }

    public void createRole(RoleType type) {
        Role role = new Role();
        role.setId(UUID.randomUUID());
        role.setRole(type);
        repository.save(role);
    }
}
