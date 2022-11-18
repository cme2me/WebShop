package com.gb.shop.security;

import com.gb.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userService.getUserByLogin(username)
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
        List<GrantedAuthority> authorities = user.getRoles().stream().map(it -> new SimpleGrantedAuthority(it.getRole().toString())).collect(Collectors.toList());
        return new User(user.getLogin(), user.getPassword(),authorities);
    }
}
