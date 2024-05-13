package com.hxt.web.mapper;

import com.github.pagehelper.Page;
import com.hxt.pojo.entity.HotSearch;
import com.hxt.pojo.ov.HotSearchDetailsVO;
import com.hxt.pojo.ov.HotSearchVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface HotSearchMapper {
    @Insert("insert into hotSearch(userName, hotNewsLine, hotNewsTitle, hotCommentID, hotSearchComment, hotNewsLabel, hotSearchTime) values(#{userName}, #{hotNewsLine}, #{hotNewsTitle}, #{hotCommentID}, #{hotSearchComment}, #{hotNewsLabel}, #{hotSearchTime})")
    void insertHotSearch(HotSearch hotSearch);

    /**
     * 获取热搜
     * @return
     */
    Page<HotSearchVO> getHotSearch();

    /**
     * 获取热搜详情
     * @param hotNewsLine
     * @return
     */
    Page<HotSearchDetailsVO> getDetails(Integer hotNewsLine);

    /**
     * 撤销热搜
     * @param hotNewsLine
     */
    @Update("update hotSearch set isDisabled = 1 where hotNewsLine = #{hotNewsLine}")
    void repeal(Integer hotNewsLine);

    /**
     * 根据用户获取热搜
     * @param username
     * @return
     */
    List<HotSearchVO> getHotSearchByUser(String username);

    /**
     * 获取热搜排行，前10
     * @return
     */
    @Select("SELECT hotNewsTitle\n" +
            "FROM (\n" +
            "  SELECT hotNewsTitle,\n" +
            "         COUNT(*) as negativeNum\n" +
            "  FROM hotsearch\n" +
            "  WHERE hotNewsLabel < -0.8\n" +
            "  GROUP BY hotNewsTitle\n" +
            "  ORDER BY negativeNum DESC\n" +
            ") AS subquery limit 10")
    List<String> getHotSearchChart();
}
