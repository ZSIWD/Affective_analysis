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

    @PostMapping("/getHotSearch")
    public Result<List<HotSearchVO>> getHotSearch(@RequestBody PageDTO pageDTO) {
        List<HotSearchVO> hotSearch = hotSearchService.getHotSearch(pageDTO);
        return Result.success(hotSearch);
    }

    @PostMapping("/getHotSearchDetails/{id}")
    public Result<List<HotSearchDetailsVO>> getHotSearchDetails(@RequestBody PageDTO pageDTO,@PathVariable("id") Integer hotNewsLine){
        List<HotSearchDetailsVO> details = hotSearchService.getDetails(pageDTO,hotNewsLine);
        return Result.success(details);
    }

    @PutMapping("/repealHotSearch/{id}")
    public Result repealHotSearch(@PathVariable("id") Integer hotNewsLine){
        hotSearchService.repealHotSearch(hotNewsLine);
        return Result.success();
    }
}
