package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class OrderSearchBean {
    private Integer id;
    private Integer patId;
    private String patientName;
    private Integer doctorId;
    private LocalDate workTime;
    private String status;

}
