package com.hxt.web.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.ov.HotSearchDetailsVO;
import com.hxt.pojo.ov.HotSearchVO;
import com.hxt.web.mapper.HotSearchMapper;
import com.hxt.web.service.HotSearchService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotSearchSearchImpl implements HotSearchService {
    @Resource
    private HotSearchMapper hotSearchMapper;
    @Override
    public List<HotSearchVO> getHotSearch(PageDTO pageDTO) {
        Integer page = pageDTO.getPage();
        Integer size = pageDTO.getSize();
        PageHelper.startPage(page,size);
        List<HotSearchVO> hotSearch = hotSearchMapper.getHotSearch();
        return hotSearch;
    }

    @Override
    public List<HotSearchDetailsVO> getDetails(PageDTO pageDTO,Integer hotNewsLine) {
        Integer page = pageDTO.getPage();
        Integer size = pageDTO.getSize();
        PageHelper.startPage(page,size);
        List<HotSearchDetailsVO> details = hotSearchMapper.getDetails(hotNewsLine);
        return details;
    }

    @Override
    public void repealHotSearch(Integer hotNewsLine) {
        hotSearchMapper.repeal(hotNewsLine);
    }
}
