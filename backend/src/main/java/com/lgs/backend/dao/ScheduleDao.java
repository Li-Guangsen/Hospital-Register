package com.lgs.backend.dao;

import com.lgs.backend.model.Schedule;
import com.lgs.backend.model.ScheduleSearchBean;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleDao {
    List<Schedule> findAll(ScheduleSearchBean schedule);
    int deleteByPrimaryKey(Integer id);
    int insert(Schedule record);
    Schedule selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(Schedule schedule);

}
