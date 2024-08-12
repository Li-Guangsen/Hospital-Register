package com.lgs.backend.service.impl;

import com.lgs.backend.dao.PatientDao;
import com.lgs.backend.model.Patient;
import com.lgs.backend.service.PatientService;
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
    public List<Patient> getPatientAll() {
        return List.of();
    }

    @Override
    public Patient getPatientById(Integer id) {
        return null;
    }

    @Override
    public boolean updatePatient(Patient patient) {
        return false;
    }

    @Override
    public boolean deletePatient(Integer id) {
        return false;
    }

    @Override
    public boolean addPatient(Patient patient) {
        return false;
    }
}
