package com.lgs.backend.service.impl;

import com.lgs.backend.dao.UserDao;
import com.lgs.backend.model.User;
import com.lgs.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserDao userDao;
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
    @Override
    public List<User> getUserAll() {
        return List.of();
    }

    @Override
    public User getUserById(Integer id) {
        return null;
    }

    @Override
    public boolean addUser(User user) {
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUser(Integer id) {
        return false;
    }



}
