package com.sdu.demo.controller;

import com.alibaba.fastjson.JSON;
import com.sdu.demo.entity.Article;
import com.sdu.demo.entity.Food;
import com.sdu.demo.mapping.FoodMapper;
import com.sdu.demo.result.Result;
import com.sdu.demo.service.FoodService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tomato.java
 * @description: 操作Food类的控制器
 * @author: NiuYiq
 * @create: 2021-04-05 20:12
 **/


@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodService foodService;
    @Autowired
    FoodMapper foodMapper;

    private static final Logger logger = LogManager.getLogger(FoodController.class);

    @RequestMapping("/select")
    public Result selectFoodByChineseName(String chineseName){

//        Food food = foodService.FindByChineseName(chinsesName);
//        return JSON.toJSONString(food);    //直接转化为json对象返回   测试成功
//        JSON.toJSON()
//        System.out.println("精准搜索食物");
//        return JSON.toJSONString();
        try {
            Food food = foodMapper.findByChineseName(chineseName);
            Map m = new HashMap();
            m.put("list",food);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("FoodController.select");
            return Result.error().message("精准查找出错");
        }
    }


    //food类的模糊搜索
    @RequestMapping("/fuzzySearch")
    public Result findByFuzzysearch(String chineseName){
//        List<Food> list = new ArrayList<>();
//        list = foodMapper.findByFuzzySearch(chineseName);
//        System.out.println("模糊搜索食物");
//        return list;

        try {
            List list = foodMapper.findByFuzzySearch(chineseName);
            Map m = new HashMap();
            m.put("list",list);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("FoodController.fuzzySearch");
            return Result.error().message("模糊搜索出错");
        }
    }

    //根据喜好推荐
    @RequestMapping("/recommendByFavorable")
    public Result recommendByFavorable(String userName, String date){
//        System.out.println("根据喜好算法推荐食物");
//        return JSON.toJSONString();

        try {
            List list = foodService.recommendedFavorableFood(userName,date);
            Map m = new HashMap();
            m.put("list",list);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("FoodController.recommendByFavorable");
            return Result.error().message("FoodController.recommendByFavorable报错");
        }
    }

    //根据欠缺营养推荐
    @RequestMapping("/recommendByNutrition")
    public Result recommendByNutrition(String userName, String date){
        System.out.println("根据营养算法推荐食物");

        try {
            List list = foodService.recommendedNutritionFood(userName, date);
            Map m = new HashMap();
            m.put("list",list);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("FoodController.recommendByNutrition");
            return Result.error().message("FoodController.recommendByNutrition");
        }
    }


    //获取所有食物信息的名字
    @RequestMapping("/getAllInfo")
    public Result getAllInfo(){
//        System.out.println("获取所有食物");
//        return JSON.toJSONString();

        try {
            List list = foodService.getAllInfo();
            Map m = new HashMap();
            m.put("list",list);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("FoodController.getAllInfo");
            return Result.error().message("FoodController.getAllInfo报错");
        }
    }
}
