package com.lgs.backend.service.impl;

import com.lgs.backend.dao.DoctorDao;
import com.lgs.backend.model.Doctor;
import com.lgs.backend.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DoctorServiceImpl implements DoctorService {
    private DoctorDao doctorDao;
    @Autowired
    public void setDoctorDao(DoctorDao doctorDao) {
        this.doctorDao = doctorDao;
    }
    @Override
    public List<Doctor> getDoctorAll() {
        return List.of();
    }

    @Override
    public Doctor getDoctorById(Integer id) {
        return null;
    }

    @Override
    public boolean addDoctor(Doctor doctor) {
        return false;
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        return false;
    }

    @Override
    public boolean deleteDoctor(Integer id) {
        return false;
    }
}
