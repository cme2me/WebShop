package com.gb.shop.controller;

import com.gb.shop.dao.entity.User;
import com.gb.shop.dao.model.enums.RoleType;
import com.gb.shop.service.RoleService;
import com.gb.shop.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;
    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }
    @PostMapping("/register")
    @Secured("USER")
    public void registerUser(@RequestParam("login") String login,
                             @RequestParam("password") String password) {
        roleService.createRole(RoleType.USER);
        userService.createUser(login, password);
    }
    @GetMapping("/get/all/users")
    @Secured("ADMIN")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok().body(userService.getAllUsers());
    }

    @PostMapping("/secret/admin")
    public void loginAsAdmin() {
        roleService.createRole(RoleType.ADMIN);
    }
}
