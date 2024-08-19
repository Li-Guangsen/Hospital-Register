package com.lgs.backend.controller;

import com.lgs.backend.model.Order;
import com.lgs.backend.model.Patient;
import com.lgs.backend.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
@RequestMapping("/client")
public class BookController {
    private ScheduleService scheduleService;
    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @PostMapping("/book")
    public ResponseEntity<Map<String, Object>> book(Integer scheduleId, HttpSession session) {
        Patient patient = (Patient) session.getAttribute("patient");
        Order order = new Order(patient.getId(), scheduleId, "待叫号", "预约挂号测试");
        boolean success = scheduleService.addOrder(order);
        return ResponseEntity.ok(Map.of("success", success));
    }
}
