package com.sdu.demo.mapping;


import com.sdu.demo.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FoodMapper {

    @Select("SELECT * FROM food WHERE chineseName=#{chineseName}")
    Food findByChineseName(@Param("chineseName") String chineseName);     //中文名检索Food数据表 返回某食物的全部信息

    @Select("SELECT * FROM food WHERE englishName=#{englishName}")
    Food findByEnglishName(@Param("englishName") String englishName);     //英文名检索Food数据表 返回某食物的全部信息

    @Select("SELECT taste FROM food WHERE chineseName=#{chineseName}")
    String findTasteByChineseName(@Param("chineseName") String chineseName);       //拿到食物的口味信息

    @Select("SELECT * FROM food WHERE chineseName LIKE CONCAT('%%',#{chineseName},'%%')")   //模糊搜索
    List<Food> findByFuzzySearch(@Param("chineseName") String chineseName);
//
    @Select("SELECT taste FROM food WHERE id=#{id}")    //根据食物id拿到食物
    Food findById(@Param("id") int id);     //中文名检索Food数据表 返回某食物的全部信息

    @Select("Select chineseName FROM food")
    List<String> getAllInfo();

    @Select("Select * FROM food WHERE taste = #{taste}")
    List<Food> getTasteFood(String taste);
}
