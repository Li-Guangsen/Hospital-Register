package com.lgs.backend.dao;

import com.lgs.backend.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDao {
    List<User> findAll(User user);
    int deleteByPrimaryKey(Integer id);
    int insert(User user);
    User selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(User user);
}
