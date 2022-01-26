package com.sdu.demo.service;

import com.sdu.demo.entity.DailyTakein;
import com.sdu.demo.entity.Food;
import com.sdu.demo.mapping.DailyTakeinMapper;
import com.sdu.demo.mapping.FoodMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-10 00:28
 **/


@Service
public class DailyTakeinServiceImpl implements DailyTakeinService{

    @Autowired
    FoodMapper foodMapper;

    @Autowired
    DailyTakeinMapper dailyTakeinMapper;


    @Override
    public int insertByUsernameAndFood(String userName, String food,String date) {    //添加完整的当日摄入信息
        Food f = foodMapper.findByChineseName(food);
        return dailyTakeinMapper.insertByUsernameAndFood(userName,food,date,f.getProtein(),f.getFat(),
                f.getCarbohydrate(),f.getCellulose(),f.getHeat());
    }

    @Override
    public List<Double> calculateTakein(String userName,String date) {    //计算摄入量
        double [] arr =new double[5];            //分别是蛋白质 脂肪 碳水 纤维素 热量
        for (int i=0;i<5;i++){
            arr[i]=0;      //初始化为0
        }
        List<DailyTakein> list = new ArrayList<>();
        list = dailyTakeinMapper.selectByUsernameAndDate(userName,date);
        if (list==null){
            System.out.println("没拿到");
        }
        for (int i= 0;i<list.size();i++){
            arr[0]+=(Double.parseDouble(list.get(i).getProtein()))*2;
            arr[1]+=Double.parseDouble(list.get(i).getFat())*2;
            arr[2]+=Double.parseDouble(list.get(i).getCarbohydrate())*2;
            arr[3]+=Double.parseDouble(list.get(i).getCellulose())*2;
            arr[4]+=Double.parseDouble(list.get(i).getHeat())*2;
        }
        List<Double> res = new ArrayList<>();
        res.add(arr[0]);
        res.add(arr[1]);
        res.add(arr[2]);
        res.add(arr[3]);
        res.add(arr[4]);
        return res;
    }

    @Override
    public List<DailyTakein> getFavorableTaste(String userName,String date) {
        List<DailyTakein> list=new ArrayList<>();
        list = dailyTakeinMapper.selectByUsernameAndDate(userName,date);
        System.out.println("开始");
        for (DailyTakein dailyTakein : list) {
            System.out.println(dailyTakein);
        }
        return list;
    }

    @Override
    public void recognizeByPhoto() {

    }
}
