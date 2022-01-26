package com.sdu.demo.service;

import com.sdu.demo.entity.User;
import com.sdu.demo.mapping.UserMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {


    public int register(User user);   //注册功能
    public String loginViaUserNameAndPassword(User user);
    public User findByName(String userName);
    public int updateBasicInfo(double height,double weight, String sex,int age,String userName);
    public double calculateOughtConsume(String userName);      //计算应该每天消耗的热量
}
