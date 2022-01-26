package com.sdu.demo.service;

import com.sdu.demo.entity.DailyTakein;
import com.sdu.demo.entity.Food;
import com.sdu.demo.entity.Memorandum;
import com.sdu.demo.mapping.DailyTakeinMapper;
import com.sdu.demo.mapping.FoodMapper;
import com.sdu.demo.mapping.MemorandumMapper;
import org.python.antlr.ast.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-05 20:04
 **/

@Service
public class FoodServiceImpl implements FoodService{

    @Autowired
    FoodMapper foodMapper;

    @Autowired
    MemorandumMapper memorandumMapper;

    @Autowired
    DailyTakeinService dailyTakeinService;

    @Override
    public Food FindByChineseName(String chineseName) {
        return foodMapper.findByChineseName(chineseName);
    }

    @Override
    public Food FindByEnglishName(String englishName) {
        return foodMapper.findByEnglishName(englishName);
    }

    @Override
    public String findTasteByChineseName(String chinsesName) {
        return foodMapper.findTasteByChineseName(chinsesName);
    }

    @Override
    public List<Food> findByFuzzySearch(String chineseName) {
        return foodMapper.findByFuzzySearch(chineseName);
    }

    @Override
    public List<Food> recommendedNutritionFood(String userName, String date) {    //根据喜好推荐食物
        //拿到加入备忘录里面最多的两种 口味 推荐物种食品

        //1.计算出各个营养物质的摄入量
        List<Double> arr =dailyTakeinService.calculateTakein(userName,date);   //已经成功拿到
        List<Food> list =new ArrayList<>();

        if (arr.get(0) >1.2|| arr.get(0) <0.8) {     //不满足则置为1  蛋白质
            list.add(foodMapper.findByChineseName("生鱼片"));
            list.add(foodMapper.findByChineseName("切达奶酪"));
            list.add(foodMapper.findByChineseName("炸鱿鱼"));
        }
        if (arr.get(1) >55|| arr.get(0) <44) {      //不满足则置为1  脂肪
            list.add(foodMapper.findByChineseName("北京烤鸭"));
            list.add(foodMapper.findByChineseName("果仁蜜饼"));
            list.add(foodMapper.findByChineseName("油条"));
        }
        if (arr.get(2) >6|| arr.get(0) <4) {     //不满足则置为1   碳水
            list.add(foodMapper.findByChineseName("纸杯蛋糕"));
            list.add(foodMapper.findByChineseName("奶油煎饼卷"));
            list.add(foodMapper.findByChineseName("薯条"));

        }
        if (arr.get(3) >30|| arr.get(0) <25) {   //不满足则置为1  纤维素
        }
            list.add(foodMapper.findByChineseName("毛豆"));
            list.add(foodMapper.findByChineseName("炸鱼薯条"));
            list.add(foodMapper.findByChineseName("鹰嘴豆泥"));
            list.add(foodMapper.findByChineseName("玉米片"));



        return list;
    }

    @Override
    public List<Food> recommendedFavorableFood(String userName, String date) {

        List<Food> resultList = new ArrayList<>();
        List<DailyTakein> list = new ArrayList<>();
        list = dailyTakeinService.getFavorableTaste(userName,date);
//        for (int i=0;i<list.size();i++){
//            resultList.add(foodMapper.findByChineseName(list.get(i).getFood()));
//        }
        resultList = foodMapper.getTasteFood("咸");
        return resultList;
    }

    @Override
    public List<String> getAllInfo() {
        return foodMapper.getAllInfo();
    }
}
