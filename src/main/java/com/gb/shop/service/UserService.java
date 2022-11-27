package com.gb.shop.service;

import com.gb.shop.dao.UserRepository;
import com.gb.shop.dao.entity.Role;
import com.gb.shop.dao.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> getUserByLogin(String login) {
        return repository.findByLogin(login);
    }
    //fixme сделать dto для юзеров
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        org.springframework.security.core.userdetails.User user = getUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Not found " + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), user.getAuthorities());
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorize(Collection<Role> roles) {
        return roles.stream().map(role ->  new SimpleGrantedAuthority(role.getRole().getName())).collect(Collectors.toList());
    }
}
