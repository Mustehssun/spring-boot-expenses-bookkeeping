package com.mustehssuniqbal.expensesbookkeeping.controllers;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import com.mustehssuniqbal.expensesbookkeeping.dtos.UserDto;
import com.mustehssuniqbal.expensesbookkeeping.mappers.GeneralMapper;
import com.mustehssuniqbal.expensesbookkeeping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService service;

    @Autowired
    private GeneralMapper mapper;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return ResponseEntity.of(service.getUser(id));
    }

    @PostMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody UserDto user) {
        User updatedUser = service.updateUser(id, mapper.map(user, User.class));

        return ResponseEntity.ok(updatedUser);
    }
}
