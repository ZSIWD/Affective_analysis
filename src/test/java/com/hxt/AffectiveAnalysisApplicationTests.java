package com.hxt;

import com.hxt.web.service.impl.HotSearchServiceImpl;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AffectiveAnalysisApplicationTests {
    @Resource
    private HotSearchServiceImpl hotSearchService;

    @Test
    void contextLoads() {
        hotSearchService.importDataFromCSV();
    }

}
