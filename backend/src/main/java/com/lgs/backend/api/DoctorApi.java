package com.lgs.backend.api;

import com.lgs.backend.model.Doctor;
import com.lgs.backend.service.DoctorService;
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
    public List<Doctor> getDoctorAll() {
        LOGGER.info("查询全部医生信息");
        return doctorService.getDoctorAll();
    }
    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable Integer id) {
        return doctorService.getDoctorById(id);
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
