package com.lgs.backend.api;

import com.github.pagehelper.PageInfo;
import com.lgs.backend.model.Order;
import com.lgs.backend.model.Schedule;
import com.lgs.backend.model.ScheduleSearchBean;
import com.lgs.backend.service.ScheduleService;
import com.lgs.backend.utils.PaginateInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "api/v1/schedules", produces = "application/json;charset=utf-8")
public class ScheduleApi {
    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleApi.class);
    private ScheduleService scheduleService;
    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @GetMapping
    public Map<String,Object> getScheduleAll(@RequestParam(defaultValue = "1") Integer pageNo,
                                             @RequestParam(defaultValue = "1000") Integer pageSize,
                                             ScheduleSearchBean schedule) {
        LOGGER.info("查询全部排班信息");
        PaginateInfo paginateInfo = new PaginateInfo(pageNo,pageSize);
        List<Schedule> schedules = scheduleService.getScheduleAll(paginateInfo,schedule);
        PageInfo<Schedule> pageInfo = new PageInfo<>(schedules);
        Map<String,Object> map = Map.of("pageNo",pageInfo.getPageNum(),"pageSize",pageInfo.getPageSize(),"total",pageInfo.getTotal());
        return Map.of("success",true,"rows", schedules,"pi",map);
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
    @PostMapping("/addOrder")
    public ResponseEntity<Map<String, Object>> addOrder(@RequestBody Order order) {
        boolean success = scheduleService.addOrder(order);
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
