package com.hxt.web.mapper;

import com.github.pagehelper.Page;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotCommentMapper {

    @Select("select * from hot_comment order by commentTime desc")

    List<HotComment> getHotCommentByPage();
}
