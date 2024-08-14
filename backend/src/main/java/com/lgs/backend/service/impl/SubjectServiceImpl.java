package com.lgs.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lgs.backend.dao.SubjectDao;
import com.lgs.backend.model.Doctor;
import com.lgs.backend.model.Subject;
import com.lgs.backend.service.SubjectService;
import com.lgs.backend.utils.PaginateInfo;
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
    public List<Subject> getSubjectAll(PaginateInfo paginateInfo, Subject subject) {
        try (Page<?> __ = PageHelper.startPage(paginateInfo.getPageNo(),paginateInfo.getPageSize())) {
            return subjectDao.findAll(subject);
        }
    }

    @Override
    public Subject getSubjectById(Integer id) {
        return subjectDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean addSubject(Subject subject) {
        return subjectDao.insert(subject)>0;
    }

    @Override
    public boolean updateSubject(Subject subject) {
        return subjectDao.updateByPrimaryKey(subject)>0;
    }

    @Override
    public boolean deleteSubject(Integer id) {
        return subjectDao.deleteByPrimaryKey(id)>0;
    }

    @Override
    public List<Subject> getSubjectNames() {
        return subjectDao.selectNames();
    }
}
