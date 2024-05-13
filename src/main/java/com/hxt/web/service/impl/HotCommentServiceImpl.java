package com.hxt.web.service.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import com.hxt.pojo.ov.CityProp;
import com.hxt.pojo.ov.DepLevelOv;
import com.hxt.pojo.ov.DepressionPropVo;
import com.hxt.pojo.ov.XinQiOv;
import com.hxt.result.PageResult;
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

    /**
     * 获取所有热评
     * @param pageDTO
     * @return
     */
    @Override
    public List<HotComment> getHotCommentByPage(PageDTO pageDTO) {
        //开启分页
        PageHelper.startPage(pageDTO.getPage(),pageDTO.getSize());
        //查询
        List<HotComment> list = hotCommentMapper.getHotCommentByPage();

        return list;
    }


    /**
     * 获取每个城市的三种程度抑郁度占比
     * @param pageDTO
     * @return
     */
    @Override
    public CityProp getDepressionProp(PageDTO pageDTO) {
        PageHelper.startPage(1, pageDTO.getSize());

        Page<DepressionPropVo> depressionProp = hotCommentMapper.getDepressionProp();
        List city = new ArrayList<String>();
        List hardData = new ArrayList<Float>();
        List midData = new ArrayList<Float>();
        List lightData = new ArrayList<Float>();

        for (DepressionPropVo d:depressionProp) {
           city.add(d.getCity());
           hardData.add(d.getHardlevel());
           midData.add(d.getMidlevel());
           lightData.add(d.getLightlevel());
        }
        CityProp cityProp = new CityProp();
        cityProp.setCity(city);
        cityProp.setLightData(lightData);
        cityProp.setMidData(midData);
        cityProp.setHardData(hardData);
        return cityProp;

    }


    /**
     * 获取星期抑郁度占比
     * @return
     */
    @Override
    public List<XinQiOv> getXinQi() {
        return hotCommentMapper.selectXinQi();
    }


    /**
     * 获取总的三种程度的抑郁占比
     * @param currentTime
     * @return
     */
    @Override
    public DepLevelOv getDepLevelPercentage(String currentTime) {
        DepLevelOv dp = hotCommentMapper.getDepLevelPercentage(currentTime);
        System.out.println(dp);
        return dp;
    }


    /**
     * 获取重度抑郁热评
     * @param pageDTO
     * @return
     */
    @Override
    public List<HotComment> getDeepHotCommentByPage(PageDTO pageDTO) {
        //开启分页

        PageHelper.startPage(pageDTO.getPage(),pageDTO.getSize());
        //查询
        List<HotComment> list = hotCommentMapper.getDeepHotCommentByPage();

        return list;
    }
}
