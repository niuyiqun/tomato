package com.sdu.demo.controller;

import com.alibaba.fastjson.JSON;
import com.sdu.demo.entity.Food;
import com.sdu.demo.mapping.MealMapper;
import com.sdu.demo.result.Result;
import com.sdu.demo.service.MealService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-09 21:29
 **/

@RestController
@RequestMapping("/meal")
public class MealController {

    @Autowired
    MealMapper mealMapper;

    @Autowired
    MealService mealService;
    private static final Logger logger = LogManager.getLogger(MealController.class);
    @RequestMapping("/diseaseControl")
    public Result getAllDiseaseControlFood(){    //疾病调理
//        System.out.println("获取疾病调理相关食疗");
//        return JSON.toJSONString(mealService.getAllDiseaseControlFood());

        try {
            List list = mealService.getAllDiseaseControlFood();
            Map m = new HashMap();
            m.put("list",list);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("MealController.diseaseControl");
            return Result.error().message("MealController.diseaseControl");
        }
    }

    @RequestMapping("/internalControl")
    public Result getAllInternalControlFood(){    //脏腑调理
//        System.out.println("获取脏腑调理相关食疗");
//        return JSON.toJSONString();

        try {
            List list = mealService.getAllInternalControlFood();
            Map m = new HashMap();
            m.put("list",list);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("MealController.internalControl");
            return Result.error().message("MealController.internalControl");
        }
    }

    @RequestMapping("/functionalConditioning")
    public Result getAllFunctionalConditioningFood(){  //功能性调理
//        System.out.println("获取功能性调理相关食疗");
//        return JSON.toJSONString(mealService.getAllDiseaseControlFood());

        try {
            List list = mealService.getAllFunctionalConditioningFood();
            Map m = new HashMap();
            m.put("list",list);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("MealController.functionalConditioning");
            return Result.error().message("MealController.functionalConditioning");
        }
    }


}
