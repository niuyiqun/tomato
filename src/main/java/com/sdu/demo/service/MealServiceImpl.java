package com.sdu.demo.service;

import com.sdu.demo.entity.Meal;
import com.sdu.demo.mapping.MealMapper;
import com.sdu.demo.mapping.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-09 21:34
 **/


@Service
public class MealServiceImpl implements MealService{

    @Autowired
    MealMapper mealMapper;
    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<List<Meal>> getAllDiseaseControlFood() {    //疾病调理大类的食疗数据
        List<List<Meal>> resultList = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list = menuMapper.selectByEffect("疾病调理");
        for (int i=0;i< list.size();i++){
            resultList.add(mealMapper.selectBydiseaseType((String)list.get(i)));
        }
        return resultList;
    }

    @Override
    public List<List<Meal>> getAllInternalControlFood() {
        List<List<Meal>> resultList = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list = menuMapper.selectByEffect("脏腑调理");
        for (int i=0;i< list.size();i++){
            resultList.add(mealMapper.selectBydiseaseType((String)list.get(i)));
        }
        return resultList;
    }

    @Override
    public List<List<Meal>> getAllFunctionalConditioningFood() {
        List<List<Meal>> resultList = new ArrayList<>();

        List<String> list = new ArrayList<>();
        list = menuMapper.selectByEffect("功能性调理");
        for (int i=0;i< list.size();i++){
            resultList.add(mealMapper.selectBydiseaseType((String)list.get(i)));
        }
        return resultList;
    }
}
