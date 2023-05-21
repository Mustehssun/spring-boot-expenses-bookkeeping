package com.mustehssuniqbal.expensesbookkeeping.services;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;

public interface AuthService {
    User signup(User user);
    User login(User user);
}
