package com.trivadis.spring.user.service;

import com.trivadis.spring.user.domain.User;

import java.util.List;

public interface UserService {
    User findUserById(Long id);
    List<User> getAllUsers();
    User createUser(User user);
    void deleteUserById(Long id);
}
