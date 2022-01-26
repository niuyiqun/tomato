package com.sdu.demo.service;

import com.sdu.demo.entity.Sports;
import org.apache.ibatis.annotations.Param;
import org.python.antlr.ast.Str;

public interface SportsService {


    //根据步数和摄取量进行步数推荐
    public int recommendBySteps(String userName , String date);

    int addByUsername(String userName,int dailySteps,String date);
}
