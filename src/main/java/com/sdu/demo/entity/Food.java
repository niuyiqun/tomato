package com.sdu.demo.entity;

import lombok.Data;

/**
 * @program: tomato.java
 * @description: 存储的食物实体
 * @author: NiuYiq
 * @create: 2021-04-05 16:30
 **/

@Data
public class Food {

    private int id;
    private String englishName;
    private String chineseName;
    private String taste;
    private String type;           //种类
    private String material;       //原料
    private String heat;
    private String protein;       //蛋白质
    private String fat;
    private String carbohydrate;  //碳水化合物
    private String cellulose; // 纤维素
    private String imageUrl; // 食物图片地址
}
