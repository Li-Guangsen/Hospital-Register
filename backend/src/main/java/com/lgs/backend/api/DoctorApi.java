package com.lgs.backend.api;

import com.github.pagehelper.PageInfo;
import com.lgs.backend.model.Doctor;
import com.lgs.backend.model.Subject;
import com.lgs.backend.service.DoctorService;
import com.lgs.backend.utils.PaginateInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/doctors", produces = "application/json;charset=utf-8")
public class DoctorApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(DoctorApi.class);
    private DoctorService doctorService;
    @Autowired
    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
    @GetMapping
    public Map<String,Object> getDoctorAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                     @RequestParam(defaultValue = "1000") Integer pageSize,
                                     Doctor doctor) {
        LOGGER.info("查询全部医生信息");
//        LOGGER.info("doctor: {} {}",doctor.getName(),doctor.getSubId());
        PaginateInfo paginateInfo = new PaginateInfo(pageNo,pageSize);
        List<Doctor> doctors = doctorService.getDoctorAll(paginateInfo,doctor);
        PageInfo<Doctor> pageInfo = new PageInfo<>(doctors);
        Map<String,Object> map = Map.of("pageNo",pageInfo.getPageNum(),"pageSize",pageInfo.getPageSize(),"total",pageInfo.getTotal());
        return  Map.of("success",true,"rows", doctors,"pi",map);
    }
    //请求格式：http://localhost:8080/api/v1/doctors/1
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
    }
    @GetMapping("/names")
    public List<Doctor> getDoctorNames() {
        return doctorService.getDoctorNames();
    }
    @GetMapping("/count")
    public int getDoctorCount() {
        return doctorService.getDoctorCount();
    }

    @PostMapping()
    public ResponseEntity<Map<String, Object>> addDoctor(@RequestBody Doctor doctor) {
        boolean success = doctorService.addDoctor(doctor);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteDoctor(@PathVariable Integer id) {
        boolean success = doctorService.deleteDoctor(id);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateDoctor(@RequestBody Doctor doctor) {
        boolean success = doctorService.updateDoctor(doctor);
        return ResponseEntity.ok(Map.of("success", success));
    }
}
