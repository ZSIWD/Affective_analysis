package com.hxt.web.service.impl;

import com.hxt.exception.CommonException;
import com.hxt.exception.PasswordInCorrectException;
import com.hxt.exception.UserNotFoundException;
import com.hxt.pojo.dto.SysLoginDTO;
import com.hxt.pojo.dto.SysUserRegisterDTO;
import com.hxt.pojo.entity.SysUser;
import com.hxt.web.mapper.SysUserMapper;
import com.hxt.web.service.SysUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser login(SysLoginDTO sysUserDTO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(sysUserDTO,sysUser);

        //查询账号是否存在
        SysUser sys_user = sysUserMapper.getBySysUsername(sysUser.getSysUsername());

        if(sys_user == null){
            throw new UserNotFoundException("用户不存在");
        }
        //将传入的密码加密
        String password = DigestUtils.md5DigestAsHex(sysUserDTO.getPassword().getBytes());

        if(!sys_user.getPassword().equals(password)){
            throw new PasswordInCorrectException("密码不正确");
        }

        //登录成功
        return sys_user;

    }

    @Override
    public void register(SysUserRegisterDTO userRegisterDTO) {
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(userRegisterDTO, sysUser);
        //判断账号是否被注册
        SysUser sys_user = sysUserMapper.getBySysUsername(sysUser.getSysUsername());
        if(sys_user != null){
            throw new CommonException("账号已被注册");
        }
        //密码加密
        String password = DigestUtils.md5DigestAsHex(sysUser.getPassword().getBytes());
        sysUser.setPassword(password);
        sysUserMapper.insert(sysUser);
    }
}
