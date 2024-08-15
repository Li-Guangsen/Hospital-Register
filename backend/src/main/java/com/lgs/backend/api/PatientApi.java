package com.lgs.backend.api;

import com.github.pagehelper.PageInfo;
import com.lgs.backend.model.Patient;
import com.lgs.backend.model.PatientSearchBean;
import com.lgs.backend.service.PatientService;
import com.lgs.backend.utils.PaginateInfo;
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
    public Map<String,Object> getPatientAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                            @RequestParam(defaultValue = "1000") Integer pageSize,
                                            PatientSearchBean psb) {
        LOGGER.info("查询全部病人信息");
        PaginateInfo paginateInfo = new PaginateInfo(pageNo,pageSize);
        List<Patient> patients = patientService.getPatientAll(paginateInfo,psb);
//        System.out.println("patients: "+ patients.get(0).getIdNumber()+patients.get(0).getName());
        PageInfo<Patient> pageInfo = new PageInfo<>(patients);
        Map<String,Object> map = Map.of("pageNo",pageInfo.getPageNum(),"pageSize",pageInfo.getPageSize(),"total",pageInfo.getTotal());
        return Map.of("success",true,"rows", patients,"pi",map);
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
