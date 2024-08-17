package com.lgs.backend.service;

import com.lgs.backend.model.Subject;
import com.lgs.backend.utils.PaginateInfo;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjectAll(PaginateInfo paginateInfo, Subject subject);
    Subject getSubjectById(Integer id);
    boolean addSubject(Subject subject);
    boolean updateSubject(Subject subject);
    boolean deleteSubject(Integer id);
    List<Subject> getSubjectNames();
    int getSubjectCount();
}
