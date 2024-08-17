package com.lgs.backend.service;

import com.lgs.backend.model.Patient;
import com.lgs.backend.model.PatientSearchBean;
import com.lgs.backend.utils.PaginateInfo;

import java.util.List;

public interface PatientService {
    List<Patient> getPatientAll(PaginateInfo paginateInfo, PatientSearchBean psb);
    Patient getPatientById(Integer id);
    boolean updatePatient(Patient patient);
    boolean updatePassword(Patient patient);
    boolean deletePatient(Integer id);
    boolean addPatient(Patient patient);
    int getPatientCount();
}
