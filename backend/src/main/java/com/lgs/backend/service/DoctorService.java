package com.lgs.backend.service;

import com.lgs.backend.model.Doctor;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctorAll();
    Doctor getDoctorById(Integer id);
    boolean addDoctor(Doctor doctor);
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctor(Integer id);
}
