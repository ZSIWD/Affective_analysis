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

    Page<HotSearchVO> getHotSearch();

    Page<HotSearchDetailsVO> getDetails(Integer hotNewsLine);

    @Update("update hotSearch set isDisabled = 1 where hotNewsLine = #{hotNewsLine}")
    void repeal(Integer hotNewsLine);

    List<HotSearchVO> getHotSearchByUser(String username);

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
