package com.hxt.web.controller;

import com.github.pagehelper.PageHelper;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import com.hxt.pojo.ov.CityProp;
import com.hxt.pojo.ov.DepLevelOv;
import com.hxt.pojo.ov.DepressionPropVo;
import com.hxt.pojo.ov.XinQiOv;
import com.hxt.result.PageResult;
import com.hxt.result.Result;
import com.hxt.web.service.HotCommentService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotComment")
public class HotCommentController {

    @Resource
    private HotCommentService hotCommentService;


    @PostMapping("/getHotComment")
    private Result<List<HotComment>> getHotCommentByPage(@RequestBody PageDTO pageDTO){
        List<HotComment> hotComments = hotCommentService.getHotCommentByPage(pageDTO);
        return Result.success(hotComments);
    }

    /**
     * 获取城市抑郁排行
     */
    @PostMapping("/getDepressionProp")
    private Result<CityProp> getDepressionProp(@RequestBody PageDTO pageDTO){
        CityProp depressionProp = hotCommentService.getDepressionProp(pageDTO);

        return Result.success(depressionProp);
    }


    /**
     * 获取星期抑郁数据
     */
    @GetMapping("/getXinQi")
    private Result<List<XinQiOv>> getXinQi(){
        List<XinQiOv> list = hotCommentService.getXinQi();
        return Result.success(list);
    }

    /**
     * 获取星期抑郁数据
     * id 表示第几次刷新
     */
    @GetMapping("/getDePercentage/{id}")
    private Result<DepLevelOv> getDePercentage(@PathVariable Integer id){
        String currentTime = "2023-04-01";
        if (id==1){
            currentTime = "2023-12-21";
        }
        if (id==2){
            currentTime = "2024-02-21";
        }
        DepLevelOv dp = hotCommentService.getDepLevelPercentage(currentTime);
        return Result.success(dp);
    }
}
