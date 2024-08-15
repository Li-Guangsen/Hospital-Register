package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Schedule {
    private Integer id;
    private Integer doctorId;
    private Integer count;
    private String description;
    private LocalDate workTime;

    private Doctor doctor;
}
