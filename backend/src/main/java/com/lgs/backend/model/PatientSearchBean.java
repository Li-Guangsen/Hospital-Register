package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PatientSearchBean extends Patient{
    private String birthFrom;//开始日期
    private String birthTo;//结束日期
}
