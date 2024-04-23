package com.hxt.pojo.ov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotSearchDetailsVO {
    private String userName;
    private String hotSearchComment;
    private String hotSearchTime;
    private Float hotNewsLabel;
}
