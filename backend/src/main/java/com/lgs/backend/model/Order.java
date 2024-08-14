package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Integer id;
    private Integer patId;
    private Integer schId;
    private Integer status;
    private String description;
}
