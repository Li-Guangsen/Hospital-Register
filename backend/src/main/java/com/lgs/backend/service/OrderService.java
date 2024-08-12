package com.lgs.backend.service;
import com.lgs.backend.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getOrderAll();
    Order getOrderById(Integer id);
    boolean addOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(Integer id);
}
