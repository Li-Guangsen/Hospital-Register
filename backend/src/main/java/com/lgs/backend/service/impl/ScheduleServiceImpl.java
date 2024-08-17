package com.lgs.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lgs.backend.api.ScheduleApi;
import com.lgs.backend.dao.OrderDao;
import com.lgs.backend.dao.ScheduleDao;
import com.lgs.backend.model.Order;
import com.lgs.backend.model.Schedule;
import com.lgs.backend.model.ScheduleSearchBean;
import com.lgs.backend.service.ScheduleService;
import com.lgs.backend.utils.PaginateInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);
    private ScheduleDao scheduleDao;
    private OrderDao orderDao;

    @Autowired
    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }

    @Autowired
    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Schedule> getScheduleAll(PaginateInfo paginateInfo, ScheduleSearchBean schedule) {
        try (Page<?> __ = PageHelper.startPage(paginateInfo.getPageNo(), paginateInfo.getPageSize())) {
            return scheduleDao.findAll(schedule);
        }
    }

    @Override
    public Schedule getScheduleById(Integer id) {
        return scheduleDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean addSchedule(Schedule schedule) {
        return scheduleDao.insert(schedule) > 0;
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        return scheduleDao.updateByPrimaryKey(schedule) > 0;
    }

    @Override
    public boolean deleteSchedule(Integer id) {
        return scheduleDao.deleteByPrimaryKey(id) > 0;
    }

    @Override
    @Transactional
    public boolean addOrder(Order order) {
        boolean insertOrderSuccess = orderDao.insert(order) > 0;
//        int a = 1 / 0;
        boolean updateScheduleCountSuccess = scheduleDao.updateCount(order.getSchId()) > 0;
        if(insertOrderSuccess && updateScheduleCountSuccess)
            return true;
//        LOGGER.error("Failed to add order: {}",order);
        return false;
//        try {
//
//        } catch (Exception e) {
//        }
    }


}
