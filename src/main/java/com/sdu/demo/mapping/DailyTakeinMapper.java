package com.sdu.demo.mapping;


import com.sdu.demo.entity.DailyTakein;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface DailyTakeinMapper {


    @Insert("INSERT INTO dailyTakein(userName,date,protein,fat,carbohydrate,cellulose,heat,food) VALUES(#{userName},#{date},#{protein},#{fat},#{carbohydrate},#{cellulose},#{heat},#{food})")
    int insertByUsernameAndFood(@Param("userName")String userName,@Param("food")String food,
                                @Param("date")String date,@Param("protein")String protein,
                                @Param("fat")String fat,@Param("carbohydrate")String carbohydrate,
                                @Param("cellulose")String cellulose,@Param("heat")String heat);   //添加食物到当日摄入 八个字段全部插入

    @Select("SELECT * FROM dailyTakein WHERE userName=#{userName} and date = #{date}")
    List<DailyTakein> selectByUsernameAndDate(@Param("userName")String userName, @Param("date")String date);

    @Select("SELECT * FROM dailyTakein WHERE userName=#{userName}")
    List<DailyTakein> selectByUsername(@Param("userName")String userName);
}
