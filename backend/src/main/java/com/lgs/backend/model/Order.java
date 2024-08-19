package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Order {
    private Integer id;
    private Integer patId;
    private Integer schId;
    private String status;
    private String description;
    private Schedule schedule;
    private Patient patient;

    public Order(Integer patId, Integer schId, String status, String description) {
        this.patId = patId;
        this.schId = schId;
        this.status = status;
        this.description = description;
    }
}
