package com.hxt.web.mapper;

import com.github.pagehelper.Page;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import com.hxt.pojo.ov.DepLevelOv;
import com.hxt.pojo.ov.DepressionPropVo;
import com.hxt.pojo.ov.XinQiOv;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotCommentMapper {

    /**
     * 获取所有热评数据
     * @return
     */
    @Select("select * from hot_comment order by commentTime desc")
    List<HotComment> getHotCommentByPage();


    /**
     * 查询城市抑郁占比
     */
    Page<DepressionPropVo> getDepressionProp();

    /**
     * 查询星期抑郁占比
     */

    List<XinQiOv> selectXinQi();


    /**
     * 动态三种抑郁占比
     */

    DepLevelOv getDepLevelPercentage(String currentTime);

    /**
     * 获取重度抑郁热评
     * @return
     */
    List<HotComment> getDeepHotCommentByPage();
}