package com.sdu.demo.controller;


import com.sdu.demo.entity.Food;
import com.sdu.demo.service.FoodService;
import javatests.Foo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @Autowired
    FoodService foodService;

    @RequestMapping("/test")        //得到剩余应该行走的步数
    public Food getLeftSteps(){
        return foodService.FindByEnglishName("chicken_wings");
    }
}
