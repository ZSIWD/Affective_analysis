package com.hxt.web.service;

import com.hxt.pojo.dto.SysLoginDTO;
import com.hxt.pojo.dto.SysUserRegisterDTO;
import com.hxt.pojo.entity.SysUser;

public interface SysUserService {

    /**
     * 登录
     * @param sysUserDTO
     */
    SysUser login(SysLoginDTO sysUserDTO);

    void register(SysUserRegisterDTO userRegisterDTO);
}
