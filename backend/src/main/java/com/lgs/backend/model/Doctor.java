package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Doctor {
    private Integer id;
    private String name;
    private String sex;
    private String about;
    private String photo;
    private String education;
    private String phone;
    private LocalDate workDate;
    private String level;
    private Integer count;
    private Integer subId;
    private String subName;

}
