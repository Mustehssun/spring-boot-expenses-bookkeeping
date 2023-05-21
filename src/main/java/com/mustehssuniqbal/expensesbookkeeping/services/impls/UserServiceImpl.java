package com.mustehssuniqbal.expensesbookkeeping.services.impls;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import com.mustehssuniqbal.expensesbookkeeping.repositories.UserRepository;
import com.mustehssuniqbal.expensesbookkeeping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public User signup(User user) {
        Optional<User> existingUser = repository.findByUsername(user.getUsername());
        if(existingUser.isPresent()) {
            throw new RuntimeException("User already exists.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        return repository.save(user);
    }
}
