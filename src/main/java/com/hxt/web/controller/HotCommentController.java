package com.hxt.web.controller;

import com.github.pagehelper.PageHelper;
import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import com.hxt.pojo.ov.DepressionPropVo;
import com.hxt.pojo.ov.XinQiOv;
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
    @GetMapping("/getDepressionProp")
    private Result<List<DepressionPropVo>> getDepressionProp(){
        List<DepressionPropVo> list = hotCommentService.getDepressionProp();

        return Result.success(list);
    }


    /**
     * 获取星期抑郁数据
     */
    @GetMapping("/getXinQi")
    private Result<List<XinQiOv>> getXinQi(){
        List<XinQiOv> list = hotCommentService.getXinQi();
        return Result.success(list);
    }
}
