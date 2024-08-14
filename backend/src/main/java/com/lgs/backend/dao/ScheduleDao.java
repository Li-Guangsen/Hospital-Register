package com.lgs.backend.dao;

import com.lgs.backend.model.Schedule;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ScheduleDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Schedule record);

    int insertSelective(Schedule schedule);

    Schedule selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Schedule schedule);

}
