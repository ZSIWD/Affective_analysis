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
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

@Service
public class HotSearchSearchImpl implements HotSearchService {
    @Resource
    private HotSearchMapper hotSearchMapper;

    /**
     * 获取所有热搜
     * @param pageDTO
     * @return
     */
    @Override
    public List<HotSearchVO> getHotSearch(PageDTO pageDTO) {
        Integer page = pageDTO.getPage();
        Integer size = pageDTO.getSize();
        PageHelper.startPage(page,size);
        return hotSearchMapper.getHotSearch();
    }

    /**
     * 获取详情
     * @param pageDTO
     * @param hotNewsLine
     * @return
     */
    @Override
    public List<HotSearchDetailsVO> getDetails(PageDTO pageDTO,Integer hotNewsLine) {
        Integer page = pageDTO.getPage();
        Integer size = pageDTO.getSize();
        PageHelper.startPage(page,size);
        return hotSearchMapper.getDetails(hotNewsLine);
    }

    /**
     * 撤销详情
     * @param hotNewsLine
     */
    @Override
    public void repealHotSearch(Integer hotNewsLine) {
        hotSearchMapper.repeal(hotNewsLine);
    }

    /**
     * 根据用户获取详情
     * @param username
     * @return
     */
    @Override
    public List<HotSearchVO> getHotSearchByUser(String username) {
        List<HotSearchVO> hotSearchByUser = hotSearchMapper.getHotSearchByUser(username);
        if (hotSearchByUser.size() == 0){
            Page<HotSearchVO> hotSearch = hotSearchMapper.getHotSearch();
            int randomCount = ThreadLocalRandom.current().nextInt(2, 6);
            return hotSearch.stream()
                    .sorted((o1, o2) -> ThreadLocalRandom.current().nextInt(3) - 1)
                    .limit(randomCount) // Limits to the random count
                    .collect(Collectors.toList());
        }
        return hotSearchByUser;
    }

    /**
     * 获取详情排行榜，前10
     * @return
     */
    @Override
    public List<String> getHotSearchChart() {
        return hotSearchMapper.getHotSearchChart();
    }
}
