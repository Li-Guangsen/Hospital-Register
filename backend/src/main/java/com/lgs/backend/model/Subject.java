package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Subject {
    private Integer id;
    private String name;
    private String description;
    private String subCode;
    private String dutyDoctor;
    private LocalDate createTime;
    private String about;
    private String address;
}
