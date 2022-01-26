package com.sdu.demo.controller;

import com.alibaba.fastjson.JSON;
import com.sdu.demo.entity.Menu;
import com.sdu.demo.entity.User;
import com.sdu.demo.mapping.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-09 21:03
 **/


@RestController
@RequestMapping("/menu")
public class MenuController {

    @Autowired
    MenuMapper menuMapper;

    @RequestMapping("/test")
    public String test(){

        List<String> list = new ArrayList<>();
        list = menuMapper.selectByEffect("脏腑调理");
        System.out.println("获取食疗板块");
        return JSON.toJSONString(list);
    }

}
