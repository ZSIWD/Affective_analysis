package com.hxt.pojo.ov;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CityProp {

    private List city;
    private List hardData;
    private List midData;
    private List lightData;
}
