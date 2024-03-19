package com.hxt.pojo.ov;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUserOv {

    private String sysUsername;
    private String password;
    private Integer role;
    private Integer status;
    private String token;
}
