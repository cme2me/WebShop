package com.gb.shop.service;

import com.gb.shop.dao.UserRepository;
import com.gb.shop.dao.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void createUser(String login, String password) {
        User user = new User();
        user.setId(UUID.randomUUID());
        user.setLogin(login);
        user.setPassword(password);
        repository.save(user);
    }
    public Optional<User> getUserByLogin(String login) {
        return repository.findByLogin(login);
    }
    //fixme сделать dto для юзеров
    public List<User> getAllUsers() {
        return repository.findAll();
    }
}
