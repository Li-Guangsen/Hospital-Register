package com.lgs.backend.dao;

import com.lgs.backend.model.Patient;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PatientDao {
    int deleteByPrimaryKey(Integer id);
    int insert(Patient patient);
    int insertSelective(Patient patient);
    Patient selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(Patient patient);

}
