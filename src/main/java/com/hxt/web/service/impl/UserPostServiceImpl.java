package com.hxt.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hxt.pojo.dto.UserPostDTO;
import com.hxt.pojo.entity.UserPost;
import com.hxt.result.PageResult;
import com.hxt.web.mapper.UserPostMapper;
import com.hxt.web.service.UserPostService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

@Service
public class UserPostServiceImpl implements UserPostService {

    @Resource
    private UserPostMapper userPostMapper;
    @Override
    public PageResult getCommentByUser(UserPostDTO userPostDTO) {
        PageHelper.startPage(userPostDTO.getPage(),userPostDTO.getSize());
        String userName = userPostDTO.getUserName();
        Page<UserPost> postByUser = userPostMapper.getCommentByUser(userName);
        System.out.println(postByUser);
        PageResult pageResult = new PageResult();
        pageResult.setRecords(postByUser);
        pageResult.setTotal(postByUser.getTotal());
        return pageResult;
    }
}

