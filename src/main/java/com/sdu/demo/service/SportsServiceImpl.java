package com.sdu.demo.service;


import com.sdu.demo.entity.Sports;
import com.sdu.demo.entity.User;
import com.sdu.demo.mapping.SportsMapper;
import com.sdu.demo.mapping.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SportsServiceImpl implements SportsService{


    @Autowired
    UserService userService;

    @Autowired
    SportsMapper sportsMapper;

    @Override
    public int recommendBySteps(String userName, String date) {     //进行步数推荐

        double oughtKal = userService.calculateOughtConsume(userName);
        User user = userService.findByName(userName);

        //获取一个已经运动的量消耗的热量

        int step = sportsMapper.getdailySteps(userName,date);
        double BMR = 10 * user.getWeight() + 6.25 * user.getHeight() - 5 * user.getAge() - 161;
        double currentKal = BMR * 3 / 24 * (step/5000);

        if (currentKal>oughtKal){
            return 0;
        }else {
            return (int)(oughtKal-currentKal);
        }
    }

    @Override
    public int addByUsername(String userName, int dailySteps, String date) {
        return sportsMapper.addByUsername(userName, dailySteps, date);
    }
}
