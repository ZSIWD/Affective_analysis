package com.hxt.web.mapper;

import com.hxt.pojo.entity.SysUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface SysUserMapper {

    /**
     * 根据用户名，查询用户
     * @param sysUsername
     * @return
     */
    @Select("select * from sys_user where sys_username = #{sysUsername}")
    SysUser getBySysUsername(String sysUsername);

    /**
     * 新增用户
     * @param sysUser
     */
    @Insert("insert into sys_user values(#{sysUsername},#{password},#{role},#{status})")
    void insert(SysUser sysUser);
}
