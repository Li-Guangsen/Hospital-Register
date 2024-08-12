package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Patient {
    private Integer id;
    private String username;
    private String password;
    private String photo;
    private String name;
    private String sex;
    private String idNumber;
    private String birth;
    private String phone;
    private String description;
}
