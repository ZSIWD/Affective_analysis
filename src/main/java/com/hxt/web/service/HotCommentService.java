package com.hxt.web.service;

import com.hxt.pojo.dto.PageDTO;
import com.hxt.pojo.entity.HotComment;
import com.hxt.pojo.ov.CityProp;
import com.hxt.pojo.ov.DepLevelOv;
import com.hxt.pojo.ov.DepressionPropVo;
import com.hxt.pojo.ov.XinQiOv;
import com.hxt.result.PageResult;
import org.springframework.data.domain.Page;

import java.util.List;

public interface HotCommentService {

    public List<HotComment> getHotCommentByPage(PageDTO pageDTO);

    CityProp getDepressionProp(PageDTO pageDTO);

    List<XinQiOv> getXinQi();

    DepLevelOv getDepLevelPercentage(String currentTime);

    List<HotComment> getDeepHotCommentByPage(PageDTO pageDTO);
}
