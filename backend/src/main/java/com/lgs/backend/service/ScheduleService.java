package com.lgs.backend.service;

import com.lgs.backend.model.Schedule;

import java.util.List;

public interface ScheduleService {
    List<Schedule> getScheduleAll();
    Schedule getScheduleById(Integer id);
    boolean addSchedule(Schedule schedule);
    boolean updateSchedule(Schedule schedule);
    boolean deleteSchedule(Integer id);
}
