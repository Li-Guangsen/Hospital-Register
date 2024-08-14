package com.lgs.backend.dao;

import com.lgs.backend.model.Order;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Order order);

    int insertSelective(Order order);

    Order selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Order order);

}
