package com.sdu.demo.mapping;


import com.sdu.demo.entity.Meal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MealMapper {


    @Select("SELECT * FROM meal WHERE diseaseType=#{diseaseType}")
    List<Meal> selectBydiseaseType(@Param("diseaseType") String diseaseType);    //找到二级类型的菜谱
}
