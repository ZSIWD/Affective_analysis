package com.hxt.constant;

import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;

@Data
public class LineDataConstant {
    public static final ArrayList<Integer> MALE =
            new ArrayList<>(Arrays.asList(8, 12, 6, 8, 15, 13, 18, 23, 14, 16, 14, 12));

    public static final ArrayList<Integer> FEMALE =
            new ArrayList<>(Arrays.asList(10, 16, 7, 12, 8, 16, 19, 22, 12, 18, 20, 17));
}
