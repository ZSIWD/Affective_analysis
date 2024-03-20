package com.hxt.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import com.hxt.web.mapper.HotCommentMapper;
import com.hxt.web.service.HotCommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotCommentServiceImpl implements HotCommentService {
    @Resource
    private HotCommentMapper hotCommentMapper;

    @Override
    public List<HotComment> getHotCommentByPage(PageDTO pageDTO) {

        //开启分页

        PageHelper.startPage(pageDTO.getPage(),pageDTO.getSize());
        //查询
        List<HotComment> list = hotCommentMapper.getHotCommentByPage();

        return list;
    }
}
