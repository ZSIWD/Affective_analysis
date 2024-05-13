package com.hxt.web.mapper;

import com.github.pagehelper.Page;
import com.hxt.pojo.entity.UserPost;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserPostMapper {

    /**
     * 根据用户获取评论
     * @param userName
     * @return
     */
    Page<UserPost> getCommentByUser(String userName);
}
