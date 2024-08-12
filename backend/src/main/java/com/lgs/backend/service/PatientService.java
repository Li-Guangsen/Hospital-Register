package com.lgs.backend.service;

import com.lgs.backend.model.Patient;

import java.util.List;

public interface PatientService {
    List<Patient> getPatientAll();
    Patient getPatientById(Integer id);
    boolean updatePatient(Patient patient);
    boolean deletePatient(Integer id);
    boolean addPatient(Patient patient);
}
