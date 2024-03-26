package com.hxt.pojo.ov;

import lombok.Builder;
import lombok.Data;

@Data
public class DepressionPropVo {

    private String city;
    private Float hardlevel;
    private Float midlevel;
    private Float lightlevel;
}
