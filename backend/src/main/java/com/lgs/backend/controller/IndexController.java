package com.lgs.backend.controller;

import com.lgs.backend.model.*;
import com.lgs.backend.service.OrderService;
import com.lgs.backend.service.ScheduleService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/client")
public class IndexController {
    private ScheduleService scheduleService;
    private OrderService orderService;

    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @Autowired
    public void setOrderService(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/index")
    public String toIndex() {
        return "client/index";
    }

    @GetMapping("/list")
    public String list(Map<String, Object> model) {
        List<Schedule> schedules = scheduleService.getNowSchedule(null);
        model.put("schedules", schedules);
        return "client/list";
    }

    @GetMapping("/order")
    public String toOrder(HttpSession session,Map<String, Object> model) {
        if (session.getAttribute("patient") == null)
            return "client/login";
        else {
            Patient patient = (Patient) session.getAttribute("patient");
            OrderSearchBean orderSearchBean = new OrderSearchBean();
            orderSearchBean.setPatId(patient.getId());
            List<Order> orders = orderService.getOrderAll(orderSearchBean);
            model.put("orders", orders);
            return "client/order";
        }
    }

    @GetMapping("/message")
    public String toMessage() {
        return "client/message";
    }

    @GetMapping("/my")
    public String toMy(HttpSession session, Map<String, Object> model) {
        if (session.getAttribute("patient") == null)
            return "client/login";
        else {
            model.put("patient", session.getAttribute("patient"));
            return "client/my";
        }
    }
}
