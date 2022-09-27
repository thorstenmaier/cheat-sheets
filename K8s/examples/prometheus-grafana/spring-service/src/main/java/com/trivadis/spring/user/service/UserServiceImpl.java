package com.trivadis.spring.user.service;

import com.trivadis.spring.user.domain.LogEntry;
import com.trivadis.spring.user.domain.User;
import com.trivadis.spring.user.repository.LogEntryRepository;
import com.trivadis.spring.user.repository.UserRepository;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private LogEntryRepository logEntryRepository;

    public UserServiceImpl(UserRepository userRepository, LogEntryRepository logEntryRepository) {
        this.userRepository = userRepository;
        this.logEntryRepository = logEntryRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User findUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Transactional
    public User createUser(User user) {
        logEntryRepository.save(new LogEntry("User created"));
        return userRepository.save(user);
    }

    @Override
    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
