package com.lgs.backend.controller;

import com.github.pagehelper.PageInfo;
import com.lgs.backend.model.Schedule;
import com.lgs.backend.model.ScheduleSearchBean;
import com.lgs.backend.service.ScheduleService;
import com.lgs.backend.utils.PaginateInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/client")
public class IndexController {
    private ScheduleService scheduleService;
    @Autowired
    public void setScheduleService(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }
    @GetMapping("/index")
    public String toIndex() {
        return "client/index";
    }
    @GetMapping("/list")
    public String list(Map<String,Object> model) {
            List<Schedule> schedules = scheduleService.getNowSchedule(null);
            model.put("schedules", schedules);
        return "client/list";
    }
    @GetMapping("/hot")
    public String toHot() {
        return "client/hot";
    }
    @GetMapping("/message")
    public String toMessage() {
        return "client/message";
    }
    @GetMapping("/my")
    public String toMy() {
        return "client/my";
    }
}
