package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Schedule {
    private Integer id;
    private Integer doctorId;
    private String money;
    private int status;
    private String description;
    private String startTime;
    private String endTime;
}
