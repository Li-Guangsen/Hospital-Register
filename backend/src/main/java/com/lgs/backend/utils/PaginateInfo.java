package com.lgs.backend.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaginateInfo {
    private Integer pageNo;
    private Integer pageSize;

    public PaginateInfo(Integer pageNo, Integer pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
