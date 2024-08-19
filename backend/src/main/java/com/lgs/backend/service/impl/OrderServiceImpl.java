package com.lgs.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lgs.backend.dao.OrderDao;
import com.lgs.backend.model.Order;
import com.lgs.backend.model.OrderSearchBean;
import com.lgs.backend.model.OrderSearchCount;
import com.lgs.backend.service.OrderService;
import com.lgs.backend.utils.PaginateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {
    private OrderDao orderDao;
    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }
    @Override
    public List<Order> getOrderAll(PaginateInfo paginateInfo, OrderSearchBean order) {

        try (Page<?> __ = PageHelper.startPage(paginateInfo.getPageNo(),paginateInfo.getPageSize())) {
            return orderDao.findAll(order);
        }
    }

    @Override
    public List<Order> getOrderAll(OrderSearchBean order) {
        return orderDao.findAll(order);
    }

    @Override
    public Order getOrderById(Integer id) {
        return orderDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean addOrder(Order order) {
        return orderDao.insert(order)>0;
    }

    @Override
    public boolean updateOrder(Order order) {
        return orderDao.updateByPrimaryKey(order)>0;
    }

    @Override
    public boolean deleteOrder(Integer id) {
        return orderDao.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean updateStatus(Order order) {
        return orderDao.updateStatus(order)>0;
    }

    @Override
    public int getOrderCount() {
        return orderDao.count();
    }

    @Override
    public List<OrderSearchCount> getDoctorOrderCount() {
        return orderDao.findDoctorCount();
    }

    @Override
    public List<Integer> getWorkDateOrderCount() {
       LocalDate today = LocalDate.now();
//        System.out.println(today);
        LocalDate firstDayOfWeek = today.with(TemporalAdjusters.previousOrSame(java.time.DayOfWeek.MONDAY));
//        System.out.println(firstDayOfWeek);
        List<OrderSearchCount> rows = orderDao.findWorkDateCount();
        List<Integer> data = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            String fdw = firstDayOfWeek.toString();
            for (OrderSearchCount row : rows)
                if (row.getName().equals(fdw))
                    data.add(row.getValue());
            if (data.size() < i + 1)
                data.add(0);
            firstDayOfWeek = firstDayOfWeek.plusDays(1);

        }
        return data;
    }

    @Override
    public List<OrderSearchCount> getSubjectOrderCount() {
        return orderDao.findSubjectCount();
    }

    @Override
    public boolean closeOrder(Integer id) {
        return orderDao.closeOrder(id)>0;
    }
}
