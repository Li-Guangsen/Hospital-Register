package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Schedule {
    private Integer id;
    private Integer doctorId;
    private BigDecimal money;
    private Integer status;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
