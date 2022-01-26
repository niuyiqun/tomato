package com.sdu.demo.service;

import com.sdu.demo.entity.Memorandum;
import com.sdu.demo.mapping.MemorandumMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-05 20:10
 **/

@Service
public class MemorandumServiceImpl implements MemorandumService{

    @Autowired
    MemorandumMapper memorandumMapper;

    @Autowired
    FoodService foodService;


    @Override
    public int addFoodToMemorandumByUsername(String userName, String food,String time) {
//        String taste = foodService.findTasteByChineseName(food);
        return memorandumMapper.addFoodToMemorandumByUsername(userName,food,time);
    }

    @Override
    public List<Memorandum> selectMemorandumByUsername(String userName) {
        return memorandumMapper.selectMemorandumByUsername(userName);
    }

    @Override
    public int deleteFromMemorandumByUsernameAndFood(String userName, String food) {
        return memorandumMapper.deleteFromMemorandumByUsernameAndFood(userName,food);
    }
}
