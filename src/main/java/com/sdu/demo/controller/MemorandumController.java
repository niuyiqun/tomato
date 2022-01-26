package com.sdu.demo.controller;

import com.alibaba.fastjson.JSON;
import com.sdu.demo.entity.Memorandum;
import com.sdu.demo.mapping.MemorandumMapper;
import com.sdu.demo.result.Result;
import com.sdu.demo.service.MemorandumService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tomato.java
 * @description: 备忘录操作的控制器
 * @author: NiuYiq
 * @create: 2021-04-05 21:09
 **/

@RestController
@RequestMapping("/memorandum")
public class MemorandumController {

    @Autowired
    MemorandumService memorandumService;

    @Autowired
    MemorandumMapper memorandumMapper;
    private static final Logger logger = LogManager.getLogger(MemorandumController.class);

    @RequestMapping("/add")
    public Result addFoodToMemorandumByUsername(String userName, String food){

//        return JSON.toJSONString(Result.success());

        try {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String time = df.format(new Date());// new Date()为获取当前系统时间
            memorandumService.addFoodToMemorandumByUsername(userName,food,time);
//        memorandumMapper.addFoodToMemorandumByUsername(userName,food,time);
            System.out.println("添加食物至备忘录");
            return Result.success().message("添加食物成功");
        }catch (Exception e){
            logger.error("MemorandumController.add");
            return Result.error().message("MemorandumController.add报错");
        }
    }
    
    @RequestMapping("/select")   //查询该用户的备忘录的food信息     //这个没问题
    public Result findByUserName(String userName){
        System.out.println("查询备忘录信息");
//        return JSON.toJSONString(memorandumService.selectMemorandumByUsername(userName));

        try {
            List<Memorandum> list =memorandumService.selectMemorandumByUsername(userName);
            Map m = new HashMap();
            m.put("list",list);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("MemorandumController.select");
            return Result.error().message("MemorandumController.select");
        }
    }

    @RequestMapping("/delete")    //从备忘录里面删除一条数据
    public Result deleteFromMemorandumByUsernameAndFood(String userName, String food){
        System.out.println("删除备忘录食物");
//        return JSON.toJSONString();

        try {
            memorandumService.deleteFromMemorandumByUsernameAndFood(userName, food);
            return Result.success().message("删除食物成功");
        }catch (Exception e){
            logger.error("MemorandumController.delete");
            return Result.error().message("MemorandumController.delete");
        }
    }




}
