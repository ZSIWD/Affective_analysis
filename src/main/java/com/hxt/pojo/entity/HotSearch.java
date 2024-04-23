package com.hxt.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.sql.In;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotSearch {
    private String userName;
    private Integer hotNewsLine;
    private String hotNewsTitle;
    private Long hotCommentID;
    private String hotSearchComment;
    private Integer hotNewsLabel;
    private String hotSearchTime;

}
