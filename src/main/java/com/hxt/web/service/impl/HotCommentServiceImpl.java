package com.hxt.web.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageHelper;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import com.hxt.pojo.ov.DepressionPropVo;
import com.hxt.pojo.ov.XinQiOv;
import com.hxt.web.mapper.HotCommentMapper;
import com.hxt.web.service.HotCommentService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


    @Override
    public List<DepressionPropVo> getDepressionProp() {
        // 创建一个包含数据的列表
        List<Map<String, Object>> dataArray = new ArrayList<>();

        // 添加重度抑郁数据
        Map<String, Object> severeDepression = new HashMap<>();
        severeDepression.put("name", "重度抑郁");
        severeDepression.put("type", "bar");
        severeDepression.put("stack", "total");
        severeDepression.put("label", Map.of("show", true));
        severeDepression.put("emphasis", Map.of("focus", "series"));
        severeDepression.put("data", List.of(137, 80, 86, 72, 67, 49, 56));
        dataArray.add(severeDepression);

        // 添加中度抑郁数据
        Map<String, Object> moderateDepression = new HashMap<>();
        moderateDepression.put("name", "中度抑郁");
        moderateDepression.put("type", "bar");
        moderateDepression.put("stack", "total");
        moderateDepression.put("label", Map.of("show", true));
        moderateDepression.put("emphasis", Map.of("focus", "series"));
        moderateDepression.put("data", List.of(187, 107, 100, 103, 91, 106, 68));
        dataArray.add(moderateDepression);

        // 添加轻度抑郁数据
        Map<String, Object> mildDepression = new HashMap<>();
        mildDepression.put("name", "轻度抑郁");
        mildDepression.put("type", "bar");
        mildDepression.put("stack", "total");
        mildDepression.put("label", Map.of("show", true));
        mildDepression.put("emphasis", Map.of("focus", "series"));
        mildDepression.put("data", List.of(330, 193, 190, 168, 151, 133, 104));
        dataArray.add(mildDepression);

        // 将列表转换为JSON字符串
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonData = null;
        try {
            jsonData = objectMapper.writeValueAsString(dataArray);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            return objectMapper.readValue(jsonData, List.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<XinQiOv> getXinQi() {

        return hotCommentMapper.selectXinQi();
    }
}
