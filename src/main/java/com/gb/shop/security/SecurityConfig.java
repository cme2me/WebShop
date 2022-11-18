package com.gb.shop.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
    @Bean
    public SecurityFilterChain configureSecurityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .authorizeRequests()
                .antMatchers("/findAll").hasAnyRole("ADMIN", "USER", "MANAGER")
                .antMatchers("/get/basket/products").hasAnyRole("ADMIN", "USER", "MANAGER")
                .antMatchers("/save/to/basket/{id}").hasAnyRole("ADMIN", "USER", "MANAGER")
                .antMatchers("/delete/{id}").hasRole("MANAGER")
                .antMatchers("/update").hasRole("MANAGER")
                .antMatchers("/save").hasRole("MANAGER")
                .and()
                .formLogin()
                .and()
                .build();
    }
}
