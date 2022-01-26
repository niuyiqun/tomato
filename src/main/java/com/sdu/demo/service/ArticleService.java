package com.sdu.demo.service;

import com.sdu.demo.entity.Article;
import com.sdu.demo.mapping.ArticleMapper;

import java.util.List;


public interface ArticleService {
    public List<Article> getAllArticle();   //获取已存的全部文章
}
