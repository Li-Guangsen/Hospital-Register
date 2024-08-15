package com.lgs.backend.dao;

import com.lgs.backend.model.Doctor;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoctorDao {
    List<Doctor> findAll(Doctor doctor);
    List<Doctor> selectNames();
    int deleteByPrimaryKey(Integer id);
    int insert(Doctor doctor);
    Doctor selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(Doctor doctor);

}
