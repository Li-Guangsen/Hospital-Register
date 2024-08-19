package com.lgs.backend.service;

import com.lgs.backend.model.Order;
import com.lgs.backend.model.Schedule;
import com.lgs.backend.model.ScheduleSearchBean;
import com.lgs.backend.utils.PaginateInfo;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getScheduleAll(PaginateInfo paginateInfo, ScheduleSearchBean schedule);
    List<Schedule> getNowSchedule( ScheduleSearchBean schedule);
    Schedule getScheduleById(Integer id);
    boolean addSchedule(Schedule schedule);
    boolean updateSchedule(Schedule schedule);
    boolean deleteSchedule(Integer id);
    boolean addOrder(Order order);
}
