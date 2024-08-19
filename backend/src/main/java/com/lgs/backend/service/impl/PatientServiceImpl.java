package com.lgs.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lgs.backend.dao.PatientDao;
import com.lgs.backend.model.Patient;
import com.lgs.backend.model.PatientSearchBean;
import com.lgs.backend.service.PatientService;
import com.lgs.backend.utils.PaginateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {
    private PatientDao patientDao;
    @Autowired
    public void setPatientDao(PatientDao patientDao) {
        this.patientDao = patientDao;
    }
    @Override
    public List<Patient> getPatientAll(PaginateInfo paginateInfo, PatientSearchBean psb) {
        try (Page<?> __ = PageHelper.startPage(paginateInfo.getPageNo(),paginateInfo.getPageSize())) {
            return patientDao.findAll(psb);
        }
    }

    @Override
    public Patient getPatientById(Integer id) {
        return patientDao.selectByPrimaryKey(id);
    }

    @Override
    public Patient getPatientByPhone(String phone) {
        return patientDao.selectByPhone(phone);
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return patientDao.updateByPrimaryKey(patient)>0;
    }

    @Override
    public boolean updatePassword(Patient patient) {
        return patientDao.updatePassword(patient)>0;
    }

    @Override
    public boolean deletePatient(Integer id) {
        return patientDao.deleteByPrimaryKey(id)>0;
    }

    @Override
    public boolean addPatient(Patient patient) {
        return patientDao.insert(patient)>0;
    }

    @Override
    public int getPatientCount() {
        return patientDao.count();
    }
}
