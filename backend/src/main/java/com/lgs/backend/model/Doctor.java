package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Doctor {
    private Integer id;
    private String name;
    private String sex;
    private String about;
    private String photo;
    private String education;
    private String university;
    private String major;
    private String workDate;
    private String level;
    private int count;
    private String subId;
}
