package com.hxt.web.controller;

import com.hxt.pojo.dto.SysLoginDTO;
import com.hxt.pojo.dto.SysUserRegisterDTO;
import com.hxt.pojo.entity.SysUser;
import com.hxt.pojo.ov.SysUserOv;
import com.hxt.properties.JwtProperties;
import com.hxt.result.Result;
import com.hxt.utils.JwtUtil;
import com.hxt.web.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    @Resource
    private SysUserService sysUserService;
    @Resource
    private JwtProperties jwtProperties;

    //登录
    @PostMapping("/login")
    private Result<SysUserOv> login(@RequestBody SysLoginDTO sysUserDTO){
        SysUser sysUser = sysUserService.login(sysUserDTO);
        //生成claims
        Map<String, Object> claims = new HashMap<>();
        claims.put("用户名", sysUser.getSysUsername());
        //生成token
        String token = JwtUtil.createJWT(jwtProperties.getJwtSecretKey(), jwtProperties.getJwtTtl(), claims);
        SysUserOv userOv = new SysUserOv();
        BeanUtils.copyProperties(sysUser,userOv);
        userOv.setToken(token);
        return Result.success(userOv);
    }

    /**
     * 注册
     */
    @PostMapping("/register")
    private Result register(@RequestBody SysUserRegisterDTO userRegisterDTO){
        sysUserService.register(userRegisterDTO);
        return Result.success();
    }

}
