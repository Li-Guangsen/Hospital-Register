package com.lgs.backend.api;

import com.lgs.backend.model.Subject;
import com.lgs.backend.service.SubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/v1/subjects", produces = "application/json;charset=utf-8")
public class SubjectApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(SubjectApi.class);

    private SubjectService subjectService;
    @Autowired
    public void setSubjectService(SubjectService subjectService) {
        this.subjectService = subjectService;
    }
    @GetMapping
    public List<Subject> getSubjectAll() {
        LOGGER.info("查询全部信息");
        return subjectService.getSubjectAll();
    }
    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable Integer id) {
        return subjectService.getSubjectById(id);
    }
    @PostMapping()
    public ResponseEntity<Map<String, Object>> addSubject(@RequestBody Subject subject) {
        boolean success = subjectService.addSubject(subject);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteDoctor(@PathVariable Integer id) {
        boolean success = subjectService.deleteSubject(id);
        return ResponseEntity.ok(Map.of("success", success));
    }

    @PutMapping
    public ResponseEntity<Map<String, Object>> updateSubject(@RequestBody Subject subject) {
        boolean success = subjectService.updateSubject(subject);
        return ResponseEntity.ok(Map.of("success", success));
    }

}
