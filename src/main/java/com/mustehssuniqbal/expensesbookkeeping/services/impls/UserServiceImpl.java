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
    public Optional<User> getUser(Long id) {
        return repository.findById(id);
    }

    @Override
    public User updateUser(Long id, User user) {
        Optional<User> optionalExistingUser = repository.findById(id);
        if(!optionalExistingUser.isPresent()) {
            throw new RuntimeException("User does not exist!");
        }
        User existingUser = optionalExistingUser.get();
        existingUser.setAge(user.getAge());
        existingUser.setEmail(user.getEmail());
        existingUser.setIsAccountLocked(user.getIsAccountLocked());
        existingUser.setIsAccountEnabled(user.getIsAccountEnabled());
        existingUser.setIsAccountExpired(user.getIsAccountExpired());
        existingUser.setFirstName(user.getFirstName());
        existingUser.setLastName(user.getLastName());
        existingUser.setGender(user.getGender());
        existingUser.setAuthorities(user.getAuthorities());

        return repository.save(existingUser);
    }
}
