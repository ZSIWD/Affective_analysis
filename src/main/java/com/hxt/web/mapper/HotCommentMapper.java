package com.hxt.web.mapper;

import com.github.pagehelper.Page;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import com.hxt.pojo.ov.DepressionPropVo;
import com.hxt.pojo.ov.XinQiOv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotCommentMapper {

    @Select("select * from hot_comment order by commentTime desc")
    List<HotComment> getHotCommentByPage();


    /**
     * 查询城市抑郁占比
     */
    List<DepressionPropVo> getDepressionProp();

    /**
     * 查询星期抑郁占比
     */

    List<XinQiOv> selectXinQi();



}