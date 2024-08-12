package com.lgs.backend.api;

import com.lgs.backend.model.Schedule;
import com.lgs.backend.service.ScheduleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/schedule", produces = "application/json;charset=utf-8")
public class ScheduleApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleApi.class);
    private ScheduleService scheduleService;
    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @GetMapping
    public List<Schedule> getScheduleAll() {
        LOGGER.info("查询全部信息");
        return scheduleService.getScheduleAll();
    }
    @GetMapping("/{id}")
    public Schedule getScheduleById(@PathVariable Integer id) {
        return scheduleService.getScheduleById(id);
    }
    @PostMapping
    public ResponseEntity<Map<String, Object>> addSchedule(@RequestBody Schedule schedule) {
        boolean success = scheduleService.addSchedule(schedule);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Object>> deleteSchedule(@PathVariable Integer id) {
        boolean success = scheduleService.deleteSchedule(id);
        return ResponseEntity.ok(Map.of("success", success));
    }
    @PutMapping
    public ResponseEntity<Map<String, Object>> updateSchedule(@RequestBody Schedule schedule) {
        boolean success = scheduleService.updateSchedule(schedule);
        return ResponseEntity.ok(Map.of("success", success));
    }
}
