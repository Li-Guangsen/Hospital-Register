package com.lgs.backend.service;

import com.lgs.backend.model.Doctor;
import com.lgs.backend.utils.PaginateInfo;

import java.util.List;

public interface DoctorService {
    List<Doctor> getDoctorAll(PaginateInfo paginateInfo, Doctor doctor);
    List<Doctor>  getDoctorNames();
    Doctor getDoctorById(Integer id);
    boolean addDoctor(Doctor doctor);
    boolean updateDoctor(Doctor doctor);
    boolean deleteDoctor(Integer id);
    int getDoctorCount();
}
