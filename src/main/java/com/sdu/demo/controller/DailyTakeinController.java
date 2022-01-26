package com.sdu.demo.controller;


import com.alibaba.fastjson.JSON;
import com.sdu.demo.entity.Article;
import com.sdu.demo.entity.DailyTakein;
import com.sdu.demo.entity.User;
import com.sdu.demo.mapping.UserMapper;
import com.sdu.demo.result.Result;
import com.sdu.demo.service.DailyTakeinService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

@RestController
@RequestMapping("/DailyTakein")
public class DailyTakeinController {

    @Autowired
    DailyTakeinService dailyTakeinService;

    @Autowired
    UserMapper userMapper;
    private static final Logger logger = LogManager.getLogger(DailyTakeinController.class);
    @RequestMapping("/add")
    public Result add(String userName,String food){

        try {
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
            dailyTakeinService.insertByUsernameAndFood(userName,food,dateFormat.format(date));
            return Result.success().message("添加摄入食物成功");
        }catch (Exception e){
            logger.error("DailyTakeinController.add");
            return Result.error().message("添加摄入食物出错");
        }
    }

    @RequestMapping("/getDailyTakein")
    public Result  getDailyTakein(String userName,String date){

        try {
            List<Double> list = dailyTakeinService.calculateTakein(userName, date);
//            Map<String, Double> map = new HashMap<>();
//            map.put("蛋白质",list.get(0));
//            map.put("脂肪 ",list.get(1));
//            map.put("碳水 ",list.get(2));
//            map.put("纤维素",list.get(3));
//            map.put("热量",list.get(4));

            DailyTakein dailyTakein = new DailyTakein();
            dailyTakein.setProtein(Double.toString(list.get(0)));
            dailyTakein.setFat(Double.toString(list.get(1)));
            dailyTakein.setCarbohydrate(Double.toString(list.get(2)));
            dailyTakein.setCellulose(Double.toString(list.get(3)));
            dailyTakein.setHeat(Double.toString(list.get(4)));
            System.out.println(dailyTakein);
            System.out.println(list);

            Map m = new HashMap();
            m.put("map",dailyTakein);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("DailyTakeinController.getDailyTakein");
            return Result.error().message("获取每日摄入出错");
        }
    }

    @RequestMapping("/getDailyOughtTakein")
    public Result getDailyOughtTakein(String userName,String date){
        System.out.println("获取每日应该摄入");

        try {
            User user = userMapper.findByName(userName);
            LocalDate d = LocalDate.now(); // get the current date
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//            System.out.println(d.format(formatter));
            int rand = Integer.parseInt(d.format(formatter).substring(0,2))/2;
//            System.out.println(d.format(formatter).getClass().toString());
//            int ran2 = (int) (Math.random()*rand);
//            System.out.println(ran2);
            List<Double> list =new ArrayList<>();
            list.add(70.0+rand);
            list.add(50.0+rand);
            list.add(5.0+rand);
            list.add(27.5+rand);
            list.add(1150.0+rand);
//            list.set(0, user.getWeight());
//            list.set(2, user.getWeight());

            DailyTakein dailyTakein = new DailyTakein();
            dailyTakein.setProtein(Double.toString(list.get(0)));
            dailyTakein.setFat(Double.toString(list.get(1)));
            dailyTakein.setCarbohydrate(Double.toString(list.get(2)));
            dailyTakein.setCellulose(Double.toString(list.get(3)));
            dailyTakein.setHeat(Double.toString(list.get(4)));


            Map m = new HashMap();
            m.put("map",dailyTakein);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("DailyTakeinController.getDailyOughtTakein");
            return Result.error().message("获取每日应当摄入出错");
        }
    }

//    @RequestMapping("/getDailyOughtTakein")
//    public double [] recognizeByPhoto(String userName,String date){      //拍照识别的
//
//        double [] arr =new double[]{0.9,50,5,27.5,1150};
//        return arr;
//    }

}
