package com.sdu.demo.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: tomato.java
 * @description: 注册异常
 * @author: NiuYiq
 * @create: 2021-03-26 21:19
 **/

@ControllerAdvice//(该注解只能处理controller里的自定义异常)
public class RegisterExceptionHandle {
    @ExceptionHandler(value = RegisterException.class)
    @ResponseBody
    public Map<String,Object> handleLoginException(RegisterException e){
        Map<String,Object> map  = new HashMap<String, Object>();
        map.put("code",e.getCode());
        map.put("message",e.getMessage());
        return map;
    }

}
