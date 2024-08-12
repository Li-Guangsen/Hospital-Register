package com.lgs.backend.service;

import com.lgs.backend.model.Subject;

import java.util.List;

public interface SubjectService {
    List<Subject> getSubjectAll();
    Subject getSubjectById(Integer id);
    boolean addSubject(Subject subject);
    boolean updateSubject(Subject subject);
    boolean deleteSubject(Integer id);
}
