package com.sdu.demo.entity;

import lombok.Data;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-09 12:46
 **/

@Data
public class DailyTakein {

    int id;
    String userName;
    String date;
    String protein;
    String fat;
    String cellulose;
    String carbohydrate;
    String heat;
    String food;

}

