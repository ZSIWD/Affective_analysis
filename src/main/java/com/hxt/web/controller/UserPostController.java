package com.hxt.web.controller;

import com.hxt.pojo.dto.UserPostDTO;
import com.hxt.pojo.entity.UserPost;
import com.hxt.result.PageResult;
import com.hxt.result.Result;
import com.hxt.web.service.UserPostService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userPost")
public class UserPostController {

    @Resource
    private UserPostService userPostService;

    /**
     * 通过用户名得到发表的
     * @return
     */
    @PostMapping("/getCommentByUser")
    private Result getCommentByUser(@RequestBody UserPostDTO userPostDTO) {
            PageResult result = userPostService.getCommentByUser(userPostDTO);
            return Result.success(result);
    }
}
