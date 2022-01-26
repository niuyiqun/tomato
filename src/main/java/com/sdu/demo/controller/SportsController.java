package com.sdu.demo.controller;


import com.alibaba.fastjson.JSON;
import com.sdu.demo.mapping.SportsMapper;
import com.sdu.demo.result.Result;
import com.sdu.demo.service.SportsService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sports")
public class SportsController {

    @Autowired
    SportsService sportsService;

    @Autowired
    SportsMapper sportsMapper;

    private static final Logger logger = LogManager.getLogger(SportsController.class);
    @RequestMapping("/getLeftSteps")        //得到剩余应该行走的步数
    public Result getLeftSteps(String userName , String date){
        System.out.println("获取算法运动推荐");

        try {
            int a = sportsService.recommendBySteps(userName, date);
            Map m = new HashMap();
            m.put("推荐步数",a);
            return Result.success().data(m);
        }catch (Exception e){
            e.printStackTrace();
            logger.error("SportsController.getLeftSteps");
            return Result.error().message("SportsController.getLeftSteps报错");
        }
    }

    @RequestMapping("/setSteps")
    public Result setSteps(String userName , int dailySteps,String date){
        System.out.println("设置运动步数");

        try {
            sportsMapper.addByUsername(userName, dailySteps, date);
            return Result.success().message("设置步数成功");
        }catch (Exception e){
            logger.error("SportsController.setSteps");
            return Result.error().message("SportsController.setSteps报错");
        }
    }


}
