package com.sdu.demo.service;

import com.sdu.demo.entity.User;
import com.sdu.demo.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-03-27 11:12
 **/

@Service
public class UserServiceImpl implements UserService{


    @Autowired
    private UserMapper userMapper;

    @Override
    public int register(User user) {
        return userMapper.register(user);
    }

    @Override
    public String loginViaUserNameAndPassword(User user) {
        return userMapper.loginViaUserNameAndPassword(user);
    }

    @Override
    public User findByName(String userName) {
        return userMapper.findByName(userName);
    }

    @Override
    public int updateBasicInfo(double height, double weight, String sex, int age, String userName) {
        return userMapper.updateBasicInfo(height, weight, sex, age, userName);
    }

    @Override
    public double calculateOughtConsume(String userName) {      //每日应该摄入的营养
        double sportlevel = 1.3;
        User user = userMapper.findByName(userName);
        double kal;
        if (user.getSex().equals("男")){
            kal = (665 + 1.38 * user.getWeight()+ 5 * user.getHeight() - 6.8 * user.getAge()) * sportlevel ;
        }else {
            kal = (665 + 9.6  * user.getWeight()+ 1.9 * user.getHeight() - 4.7 * user.getAge()) * sportlevel ;
        }
        return kal;
    }
}
