package com.sdu.demo.controller;

import com.alibaba.fastjson.JSON;
import com.sdu.demo.entity.User;
import com.sdu.demo.exception.LoginException;
import com.sdu.demo.exception.RegisterException;
import com.sdu.demo.mapping.UserMapper;
import com.sdu.demo.result.Result;
import com.sdu.demo.service.UserService;
import com.sdu.demo.shiro.UserRealm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: tomato.java
 * @description: 用户操作
 * @author: NiuYiq
 * @create: 2021-03-25 15:58
 **/

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserService userService;
    private static final Logger logger = LogManager.getLogger(UserController.class);


    @RequestMapping("/register")         //@validated 是@valid的一次封装，提供了一些新的功能
    public Result register(@Valid User user, BindingResult bindingResult){

//        Map<String,Object> map  = new HashMap<String, Object>();
//        if(bindingResult.hasErrors()){
//            throw new RegisterException(bindingResult.getFieldError().getDefaultMessage());   //获取validate的错误信息
//        }
//        userService.register(user);
//        System.out.println("用户注册");
//        return JSON.toJSONString(Result.success());


        try {
            Map<String,Object> map  = new HashMap<String, Object>();
            if(bindingResult.hasErrors()){
                throw new RegisterException(bindingResult.getFieldError().getDefaultMessage());   //获取validate的错误信息
            }
            user.setHeight(180);
            user.setWeight(120);
            userService.register(user);
            System.out.println("用户注册");
            return Result.success();
        }catch (Exception e){
            logger.error("UserController.register");
            return Result.error().message("UserController.register报错");
        }
    }

    @RequestMapping("/login")         //@validated 是@valid的一次封装，提供了一些新的功能
    public Result login(User user, BindingResult bindingResult){
        System.out.println("用户登录");
//
//        HashMap<String,Object> map  = new HashMap<String, Object>();
////            return bindingResult.getFieldError().getDefaultMessage();  //拿到定义的message信息
////        System.out.println(ResultEnum.SUCCESS.getCode()+ " "+ResultEnum.SUCCESS.getMsg());
////            throw new LoginException(ResultEnum.LOGIN_ERROR);
//        if(bindingResult.hasErrors()){
//
//            throw new LoginException(bindingResult.getFieldError().getDefaultMessage());
//        }
//        //创建securityManager
//        DefaultSecurityManager defaultSecurityManager = new DefaultSecurityManager();
//        //IniRealm realm = new IniRealm("classpath:shiro.ini");
//        //设置为自定义realm获取认证数据
//        defaultSecurityManager.setRealm(new UserRealm());
//        //将安装工具类中设置默认安全管理器
//        SecurityUtils.setSecurityManager(defaultSecurityManager);
//        //获取主体对象
//        Subject subject = SecurityUtils.getSubject();
//        //创建token令牌
//        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(), user.getPassword());
//        try {
//            subject.login(token);//用户登录   //说明代码底层 你在调用的时候出现了一些问题
//            System.out.println("登录成功~~");
//            return Result.success();
//        } catch (UnknownAccountException e) {
//            e.printStackTrace();
//            System.out.println("用户名错误!!");
//            map.put("info","用户名错误!!");
//            return Result.error();
//        }catch (IncorrectCredentialsException e){
//            e.printStackTrace();
//            System.out.println("密码错误!!!");
//            map.put("info","密码错误!!!");
//            return Result.error();
//        }
        try {
            String pa = userService.loginViaUserNameAndPassword(user);
            if (pa.equals(user.getPassword())){
                return Result.success().message("登录成功");
            }else {
                return Result.error().message("密码或用户名失败");
            }
        }catch (Exception e){
            logger.error("UserController.login");
            return Result.error().message("密码或用户名失败");
        }
    }

    @RequestMapping("/updataInfo")
    public Result test(double height,double weight, String sex,int age,String userName){
        System.out.println("用户更新信息");
//        userService.updateBasicInfo(height, weight, sex, age, userName);
//        return JSON.toJSONString(Result.success());

        try {
            userService.updateBasicInfo(height, weight, sex, age, userName);
            return Result.success().message("更新信息成功");
        }catch (Exception e){
            logger.error("UserController.updataInfo");
            return Result.error().message("UserController.updataInfo报错");
        }
    }

    @RequestMapping("/test")
    public String test(String name){
        User user = userMapper.findByName(name);
        System.out.println(user);
        return "success";
    }

    @RequestMapping("/getUserInfo")
    public Result getUserInfo(String userName){
        System.out.println("用户更新信息");
//        userService.updateBasicInfo(height, weight, sex, age, userName);
//        return JSON.toJSONString(Result.success());

        try {
            User u = userService.findByName(userName);
            User user = new User();
            user.setAge(u.getAge());
            user.setUserName(u.getUserName());
            user.setHeight(u.getHeight());
            user.setSex(u.getSex());

            Map m = new HashMap();
            m.put("userInfo",u);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("UserController.getUserInfo");
            return Result.error().message("UserController.getUserInfo报错");
        }
    }



}
