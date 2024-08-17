package com.lgs.backend.dao;

import com.lgs.backend.model.Order;
import com.lgs.backend.model.OrderSearchBean;
import com.lgs.backend.model.OrderSearchCount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrderDao {
    List<Order> findAll(OrderSearchBean order);
    int deleteByPrimaryKey(Integer id);
    int insert(Order order);
    Order selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(Order order);
    int updateStatus(Order order);
    int count();
    List<OrderSearchCount> findDoctorCount();
    List<OrderSearchCount> findWorkDateCount();
    List<OrderSearchCount> findSubjectCount();

}
