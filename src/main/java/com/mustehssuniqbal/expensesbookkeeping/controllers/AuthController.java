package com.mustehssuniqbal.expensesbookkeeping.controllers;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import com.mustehssuniqbal.expensesbookkeeping.dtos.UserDto;
import com.mustehssuniqbal.expensesbookkeeping.mappers.GeneralMapper;
import com.mustehssuniqbal.expensesbookkeeping.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService service;

    @Resource(name = "generalMapper")
    private GeneralMapper mapper;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserDto userDto) {
        User user = service.signup(mapper.map(userDto, User.class));

        return ResponseEntity.ok(user);
    }

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody UserDto userdto) {
        User user = service.login(mapper.map(userdto, User.class));

        return ResponseEntity.ok(user);
    }

    @PostMapping("/validateToken")
    public ResponseEntity<Boolean> validateToken() {
        return ResponseEntity.ok().build(); //validation of token is already done in interceptors. So if flow reaches, it's already validated.
    }
}
