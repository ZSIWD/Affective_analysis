package com.hxt.web.controller;

import com.hxt.pojo.dto.LineDataVo;
import com.hxt.pojo.dto.UserPostDTO;
import com.hxt.pojo.entity.UserPost;
import com.hxt.result.PageResult;
import com.hxt.result.Result;
import com.hxt.web.service.UserPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/userPost")
public class UserPostController {

    @Resource
    private UserPostService userPostService;

    /**
     * 通过用户名得到用户情感分析数据
     * @return
     */
    @PostMapping("/getCommentByUser")
    private Result getCommentByUser(@RequestBody UserPostDTO userPostDTO) {
        PageResult result = userPostService.getCommentByUser(userPostDTO);
        return Result.success(result);
    }

    /**
     * 获得男女比例图数据
     * @return
     */
    @GetMapping("/getLineData")
    private Result getLineData() {
        LineDataVo result = userPostService.getLineData();
        return Result.success(result);
    }


}
