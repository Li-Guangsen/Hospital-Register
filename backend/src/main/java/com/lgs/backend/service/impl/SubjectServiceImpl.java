package com.lgs.backend.service.impl;

import com.lgs.backend.dao.SubjectDao;
import com.lgs.backend.model.Subject;
import com.lgs.backend.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {
    private SubjectDao subjectDao;
    @Autowired
    public SubjectServiceImpl(SubjectDao subjectDao) {
        this.subjectDao = subjectDao;
    }


    @Override
    public List<Subject> getSubjectAll() {
        return List.of();
    }

    @Override
    public Subject getSubjectById(Integer id) {
        return null;
    }

    @Override
    public boolean addSubject(Subject subject) {
        return false;
    }

    @Override
    public boolean updateSubject(Subject subject) {
        return false;
    }

    @Override
    public boolean deleteSubject(Integer id) {
        return false;
    }
}
