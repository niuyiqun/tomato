package com.sdu.demo.controller;

import com.alibaba.fastjson.JSON;
import com.sdu.demo.entity.Article;
import com.sdu.demo.mapping.ArticleMapper;
import com.sdu.demo.result.Result;
import com.sdu.demo.service.ArticleService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-09 20:04
 **/


@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @Autowired
    ArticleMapper articleMapper;

    private static final Logger logger = LogManager.getLogger(ArticleController.class);
    @RequestMapping("/getAllArticle")
    public Result getAllArticle(){
        try {
            List<Article> list = articleService.getAllArticle();
            Map m = new HashMap();
            m.put("list",list);
            return Result.success().data(m);
        }catch (Exception e){
            logger.error("ArticleController.getAllArticle");
            return Result.error().message("获取文章全部信息错误");
        }
//        System.out.println("获取所有用户发表的文章");
//        return JSON.toJSONString();
    }
}
