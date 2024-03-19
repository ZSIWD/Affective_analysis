package com.hxt.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "affective.jwt")
// 读取配置
public class JwtProperties {
    private String jwtSecretKey;
    private Long jwtTtl;
    private String jwtTokenName;
}
