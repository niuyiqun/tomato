package com.sdu.demo.exception;
import com.sdu.demo.result.Result;
import com.sdu.demo.result.ResultCodeEnum;

/**
 * @program: tomato.java
 * @description: 处理登录异常情况
 * @author: NiuYiq
 * @create: 2021-03-25 16:18
 **/

public class LoginException extends RuntimeException{


    private Integer code;  //错误码

    public LoginException() {}

    public LoginException(ResultCodeEnum resultEnum) {   //返回常规错误用到的构造器    接收一个枚举类型
        super("resultEnum.getMsg()");
        this.code = resultEnum.getCode();
    }
    public LoginException(String msg) {       //返回特定的message信息用的构造器    把特定的message传到exception类中，code设置为0
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
