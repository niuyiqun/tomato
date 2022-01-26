package com.sdu.demo.controller;


import com.sdu.demo.entity.Food;
import com.sdu.demo.service.FoodService;
import com.sdu.demo.util.FileUtil;
import org.python.antlr.ast.Str;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/photo")
public class phtotController {

    @Autowired
    FoodService foodService;

    @RequestMapping("/uploading")
    public Food uploading(){

        String result = "";
        System.out.println("拍照识别AI算法调用python文件");
        String imgLocation = "";
//        try {
//            imgLocation = FileUtil.handlePicture(part, file);
//        }catch (Exception e){
//            e.printStackTrace();
//        }
        String[] params = new String[] { "python3.7", "../food101_ResNet50.py -m test -i ", imgLocation};  //在控制台跑程序
        Process proc;    //../food101_ResNet50.py
        try {
//            proc = Runtime.getRuntime().exec("cmd /c D:\\python爬虫\\demo2.py");// 执行py文件  怎么传参
            proc = Runtime.getRuntime().exec(params);// 执行py文件

            //用输入输出流来截取结果
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            List<String> list =new ArrayList<>();
            while ((line = in.readLine()) != null) {//python xxx.py -m test
                System.out.println(line);
                list.add(line);
            }
            result = list.get(list.size());
            System.out.println("result = "+result);

            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return foodService.FindByEnglishName("chicken_wings");

    }
}
