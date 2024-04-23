package com.hxt.web.service;

import com.github.pagehelper.Page;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.ov.HotSearchDetailsVO;
import com.hxt.pojo.ov.HotSearchVO;

import java.util.List;


public interface HotSearchService {
    List<HotSearchVO> getHotSearch(PageDTO pageDTO);

    List<HotSearchDetailsVO> getDetails(PageDTO pageDTO,Integer hotNewsLine);

    void repealHotSearch(Integer hotNewsLine);
}
