package com.hxt.web.service;

import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HotCommentService {

    public List<HotComment> getHotCommentByPage(PageDTO pageDTO);
}
