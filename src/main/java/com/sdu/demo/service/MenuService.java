package com.sdu.demo.service;

import com.sdu.demo.entity.Menu;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuService {

    //拿到三种种类的食谱
    public List<String> selectByEffect(String effect);
}
