package com.sdu.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: tomato.java
 * @description: 处理登录异常的类
 * @author: NiuYiq
 * @create: 2021-03-25 16:36
 **/

@ControllerAdvice//(该注解只能处理controller里的自定义异常)
public class LoginExceptionHandler {
    @ExceptionHandler(value = LoginException.class)
    @ResponseBody
    public Map<String,Object> handleLoginException(LoginException e){
        Map<String,Object> map  = new HashMap<String, Object>();
        map.put("code",e.getCode());
        map.put("message",e.getMessage());

        return map;
    }
}
