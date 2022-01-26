package com.sdu.demo.entity;

import lombok.Data;

import javax.validation.constraints.*;

/**
 * @program: tomato.java
 * @description: 登录到app得到用户实体类
 * @author: NiuYiq
 * @create: 2021-03-25 15:36
 **/

@Data
public class User {

    private int id;

    @Pattern(regexp = "^1([358][0-9]|4[579]|66|7[0135678]|9[89])[0-9]{8}$" ,message = "号码格式错误，请检查重新输入")
    private String phoneNumber;

    @NotEmpty(message = "名字不能为空")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    private String password;

    private double height;  //身高
    private double weight;  //体重
    private int age;        //年龄
    private String sex;     //性别


}
