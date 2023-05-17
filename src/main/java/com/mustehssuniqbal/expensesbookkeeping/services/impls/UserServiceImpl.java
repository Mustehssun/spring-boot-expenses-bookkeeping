package com.mustehssuniqbal.expensesbookkeeping.services.impls;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import com.mustehssuniqbal.expensesbookkeeping.repositories.UserRepository;
import com.mustehssuniqbal.expensesbookkeeping.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository repository;

    @Override
    public User signup(User user) {
        Optional<User> existingUser = repository.findByUsername(user.getUsername());
        if(existingUser.isPresent()) {
            throw new RuntimeException("User already exists.");
        }
        return repository.save(user);
    }
}
