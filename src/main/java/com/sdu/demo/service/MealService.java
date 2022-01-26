package com.sdu.demo.service;

import com.sdu.demo.entity.Meal;

import java.util.List;

public interface MealService {

    public List<List<Meal>> getAllDiseaseControlFood();   //疾病调理大类的食疗数据
    public List<List<Meal>> getAllInternalControlFood();  //脏腑调理大类的食疗数据
    public List<List<Meal>> getAllFunctionalConditioningFood();  //功能性调理大类的食疗数据


}
