package com.sdu.demo.service;

import com.sdu.demo.entity.Food;
import org.apache.ibatis.annotations.Param;
import org.python.antlr.ast.Str;

import java.util.List;

public interface FoodService {


    public Food FindByChineseName(String chineseName);
    public Food FindByEnglishName(String englishName);
    public String findTasteByChineseName(String userName);
    public List<Food> findByFuzzySearch(String chineseName);
    public List<Food> recommendedNutritionFood(String userName, String date);
    public List<Food> recommendedFavorableFood(String userName, String date);
    public List<String> getAllInfo();

}
