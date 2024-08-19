package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PatientEditBean {
    private Integer id;
    private String oldPwd;
    private String newPwd;

}
