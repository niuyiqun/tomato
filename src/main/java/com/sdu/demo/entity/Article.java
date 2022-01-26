package com.sdu.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.python.antlr.ast.Str;

/**
 * @program: tomato.java
 * @description:
 * @author: NiuYiq
 * @create: 2021-04-09 19:45
 **/

@Data
@AllArgsConstructor
public class Article {

    private int id;
    private String title;
    private String image;
    private String html;

}
