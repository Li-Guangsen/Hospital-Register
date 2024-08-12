package com.lgs.backend.api;

import com.lgs.backend.model.Patient;
import com.lgs.backend.service.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/patients", produces = "application/json;charset=utf-8")
public class PatientApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientApi.class);

    private PatientService patientService;
    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }
    @GetMapping
    public List<Patient> getPatientAll() {
        LOGGER.info("查询全部信息");
        return patientService.getPatientAll();
    }
    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable Integer id) {
        return patientService.getPatientById(id);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> addPatient(@RequestBody Patient patient) {
        boolean success = patientService.addPatient(patient);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deletePatient(@PathVariable Integer id) {
        boolean success = patientService.deletePatient(id);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @PutMapping
    public ResponseEntity<Map<String, Object>> updatePatient(@RequestBody Patient patient) {
        boolean success = patientService.updatePatient(patient);
        return ResponseEntity.ok(Map.of("success", success));
    }

}
