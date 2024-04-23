package com.hxt.web.service.impl;

import com.hxt.pojo.entity.HotSearch;
import com.hxt.web.mapper.HotSearchMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.List;


@Service
public class HotSearchServiceImpl {

    @Resource
    private HotSearchMapper hotSearchMapper;

    @Transactional
    public void importDataFromCSV() {
        String path = "C:\\Users\\46852\\Desktop\\resou.csv";
        try (CSVReader reader = new CSVReader(new InputStreamReader(new FileInputStream(path), "UTF-8"))) {
            List<String[]> records = reader.readAll();
            for (String[] record : records) {
                if (record.length >= 7) { // 确保每一行都有足够的数据
                    HotSearch hotSearch = new HotSearch();
                    hotSearch.setUserName(record[0]);
                    System.out.println(record[0]);
                    hotSearch.setHotNewsLine(Integer.parseInt(record[1]));
                    hotSearch.setHotNewsTitle(record[2]);
                    hotSearch.setHotCommentID(Long.parseLong(record[3]));
                    hotSearch.setHotSearchComment(record[4]);
                    hotSearch.setHotNewsLabel(Integer.parseInt(record[5]));
                    hotSearch.setHotSearchTime(record[6]);
                    hotSearchMapper.insertHotSearch(hotSearch);
                }
            }
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to store csv data: " + e.getMessage());
        }
    }

}
