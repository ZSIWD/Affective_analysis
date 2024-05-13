package com.hxt.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hxt.constant.LineDataConstant;
import com.hxt.pojo.dto.LineDataVo;
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

    /**
     * 根据用户获取热评
     * @param userPostDTO
     * @return
     */
    @Override
    public PageResult getCommentByUser(UserPostDTO userPostDTO) {
        //分页设置
        PageHelper.startPage(userPostDTO.getPage(),userPostDTO.getSize());
        //得到用户名
        String userName = userPostDTO.getUserName();
        //分页查询
        Page<UserPost> postByUser = userPostMapper.getCommentByUser(userName);
        //如果没有该用户数据
        if (postByUser.size()==0){
            Page<UserPost> allComment = userPostMapper.getCommentByUser(null);
        }
        //返回数据
        PageResult pageResult = new PageResult();
        pageResult.setRecords(postByUser);
        pageResult.setTotal(postByUser.getTotal());
        return pageResult;
    }

    /**
     * 获取男女月份抑郁占比
     * @return
     */

    @Override
    public LineDataVo getLineData() {
        LineDataVo lineDataVo = new LineDataVo();
        lineDataVo.setMale(LineDataConstant.MALE);
        lineDataVo.setFemale(LineDataConstant.FEMALE);
        return lineDataVo;
    }
}

