package com.lgs.backend.service.impl;

import com.lgs.backend.dao.ScheduleDao;
import com.lgs.backend.model.Schedule;
import com.lgs.backend.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private ScheduleDao scheduleDao;
    @Autowired
    public void setScheduleDao(ScheduleDao scheduleDao) {
        this.scheduleDao = scheduleDao;
    }
    @Override
    public List<com.lgs.backend.model.Schedule> getScheduleAll() {
        return List.of();
    }

    @Override
    public com.lgs.backend.model.Schedule getScheduleById(Integer id) {
        return null;
    }

    @Override
    public boolean addSchedule(Schedule schedule) {
        return false;
    }

    @Override
    public boolean updateSchedule(Schedule schedule) {
        return false;
    }

    @Override
    public boolean deleteSchedule(Integer id) {
        return false;
    }
}
