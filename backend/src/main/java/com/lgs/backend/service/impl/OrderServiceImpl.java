package com.lgs.backend.service.impl;

import com.lgs.backend.dao.OrderDao;
import com.lgs.backend.model.Order;
import com.lgs.backend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    @Override
    public List<Order> getOrderAll() {
        return null;
    }

    @Override
    public Order getOrderById(Integer id) {
        return null;
    }

    @Override
    public boolean addOrder(Order order) {
        return false;
    }

    @Override
    public boolean updateOrder(Order order) {
        return false;
    }

    @Override
    public boolean deleteOrder(Integer id) {
        return false;
    }
}
