package com.sdu.demo.entity;

import lombok.Data;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-09 19:47
 **/

@Data
public class Meal {

    private int id;
    private String food;
    private String diseaseType;
    private String pictureUrl;
    private String material;

}
