package com.mustehssuniqbal.expensesbookkeeping.services.impls;

import com.mustehssuniqbal.expensesbookkeeping.domain.User;
import com.mustehssuniqbal.expensesbookkeeping.repositories.UserRepository;
import com.mustehssuniqbal.expensesbookkeeping.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {
    @Autowired
    private UserRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public User signup(User user) {
        Optional<User> existingUser = repository.findByUsername(user.getUsername());
        if(existingUser.isPresent()) {
            throw new RuntimeException("User already exists.");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setIsAccountEnabled(true);
        user.setIsAccountExpired(false);
        user.setIsAccountLocked(false);

        return repository.save(user);
    }

    @Override
    public User login(User user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword())
        );
        User authenticatedUser = (User) authentication.getPrincipal();

        return user;
    }
}
