package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Patient {
    private Integer id;
    private String phone;
    private String password;
    private String photo;
    private String name;
    private String sex;
    private String idNumber;
    private LocalDate birth;
    private String description;
}
