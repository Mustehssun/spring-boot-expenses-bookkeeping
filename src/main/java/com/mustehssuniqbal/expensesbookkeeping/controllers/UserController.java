package com.mustehssuniqbal.expensesbookkeeping.controllers;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import com.mustehssuniqbal.expensesbookkeeping.dtos.UserDto;
import com.mustehssuniqbal.expensesbookkeeping.mappers.GeneralMapper;
import com.mustehssuniqbal.expensesbookkeeping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private GeneralMapper mapper;

    @PostMapping("/signup")
    public ResponseEntity<User> signup(@RequestBody UserDto userDto) {
        User user = service.signup(mapper.map(userDto, User.class));

        return ResponseEntity.ok(user);
    }
}
