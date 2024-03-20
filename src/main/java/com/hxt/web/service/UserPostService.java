package com.hxt.web.service;

import com.hxt.pojo.dto.UserPostDTO;
import com.hxt.result.PageResult;

import javax.naming.ldap.PagedResultsControl;

public interface UserPostService {
    PageResult getCommentByUser(UserPostDTO userPostDTO);
}
