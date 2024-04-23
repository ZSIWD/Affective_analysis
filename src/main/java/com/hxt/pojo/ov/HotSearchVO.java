package com.hxt.pojo.ov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HotSearchVO {

    private Integer hotNewsLine;
    private String hotNewsTitle;
    private Integer totalCount;
    private Integer pCount;
    private Integer nCount;
    private Float pPercentage;
    private Float nPercentage;
}
