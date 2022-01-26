package com.sdu.demo.exception;

import com.sdu.demo.result.ResultCodeEnum;

/**
 * @program: tomato.java
 * @description: 注册失败的异常
 * @author: NiuYiq
 * @create: 2021-03-26 21:11
 **/

public class RegisterException  extends RuntimeException{

    private Integer code;  //错误码

    public RegisterException() {}

    public RegisterException(ResultCodeEnum resultEnum) {   //返回常规错误用到的构造器    接收一个枚举类型
        super("resultEnum.getMsg()");
        this.code = resultEnum.getCode();
    }
    public RegisterException(String msg) {       //返回特定的message信息用的构造器    把特定的message传到exception类中，code设置为0
        super(msg);
        this.code = 0;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
