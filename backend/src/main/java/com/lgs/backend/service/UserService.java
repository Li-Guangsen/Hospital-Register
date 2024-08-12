package com.lgs.backend.service;

import com.lgs.backend.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserAll();
    User getUserById(Integer id);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(Integer id);
}
