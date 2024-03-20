package com.hxt.result;

import lombok.Data;

import java.util.List;

@Data
public class PageResult {

    private List records;
    private Long total;
}
