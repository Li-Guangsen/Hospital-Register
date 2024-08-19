package com.lgs.backend.service;
import com.lgs.backend.model.Order;
import com.lgs.backend.model.OrderSearchBean;
import com.lgs.backend.model.OrderSearchCount;
import com.lgs.backend.utils.PaginateInfo;

import java.util.List;

public interface OrderService {
    List<Order> getOrderAll(PaginateInfo paginateInfo, OrderSearchBean order);
    List<Order> getOrderAll(OrderSearchBean order);
    Order getOrderById(Integer id);
    boolean addOrder(Order order);
    boolean updateOrder(Order order);
    boolean deleteOrder(Integer id);
    boolean updateStatus(Order order);
    int getOrderCount();
    List<OrderSearchCount> getDoctorOrderCount();
    List<Integer> getWorkDateOrderCount();
    List<OrderSearchCount> getSubjectOrderCount();
    boolean closeOrder(Integer id);
}
