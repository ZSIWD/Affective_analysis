package com.hxt.web.mapper;

import com.hxt.pojo.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {

    @Select("select * from sys_user where sys_username = #{sysUsername}")
    SysUser getBySysUsername(String sysUsername);

    @Insert("insert into sys_user values(#{sysUsername},#{password},#{role},#{status})")
    void insert(SysUser sysUser);
}
