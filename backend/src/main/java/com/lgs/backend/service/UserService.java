package com.lgs.backend.service;

import com.lgs.backend.model.User;
import com.lgs.backend.utils.PaginateInfo;

import java.util.List;

public interface UserService {
    List<User> getUserAll(PaginateInfo paginateInfo, User user);
    User getUserById(Integer id);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean updatePassword(User user);
    boolean deleteUser(Integer id);
    User findUserByUsername(String username);
}
