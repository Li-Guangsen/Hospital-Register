package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ScheduleSearchBean {
    private Integer Id;
    private LocalDate workTime;
    private String doctorName;
    private Integer subId;
    private Integer count;
}
