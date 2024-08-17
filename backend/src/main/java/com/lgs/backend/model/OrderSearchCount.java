package com.lgs.backend.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderSearchCount {
    public OrderSearchCount(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    private String name;
    private Integer value;
}
