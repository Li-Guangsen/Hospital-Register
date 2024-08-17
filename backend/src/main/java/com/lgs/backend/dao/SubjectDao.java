package com.lgs.backend.dao;

import com.lgs.backend.model.Subject;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SubjectDao {
    List<Subject> findAll(Subject subject);
    int deleteByPrimaryKey(Integer id);
    int insert(Subject subject);
    Subject selectByPrimaryKey(Integer id);
    int updateByPrimaryKey(Subject subject);
    String selectSubName(Integer id);
    List<Subject> selectNames();
    int count();

}
