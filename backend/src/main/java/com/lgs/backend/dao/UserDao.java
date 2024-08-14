package com.lgs.backend.dao;

import com.lgs.backend.model.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int deleteByPrimaryKey(String username);

    int insert(User user);

    int insertSelective(User user);

    User selectByPrimaryKey(String username);

    int updateByPrimaryKeySelective(User user);


}
