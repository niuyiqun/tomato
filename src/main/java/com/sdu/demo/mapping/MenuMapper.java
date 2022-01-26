package com.sdu.demo.mapping;


import com.sdu.demo.entity.Menu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.python.antlr.ast.Str;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MenuMapper {


    @Select("SELECT diseaseType FROM menu WHERE effect=#{effect}")    //找到一级类型的种类
    List<String> selectByEffect(@Param("effect") String effect);

}
