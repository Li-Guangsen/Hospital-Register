package com.lgs.backend.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.lgs.backend.dao.DoctorDao;
import com.lgs.backend.model.Doctor;
import com.lgs.backend.service.DoctorService;
import com.lgs.backend.utils.PaginateInfo;
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
    public List<Doctor> getDoctorAll(PaginateInfo paginateInfo, Doctor doctor){
        try (Page<?> __ = PageHelper.startPage(paginateInfo.getPageNo(),paginateInfo.getPageSize())) {
            return doctorDao.findAll(doctor);
        }
    }

    @Override
    public List<Doctor> getDoctorNames() {
        return doctorDao.selectNames();
    }

    @Override
    public Doctor getDoctorById(Integer id) {
        return doctorDao.selectByPrimaryKey(id);
    }

    @Override
    public boolean addDoctor(Doctor doctor) {

        return doctorDao.insert(doctor)>0;
    }

    @Override
    public boolean updateDoctor(Doctor doctor) {
        return doctorDao.updateByPrimaryKey(doctor)>0;
    }

    @Override
    public boolean deleteDoctor(Integer id) {
        return doctorDao.deleteByPrimaryKey(id)>0;
    }

    @Override
    public int getDoctorCount() {
        return doctorDao.count();
    }
}
