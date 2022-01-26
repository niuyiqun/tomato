package com.sdu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-06 18:34
 **/


@RestController
public class testPython {

    @RequestMapping("/openLight")
    public String openLight() throws IOException {
        String command = "cmd.exe /c cd"
                + "D:\\python爬虫\\pythonProject"
                + "&& start python main.py";
        Process p = Runtime.getRuntime().exec(command);
        return "success";
    }
}
