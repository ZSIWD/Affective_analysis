package com.hxt.pojo.ov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DepLevelOv {

    private Integer levelCount1;
    private Integer levelCount2;
    private Integer levelCount3;
    private Integer totalCount;
    private Float levelPercentage1;
    private Float levelPercentage2;
    private Float levelPercentage3;
}
