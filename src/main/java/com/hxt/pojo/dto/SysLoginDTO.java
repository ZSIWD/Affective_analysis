package com.hxt.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysLoginDTO {

    private String sysUsername;
    private String password;
    private Integer role;
    private Integer status;
}
