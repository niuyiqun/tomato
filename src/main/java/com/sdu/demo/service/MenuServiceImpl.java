package com.sdu.demo.service;

import com.sdu.demo.entity.Menu;
import com.sdu.demo.mapping.MenuMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-09 21:10
 **/

@Service
public class MenuServiceImpl implements MenuService{

    @Autowired
    MenuMapper menuMapper;

    @Override
    public List<String> selectByEffect(String effect) {     //返回的是diseaseType的字符串数组
        return menuMapper.selectByEffect(effect);
    }
}
