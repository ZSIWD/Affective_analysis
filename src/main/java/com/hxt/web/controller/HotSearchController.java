package com.hxt.web.controller;

import com.github.pagehelper.Page;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotSearch;
import com.hxt.pojo.ov.HotSearchDetailsVO;
import com.hxt.pojo.ov.HotSearchVO;
import com.hxt.result.Result;
import com.hxt.web.service.HotSearchService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ResponseBody
@RequestMapping("/hotSearch")
public class HotSearchController {
    @Resource
    private HotSearchService hotSearchService;

    /**
     * 获取所有热搜
     * @param pageDTO
     * @return
     */
    @PostMapping("/getHotSearch")
    public Result<List<HotSearchVO>> getHotSearch(@RequestBody PageDTO pageDTO) {
        List<HotSearchVO> hotSearch = hotSearchService.getHotSearch(pageDTO);
        return Result.success(hotSearch);
    }

    /**
     * 获取热搜详情
     * @param pageDTO
     * @param hotNewsLine
     * @return
     */
    @PostMapping("/getHotSearchDetails/{id}")
    public Result<List<HotSearchDetailsVO>> getHotSearchDetails(@RequestBody PageDTO pageDTO,@PathVariable("id") Integer hotNewsLine){
        List<HotSearchDetailsVO> details = hotSearchService.getDetails(pageDTO,hotNewsLine);
        return Result.success(details);
    }

    /**
     * 撤销热搜
     * @param hotNewsLine
     * @return
     */
    @PutMapping("/repealHotSearch/{id}")
    public Result repealHotSearch(@PathVariable("id") Integer hotNewsLine){
        hotSearchService.repealHotSearch(hotNewsLine);
        return Result.success();
    }

    /**
     * 获取某个用户评论的热搜
     * @param username
     * @return
     */
    @GetMapping("/getHotSearchByUser")
    public Result<List<HotSearchVO>> getHotSearchByUser(String username){
        List<HotSearchVO> hotSearch = hotSearchService.getHotSearchByUser(username);
        return Result.success(hotSearch);
    }

    /**
     * 获取热搜排行，前10
     * @return
     */
    @GetMapping("/getHotSearchChart")
    public Result<List<String>> getHotSearchChart(){
        List<String> hotSearchChart = hotSearchService.getHotSearchChart();
        return Result.success(hotSearchChart);
    }
}
