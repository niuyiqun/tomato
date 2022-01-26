package com.sdu.demo.mapping;


import com.sdu.demo.entity.Article;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleMapper {

    @Select("SELECT * FROM article")
    List<Article> getAllArticle();   //获取已存的全部文章
}
