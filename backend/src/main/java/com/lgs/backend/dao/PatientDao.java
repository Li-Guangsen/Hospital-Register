package com.lgs.backend.dao;

import com.lgs.backend.model.Patient;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PatientDao {
    List<Patient> findAll(Patient patient);
    int deleteByPrimaryKey(Integer id);
    int insert(Patient patient);
    Patient selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(Patient patient);

}
