package com.lgs.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lgs.backend.dao.ScheduleDao;
import com.lgs.backend.model.Schedule;
import com.lgs.backend.model.ScheduleSearchBean;
import com.lgs.backend.service.ScheduleService;
import com.lgs.backend.utils.PaginateInfo;
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
}
