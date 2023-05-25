package com.mustehssuniqbal.expensesbookkeeping.services;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;

import java.util.Optional;

public interface UserService {
    Optional<User> getUser(Long id);
    User updateUser(Long id, User user);
}
