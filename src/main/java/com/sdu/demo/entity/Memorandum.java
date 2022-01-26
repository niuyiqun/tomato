package com.sdu.demo.entity;

import lombok.Data;

/**
 * @program: tomato.java
 * @description: 饮食备忘录
 * @author: NiuYiq
 * @create: 2021-04-05 18:54
 **/

@Data
public class Memorandum {

    private int id;            // 备忘录id
    private String userName;   // 该备忘录的拥有者
    private String food;   //
    private String time; //时间

}
